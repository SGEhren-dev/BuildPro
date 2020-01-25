package com.github.sgehren.buildpro.files;

import java.io.File;
import java.io.IOException;

import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class CustomConfig {

    private static File file;
    private static FileConfiguration customFile;

    //Find and generate custom config
    public static void setup()
    {
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("Core").getDataFolder(), "customConfig.yml");

        if(!file.exists())
        {
            try {
                file.createNewFile();

            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }

        customFile = YamlConfiguration.loadConfiguration(file);
    }

    public static FileConfiguration get()
    {
        return customFile;
    }

    public static void save()
    {
        try {
            customFile.save(file);
        } catch (IOException e)
        {
            System.out.println("Couldn't save your file..");
        }
    }

    public static void reload()
    {
        customFile = YamlConfiguration.loadConfiguration(file);
    }
}