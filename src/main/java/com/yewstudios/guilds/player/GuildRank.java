package com.yewstudios.guilds.player;

import net.md_5.bungee.api.ChatColor;

/**
 * Created by Mat
 */
public enum GuildRank {

    OWNER("[GL] ", ChatColor.RED), COLEADER("[CL] ", ChatColor.AQUA), MEMBER("[M] ", ChatColor.YELLOW);

    private String chatPrefix;

    private ChatColor prefixColour;

    GuildRank(String prefix, ChatColor prefixColour)
    {
        this.chatPrefix = prefix;
        this.prefixColour = prefixColour;
    }

    public String getChatPrefix()
    {
        return prefixColour + chatPrefix;
    }

}
