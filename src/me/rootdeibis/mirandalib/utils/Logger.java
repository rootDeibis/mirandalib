package me.rootdeibis.mirandalib.utils;

import java.util.List;
import java.util.stream.Collectors;


public class Logger {




    public static void info(String message, Object... params) {
        info(PlaceholderFormat.parseParams(message, params));
    }

    public static void info(List<String> messageList, Object... params) {
        info(messageList.stream().map(str -> PlaceholderFormat.parseParams(str, params)).collect(Collectors.toList()));
    }

    



    
}
