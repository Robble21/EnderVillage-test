package de.robble.endervillageplugin.commands;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            if(player.hasPermission("endervillage.fly")){
                if(args.length == 0) {
                    if (player.getAllowFlight()) {
                        if(!player.getGameMode().equals(GameMode.SPECTATOR) || !player.getGameMode().equals(GameMode.CREATIVE)) {
                            player.setAllowFlight(false);
                            player.sendMessage("§aDu kannst nun nicht mehr fliegen.");
                        }else {
                            player.sendMessage("§cDu kannst das Fliegen in diesem Spielmodus nicht beenden!");
                        }
                    } else {
                        player.setAllowFlight(true);
                        player.sendMessage("§aDu kannst nun fliegen.");
                    }
                }else if(args.length == 1){
                    if(args[0].equalsIgnoreCase("1")){
                        player.setFlySpeed((float) 0.1);
                    }else if(args[0].equalsIgnoreCase("2")){
                        player.setFlySpeed((float) 0.2);
                    }else if(args[0].equalsIgnoreCase("3")){
                        player.setFlySpeed((float) 0.3);
                    }else if(args[0].equalsIgnoreCase("4")){
                        player.setFlySpeed((float) 0.4);
                    }else if(args[0].equalsIgnoreCase("5")){
                        player.setFlySpeed((float) 0.5);
                    }else{
                        player.sendMessage("§4Bitte nutze /fly [1-5]");
                    }
                }
            }
            else player.sendMessage("§4Dazu hast du keine rechte! §6(endervillage.fly)");
        }
        return false;
    }
}
