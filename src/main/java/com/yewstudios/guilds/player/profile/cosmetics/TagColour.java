package com.yewstudios.guilds.player.profile.cosmetics;

import net.md_5.bungee.api.ChatColor;

/**
 * Created by Mat
 */
public enum TagColour {

    DEFAULT(ChatColor.GRAY, 1),
    GOLD(ChatColor.GOLD, 2),
    RED(ChatColor.RED, 3),
    GREEN(ChatColor.GREEN, 4);


    ChatColor chatColour;
    int id;

    TagColour(ChatColor colour, int id)
    {
        this.chatColour = colour;
        this.id = id;
    }

    public ChatColor getChatColour()
    {
        return this.chatColour;
    }

    private int getID()
    {
        return this.id;
    }

    public TagColour fromID(int id)
    {
        for(TagColour colour : values())
        {
            if(colour.getID() == id) return colour;
        }
        return null;
    }

}
