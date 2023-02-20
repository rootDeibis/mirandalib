package me.rootdeibis.mirandalib.managers.commands;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public abstract class MirandaCommand extends Command {

    protected MirandaCommand(String name) {
        super(name);
    }

    protected MirandaCommand(String name, String description) {
        super(name);

        this.setDescription(description);
    }

    protected MirandaCommand(String name, String description, String... aliases) {
        super(name);

        this.setDescription(description);
        this.setAliases(Arrays.stream(aliases).collect(Collectors.toList()));

    }

    @Override
    public boolean execute(CommandSender arg0, String arg1, String[] arg2) {
        return this.handle(arg0, arg1, this, arg2);
    }

    abstract boolean handle(CommandSender sender, String label, Command command, String[] args);

    
    
}
