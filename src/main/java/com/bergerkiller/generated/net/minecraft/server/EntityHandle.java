package com.bergerkiller.generated.net.minecraft.server;

import com.bergerkiller.mountiplex.reflection.util.StaticInitHelper;
import com.bergerkiller.mountiplex.reflection.declarations.Template;
import com.bergerkiller.bukkit.common.bases.IntVector3;
import com.bergerkiller.bukkit.common.nbt.CommonTagCompound;
import com.bergerkiller.bukkit.common.wrappers.BlockData;
import com.bergerkiller.bukkit.common.wrappers.DataWatcher;
import com.bergerkiller.bukkit.common.wrappers.DataWatcher.Key;
import com.bergerkiller.bukkit.common.wrappers.ResourceKey;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * Instance wrapper handle for type <b>net.minecraft.server.Entity</b>.
 * To access members without creating a handle type, use the static {@link #T} member.
 * New handles can be created from raw instances using {@link #createHandle(Object)}.
 */
public abstract class EntityHandle extends Template.Handle {
    /** @See {@link EntityClass} */
    public static final EntityClass T = new EntityClass();
    static final StaticInitHelper _init_helper = new StaticInitHelper(EntityHandle.class, "net.minecraft.server.Entity");

    /* ============================================================================== */

    public static EntityHandle createHandle(Object handleInstance) {
        return T.createHandle(handleInstance);
    }

    public static final EntityHandle createNew(WorldHandle world) {
        return T.constr_world.newInstance(world);
    }

    /* ============================================================================== */

    public static int entityCount() {
        return T.entityCount.getInteger();
    }

    public static void entityCount_set(int value) {
        T.entityCount.setInteger(value);
    }

    public abstract void updateBlockCollision();
    public abstract void playStepSound(IntVector3 position, BlockData blockData);
    public abstract void setRotation(float yaw, float pitch);
    public abstract void burn(float dmg);
    public abstract Item dropItem(Material material, int amount, float force);
    public abstract Item dropItemStack(ItemStack itemstack, float force);
    public abstract ResourceKey getSwimSound();
    public abstract void makeSound(ResourceKey soundeffect, float volume, float pitch);
    public abstract boolean isInWaterUpdate();
    public abstract boolean isInWater();
    public abstract boolean hasMovementSound();
    public abstract void updateFalling(double d0, boolean flag, BlockData blockData, IntVector3 position);
    public abstract void doStepSoundUpdate(IntVector3 blockposition, BlockData blockData);
    public abstract void checkBlockCollisions();
    public abstract double calculateDistance(double x, double y, double z);
    public abstract boolean damageEntity(DamageSourceHandle damagesource, float damage);
    public abstract void setPosition(double x, double y, double z);
    public abstract void setPositionRotation(double x, double y, double z, float yaw, float pitch);
    public abstract void setLocation(double x, double y, double z, float yaw, float pitch);
    public abstract float getHeadRotation();
    public abstract AxisAlignedBBHandle getBoundingBox();
    public abstract void setBoundingBox(AxisAlignedBBHandle axisalignedbb);
    public abstract AxisAlignedBBHandle getOtherBoundingBox();
    public abstract AxisAlignedBBHandle getEntityBoundingBox(EntityHandle entity);
    public abstract void recalcPosition();
    public abstract boolean isBurning();
    public abstract void setOnFire(int numSeconds);
    public abstract boolean isWet();
    public abstract void saveToNBT(CommonTagCompound compound);
    public abstract void onTick();
    public abstract void loadFromNBT(CommonTagCompound compound);
    public abstract boolean savePassenger(CommonTagCompound compound);
    public abstract boolean saveEntity(CommonTagCompound compound);
    public abstract boolean isSneaking();
    public abstract void appendEntityCrashDetails(CrashReportSystemDetailsHandle crashreportsystemdetails);
    public abstract int getId();
    public abstract UUID getUniqueID();
    public abstract DataWatcher getDataWatcher();
    public abstract void onPush(double d0, double d1, double d2);
    public abstract int getPortalCooldownMaximum();
    public abstract void collide(EntityHandle entity);
    public abstract Entity getBukkitEntity();

    public List<EntityHandle> getPassengers() {
        if (T.opt_passengers.isAvailable()) {
            List<EntityHandle> passengers = T.opt_passengers.get(getRaw());
            if (passengers == null) {
                return java.util.Collections.emptyList();
            } else {
                return passengers;
            }
        } else {
            EntityHandle passenger = T.opt_passenger.get(getRaw());
            if (passenger == null) {
                return java.util.Collections.emptyList();
            } else {
                return java.util.Arrays.asList(passenger);
            }
        }
    }

    public boolean hasPassengers() {
        if (T.opt_passengers.isAvailable()) {
            List<EntityHandle> passengers = T.opt_passengers.get(getRaw());
            return passengers != null && passengers.size() > 0;
        } else {
            return T.opt_passenger.get(getRaw()) != null;
        }
    }

    public void setPassengers(List<EntityHandle> passengers) {
        if (T.opt_passengers.isAvailable()) {
            List<EntityHandle> entity_passengers = T.opt_passengers.get(getRaw());
            if (entity_passengers == null) {
                T.opt_passengers.set(getRaw(), passengers);
            } else {
                entity_passengers.clear();
                entity_passengers.addAll(passengers);
            }
        } else if (passengers.size() == 0) {
            T.opt_passenger.set(getRaw(), null);
        } else {
            T.opt_passenger.set(getRaw(), passengers.get(0));
        }
    }


    public static DataWatcher.Key<Byte> DATA_FLAGS = DataWatcher.Key.Type.BYTE.createKey(T.DATA_FLAGS, 0);
    public static DataWatcher.Key<Integer> DATA_AIR_TICKS = DataWatcher.Key.Type.INTEGER.createKey(T.DATA_AIR_TICKS, 1);
    public static DataWatcher.Key<String> DATA_CUSTOM_NAME = DataWatcher.Key.Type.STRING.createKey(T.DATA_CUSTOM_NAME, 2);
    public static DataWatcher.Key<Boolean> DATA_CUSTOM_NAME_VISIBLE = DataWatcher.Key.Type.BOOLEAN.createKey(T.DATA_CUSTOM_NAME_VISIBLE, 3);
    public static DataWatcher.Key<Boolean> DATA_SILENT = DataWatcher.Key.Type.BOOLEAN.createKey(T.DATA_SILENT, 4);
    public static DataWatcher.Key<Boolean> DATA_NO_GRAVITY = DataWatcher.Key.Type.BOOLEAN.createKey(T.DATA_NO_GRAVITY, -1);

    public static final int DATA_FLAG_ON_FIRE = (1 << 0);
    public static final int DATA_FLAG_SNEAKING = (1 << 1);
    public static final int DATA_FLAG_UNKNOWN1 = (1 << 2);
    public static final int DATA_FLAG_SPRINTING = (1 << 3);
    public static final int DATA_FLAG_UNKNOWN2 = (1 << 4);
    public static final int DATA_FLAG_INVISIBLE = (1 << 5);
    public static final int DATA_FLAG_GLOWING = (1 << 6);
    public static final int DATA_FLAG_FLYING = (1 << 7);


    public boolean isPassenger() {
        if (T.isPassenger.isAvailable()) {
            return T.isPassenger.invoke(getRaw());
        } else {
            return T.vehicle.raw.get(getRaw()) != null;
        }
    }

    public boolean isVehicle() {
        if (T.isVehicle.isAvailable()) {
            return T.isVehicle.invoke(getRaw());
        } else {
            return T.opt_passenger.get(getRaw()) != null;
        }
    }


    public int getMaxFireTicks() {
        if (T.prop_getMaxFireTicks.isAvailable()) {
            return T.prop_getMaxFireTicks.invoke(getRaw());
        } else if (T.field_maxFireTicks.isAvailable()) {
            return T.field_maxFireTicks.getInteger(getRaw());
        } else {
            throw new UnsupportedOperationException("Max Fire Ticks can not be read");
        }
    }


    public EntityHandle getDriverEntity() {
        if (T.getDriverEntity.isAvailable()) {
            return T.getDriverEntity.invoke(getRaw());
        } else {
            return null; // driver feature not a thing on this server
        }
    }


    public boolean isInSameVehicle(EntityHandle entity) {
        if (T.isInSameVehicle.isAvailable()) {
            return T.isInSameVehicle.invoke(getRaw(), entity);
        } else {
            Object rawPassenger = T.opt_passenger.raw.get(this.getRaw());
            Object rawVehicle = T.vehicle.raw.get(this.getRaw());
            Object rawEntity = entity.getRaw();
            return rawEntity == rawPassenger || rawEntity == rawVehicle;
        }
    }


    public WorldServerHandle getWorldServer() {
        return WorldServerHandle.createHandle(T.world.raw.get(getRaw()));
    }

    public org.bukkit.entity.Entity toBukkit() {
        return com.bergerkiller.bukkit.common.conversion.type.WrapperConversion.toEntity(getRaw());
    }

    public static EntityHandle fromBukkit(org.bukkit.entity.Entity entity) {
        return createHandle(com.bergerkiller.bukkit.common.conversion.type.HandleConversion.toEntityHandle(entity));
    }
    public abstract Entity getBukkitEntityField();
    public abstract void setBukkitEntityField(Entity value);
    public abstract int getIdField();
    public abstract void setIdField(int value);
    public abstract EntityHandle getVehicle();
    public abstract void setVehicle(EntityHandle value);
    public abstract boolean isIgnoreChunkCheck();
    public abstract void setIgnoreChunkCheck(boolean value);
    public abstract WorldHandle getWorld();
    public abstract void setWorld(WorldHandle value);
    public abstract double getLastX();
    public abstract void setLastX(double value);
    public abstract double getLastY();
    public abstract void setLastY(double value);
    public abstract double getLastZ();
    public abstract void setLastZ(double value);
    public abstract double getLocX();
    public abstract void setLocX(double value);
    public abstract double getLocY();
    public abstract void setLocY(double value);
    public abstract double getLocZ();
    public abstract void setLocZ(double value);
    public abstract double getMotX();
    public abstract void setMotX(double value);
    public abstract double getMotY();
    public abstract void setMotY(double value);
    public abstract double getMotZ();
    public abstract void setMotZ(double value);
    public abstract float getYaw();
    public abstract void setYaw(float value);
    public abstract float getPitch();
    public abstract void setPitch(float value);
    public abstract float getLastYaw();
    public abstract void setLastYaw(float value);
    public abstract float getLastPitch();
    public abstract void setLastPitch(float value);
    public abstract AxisAlignedBBHandle getBoundingBoxField();
    public abstract void setBoundingBoxField(AxisAlignedBBHandle value);
    public abstract boolean isOnGround();
    public abstract void setOnGround(boolean value);
    public abstract boolean isHorizontalMovementImpaired();
    public abstract void setHorizontalMovementImpaired(boolean value);
    public abstract boolean isVerticalMovementImpaired();
    public abstract void setVerticalMovementImpaired(boolean value);
    public abstract boolean isMovementImpaired();
    public abstract void setMovementImpaired(boolean value);
    public abstract boolean isVelocityChanged();
    public abstract void setVelocityChanged(boolean value);
    public abstract boolean isJustLanded();
    public abstract void setJustLanded(boolean value);
    public abstract boolean isDead();
    public abstract void setDead(boolean value);
    public abstract float getWidth();
    public abstract void setWidth(float value);
    public abstract float getLength();
    public abstract void setLength(float value);
    public abstract float getWalkedDistanceXZ();
    public abstract void setWalkedDistanceXZ(float value);
    public abstract float getWalkedDistanceXYZ();
    public abstract void setWalkedDistanceXYZ(float value);
    public abstract float getFallDistance();
    public abstract void setFallDistance(float value);
    public abstract int getStepCounter();
    public abstract void setStepCounter(int value);
    public abstract float getHeightOffset();
    public abstract void setHeightOffset(float value);
    public abstract boolean isNoclip();
    public abstract void setNoclip(boolean value);
    public abstract Random getRandom();
    public abstract void setRandom(Random value);
    public abstract int getTicksLived();
    public abstract void setTicksLived(int value);
    public abstract int getFireTicks();
    public abstract void setFireTicks(int value);
    public abstract DataWatcher getDatawatcherField();
    public abstract void setDatawatcherField(DataWatcher value);
    public abstract boolean isLoaded();
    public abstract void setIsLoaded(boolean value);
    public abstract int getChunkX();
    public abstract void setChunkX(int value);
    public abstract int getChunkY();
    public abstract void setChunkY(int value);
    public abstract int getChunkZ();
    public abstract void setChunkZ(int value);
    public abstract boolean isPositionChanged();
    public abstract void setPositionChanged(boolean value);
    public abstract int getPortalCooldown();
    public abstract void setPortalCooldown(int value);
    public abstract boolean isAllowTeleportation();
    public abstract void setAllowTeleportation(boolean value);
    public abstract int getDimension();
    public abstract void setDimension(int value);
    public abstract boolean isValid();
    public abstract void setValid(boolean value);
    /**
     * Stores class members for <b>net.minecraft.server.Entity</b>.
     * Methods, fields, and constructors can be used without using Handle Objects.
     */
    public static final class EntityClass extends Template.Class<EntityHandle> {
        public final Template.Constructor.Converted<EntityHandle> constr_world = new Template.Constructor.Converted<EntityHandle>();

        public final Template.StaticField.Integer entityCount = new Template.StaticField.Integer();
        @Template.Optional
        public final Template.StaticField.Converted<Key<Byte>> DATA_FLAGS = new Template.StaticField.Converted<Key<Byte>>();
        @Template.Optional
        public final Template.StaticField.Converted<Key<Integer>> DATA_AIR_TICKS = new Template.StaticField.Converted<Key<Integer>>();
        @Template.Optional
        public final Template.StaticField.Converted<Key<String>> DATA_CUSTOM_NAME = new Template.StaticField.Converted<Key<String>>();
        @Template.Optional
        public final Template.StaticField.Converted<Key<Boolean>> DATA_CUSTOM_NAME_VISIBLE = new Template.StaticField.Converted<Key<Boolean>>();
        @Template.Optional
        public final Template.StaticField.Converted<Key<Boolean>> DATA_SILENT = new Template.StaticField.Converted<Key<Boolean>>();
        @Template.Optional
        public final Template.StaticField.Converted<Key<Boolean>> DATA_NO_GRAVITY = new Template.StaticField.Converted<Key<Boolean>>();

        public final Template.Field.Converted<Entity> bukkitEntityField = new Template.Field.Converted<Entity>();
        public final Template.Field.Integer idField = new Template.Field.Integer();
        @Template.Optional
        public final Template.Field.Converted<List<EntityHandle>> opt_passengers = new Template.Field.Converted<List<EntityHandle>>();
        @Template.Optional
        public final Template.Field.Converted<EntityHandle> opt_passenger = new Template.Field.Converted<EntityHandle>();
        public final Template.Field.Converted<EntityHandle> vehicle = new Template.Field.Converted<EntityHandle>();
        public final Template.Field.Boolean ignoreChunkCheck = new Template.Field.Boolean();
        public final Template.Field.Converted<WorldHandle> world = new Template.Field.Converted<WorldHandle>();
        public final Template.Field.Double lastX = new Template.Field.Double();
        public final Template.Field.Double lastY = new Template.Field.Double();
        public final Template.Field.Double lastZ = new Template.Field.Double();
        public final Template.Field.Double locX = new Template.Field.Double();
        public final Template.Field.Double locY = new Template.Field.Double();
        public final Template.Field.Double locZ = new Template.Field.Double();
        public final Template.Field.Double motX = new Template.Field.Double();
        public final Template.Field.Double motY = new Template.Field.Double();
        public final Template.Field.Double motZ = new Template.Field.Double();
        public final Template.Field.Float yaw = new Template.Field.Float();
        public final Template.Field.Float pitch = new Template.Field.Float();
        public final Template.Field.Float lastYaw = new Template.Field.Float();
        public final Template.Field.Float lastPitch = new Template.Field.Float();
        public final Template.Field.Converted<AxisAlignedBBHandle> boundingBoxField = new Template.Field.Converted<AxisAlignedBBHandle>();
        public final Template.Field.Boolean onGround = new Template.Field.Boolean();
        public final Template.Field.Boolean horizontalMovementImpaired = new Template.Field.Boolean();
        public final Template.Field.Boolean verticalMovementImpaired = new Template.Field.Boolean();
        public final Template.Field.Boolean movementImpaired = new Template.Field.Boolean();
        public final Template.Field.Boolean velocityChanged = new Template.Field.Boolean();
        public final Template.Field.Boolean justLanded = new Template.Field.Boolean();
        public final Template.Field.Boolean dead = new Template.Field.Boolean();
        public final Template.Field.Float width = new Template.Field.Float();
        public final Template.Field.Float length = new Template.Field.Float();
        public final Template.Field.Float walkedDistanceXZ = new Template.Field.Float();
        public final Template.Field.Float walkedDistanceXYZ = new Template.Field.Float();
        public final Template.Field.Float fallDistance = new Template.Field.Float();
        public final Template.Field.Integer stepCounter = new Template.Field.Integer();
        public final Template.Field.Float heightOffset = new Template.Field.Float();
        public final Template.Field.Boolean noclip = new Template.Field.Boolean();
        public final Template.Field<Random> random = new Template.Field<Random>();
        public final Template.Field.Integer ticksLived = new Template.Field.Integer();
        @Template.Optional
        public final Template.Field.Integer field_maxFireTicks = new Template.Field.Integer();
        public final Template.Field.Integer fireTicks = new Template.Field.Integer();
        public final Template.Field.Converted<DataWatcher> datawatcherField = new Template.Field.Converted<DataWatcher>();
        public final Template.Field.Boolean isLoaded = new Template.Field.Boolean();
        public final Template.Field.Integer chunkX = new Template.Field.Integer();
        public final Template.Field.Integer chunkY = new Template.Field.Integer();
        public final Template.Field.Integer chunkZ = new Template.Field.Integer();
        public final Template.Field.Boolean positionChanged = new Template.Field.Boolean();
        public final Template.Field.Integer portalCooldown = new Template.Field.Integer();
        public final Template.Field.Boolean allowTeleportation = new Template.Field.Boolean();
        public final Template.Field.Integer dimension = new Template.Field.Integer();
        @Template.Optional
        public final Template.Field<double[]> move_SomeArray = new Template.Field<double[]>();
        @Template.Optional
        public final Template.Field.Long move_SomeState = new Template.Field.Long();
        public final Template.Field.Boolean valid = new Template.Field.Boolean();

        public final Template.Method<Void> updateBlockCollision = new Template.Method<Void>();
        public final Template.Method.Converted<Void> playStepSound = new Template.Method.Converted<Void>();
        public final Template.Method<Void> setRotation = new Template.Method<Void>();
        public final Template.Method<Void> burn = new Template.Method<Void>();
        public final Template.Method.Converted<Item> dropItem = new Template.Method.Converted<Item>();
        public final Template.Method.Converted<Item> dropItemStack = new Template.Method.Converted<Item>();
        public final Template.Method.Converted<ResourceKey> getSwimSound = new Template.Method.Converted<ResourceKey>();
        public final Template.Method.Converted<Void> makeSound = new Template.Method.Converted<Void>();
        public final Template.Method<Boolean> isInWaterUpdate = new Template.Method<Boolean>();
        public final Template.Method<Boolean> isInWater = new Template.Method<Boolean>();
        public final Template.Method<Boolean> hasMovementSound = new Template.Method<Boolean>();
        public final Template.Method.Converted<Void> updateFalling = new Template.Method.Converted<Void>();
        public final Template.Method.Converted<Void> doStepSoundUpdate = new Template.Method.Converted<Void>();
        public final Template.Method<Void> checkBlockCollisions = new Template.Method<Void>();
        public final Template.Method<Double> calculateDistance = new Template.Method<Double>();
        public final Template.Method.Converted<Boolean> damageEntity = new Template.Method.Converted<Boolean>();
        public final Template.Method<Void> setPosition = new Template.Method<Void>();
        public final Template.Method<Void> setPositionRotation = new Template.Method<Void>();
        public final Template.Method<Void> setLocation = new Template.Method<Void>();
        public final Template.Method<Float> getHeadRotation = new Template.Method<Float>();
        public final Template.Method.Converted<AxisAlignedBBHandle> getBoundingBox = new Template.Method.Converted<AxisAlignedBBHandle>();
        public final Template.Method.Converted<Void> setBoundingBox = new Template.Method.Converted<Void>();
        public final Template.Method.Converted<AxisAlignedBBHandle> getOtherBoundingBox = new Template.Method.Converted<AxisAlignedBBHandle>();
        public final Template.Method.Converted<AxisAlignedBBHandle> getEntityBoundingBox = new Template.Method.Converted<AxisAlignedBBHandle>();
        @Template.Optional
        public final Template.Method<Boolean> isVehicle = new Template.Method<Boolean>();
        @Template.Optional
        public final Template.Method<Boolean> isPassenger = new Template.Method<Boolean>();
        public final Template.Method<Void> recalcPosition = new Template.Method<Void>();
        public final Template.Method<Boolean> isBurning = new Template.Method<Boolean>();
        public final Template.Method<Void> setOnFire = new Template.Method<Void>();
        @Template.Optional
        public final Template.Method<Integer> prop_getMaxFireTicks = new Template.Method<Integer>();
        public final Template.Method<Boolean> isWet = new Template.Method<Boolean>();
        @Template.Optional
        public final Template.Method.Converted<EntityHandle> getDriverEntity = new Template.Method.Converted<EntityHandle>();
        public final Template.Method.Converted<Void> saveToNBT = new Template.Method.Converted<Void>();
        public final Template.Method<Void> onTick = new Template.Method<Void>();
        public final Template.Method.Converted<Void> loadFromNBT = new Template.Method.Converted<Void>();
        public final Template.Method.Converted<Boolean> savePassenger = new Template.Method.Converted<Boolean>();
        public final Template.Method.Converted<Boolean> saveEntity = new Template.Method.Converted<Boolean>();
        public final Template.Method<Boolean> isSneaking = new Template.Method<Boolean>();
        @Template.Optional
        public final Template.Method.Converted<Boolean> isInSameVehicle = new Template.Method.Converted<Boolean>();
        public final Template.Method.Converted<Void> appendEntityCrashDetails = new Template.Method.Converted<Void>();
        public final Template.Method<Integer> getId = new Template.Method<Integer>();
        public final Template.Method<UUID> getUniqueID = new Template.Method<UUID>();
        public final Template.Method.Converted<DataWatcher> getDataWatcher = new Template.Method.Converted<DataWatcher>();
        public final Template.Method<Void> onPush = new Template.Method<Void>();
        public final Template.Method<Integer> getPortalCooldownMaximum = new Template.Method<Integer>();
        @Template.Optional
        public final Template.Method.Converted<Boolean> onInteractBy_1_8_8 = new Template.Method.Converted<Boolean>();
        @Template.Optional
        public final Template.Method.Converted<Boolean> onInteractBy_1_9 = new Template.Method.Converted<Boolean>();
        @Template.Optional
        public final Template.Method.Converted<Boolean> onInteractBy_1_11_2 = new Template.Method.Converted<Boolean>();
        public final Template.Method.Converted<Void> collide = new Template.Method.Converted<Void>();
        public final Template.Method.Converted<Entity> getBukkitEntity = new Template.Method.Converted<Entity>();

    }

}

