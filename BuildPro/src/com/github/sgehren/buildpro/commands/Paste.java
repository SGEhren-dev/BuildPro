package com.github.sgehren.buildpro.commands;

import com.github.sgehren.buildpro.Core;
import com.github.sgehren.buildpro.Events;
import com.github.sgehren.buildpro.editor.Mathf;
import com.github.sgehren.buildpro.editor.Selection;
import com.github.sgehren.buildpro.shapes.Cuboid;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.Console;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Paste implements CommandExecutor {

    Events events = new Events();

    private static Location locationOfPlayerAtPaste;                    //Player location at time of paste

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {

        if(sender instanceof Player)                                    //Is the sender an instance of a player? If not, return false
        {
            Player p = (Player) sender;
            World world = p.getWorld();

            Cuboid paste = new Cuboid(Events.primarySelection, Events.secondarySelection);

            int nX = p.getLocation().getBlockX() + paste.getSizeX();
            int nY = p.getLocation().getBlockY() + paste.getSizeY();
            int nZ = p.getLocation().getBlockZ() + paste.getSizeZ();

            Location pLoc = p.getLocation();
            Location newLoc = new Location(world, nX, nY, nZ);
            Cuboid newCuboid = new Cuboid(pLoc, newLoc);

            List<Block> blockList = paste.getBlocks();

            for(Block b : blockList) { System.out.println(b.getType() + " " + b.getX() + " " + b.getY() + " " + b.getZ()); }
        }

        return false;
    }
}
