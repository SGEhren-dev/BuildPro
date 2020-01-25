package com.github.sgehren.buildpro.editor;

import java.util.ArrayList;
import java.util.List;

import com.github.sgehren.buildpro.commands.Selector;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

public class Selection
{
    //Our constant variables that shouldnt be changed
    public static final int MAX_SELECTION = 999999999;
    public static final ItemStack WAND = Selector.customItem(new ItemStack(Material.WOODEN_AXE), "Selector");

    public static List<Block> getBlocks(Location loc1, Location loc2)
    {
        if(loc1.getWorld() != loc2.getWorld())
            return null;

        World world = loc1.getWorld();

        List<Block> blocks = new ArrayList<>();

        int x1 = loc1.getBlockX();
        int y1 = loc1.getBlockY();
        int z1 = loc1.getBlockZ();

        int x2 = loc2.getBlockX();
        int y2 = loc2.getBlockY();
        int z2 = loc2.getBlockZ();

        int lowestX = Math.min(x1, x2);
        int lowestY = Math.min(y1, y2);
        int lowestZ = Math.min(z1, z2);

        int highestX = lowestX == x1 ? x2 : x1;
        int highestY = lowestY == y1 ? y2 : y1;
        int highestZ = lowestZ == z1 ? z2 : z1;

        for(int x = lowestX; x <= highestX; x++)
        {
            for(int y = lowestY; y <= highestY; y++)
            {
                for(int z = lowestZ; z <= highestZ; z++)
                {
                    blocks.add(world.getBlockAt(x, y, z));
                }
            }
        }

        return blocks;
    }

    @SuppressWarnings("deprecation")
    public static int[][][] blocksToArray(Location loc1, Location loc2)
    {
        int maxX = Mathf.getMaxX(loc1, loc2);             //MaxX Location
        int maxY = Mathf.getMaxY(loc1, loc2);             //MaxY Location
        int maxZ = Mathf.getMaxZ(loc1, loc2);             //MaxZ Location

        int minX = Mathf.getMinX(loc1, loc2);             //MinX Location
        int minY = Mathf.getMinY(loc1, loc2);             //MinY Location
        int minZ = Mathf.getMinZ(loc1, loc2);             //MinZ Location

        int[][][] blocks = new int[maxX - minX + 1][maxY - minY + 1][maxZ - minZ + 1];

        for(int x = minX; x <= maxX; x++) {
            for(int y = minY; y <= maxY; y++) {
                for(int z = minZ; z <= maxZ; z++) {
                    Block block = loc1.getWorld().getBlockAt(x, y, z);
                    blocks[x - minX][y - minY][z - minZ] = block.getType().getId();
                }
            }
        }

        return blocks;
    }
}