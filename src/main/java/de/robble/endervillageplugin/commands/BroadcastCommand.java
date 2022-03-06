package de.robble.endervillageplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BroadcastCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(player.hasPermission("endervillage.bc")){

                String bcm = "";

                for (int i = 0; i < args.length; i++){
                    bcm = bcm + args [i] + " ";
                }
                for(Player playerAll : Bukkit.getOnlinePlayers()){
                    playerAll.sendMessage("§5§lEnderVillage: " + bcm);
                }
            }
        }
        return false;
    }
}
