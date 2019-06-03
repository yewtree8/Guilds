package com.yewstudios.guilds.util;

import com.yewstudios.guilds.Guilds;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;

import java.util.UUID;

/**
 * Created by mat
 */
public class EconUtil {


    public static boolean hasEnough(UUID id, double amount)
    {
        OfflinePlayer pl = Bukkit.getOfflinePlayer(id);
        double balance = Guilds.getEconomy().getBalance(pl);

        return balance >= amount;
    }



}
