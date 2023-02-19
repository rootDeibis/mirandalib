package me.rootdeibis.mirandalib.managers.configuration;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;

import me.rootdeibis.mirandalib.utils.Cache;

public class IDirectory {

    private final File directory;
    private final Cache<IFile> files = new Cache<>();

    private final FileManager fileManager;
    public IDirectory(File dir, FileManager fileManager) {
        if (!dir.exists() || !dir.isDirectory()) throw new RuntimeException("Invalid dir: " + dir.getName());
        this.directory = dir;
        this.fileManager = fileManager;

        this.loadFiles();
    }


    public File getDirectory() {
        return this.directory;
    }

    public IFile Import(String name) {
        return this.files.find(f -> f.getFile().getName().equals(name));
    }

    public void Export(String source, String dest) {
        this.fileManager.Export(source, this.directory.getName() + "/" + dest);
    }


    public Cache<IFile> getFiles() {
        return files;
    }

    private void loadFiles() {
       Arrays.stream(Objects.requireNonNull(this.directory.listFiles(f -> f.getName().endsWith(".yml"))))
               .map(IFile::new)
               .forEach(files::add);
    }
}