package me.rootdeibis.mirandalib.utils;

import java.util.regex.Pattern;

import org.bukkit.ChatColor;

public class ColorUtils {   

    private static String HEX_PATTERN = "^#[a-fA-F0-9]{6}";
    
    public static String parse(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }



    public static boolean hexValidate(String hex) {
        return Pattern.compile(HEX_PATTERN).matcher(hex).find();
    }

}