package de.robble.endervillageplugin.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BreakEvent implements Listener {
    @EventHandler
    public void onBreak(BlockBreakEvent event){
        if(!event.getPlayer().hasPermission("endervillage.break")){
            if(event.getPlayer().getWorld().getName().equalsIgnoreCase("world") ||
                    event.getPlayer().getWorld().getName().equalsIgnoreCase(" WELTEN NAMEN HIER EINFÜGEN ") ||
                    event.getPlayer().getWorld().getName().equalsIgnoreCase(" WELTEN NAMEN HIER EINFÜGEN ")){
                event.setCancelled(true);
            }
        }
    }
}
