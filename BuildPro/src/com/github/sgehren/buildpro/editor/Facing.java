package com.github.sgehren.buildpro.editor;

import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;

public class Facing {

    public static BlockFace getFacingFromString(String string) {
        BlockFace face;

        switch (string) {
            case "north":
                return BlockFace.NORTH;
            case "north_east":
                return BlockFace.NORTH_EAST;
            case "south_east":
                return BlockFace.SOUTH_EAST;
            case "south":
                return BlockFace.SOUTH;
            case "south_west":
                return BlockFace.SOUTH_WEST;
            case "west":
                return BlockFace.WEST;
            case "north_west":
                return BlockFace.NORTH_WEST;
            case "up":
                return BlockFace.UP;
            case "down":
                return BlockFace.DOWN;
            default:
                return null;
        }
    }
}
