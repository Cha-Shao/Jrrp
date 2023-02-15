package com.elfmc.luckyvalue;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.OfflinePlayer;

public class LuckyValueExpansion extends PlaceholderExpansion {

    @Override
    public String getAuthor() {
        return "Cha_Shao";
    }

    @Override
    public String getIdentifier() {
        return "luckyvalue";
    }

    @Override
    public String getVersion() {
        return "1.2.2";
    }

    @Override
    public boolean persist() {
        return true;
    }

    @Override
    public boolean canRegister() {
        return true;
    }

    @Override
    public String onRequest(OfflinePlayer player, String params) {
        if (params.equals("")) {
            return String.valueOf(GetData.getValue(player.getName()));
        } else {
            return String.valueOf(GetData.getValue(params));
        }
    }
}
