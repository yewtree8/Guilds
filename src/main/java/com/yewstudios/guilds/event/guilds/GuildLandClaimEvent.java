package com.yewstudios.guilds.event.guilds;

import com.yewstudios.guilds.event.GuildEvent;
import com.yewstudios.guilds.guild.Guild;
import org.bukkit.entity.Player;

/**
 * Created by Mat
 *
 * Activated when a guild claims land and is allowed.
 */
public class GuildLandClaimEvent extends GuildEvent {

    private Guild guild;

    private Player landClaimant;

    private double claimPrice;

    public GuildLandClaimEvent(Guild guild, Player landClaimant, double claimPrice)
    {
        super();
        this.guild = guild;
        this.landClaimant = landClaimant;
        this.claimPrice = claimPrice;
    }

    public Guild getClaimingGuild()
    {
        return this.guild;
    }

    public Player getLandClaimer()
    {
        return this.landClaimant;
    }

    public double getClaimPrice()
    {
        return this.claimPrice;
    }


}
