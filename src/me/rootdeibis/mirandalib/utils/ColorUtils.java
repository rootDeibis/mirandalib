package me.rootdeibis.mirandalib.utils;

import java.util.regex.Pattern;

import org.bukkit.ChatColor;

public class ColorUtils {   

    private static String HEX_PATTERN = "^#[a-fA-F0-9]{6}";
    
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



    public static boolean hexValidate(String hex) {
        return Pattern.compile(HEX_PATTERN).matcher(hex).find();
    }

}