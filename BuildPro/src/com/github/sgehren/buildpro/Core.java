package com.github.sgehren.buildpro;

import com.github.sgehren.buildpro.commands.Copy;
import com.github.sgehren.buildpro.commands.Paste;
import com.github.sgehren.buildpro.commands.Selector;
import com.github.sgehren.buildpro.commands.Set;
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
        getCommand("selector").setExecutor(new Selector());
        getCommand("copy").setExecutor(new Copy());
        getCommand("paste").setExecutor(new Paste());
        getCommand("set").setExecutor(new Set());

        //Setup Config
        getConfig().options().copyDefaults();
        saveDefaultConfig();

    }

    public File getPluginFolder()
    {
        return this.getDataFolder();
    }
}
