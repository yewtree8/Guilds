package com.yewstudios.guilds.player.profile.stats;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.UUID;

/**
 * Created by Mat
 */
@Getter
@Setter
public class PlayerStats {

    private UUID id;

    private int kills;
    private int deaths;
    private int moneyPerHour;
    private int armourBroken;
    private int potionsThrown;
    private int arrowsBlocked;

    private int bountiesCollected;

    private int beetrootHarvested;

    private float killDeathRatio;

    private float damageGiven;
    private float damageTaken;

    public PlayerStats(UUID uuid)
    {
        this.id = uuid;
    }

}
