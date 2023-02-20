package me.rootdeibis.mirandalib.utils;

public class PlaceholderFormat {


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
