package com.yewstudios.guilds;

import com.yewstudios.guilds.backend.db.Database;
import com.yewstudios.guilds.backend.db.table.TableGenerator;
import com.yewstudios.guilds.cache.Cache;
import com.yewstudios.guilds.cmd.GuildCommand;
import com.yewstudios.guilds.io.FileManager;
import com.yewstudios.guilds.listener.GuildChatListener;
import com.yewstudios.guilds.listener.PlayerJoinListener;
import com.yewstudios.guilds.listener.PlayerLeaveListener;
import com.yewstudios.guilds.listener.PlayerMovementListener;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.event.Listener;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author Mat
 */
public class Guilds extends JavaPlugin {


    private static Guilds instance;
    public static Guilds getPlugin(){return instance;}

    private static boolean loaded; //making sure there's no fuckery.

    private static Economy economy;

    private Listener[] listenerList =
            {
                    new PlayerJoinListener(),
                    new GuildChatListener(),
                    new PlayerJoinListener(),
                    new PlayerMovementListener(),
                    new PlayerLeaveListener(),
            };

    public static void log(String msg){System.out.println("[Guilds] -> " + msg);}
    public static void bigLogMessage(String msg)
    {
        System.out.println("============================");
        System.out.println("[Guilds] -> " + msg);
        System.out.println("============================");
    }

    private static FileManager fileManager;

    private static Database database;

    private static Cache pluginCache;


    public void onEnable()
    {
        instance = this;
        loaded = false;
        init();
        loaded = true;
    }

    public void onDisable()
    {
        getDatabase().getSource().close();
    }

    private void init()
    {
        bigLogMessage("Guilds is loading!");
        registerListeners();
        setupEconomy();
        loadFiles();
        loadDatabaseComponents();
        registerCommands();
        loadCache();
        log("All done and loaded!");
    }

    private void loadFiles()
    {
        log("Loading files...");
        fileManager = new FileManager();
        getFileManager().loadFiles();
    }

    private void loadDatabaseComponents()
    {
        log("Loading database components...");
        database = new Database();
        new TableGenerator(getDatabase()).generateProfileTable();
    }

    private void registerListeners()
    {
        log("Registering event listeners...");
        for(Listener listener : listenerList)
        {
            this.getServer().getPluginManager().registerEvents(listener, this);
        }
    }

    private boolean setupEconomy()
    {
        log("Hooking and registering economy w/ vault");
        RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
        if (economyProvider != null) {
            economy = economyProvider.getProvider();
            log("Economy hooked!");
        }

        return (economy != null);
    }

    private void loadCache()
    {
        log("Loading cache base...");
        pluginCache = new Cache();
    }

    private void registerCommands()
    {
        this.getCommand("guild").setExecutor(new GuildCommand());
    }

    public static boolean isLoaded() { return loaded; }

    public static FileManager getFileManager()
    {
        return fileManager;
    }

    public static Database getDatabase() { return database; }

    public static Economy getEconomy() {return economy;}

    public static Cache getCache() { return pluginCache; }

}
