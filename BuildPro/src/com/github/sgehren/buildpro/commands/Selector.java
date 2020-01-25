package com.github.sgehren.buildpro.commands;

import com.github.sgehren.buildpro.editor.Selection;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class Selector implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {

        if(sender instanceof Player)
        {
            Player p = (Player) sender;
            Inventory inv = p.getInventory();

            inv.addItem(new ItemStack(Selection.WAND));

            p.sendMessage(ChatColor.GREEN + "Selector tool has been given.");
        }

        return false;
    }

    public static ItemStack customItem(ItemStack item, String name)
    {
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.LIGHT_PURPLE + name);
        item.setItemMeta(meta);

        return item;
    }
}
