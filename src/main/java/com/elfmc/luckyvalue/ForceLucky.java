package com.elfmc.luckyvalue;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class ForceLucky implements CommandExecutor {
    private static final Plugin plugin = LuckyValue.getPlugin(LuckyValue.class);

    private void sendBroadcast(String message) {
        for (Player player: Bukkit.getOnlinePlayers()) {
            player.sendMessage(message);
        }
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender,
                             @NotNull Command cmd,
                             @NotNull String label,
                             String[] args
    ) {
        if (cmd.getName().equalsIgnoreCase("forcelve")) {
            if (args.length > 0) {
                String otherPlayer = args[0];
                String message = GetLuckyMessage.getMessage(otherPlayer);
                sendBroadcast(message);
            }
            else {
                String message = plugin.getConfig().getString("needPlayer");
                assert message != null;
                sender.sendMessage(message);
            }
        }
        return true;
    }
}
