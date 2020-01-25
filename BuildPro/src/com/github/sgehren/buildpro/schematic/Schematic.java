package com.github.sgehren.buildpro.schematic;

import com.github.sgehren.buildpro.Core;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Schematic {

    //Create core object
    Core core = new Core();

    public Schematic() {}

    public static Schematic get() { return new Schematic(); }

    ObjectOutputStream out = null;
    FileOutputStream fs = null;

    public void saveSchematic(String name)
    {
        File file = new File(core.getPluginFolder() + "/schematics/" + name + ".schem");
    }
}
