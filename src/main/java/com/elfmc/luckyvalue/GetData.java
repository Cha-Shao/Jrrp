package com.elfmc.luckyvalue;

import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class GetData {
    private static final Plugin plugin = LuckyValue.getPlugin(LuckyValue.class);
    public static int getValue(@NotNull String playerName) {
        int seed = (
                plugin.getConfig().getString("secret")
                        + playerName
                        + LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"))).hashCode();
        Random randomNumb = new Random(seed);
        return randomNumb.nextInt(100) + 1;
    }

    public static String getMessage(@NotNull String playerName,
                                    int luckyValue
    ) {
        String message;
        if (luckyValue == 100) {
            message = plugin.getConfig().getString("message.at_100.message");
        } else if (luckyValue == 99) {
            message = plugin.getConfig().getString("message.at_99.message");
        } else if (luckyValue >= 90) {
            message = plugin.getConfig().getString("message.lt_90.message");
        } else if (luckyValue >= 60) {
            message = plugin.getConfig().getString("message.lt_60.message");
        } else if (luckyValue > 50) {
            message = plugin.getConfig().getString("message.lt_50.message");
        } else if (luckyValue == 50) {
            message = plugin.getConfig().getString("message.at_50.message");
        } else if (luckyValue >= 40) {
            message = plugin.getConfig().getString("message.lt_40.message");
        } else if (luckyValue >= 11) {
            message = plugin.getConfig().getString("message.lt_11.message");
        } else if (luckyValue > 1) {
            message = plugin.getConfig().getString("message.lt_1.message");
        }else {
            message = plugin.getConfig().getString("message.at_1.message");
        }
        assert message != null;
        message = message.
                replace("{player}", playerName)
                .replace("{value}", String.valueOf(luckyValue));
        return message;
    }

    public static String getCommand(@NotNull String playerName,
                                    int luckyValue
    ) {
        String command;
        if (luckyValue == 100) {
            command = plugin.getConfig().getString("message.at_100.command");
        } else if (luckyValue == 99) {
            command = plugin.getConfig().getString("message.at_99.command");
        } else if (luckyValue >= 90) {
            command = plugin.getConfig().getString("message.lt_90.command");
        } else if (luckyValue >= 60) {
            command = plugin.getConfig().getString("message.lt_60.command");
        } else if (luckyValue > 50) {
            command = plugin.getConfig().getString("message.lt_50.command");
        } else if (luckyValue == 50) {
            command = plugin.getConfig().getString("message.at_50.command");
        } else if (luckyValue >= 40) {
            command = plugin.getConfig().getString("message.lt_40.command");
        } else if (luckyValue >= 11) {
            command = plugin.getConfig().getString("message.lt_11.command");
        } else if (luckyValue > 1) {
            command = plugin.getConfig().getString("message.lt_1.command");
        }else {
            command = plugin.getConfig().getString("message.at_1.command");
        }
        if (command != null) command = command.replace("{player}", playerName);
        return command;
    }
}
