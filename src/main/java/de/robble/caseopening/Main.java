package de.robble.caseopening;

import de.robble.caseopening.crates.*;
import de.robble.caseopening.mysql.DatabaseManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.SQLException;

public final class Main extends JavaPlugin {
    private DatabaseManager databaseManager;
    private static Main instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        Register();
        instance = this;
        databaseManager = new DatabaseManager();
        try {
            databaseManager.connect();
        } catch (SQLException e) {
            System.out.println();
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void Register(){
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new InventoryClickListener(), this);
        pluginManager.registerEvents(new DorfKisteSpinning(), this);
        pluginManager.registerEvents(new EnderkisteSpinning(), this);
        pluginManager.registerEvents(new VillagerkisteSpinning(), this);

        Bukkit.getPluginCommand("kisten").setExecutor(new KistenGUI());
        Bukkit.getPluginCommand("dkspin").setExecutor(new DorfKisteSpinning());
        Bukkit.getPluginCommand("ekspin").setExecutor(new EnderkisteSpinning());
        Bukkit.getPluginCommand("vkspin").setExecutor(new VillagerkisteSpinning());

    }

    public DatabaseManager getDatabaseManager() {
        return databaseManager;
    }

    public static Main getInstance() {
        return instance;
    }
}
