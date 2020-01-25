package com.github.sgehren.buildpro;

import com.github.sgehren.buildpro.editor.Selection;
import com.github.sgehren.buildpro.shapes.Cuboid;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;

public class Events implements Listener {

    Selection selection = new Selection();

    public static Location primarySelection;
    public static Location secondarySelection;

    public static Cuboid cuboid;

    public boolean wandOnJoin = true;

    public Events() {}

    public Events(Core core)
    {
        core.getServer().getPluginManager().registerEvents(this, core);
    }

    //We can add the builders wand to the players inventory as soon as we join the lobby as
    //long as its "true" in the config
    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerJoin(PlayerJoinEvent event)
    {
        Player p = event.getPlayer();       //Get the player that joined

        p.sendMessage("Welcome Back " + p.getDisplayName());        //Welcome them to the server

        if(wandOnJoin)      //Check if the wandOnJoin config variable is enabled or not
        {
            Inventory inv = p.getInventory();                           //Get the players inventory
            if(!inv.contains(Selection.WAND))                           //Check if they already have a selector
                inv.addItem(Selection.WAND);                            //If they do not, then give them the selector
        }
    }

    /*
     * Handles when the player makes a selection with the selector object (WOODEN_AXE)
     *
     * Get the block that was clicked and the location of the block, make sure they were not previously selected,
     * then save the selected block to the primary and secondary locations so they can be modified by other
     * commands.
     */
    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerInteract(PlayerInteractEvent event)
    {
        Player p = event.getPlayer();       //Get the player that triggered the event
        Action act = event.getAction();     //Get the action type for they event (interation)

        Block blockA, blockB;               //Our blocks that are being selected by the user

        if((event.getAction() != Action.RIGHT_CLICK_AIR) && (event.getAction() == Action.RIGHT_CLICK_BLOCK && event.getHand() == EquipmentSlot.HAND) && (event.getItem().getType() == Material.WOODEN_AXE))
        {
            blockB = event.getClickedBlock();
            if(secondarySelection != secondarySelection || secondarySelection == null)      //Make this selection as long as the location is not the same or is null
            {
                secondarySelection = blockB.getLocation();
                p.sendMessage("Location X: " + secondarySelection.getBlockX() + " Y: " + secondarySelection.getBlockY() + " Z: " + secondarySelection.getBlockZ() + " selected!");
            }
        }

        else if ((event.getAction() == Action.LEFT_CLICK_BLOCK) && (event.getItem().getType() == Material.WOODEN_AXE) && (event.getHand() == EquipmentSlot.HAND))
        {
            blockA = event.getClickedBlock();
            if(primarySelection != primarySelection || primarySelection == null)        //Make this selection if the location is not the same or is null
            {
                primarySelection = blockA.getLocation();
                p.sendMessage("Location X: " + primarySelection.getBlockX() + " Y: " + primarySelection.getBlockY() + " Z: " + primarySelection.getBlockZ() + " selected!");
            }
        }

        if(secondarySelection != null && primarySelection != null) {
            cuboid = new Cuboid(this.primarySelection, this.secondarySelection);
        }
    }
}
