package com.yewstudios.guilds.guild;

import com.yewstudios.guilds.claim.ChunkClaim;

import java.util.List;
import java.util.UUID;

/**
 * Created by Mat
 */
public class GuildData {

    private double guildBalance;
    private List<UUID> members;

    private UUID ownerUUID;
    private UUID coOwnerUUID;
    private List<ChunkClaim> claimedChunks;

    public GuildData(Guild guild)
    {
        //TODO load data from table
    }

    public double getGuildBalance()
    {
        return this.guildBalance;
    }

    public List<ChunkClaim> getClaimedChunks()
    {
        return this.claimedChunks;
    }


}
