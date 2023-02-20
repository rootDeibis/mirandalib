package me.rootdeibis.mirandalib.utils;

import java.util.List;

public class Logger {




    public static void info(String message, Object... params) {
        info(PlaceholderFormat.parseParams(message, params));
    }

    public static void info(List<String> messageList, Object... params) {
        info(String.join("\n", messageList));
    }

    



    
}
