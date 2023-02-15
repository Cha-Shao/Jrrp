package com.elfmc.luckyvalue;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class RunCommand {
    private static final Plugin plugin = LuckyValue.getPlugin(LuckyValue.class);
    public static void asConsole(String command) {
        plugin.getServer().dispatchCommand(plugin.getServer().getConsoleSender(), command);
    }
}
