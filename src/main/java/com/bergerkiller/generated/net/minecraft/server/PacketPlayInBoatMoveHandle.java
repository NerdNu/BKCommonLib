package com.bergerkiller.generated.net.minecraft.server;

import com.bergerkiller.mountiplex.reflection.util.StaticInitHelper;
import com.bergerkiller.mountiplex.reflection.declarations.Template;

/**
 * Instance wrapper handle for type <b>net.minecraft.server.PacketPlayInBoatMove</b>.
 * To access members without creating a handle type, use the static {@link #T} member.
 * New handles can be created from raw instances using {@link #createHandle(Object)}.
 */
@Template.Optional
public abstract class PacketPlayInBoatMoveHandle extends Template.Handle {
    /** @See {@link PacketPlayInBoatMoveClass} */
    public static final PacketPlayInBoatMoveClass T = new PacketPlayInBoatMoveClass();
    static final StaticInitHelper _init_helper = new StaticInitHelper(PacketPlayInBoatMoveHandle.class, "net.minecraft.server.PacketPlayInBoatMove");

    /* ============================================================================== */

    public static PacketPlayInBoatMoveHandle createHandle(Object handleInstance) {
        return T.createHandle(handleInstance);
    }

    /* ============================================================================== */

    public abstract boolean isRightPaddle();
    public abstract void setRightPaddle(boolean value);
    public abstract boolean isLeftPaddle();
    public abstract void setLeftPaddle(boolean value);
    /**
     * Stores class members for <b>net.minecraft.server.PacketPlayInBoatMove</b>.
     * Methods, fields, and constructors can be used without using Handle Objects.
     */
    public static final class PacketPlayInBoatMoveClass extends Template.Class<PacketPlayInBoatMoveHandle> {
        public final Template.Field.Boolean rightPaddle = new Template.Field.Boolean();
        public final Template.Field.Boolean leftPaddle = new Template.Field.Boolean();

    }

}

