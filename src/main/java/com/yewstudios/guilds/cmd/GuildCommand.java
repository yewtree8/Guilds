package com.yewstudios.guilds.cmd;

import com.yewstudios.guilds.guild.Guild;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Mat
 */
public class GuildCommand implements CommandExecutor {


    /**
     * Guild create
     * Guild join
     * Guild disband
     * Guild chat
     * Guild promote
     */

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args)
    {
        if(sender instanceof Player)
        {
            Player player = (Player) sender;
            if(args.length == 2)
            {
                String arg = args[0];

                switch (arg)
                {
                    case("create"):
                        handleCreate(args[1], player);
                }

            }
        }
        return false;
    }


    private void handleCreate(String guildArgument, Player player)
    {

    }

}
