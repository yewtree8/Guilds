package com.yewstudios.guilds.event;

import com.yewstudios.guilds.Guilds;
import com.yewstudios.guilds.cache.Cache;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Created by Mat
 *
 * Base event class, might turn out to be incredibly useful
 * in the future, who knows?
 */
public abstract class GuildEvent extends Event {

    private Guilds plugin;

    private Cache pluginCache;

    public GuildEvent()
    {
        plugin = Guilds.getPlugin();
        pluginCache = Guilds.getCache();
    }

    /**
     * Easy safe way to get the current
     * base state of the main class, makes the typeset
     * a little more dynamic.
     * @return Safe JavaPlugin instance at given called time.
     */
    public Guilds getPlugin()
    {
        return this.plugin;
    }

    /**
     * Same concept as the one above, removes
     * the need for constant calling safely.
     * @return
     */
    public Cache getCache()
    {
        return this.pluginCache;
    }

    @Override
    public HandlerList getHandlers()
    {
        return null;
    }
}
