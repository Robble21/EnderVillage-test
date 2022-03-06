package de.robble.endervillageplugin;

import de.robble.endervillageplugin.commands.BroadcastCommand;
import de.robble.endervillageplugin.commands.FlyCommand;
import de.robble.endervillageplugin.commands.InvseeCommand;
import de.robble.endervillageplugin.commands.VanishCommand;
import de.robble.endervillageplugin.events.BreakEvent;
import de.robble.endervillageplugin.events.CommandListener;
import de.robble.endervillageplugin.events.JoinQuitListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.Register();
        log("EnderVillage Plugin erfolgreich hochgefahren.");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        log("EnderVillage Plugin erfolgreich heruntergefahren.");
    }

    public void log(String text){
        Bukkit.getConsoleSender().sendMessage(text);
    }

    public void Register(){
        Bukkit.getPluginCommand("fly").setExecutor(new FlyCommand());
        Bukkit.getPluginCommand("vanish").setExecutor(new VanishCommand());
        Bukkit.getPluginCommand("invsee").setExecutor(new InvseeCommand());
        Bukkit.getPluginCommand("bc").setExecutor(new BroadcastCommand());

        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new BreakEvent(), this);
        pluginManager.registerEvents(new JoinQuitListener(), this);
        pluginManager.registerEvents(new CommandListener(), this);
    }
}
