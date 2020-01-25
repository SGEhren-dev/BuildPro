package com.github.sgehren.buildpro.shapes;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;

import java.util.*;

public class Cylinder implements Iterable<Block> {

    protected final String worldName;
    protected final int radius;
    protected final int x, y, z;

    public Cylinder(Location l1, Integer block, int radius, Material m1)
    {
        this.worldName = l1.getWorld().getName();
        this.radius = radius;
        this.x = l1.getBlockX();
        this.y = l1.getBlockY();
        this.z = l1.getBlockZ();

        int cx = l1.getBlockX();
        int cy = l1.getBlockY();
        int cz = l1.getBlockZ();

        World w = l1.getWorld();

        int sqr = radius * radius;

        for(int x = this.x - this.radius; x <= this.x + this.radius; x++) {
            for(int z = this.z - this.radius; z <= this.z + this.radius; z++) {
                if((this.x - x) * (this.x - x) + (this.z - z) * (this.z - z) <= sqr) {
                    w.getBlockAt(x, y, z).setType(m1);
                }
            }
        }
    }

    public Cylinder(Map<String, Object> map) {
        this.worldName = (String) map.get("worldName");
        this.radius = (int) map.get("radius");
        this.x = (int) map.get("x");
        this.y = (int) map.get("y");
        this.z = (int) map.get("z");
    }

    public Map<String, Object> serialize() {
        Map<String, Object> map = new HashMap();
        map.put("worldName", this.worldName);
        map.put("radius", this.radius);
        map.put("x", this.x);
        map.put("y", this.y);
        map.put("z", this.z);

        return map;
    }

    /**
     * Get the radius of the cylinder
     *
     * @return Radius of the cylinder
     */
    public int getRadius() { return this.radius; }

    /**
     * Get the world the Cylinder is in
     *
     * @return World the Cylinder is ins
     */
    public World getWorld() {
        World w = Bukkit.getWorld(this.worldName);
        if(w == null) throw new IllegalArgumentException("World " + this.worldName + " is not laoded");

        return w;
    }

    /**
     * Get the diameter of the Cylinder
     *
     * @return  Diameter of the Cylinder
     */
    public int getRediusSqrd() { return this.radius * this.radius; }

    public List<Block> getBlocks() {
        Iterator<Block> blockI = this.iterator();
        List<Block> copy = new ArrayList<Block>();

        while(blockI.hasNext())
            copy.add(blockI.next());

        return copy;
    }

    @Override
    public Iterator<Block> iterator() {
        return null;
    }
}
