package com.github.sgehren.buildpro.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

public class SchematicUI implements CommandExecutor {

    public static Inventory inv = Bukkit.createInventory(null, 9, "Schematic Manager");

    static {
        inv.setItem(4, new ItemStack(Selector.customItem(new ItemStack(Material.REDSTONE_BLOCK), "New Schematic")));
        inv.setItem(6, new ItemStack(Selector.customItem(new ItemStack(Material.EMERALD_BLOCK), "Existing Schematic")));
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {

        if (sender instanceof Player) {
            Player p = (Player) sender;

            //create the inventory and load the schematics into the inventory to be selected for loading
            p.openInventory(inv);
        }

        return false;
    }
}
