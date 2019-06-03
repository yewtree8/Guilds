package com.yewstudios.guilds.util;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mat
 *
 * Acts as a serializer for locations in an easier way,
 * Can also be used for storage in files or in a hashmap, as strings are
 * smaller than the location object, rebuild it when you get the string.
 */
public final class Serializer {


    public static String serializeLocation(Location loc)
    {
        double x = loc.getX();
        double y = loc.getY();
        double z = loc.getZ();
        String world = loc.getWorld().getName();
        float pitch = loc.getPitch();
        float yaw = loc.getYaw();

        String serializedLocation = x+","+y+","+z+","+world+","+pitch+","+yaw;

        return serializedLocation;
    }


    public static Location rebuildLocation(String serializedLocation)
    {
        String[] tokens = serializedLocation.split(",");
        double x = Double.parseDouble(tokens[0]);
        double y = Double.parseDouble(tokens[1]);
        double z = Double.parseDouble(tokens[2]);
        World world = Bukkit.getWorld(tokens[3]);

        float pitch = Float.parseFloat(tokens[4]);

        float yaw = Float.parseFloat(tokens[5]);

        Location rebuiltLocation = new Location(world, x, y, z);

        rebuiltLocation.setPitch(pitch);
        rebuiltLocation.setYaw(yaw);

        return rebuiltLocation;
    }


    public static List<Location> convertSerializedLocationList(List<String> serializedLocations)
    {
        List<Location> newList = new ArrayList<Location>();
        serializedLocations.forEach( serializedLocation -> {

            Location rebuiltLocation = rebuildLocation(serializedLocation);
            newList.add(rebuiltLocation);

        });
        return newList;
    }



}
