package com.github.sgehren.buildpro.editor;

import org.bukkit.Material;

public class Stairs {

    public static boolean isStair(Material material) {

        if(material == Material.SMOOTH_QUARTZ_STAIRS) { return true; }
        else if(material == Material.SANDSTONE_STAIRS) { return true; }
        else if(material == Material.SMOOTH_RED_SANDSTONE_STAIRS) { return true; }
        else if(material == Material.SMOOTH_SANDSTONE_STAIRS) { return true; }
        else if(material == Material.SPRUCE_STAIRS) { return true; }
        else if(material == Material.STONE_BRICK_STAIRS) { return true; }
        else if(material == Material.STONE_STAIRS) { return true; }
        else if(material == Material.ACACIA_STAIRS) { return true; }
        else if(material == Material.ANDESITE_STAIRS) { return true; }
        else if(material == Material.BIRCH_STAIRS) { return true; }
        else if(material == Material.BRICK_STAIRS) { return true; }
        else if(material == Material.COBBLESTONE_STAIRS) { return true; }
        else if(material == Material.DARK_OAK_STAIRS) { return true; }
        else if(material == Material.DARK_PRISMARINE_STAIRS) { return true; }
        else if(material == Material.DIORITE_STAIRS) { return true; }
        else if(material == Material.END_STONE_BRICK_STAIRS) { return true; }
        else if(material == Material.END_STONE) { return true; }
        else if(material == Material.GRANITE_STAIRS) { return true; }
        else if(material == Material.JUNGLE_STAIRS) { return true; }
        else if(material == Material.POLISHED_ANDESITE_STAIRS) { return true; }
        else if(material == Material.POLISHED_DIORITE_STAIRS) { return true; }
        else if(material == Material.POLISHED_GRANITE_STAIRS) { return true; }
        else if(material == Material.MOSSY_COBBLESTONE_STAIRS) { return true; }
        else if(material == Material.MOSSY_STONE_BRICK_STAIRS) { return true; }
        else if(material == Material.NETHER_BRICK_STAIRS) { return true; }
        else if(material == Material.OAK_STAIRS) { return true; }
        else if(material == Material.PRISMARINE_BRICK_STAIRS) { return true; }
        else if(material == Material.PRISMARINE_STAIRS) { return true; }
        else if(material == Material.PURPUR_STAIRS) { return true; }
        else if(material == Material.QUARTZ_STAIRS) { return true; }
        else if(material == Material.RED_NETHER_BRICK_STAIRS) { return true; }
        else if(material == Material.RED_SANDSTONE_STAIRS) { return true; }
        else { return false; }
    }
}
