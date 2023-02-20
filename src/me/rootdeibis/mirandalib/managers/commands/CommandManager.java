package me.rootdeibis.mirandalib.managers.commands;

import java.lang.reflect.Field;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;

public class CommandManager {

    public static void register(String[] names, CommandExecutor executor) {

        try {
            Field field = Bukkit.getServer().getClass().getDeclaredField("commandMap");

            field.setAccessible(true);

            CommandMap commandMap = (CommandMap) field.get(Bukkit.getServer());

            for (String alias : names) {
                commandMap.register(alias, createCommand(alias, executor));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static Command createCommand(String name,CommandExecutor executor) {
       return new Command(name) {
        @Override
        public boolean execute(CommandSender arg0, String arg1, String[] arg2) {
            return executor.onCommand(arg0, this, arg1, arg2);
        }
       };
    }
    
}
