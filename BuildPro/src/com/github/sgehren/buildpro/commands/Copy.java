package com.github.sgehren.buildpro.commands;

import com.github.sgehren.buildpro.Core;
import com.github.sgehren.buildpro.Events;
import com.github.sgehren.buildpro.editor.Mathf;
import com.github.sgehren.buildpro.editor.Selection;
import com.github.sgehren.buildpro.shapes.Cuboid;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Copy implements CommandExecutor {

    Events events = new Events();

    public static List<Block> blocks = new ArrayList<>();
    public static List<Block> blocksCopy = new ArrayList<>();

    public static Cuboid copy;

    private static double playerRotationAtTimeOfCopy;           //Get the direction the player is facing at the time of copy, then put this into getCardinalDirection

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {

        if(sender instanceof Player)
        {
            Player p = (Player) sender;

            copy = new Cuboid(Events.primarySelection, Events.secondarySelection);

            if(copy != null) { p.sendMessage(ChatColor.LIGHT_PURPLE + "Your selection has been copied!"); }
        }

        return false;
    }

    public static String getCardinalDirection(Player player)
    {
        playerRotationAtTimeOfCopy = (player.getLocation().getYaw() - 90) % 360;

        if (playerRotationAtTimeOfCopy < 0) {
            playerRotationAtTimeOfCopy += 360.0;
        }
        if (0 <= playerRotationAtTimeOfCopy && playerRotationAtTimeOfCopy < 22.5) {
            return "N";
        } else if (22.5 <= playerRotationAtTimeOfCopy && playerRotationAtTimeOfCopy < 67.5) {
            return "NE";
        } else if (67.5 <= playerRotationAtTimeOfCopy && playerRotationAtTimeOfCopy < 112.5) {
            return "E";
        } else if (112.5 <= playerRotationAtTimeOfCopy && playerRotationAtTimeOfCopy < 157.5) {
            return "SE";
        } else if (157.5 <= playerRotationAtTimeOfCopy && playerRotationAtTimeOfCopy < 202.5) {
            return "S";
        } else if (202.5 <= playerRotationAtTimeOfCopy && playerRotationAtTimeOfCopy < 247.5) {
            return "SW";
        } else if (247.5 <= playerRotationAtTimeOfCopy && playerRotationAtTimeOfCopy < 292.5) {
            return "W";
        } else if (292.5 <= playerRotationAtTimeOfCopy && playerRotationAtTimeOfCopy < 337.5) {
            return "NW";
        } else if (337.5 <= playerRotationAtTimeOfCopy && playerRotationAtTimeOfCopy < 360.0) {
            return "N";
        } else {
            return null;
        }
    }
}
