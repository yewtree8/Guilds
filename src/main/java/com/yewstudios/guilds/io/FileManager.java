package com.yewstudios.guilds.io;

import com.yewstudios.guilds.io.files.Config;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mat
 * Basic methods in here for managing collections of files.
 */
public class FileManager {

    private List<XFile> allFiles;

    public FileManager()
    {
        allFiles = new ArrayList<>();
    }

    public void loadFiles()
    {
        new Config();
    }

    public List<XFile> getAllFiles()
    {
        return allFiles;
    }


    /***
     * Get a specific XFile by name
     * @param name - Name of file WITHOUT the .yml
     * @return The XFile with that given name
     */
    public XFile getFile(String name)
    {
        return getAllFiles().stream().filter(file -> file.getFileName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

}
