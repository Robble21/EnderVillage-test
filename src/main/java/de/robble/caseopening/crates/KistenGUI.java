package de.robble.caseopening.crates;

import de.robble.caseopening.utils.openKistenGUI1;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class KistenGUI implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        openKistenGUI1.OKG1((Player) sender);
        return false;
    }
}
