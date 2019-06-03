package com.yewstudios.guilds.guild;

import com.yewstudios.guilds.claim.ChunkClaim;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created Mat
 *
 * Main guild class
 *
 * Create separate table for each guild.
 */
public class Guild {

    private static List<Guild> allGuilds = new ArrayList<>();
    public static List<Guild> getAllGuilds(){return allGuilds;}

    private String name;

    private GuildData guildData;

    //TODO MAXIMUM GUILD NAME IS 12 characters long
    public Guild(String name)
    {
        this.name = name;
        guildData = new GuildData(this);
        getAllGuilds().add(this);
    }

    public GuildData getGuildData()
    {
        return this.guildData;
    }


    public String getName() {return this.name;}


    public static Guild getGuild(String name)
    {
        return getAllGuilds().stream().filter(guild -> guild.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }


}
