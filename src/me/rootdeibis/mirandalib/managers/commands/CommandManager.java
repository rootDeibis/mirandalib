package me.rootdeibis.mirandalib.managers.commands;

import java.lang.reflect.Field;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;

public class CommandManager {

    public static void register(MirandaCommand mirandaCommand) {

        try {
            Field field = Bukkit.getServer().getClass().getDeclaredField("commandMap");

            field.setAccessible(true);

            CommandMap commandMap = (CommandMap) field.get(Bukkit.getServer());

            
            commandMap.register(mirandaCommand.getName(), mirandaCommand);
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
