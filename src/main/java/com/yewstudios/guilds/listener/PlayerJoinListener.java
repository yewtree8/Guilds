package com.yewstudios.guilds.listener;

import com.yewstudios.guilds.Guilds;
import com.yewstudios.guilds.backend.db.table.PlayerProfileGenerator;
import com.yewstudios.guilds.cache.Cache;
import com.yewstudios.guilds.player.GuildPlayer;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.List;
import java.util.UUID;

/**
 * Created by Mat
 */
public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onPrejoin(AsyncPlayerPreLoginEvent e)
    {
        if(!Guilds.isLoaded())
        {
            String kickPrefix = ChatColor.GRAY + "[" + ChatColor.GOLD + "Guilds" + ChatColor.GRAY + "] " + ChatColor.WHITE + "";
            String kickMessage = kickPrefix + "Guilds is still fully stabilising, give it a second, spam joining will not help!";
            e.setKickMessage(kickMessage);
            e.setLoginResult(AsyncPlayerPreLoginEvent.Result.KICK_FULL);
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e)
    {
        Player p = e.getPlayer();
        List<UUID> safePlayers = Cache.getThreadSafePlayerList();
        UUID id = p.getUniqueId();
        safePlayers.add(id);
        if(!Guilds.getCache().isInCache(id)) //check if it's in cache.
        {
            new GuildPlayer(p.getUniqueId());
        }

    }

}
