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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Paste implements CommandExecutor {

    Events events = new Events();

    private static Location locationOfPlayerAtPaste;                    //Player location at time of paste

    private Location blockLoc1 = events.primarySelection;               //Location of our first selection
    private Location blockLoc2 = events.secondarySelection;             //Location of our second selection


    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {

        if(sender instanceof Player)                                    //Is the sender an instance of a player? If not, return false
        {
            Player p = (Player) sender;
            World world = p.getWorld();

            Cuboid paste = Copy.copy;

            List<Block> blocksInCuboid = paste.getBlocks();

            int nX = p.getLocation().getBlockX() + paste.getSizeX();
            int nY = p.getLocation().getBlockY() + paste.getSizeY();
            int nZ = p.getLocation().getBlockZ() + paste.getSizeZ();

            int i = 0;

            for(int x = p.getLocation().getBlockX(); x <= nX; x++) {
                for(int y = p.getLocation().getBlockY(); y <= nY; y++) {
                    for(int z = p.getLocation().getBlockZ(); z <= nZ; z++) {
                        world.getBlockAt(x, y, z).setType(blocksInCuboid.get(i).getType());
                        i++;
                    }
                }
            }
        }

        return false;
    }
}
