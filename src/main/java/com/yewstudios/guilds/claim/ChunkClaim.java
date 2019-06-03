package com.yewstudios.guilds.claim;

import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.util.HashMap;

/**
 * Created by Mat
 */
public class ChunkClaim {

    private ClaimType claimType;

    private Vector min;
    private Vector max;

    private int x;
    private int z;

    /**
     * Constructor for a new claim.
     * Does all the fun stuff
     * @param claimant The player claiming.
     */
    public ChunkClaim(Player claimant)
    {

    }

    public ChunkClaim(String serializedClaim)
    {

    }


    /**
     * Let's serialise the actual claim itself.
     * @return Serialized version of the claim.
     */
    @Override
    public String toString()
    {
        return "";
    }









}
