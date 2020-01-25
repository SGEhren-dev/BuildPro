package com.github.sgehren.buildpro;

import com.github.sgehren.buildpro.commands.*;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class Core extends JavaPlugin
{

    //Variables that will be initalized when the config loads
    public boolean wandOnJoin = true;

    //Called when the plugin launches
    public void onEnable()
    {
        //Register Events
        new Events(this);
        //Register commands
        new CommandsHandler(this);

        //Setup Config
        getConfig().options().copyDefaults();
        saveDefaultConfig();

    }

    public File getPluginFolder()
    {
        return this.getDataFolder();
    }
}
