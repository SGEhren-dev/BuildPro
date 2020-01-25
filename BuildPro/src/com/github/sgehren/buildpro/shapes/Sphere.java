package com.github.sgehren.buildpro.shapes;

import org.bukkit.block.Block;
import org.bukkit.configuration.serialization.ConfigurationSerializable;

import java.util.Iterator;
import java.util.Map;

public class Sphere implements Iterable<Block>, Cloneable, ConfigurationSerializable {

    public Sphere(int widht, int depth, int height)
    {

    }

    @Override
    public Iterator<Block> iterator() {
        return null;
    }

    @Override
    public Map<String, Object> serialize() {
        return null;
    }
}
