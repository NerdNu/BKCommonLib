package com.bergerkiller.bukkit.common.internal;

import com.bergerkiller.bukkit.common.Common;

/**
 * A list of server capabilities relevant for BKCommonLib to know about.
 * Storing them in booleans instead of evaluating frequently helps performance a bit.
 */
public class CommonCapabilities {
    /**
     * Minecraft 1.8.8 and before there was a bug in the World Entity collision handler.
     * This caused passengers to collide with their vehicle at random. Fun times!
     */
    public static final boolean VEHICLES_COLLIDE_WITH_PASSENGERS = Common.evaluateMCVersion("<=", "1.8.8");

    /**
     * Since Minecraft 1.9, effect names changed from simple names to longer keys with namespace
     * to improve mapping and sound system handling. As a result, random.fizz turned into block.fire.extinguish.
     */
    public static final boolean KEYED_EFFECTS = Common.evaluateMCVersion(">=", "1.9");

    /**
     * Since Minecraft 1.9 some changes to the chat component JSON structure
     */
    public static final boolean CHAT_TEXT_JSON_VER2 = Common.evaluateMCVersion(">=", "1.9");

    /**
     * Since Minecraft 1.9 int-based datawatcher keys were replaced with Datawatcher objects, significantly
     * simplifying registering these systems.
     */
    public static final boolean DATAWATCHER_OBJECTS = Common.evaluateMCVersion(">=", "1.9");

    /**
     * Since Minecraft 1.9.2 players can dual-wield, now introducing an off-hand
     */
    public static final boolean PLAYER_OFF_HAND = Common.evaluateMCVersion(">=", "1.9.2");

    /**
     * Since Minecraft 1.11.2 the Entity move function had some changes, introducing a
     * "EnumMoveType" enumeration parameter to handle piston motion. This changed the
     * function signature.
     */
    public static final boolean ENTITY_MOVE_VER2 = Common.evaluateMCVersion(">=", "1.11.2");

    /**
     * Since Minecraft 1.11.2 the World Provider 'isDarkWorld' boolean property was inverted.
     */
    public static final boolean WORLD_LIGHT_DARK_INVERTED = Common.evaluateMCVersion(">=", "1.11.2");

    /**
     * Since Minecraft 1.11 ItemStacks could be 'empty' using the empty constant introduced in 1.8.8.
     * The player inventory 'dirty' state uses this new empty state, among others.
     */
    public static final boolean ITEMSTACK_EMPTY_STATE = Common.evaluateMCVersion(">=", "1.11");
}
