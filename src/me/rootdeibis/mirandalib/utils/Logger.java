package me.rootdeibis.mirandalib.utils;

import java.util.List;

import org.bukkit.Bukkit;

public class Logger {

    private String PREFIX = "[MirandaLIB]";

    public Logger() {
    }



    public void info(String message) {
        Bukkit.getConsoleSender().sendMessage(ColorUtils.apply(message));
    }

    public void info(List<String> messageList) {
        info(String.join("\n", messageList));
    }



    public void setPrefix(String prefix) {
        this.PREFIX = prefix;
    }

    public String getPrefix() {
        return this.PREFIX;
    }


    
}
