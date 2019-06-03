package com.yewstudios.guilds.player.profile;

import com.yewstudios.guilds.backend.db.table.PlayerProfileGenerator;
import com.yewstudios.guilds.guild.Guild;
import com.yewstudios.guilds.player.GuildRank;
import com.yewstudios.guilds.player.profile.cosmetics.BowTrails;
import com.yewstudios.guilds.player.profile.cosmetics.TagColour;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

/**
 * Created by Mat
 *
 */
@Getter
@Setter
public class PlayerProfile {

    private int playerID;

    private Guild guild;

    private GuildRank guildRank;

    private UUID id;

    /*
    Cosmetics
     */
    private TagColour[] colours;
    private BowTrails[] bowTrails;

    public PlayerProfile(UUID playerID)
    {
        this.id = playerID;
        new PlayerProfileGenerator(getUUID());
    }

    public UUID getUUID()
    {
        return this.id;
    }


    public void save()
    {

    }

}
