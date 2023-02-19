package me.rootdeibis.mirandalib.utils;

import org.bukkit.ChatColor;

public class ColorUtils {   
    
    public static String apply(String colorString) {
        String parseHexColorsString = "";
        for (int i = 0; i < colorString.length(); i++) {
            if (colorString.charAt(i) == '#') {
                int j = i + 1;
                while (colorString.charAt(j) != ';') {
                    parseHexColorsString += colorString.charAt(j);
                    j++;
                }
            }
        }
        return ChatColor.translateAlternateColorCodes('&', parseHexColorsString);
    }


}