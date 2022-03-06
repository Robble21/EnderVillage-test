package de.robble.endervillageplugin.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.help.HelpTopic;

public class CommandListener implements Listener {

    @EventHandler(priority = EventPriority.NORMAL)
    public void onCommand(PlayerCommandPreprocessEvent event){
        if(!event.isCancelled()){
            Player p = event.getPlayer();
            String msg = event.getMessage().split(" ")[0];
            HelpTopic topic = Bukkit.getServer().getHelpMap().getHelpTopic(msg);

            if(topic == null){
                p.sendMessage("§4Dieser Command wurde nicht gefunden!");
                event.setCancelled(true);
            }
        }
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onCommandPL(PlayerCommandPreprocessEvent event) {
        Player player = event.getPlayer();
        String command = event.getMessage();
        if (command.equalsIgnoreCase("pl") || command.equalsIgnoreCase("plugins")){
            if(!player.isOp()){
                event.setCancelled(true);
                player.sendMessage("Plugins: §aNope :O");
            }
        }
    }
}
