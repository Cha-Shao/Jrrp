package com.elfmc.luckyvalue;

import org.bukkit.Bukkit;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class LuckyValue extends JavaPlugin {

    private void setupConfig() {
        // 加载配置文件
        try {
            getConfig().options().copyDefaults();
            saveDefaultConfig();
        } catch (Exception e) {
            getLogger().warning("配置文件有误，请检查。");
        }
    }
    private void setupCommand() {
        // 注册指令
        final PluginCommand baseCommand = getCommand("lve");
        final PluginCommand forceCommand = getCommand("lveforce");
        final PluginCommand reloadCommand = getCommand("lvereload");
        if (baseCommand == null || forceCommand == null || reloadCommand == null) {
            return;
        }

        baseCommand.setExecutor(new GetLucky());
        forceCommand.setExecutor(new ForceLucky());
        reloadCommand.setExecutor(new ReloadPlugin());
    }

    @Override
    public void onEnable() {
        // Plugin startup logic

        setupConfig();
        setupCommand();
        new LuckyValueExpansion().register();

        getLogger().info(this.getName() + " enabled.");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info(this.getName() + " disabled.");
    }
}
