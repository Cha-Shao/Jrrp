package com.elfmc.luckyvalue;

import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class GetLuckyMessage {
    private static final Plugin plugin = LuckyValue.getPlugin(LuckyValue.class);
    public static String getMessage(@NotNull String playerName) {
        int seed = (
                plugin.getConfig().getString("secret")
                        + playerName
                        + LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"))).hashCode();
        Random randomNumb = new Random(seed);
        int luckyValue = randomNumb.nextInt(100) + 1;
        String message;
        if (luckyValue == 100) {
            message = plugin.getConfig().getString("message.at_100");
        } else if (luckyValue == 99) {
            message = plugin.getConfig().getString("message.at_99");
        } else if (luckyValue >= 90) {
            message = plugin.getConfig().getString("message.lt_90");
        } else if (luckyValue >= 60) {
            message = plugin.getConfig().getString("message.lt_60");
        } else if (luckyValue > 50) {
            message = plugin.getConfig().getString("message.lt_50");
        } else if (luckyValue == 50) {
            message = plugin.getConfig().getString("message.at_50");
        } else if (luckyValue >= 40) {
            message = plugin.getConfig().getString("message.lt_40");
        } else if (luckyValue >= 11) {
            message = plugin.getConfig().getString("message.lt_11");
        } else if (luckyValue > 1) {
            message = plugin.getConfig().getString("message.lt_1");
        }else {
            message = plugin.getConfig().getString("message.at_1");
        }
        assert message != null;
        message = message.
                replace("{player}", playerName)
                .replace("{value}", String.valueOf(luckyValue));
        return message;
    }
}
