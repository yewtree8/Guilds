package com.yewstudios.guilds.player;

import com.yewstudios.guilds.Guilds;
import com.yewstudios.guilds.cache.Cache;
import com.yewstudios.guilds.player.profile.PlayerProfile;

import java.util.List;
import java.util.UUID;

/**
 * Created by Mat
 */
public class GuildPlayer {

    private UUID id;

    private boolean guildChatting;

    private PlayerProfile profile;

    protected int minutesOffline;

    public GuildPlayer(UUID id)
    {
        this.id = id;
        this.guildChatting = false;
        profile = new PlayerProfile(getUUID());
        minutesOffline = 0;
        Guilds.getCache().addToPlayerCache(this); //add to cache
    }

    /**
     * ASYC SAFE METHOD.
     * Method for checking whether or not to end up clearing
     * player data from the cache.
     * @return Whether to follow through with saving data
     * and remove from cache.
     */
    public boolean followCacheTick()
    {
        List<UUID> currentOnline = Cache.getThreadSafePlayerList();
        boolean online = currentOnline.contains(getUUID());
        if(online) //player is online.
        {
            minutesOffline = 0; //Just always set the value, no need for a useless ternary.
            return false;
        }
        else
        {
            incrementMinutesOffline();
            return minutesOffline >= Cache.MAXIMUM_MINUTE_CLEARANCE; //whether or not they've been off for 30 minutes.
        }
    }

    protected int getMinutesOffline()
    {
        return this.minutesOffline;
    }

    protected void incrementMinutesOffline()
    {
        this.minutesOffline++;
    }

    public void toggleChatMode()
    {
        this.guildChatting = !guildChatting;
    }

    public UUID getUUID()
    {
        return this.id;
    }

    public static GuildPlayer getPlayer(UUID id)
    {
        return Guilds.getCache().getGuildPlayer(id);
    }

    public synchronized void saveDataToDatabase()
    {

    }

}
