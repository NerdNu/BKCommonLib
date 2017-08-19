package com.bergerkiller.bukkit.common.map.util;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.block.BlockFace;

import com.bergerkiller.bukkit.common.map.MapColorPalette;
import com.bergerkiller.bukkit.common.map.MapResourcePack;
import com.bergerkiller.bukkit.common.map.MapTexture;
import com.google.gson.annotations.SerializedName;

public class Model {
    private String parent = null;
    public boolean ambientocclusion = true;
    public Map<String, Display> display = new HashMap<String, Display>();
    public Map<String, String> textures = new HashMap<String, String>();
    public List<Element> elements = new ArrayList<Element>();

    public final String getParentName() {
        return this.parent;
    }

    public void loadParent(Model parentModel) {
        for (Map.Entry<String, String> textureEntry : parentModel.textures.entrySet()) {
            if (!this.textures.containsKey(textureEntry.getKey())) {
                this.textures.put(textureEntry.getKey(), textureEntry.getValue());
            }
        }
        for (Map.Entry<String, Display> displayEntry : parentModel.display.entrySet()) {
            if (!this.display.containsKey(displayEntry.getKey())) {
                this.display.put(displayEntry.getKey(), displayEntry.getValue());
            }
        }
        this.elements.addAll(0, parentModel.elements);
    }

    public void build(MapResourcePack resourcePack) {
        // Build all textures, turning paths into absolute paths
        boolean hasChanges;
        do {
            hasChanges = false;
            for (Map.Entry<String, String> textureEntry : this.textures.entrySet()) {
                if (textureEntry.getValue().startsWith("#")) {
                    String texture = this.textures.get(textureEntry.getValue().substring(1));
                    if (texture != null) {
                        textureEntry.setValue(texture);
                        hasChanges = true;
                    }
                }
            }
        } while (hasChanges);

        // Apply all textures to the model faces
        for (Element element : this.elements) {
            element.build(resourcePack, this.textures);
        }
    }

    public List<Quad> buildQuads() {
        ArrayList<Quad> result = new ArrayList<Quad>();
        for (Element element : this.elements) {
            List<Quad> elementQuads = element.buildQuads();
            
            
            result.addAll(elementQuads);
        }
        return result;
    }

    @Override
    public Model clone() {
        Model clone = new Model();
        clone.ambientocclusion = this.ambientocclusion;
        clone.textures.putAll(this.textures);
        for (Map.Entry<String, Display> displayEntry : this.display.entrySet()) {
            if (!this.display.containsKey(displayEntry.getKey())) {
                clone.display.put(displayEntry.getKey(), displayEntry.getValue().clone());
            }
        }
        for (Element element : this.elements) {
            clone.elements.add(element.clone());
        }
        return clone;
    }

    /**
     * A square element in the model
     */
    public static class Element {
        public Vector3f from;
        public Vector3f to;
        public Rotation rotation = null;
        public Map<BlockFace, Face> faces = new EnumMap<BlockFace, Face>(BlockFace.class);

        public void build(MapResourcePack resourcePack, Map<String, String> textures) {
            for (Map.Entry<BlockFace, Face> faceEntry : faces.entrySet()) {
                faceEntry.getValue().build(faceEntry.getKey(), resourcePack, textures);
            }
        }

        public List<Quad> buildQuads() {
            ArrayList<Quad> result = new ArrayList<Quad>();
            for (Face face : faces.values()) {
                result.add(new Quad(face.face, from.clone(), to.clone(), face.texture));
            }

            if (rotation != null) {


                Matrix4f m_rotation = new Matrix4f();
                if (rotation.axis.equals("x")) {
                    m_rotation.rotateX(rotation.angle);
                } else if (rotation.axis.equals("y")) {
                    m_rotation.rotateY(rotation.angle);
                } else if (rotation.axis.equals("z")) {
                    m_rotation.rotateZ(rotation.angle);
                }

                Matrix4f m_a = new Matrix4f();
                m_a.set(new Vector3f(rotation.origin.x, rotation.origin.y, rotation.origin.z));
                
                Matrix4f m_b = new Matrix4f();
                m_b.set(new Vector3f(-rotation.origin.x, -rotation.origin.y, -rotation.origin.z));
                
                Matrix4f transform = new Matrix4f();
                transform.setIdentity();
                
                transform.multiply(m_a);
                transform.multiply(m_rotation);
                
                
                transform.multiply(m_b);

                for (Quad quad : result) {
                    quad.transform(transform);
                }
                
            }

            return result;
        }

        @Override
        public Element clone() {
            Element clone = new Element();
            clone.from = this.from.clone();
            clone.to = this.to.clone();
            for (Map.Entry<BlockFace, Face> face : this.faces.entrySet()) {
                clone.faces.put(face.getKey(), face.getValue().clone());
            }
            return clone;
        }

        /**
         * A single textured quad
         */
        public static class Face {
            @SerializedName("texture")
            private String textureName = "";
            private int[] uv = null;
            public transient BlockFace face;
            public transient MapTexture texture = null;
            public BlockFace cullface;

            public void build(BlockFace face, MapResourcePack resourcePack, Map<String, String> textures) {
                this.face = face;
                if (this.textureName.startsWith("#")) {
                    String texture = textures.get(this.textureName.substring(1));
                    if (texture != null) {
                        this.textureName = texture;
                    }
                }
                this.texture = resourcePack.getTexture(this.textureName);
                if (uv != null) {
                    int dx = uv[2] - uv[0];
                    int dy = uv[3] - uv[1];
                    int sx = (dx >= 1) ? 1 : -1;
                    int sy = (dy >= 1) ? 1 : -1;
                    int ox = (dx >= 1) ? 0 : 1;
                    int oy = (dy >= 1) ? 0 : 1;
                    MapTexture texture_uv = MapTexture.createEmpty(Math.abs(dx), Math.abs(dy));
                    byte[] buffer = texture_uv.getBuffer();
                    int index = 0;
                    for (int y = uv[1]; y != uv[3]; y += sy) {
                        for (int x = uv[0]; x != uv[2]; x += sx) {
                            buffer[index] = this.texture.readPixel(x - ox, y - oy);
                            if (buffer[index] == 0) {
                                buffer[index] = MapColorPalette.COLOR_GREEN;
                            }
                            index++;
                        }
                    }
                    this.texture = texture_uv;
                }
            }

            @Override
            public Face clone() {
                Face clone = new Face();
                clone.face = this.face;
                clone.uv = (this.uv == null) ? null : this.uv.clone();
                clone.textureName = this.textureName;
                clone.texture = this.texture.clone();
                clone.cullface = this.cullface;
                return clone;
            }
        }

        /**
         * The rotation of a model element
         */
        public static class Rotation {
            public Vector3f origin = new Vector3f();
            public String axis = "y";
            public float angle = 0.0f;
        }
    }

    /**
     * Display rendering options
     */
    public static class Display {
        public Vector3f rotation = new Vector3f();
        public Vector3f translation = new Vector3f();
        public Vector3f scale = new Vector3f();

        @Override
        public Display clone() {
            Display clone = new Display();
            clone.rotation = this.rotation.clone();
            clone.translation = this.translation.clone();
            clone.scale = this.scale.clone();
            return clone;
        }
    }
}