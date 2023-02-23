package me.rootdeibis.mirandalib.utils;

import java.util.HashMap;

public class PlaceholderFormat {

    private final HashMap<String, String> placeholders = new HashMap<>();


    public PlaceholderFormat() {

    }

    public void register(String key, Object value) {
        placeholders.put(key, String.valueOf(value));
    }

    public void remove(String key) {
        placeholders.remove(key);
    }

    public String parse(String str) {
        String parsedStr = str;


        for(String key : placeholders.keySet()) {
            parsedStr = parsedStr.replaceAll("<" + key + ">", placeholders.get(key));
        }

        return parsedStr;

    }



    public static String parseParams(String message, Object... params) {
        StringBuilder builder = new StringBuilder();

        int currentParam = 0;

        for(int i = 0; i < message.length(); i++) {

            if(i + 1 <= message.length() && message.charAt(i) == '%' && message.charAt(i + 1) == 's') {
                builder.append(params[currentParam]);

                currentParam++;
                i++;
            } else {
                builder.append(message.charAt(i));
            }
        }

        return builder.toString();

    }
    
}
