package com.bergerkiller.reflection.org.bukkit.craftbukkit;

import org.bukkit.World;

import com.bergerkiller.bukkit.common.Common;
import com.bergerkiller.bukkit.common.conversion.Conversion;
import com.bergerkiller.mountiplex.reflection.ClassTemplate;
import com.bergerkiller.mountiplex.reflection.FieldAccessor;
import com.bergerkiller.mountiplex.reflection.MethodAccessor;

public class CBChunkIOExecutor {
	public static final ClassTemplate<?> T = ClassTemplate.createCB("chunkio.ChunkIOExecutor")
	        .addImport("org.bukkit.craftbukkit.util.AsynchronousExecutor")
	        .addImport(Common.NMS_ROOT + ".Chunk");
	
    public static final FieldAccessor<Object> asynchronousExecutor = T.selectField("private static final AsynchronousExecutor<QueuedChunk, Chunk, Runnable, RuntimeException> instance");
	
	private static final MethodAccessor<Void> queueChunkLoad = T.selectMethod(
			"public static void queueChunkLoad(net.minecraft.server.World world," +
			                                  "net.minecraft.server.ChunkRegionLoader loader," +
			                                  "net.minecraft.server.ChunkProviderServer provider," +
			                                  "int x, int z, Runnable runnable)"
	);

    public static void queueChunkLoad(Object chunkRegionLoader, World world, Object chunkProviderServer, int x, int z, Runnable taskWhenFinished) {
        CBChunkIOExecutor.queueChunkLoad.invoke(null, Conversion.toWorldHandle.convert(world), chunkRegionLoader, chunkProviderServer, x, z, taskWhenFinished);
    }
}
