package com.yewstudios.guilds.listener;

import com.yewstudios.guilds.Guilds;
import com.yewstudios.guilds.cache.Cache;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * Created by Mat
 */
public class PlayerLeaveListener implements Listener {


    @EventHandler
    public void onLeave(PlayerQuitEvent e)
    {
        Player p = e.getPlayer();
        //TODO handle cache first before removing player from therad safe list.

        Cache.getThreadSafePlayerList().remove(p.getUniqueId());
    }


}
