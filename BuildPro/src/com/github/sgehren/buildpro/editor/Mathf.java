package com.github.sgehren.buildpro.editor;

import org.bukkit.Location;

/*
 * This class handles mostly all of the math for the
 * BuildPro plugin
 */
public class Mathf
{
    /*
     * All of the methods to calculate block minimums and maximums
     * between two locations are found below. All are int data types.
     */
    public static int getMinX(Location loc1, Location loc2)
    {
        return Math.min(loc1.getBlockX(), loc2.getBlockX());
    }

    public static int getMinY(Location loc1, Location loc2)
    {
        return Math.min(loc1.getBlockY(), loc2.getBlockY());
    }

    public static int getMinZ(Location loc1, Location loc2)
    {
        return Math.min(loc1.getBlockZ(), loc2.getBlockZ());
    }

    public static int getMaxX(Location loc1, Location loc2)
    {
        return getMinX(loc1, loc2) == loc1.getBlockX() ? loc2.getBlockX() : loc1.getBlockX();
    }

    public static int getMaxY(Location loc1, Location loc2)
    {
        return getMinY(loc1, loc2) == loc1.getBlockY() ? loc2.getBlockY() : loc2.getBlockY();
    }

    public static int getMaxZ(Location loc1, Location loc2)
    {
        return getMinZ(loc1, loc2) == loc1.getBlockZ() ? loc2.getBlockZ() : loc1.getBlockZ();
    }

    public static int getXDist(Location l1, Location l2)
    {
        return  l1.getBlockX() > l2.getBlockX() ? l1.getBlockX() - l2.getBlockX() : l2.getBlockX() - l1.getBlockX();
    }

    public static int getYDist(Location l1, Location l2)
    {
        return l1.getBlockY() > l2.getBlockY() ? l1.getBlockY() - l2.getBlockY() : l2.getBlockY() - l1.getBlockY();
    }

    public static int getZDist(Location l1, Location l2)
    {
        return l1.getBlockZ() > l2.getBlockZ() ? l1.getBlockZ() - l2.getBlockZ() : l2.getBlockZ() - l1.getBlockZ();
    }

    //Get the total number of blocks in the selection
    public static double countBlocksInSelection(Location select1, Location select2)
    {
        double subX, subY, subZ, sum;

        if(select1.getX() < select2.getX())
        {
            subX = select2.getX() - select1.getX();
        }
        else
        {
            subX = select1.getX() - select2.getX();
        }

        if(select1.getY() < select2.getY())
        {
            subY = select2.getY() - select1.getY();
        }
        else
        {
            subY = select1.getY() - select2.getY();
        }

        if(select1.getZ() < select2.getZ())
        {
            subZ = select2.getZ() - select1.getZ();
        }
        else
        {
            subZ = select1.getZ() - select2.getZ();
        }

        if(subX < subZ)
        {
            sum = subZ - subX;
        }
        else
        {
            sum = subX - subZ;
        }

        if(subY == 0)
            return sum;
        else
            return sum *= subY;
    }
}
