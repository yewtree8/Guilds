package com.yewstudios.guilds.listener;

import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

/**
 * Created by matty on 26/05/2019.
 */
public class PlayerMovementListener implements Listener {

    @EventHandler
    public void onHandleMovement(PlayerMoveEvent e)
    {
        int fromX = e.getFrom().getBlockX();
        int toX = e.getTo().getBlockX();

        int fromZ = e.getFrom().getBlockZ();
        int toZ = e.getTo().getBlockZ();

        if(fromX != toX || fromZ != toZ) //check the playe's actually moved a block
        {

        }

    }


}
