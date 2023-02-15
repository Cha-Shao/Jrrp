package com.elfmc.luckyvalue;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class ReloadPlugin implements CommandExecutor {

    private static final Plugin plugin = LuckyValue.getPlugin(LuckyValue.class);

    @Override
    public boolean onCommand(@NotNull CommandSender sender,
                             @NotNull Command cmd,
                             @NotNull String label,
                             String[] args
    ) {
        if (cmd.getName().equalsIgnoreCase("lvereload")) {
            try {
                plugin.reloadConfig();
                Bukkit.getLogger().info("[§d" + plugin.getName() + "§r] reloaded.");
                sender.sendMessage("[§d" + plugin.getName() + "§r] reloaded.");
            } catch (Exception e) {
                Bukkit.getLogger().warning(plugin.getName() + "配置文件可能有误");
            }
        }
        else {
            String message = plugin.getConfig().getString("noPermission");
            assert message != null;
            sender.sendMessage(message);
        }
        return true;
    }
}
