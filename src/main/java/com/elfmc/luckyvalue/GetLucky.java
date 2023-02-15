package com.elfmc.luckyvalue;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class GetLucky implements CommandExecutor {
    Plugin plugin;

    public GetLucky() {
        this.plugin = LuckyValue.getPlugin(LuckyValue.class);
    }

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
        if (cmd.getName().equalsIgnoreCase("lve")) {
            if (args.length == 0) {
                int luckyValue = GetData.getValue(sender.getName());
                String message = GetData.getMessage(sender.getName(), luckyValue);
                String command = GetData.getCommand(sender.getName(), luckyValue);
                if (command != null)
                    RunCommand.asConsole(command);
                sendBroadcast(message);
                Bukkit.getServer().getConsoleSender().sendMessage(message);
            }
            else {
                if (sender.hasPermission("lve.other")) {
                    String otherPlayer = args[0];
                    Player onlineStatus = Bukkit.getPlayer(otherPlayer);
                    if (onlineStatus != null) {
                        int luckyValue = GetData.getValue(sender.getName());
                        String message = GetData.getMessage(sender.getName(), luckyValue);
                        String command = GetData.getCommand(sender.getName(), luckyValue);
                        if (command != null)
                            RunCommand.asConsole(command);
                        sendBroadcast(message);
                    }
                    else {
                        String message = plugin.getConfig().getString("notOnline");
                        assert message != null;
                        sender.sendMessage(message);
                    }
                }
                else {
                    String message = plugin.getConfig().getString("noPermission");
                    assert message != null;
                    sender.sendMessage(message);
                }
            }
        }
        return true;
    }
}
