package com.github.sgehren.buildpro.commands;

import com.github.sgehren.buildpro.Events;
import com.github.sgehren.buildpro.editor.Facing;
import com.github.sgehren.buildpro.editor.Stairs;
import com.github.sgehren.buildpro.shapes.Cuboid;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Directional;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Rotate implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {

        if(sender instanceof Player) {

            Player player = (Player) sender;

            if(strings[0].equalsIgnoreCase("stairs")) {             //If the command arg is equal to stairs, we will rotate the stairs
                Cuboid cuboid = new Cuboid(Events.primarySelection, Events.secondarySelection);

                for(Block b : cuboid) {
                    if(Stairs.isStair(b.getType())) {
                        BlockData data = b.getBlockData();
                        if(data instanceof Directional) {
                            Directional direct = (Directional) data;
                            direct.setFacing(Facing.getFacingFromString(strings[1]));
                            b.setBlockData(direct);
                        }
                    }
                }
            }

            else if(strings[0].equalsIgnoreCase("piston")) {
                Cuboid cuboid = new Cuboid(Events.primarySelection, Events.secondarySelection);

                for(Block b : cuboid) {
                    if(b.getType() == Material.PISTON) {
                        BlockData data = b.getBlockData();
                        if(data instanceof Directional) {
                            Directional direct = (Directional) data;
                            direct.setFacing(Facing.getFacingFromString(strings[1]));
                            b.setBlockData(direct);

                        }
                    }
                }
            }

            if(strings[0].equalsIgnoreCase("block")) {
                Cuboid cuboid = new Cuboid(Events.primarySelection);

                for(Block b : cuboid) {
                    BlockData data = b.getBlockData();
                    if(data instanceof Directional) {
                        Directional direct = (Directional) data;
                        direct.setFacing(Facing.getFacingFromString(strings[1]));
                        b.setBlockData(direct);
                    }
                }
            }
        }

        return false;
    }
}
