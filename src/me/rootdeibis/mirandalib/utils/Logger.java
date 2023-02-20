package me.rootdeibis.mirandalib.utils;

import java.util.List;

import org.bukkit.Bukkit;

public class Logger {




    public static void info(String message, Object... params) {
        Bukkit.getConsoleSender().sendMessage(ColorUtils.parse(PlaceholderFormat.parseParams(message, params)));
    }

    public static void info(List<String> messageList, Object... params) {
        info(String.join("\n", messageList));
    }

    



    
}
