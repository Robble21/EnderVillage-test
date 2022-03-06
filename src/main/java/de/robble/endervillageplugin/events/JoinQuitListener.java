package de.robble.endervillageplugin.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinQuitListener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        event.setJoinMessage("§a>>>" + event.getPlayer().getDisplayName());
    }
    @EventHandler
    public void onQuit(PlayerQuitEvent event){
        event.setQuitMessage("§c<<<" + event.getPlayer().getDisplayName());
    }
}
