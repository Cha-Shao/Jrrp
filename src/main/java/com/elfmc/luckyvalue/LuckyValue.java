package com.elfmc.luckyvalue;

import org.bukkit.plugin.java.JavaPlugin;

public final class LuckyValue extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        try {
            getConfig().options().copyDefaults();
            saveDefaultConfig();
        } catch (Exception e) {
            getLogger().warning("something went wrong, please check config file.");
        }

        // Bukkit.getPluginCommand("lve")).setExecutor(new CommandRegister(this);
        getCommand("lve").setExecutor(new GetLucky());
        getCommand("forcelve").setExecutor(new ForceLucky());
        getCommand("lvereload").setExecutor(new ReloadPlugin());
        getLogger().info(this.getName() + " enabled.");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info(this.getName() + " disabled.");
    }
}
