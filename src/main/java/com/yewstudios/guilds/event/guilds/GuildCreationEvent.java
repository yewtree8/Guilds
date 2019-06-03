package com.yewstudios.guilds.event.guilds;

import com.yewstudios.guilds.event.GuildEvent;
import org.bukkit.entity.Player;

import java.util.UUID;

/**
 * Created by Mat
 *
 * Base event called when someone creates
 * a new guild successfully
 *
 *
 */
public class GuildCreationEvent extends GuildEvent {

    private UUID creatorUUID;

    private String newGuildName;

    public GuildCreationEvent(Player creator, String guildName)
    {
        super();
        this.creatorUUID = creator.getUniqueId();
        this.newGuildName = guildName;
    }

    public String getNewGuildName()
    {
        return newGuildName;
    }

    public UUID getCreatorUUID()
    {
        return creatorUUID;
    }
}
