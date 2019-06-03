package com.yewstudios.guilds.cache;

import com.yewstudios.guilds.Guilds;
import com.yewstudios.guilds.guild.Guild;
import com.yewstudios.guilds.player.GuildPlayer;
import javafx.beans.binding.ObjectExpression;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created Mat
 *
 * Base cache for everything, players, guilds, profiles, the lot.
 *
 * Can't be slowing down the server
 *
 * Just holds and clears.
 */
public final class Cache {

    private static List<UUID> threadSafePlayerList = new ArrayList<>();
    public static List<UUID> getThreadSafePlayerList(){return threadSafePlayerList; }

    public static final int MAXIMUM_MINUTE_CLEARANCE = 30;

    private ConcurrentHashMap<UUID, GuildPlayer> playerMap;

    private BukkitTask playerTimer;

    private boolean checking;

    private final long CACHE_CHECK_PERIOD = (20L * 60L);


    public Cache()
    {
        this.checking = false;
        this.playerMap = new ConcurrentHashMap<>();
        beginCacheClearanceTimer();
    }

    public GuildPlayer getGuildPlayer(UUID id)
    {
        return playerMap.get(id);
    }

    public void addToPlayerCache(GuildPlayer player)
    {
        playerMap.put(player.getUUID(), player);
    }

    public boolean isInCache(UUID id)
    {
        return this.playerMap.containsKey(id);
    }

    /**
     * Async cache clearance timer, checks every minute
     * Timeout for clearance definable above.
     */
    private void beginCacheClearanceTimer()
    {
        this.playerTimer =
                new BukkitRunnable()
                {
                    public void run()
                    {
                        /*
                            begin iteration over guildplayer set.
                         */
                        Iterator playerIterator = playerMap.entrySet().iterator();
                        while(playerIterator.hasNext())
                        {
                            Map.Entry currentSet = (Map.Entry) playerIterator.next();
                            GuildPlayer currentValue = (GuildPlayer) currentSet.getValue();
                            if(currentValue.followCacheTick())
                            {
                                currentValue.saveDataToDatabase(); //call synchronised method
                                playerIterator.remove(); //THEN once it's done remove it from them for the cache.
                            }
                        }

                        /*
                        Next thing below
                         */

                    }
                }.runTaskTimerAsynchronously(Guilds.getPlugin(), 120L, CACHE_CHECK_PERIOD);
    }








}
