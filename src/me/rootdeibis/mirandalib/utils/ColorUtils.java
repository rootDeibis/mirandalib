package me.rootdeibis.mirandalib.utils;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.bukkit.ChatColor;

public class ColorUtils {   

    private static String HEX_PATTERN = "^#[a-fA-F0-9]{6}";
    
    public static String parse(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }

    public static List<String> parse(List<String> list) {
        return list.stream().map(str -> parse(str)).collect(Collectors.toList());
    }


    public static boolean hexValidate(String hex) {
        return Pattern.compile(HEX_PATTERN).matcher(hex).find();
    }

}