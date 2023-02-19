package me.rootdeibis.mirandalib.managers.configuration;

import java.io.File;

import org.bukkit.configuration.file.YamlConfiguration;

public class IFile extends YamlConfiguration {
    
    private File file;


    public IFile(File file) {
        super();
        this.file = file;

        this.loadConfiguration();
    }


    public File getFile() {
        return file;
    }


    
    private void loadConfiguration() {
        try {

            this.load(this.file);



        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
