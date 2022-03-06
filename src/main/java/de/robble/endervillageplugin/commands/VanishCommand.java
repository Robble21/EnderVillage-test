package de.robble.endervillageplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class VanishCommand implements CommandExecutor {
    public List<Player> playersInVanish = new ArrayList<>();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            if(player.hasPermission("endervillage.vanish")){
                if(!playersInVanish.contains(player)){
                    for(Player playerAll : Bukkit.getOnlinePlayers()){
                        if(!playersInVanish.contains(playerAll)){
                            playerAll.hidePlayer(player);
                        }
                    }
                    player.setCanPickupItems(false);
                    playersInVanish.add(player);
                }else{
                    playersInVanish.remove(player);
                    for(Player playerAll : Bukkit.getOnlinePlayers()){
                        playerAll.showPlayer(player);
                    }
                    player.setCanPickupItems(false);
                }
            }
        }
        return false;
    }
}
