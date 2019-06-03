package com.yewstudios.guilds.io;

import com.yewstudios.guilds.Guilds;
import com.yewstudios.guilds.util.Serializer;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.IOException;

/**
 * Created by Mat
 * Super class for all files, just made for easy file management.
 * This class handles all the common methods that are used for file manipulation.
 * There will be a list of these objects but it's up to the user how they
 * store the files etc.
 *
 * "public class Config extends XFile"
 *
 * EDIT: Just realised that all our files will be XFiles...
 *
 */
public class XFile {

    private String fileName;

    private File actualFile;
    private FileConfiguration fileConfiguration;

    public XFile(String name)
    {
        this.fileName = name;
        this.actualFile = new File(Guilds.getPlugin().getDataFolder(), name + ".yml");
        this.fileConfiguration = YamlConfiguration.loadConfiguration(this.actualFile); // Statically load config, can only be done once.
        Guilds.getFileManager().getAllFiles().add(this);
    }

    public String getFileName()
    {
        return fileName;
    }

    public File getFile()
    {
        return this.actualFile;
    }

    public FileConfiguration getConfig()
    {
        return this.fileConfiguration;
    }

    /**
     * Common Getting methods.
     */

    public String getString(String path)
    {
        return getConfig().getString(path);
    }

    public int getInt(String path)
    {
        return getConfig().getInt(path);
    }

    public double getDouble(String path)
    {
        return getConfig().getDouble(path);
    }

    public ItemStack getItemStack(String path)
    {
        return getConfig().getItemStack(path);
    }

    public Location getLocation(String serializedPath){return Serializer.rebuildLocation(getConfig().getString(serializedPath));}

    /**
     * End common getting methods.
     */


    /**
     * Begin common methods within files.
     */

    public void save()
    {
        try {
            getConfig().save(this.actualFile);
        } catch(IOException e){e.printStackTrace();}
    }

    /**
     * Setting without the need for saving!
     */
    public void set(String path, int val)
    {
        getConfig().set(path, val);
        save();
    }

    public void set(String path, String val)
    {
        getConfig().set(path, val);
        save();
    }

    public void set(String path, ItemStack val)
    {
        getConfig().set(path, val);
        save();
    }

    public void set(String path, double val)
    {
        getConfig().set(path, val);
        save();
    }

    /**
     * So you can serialize locations easy.
     * @param path - path of serialized location.
     * @param location - location to serialize
     */
    public void set(String path, Location location)
    {
        getConfig().set(path, Serializer.serializeLocation(location));
        save();
    }

    public void removePath(String path)
    {
        getConfig().set(path, null);
        save();
    }

    /**
     * End setting.
     */



}
