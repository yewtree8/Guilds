package com.yewstudios.guilds.backend.db.table;

import com.yewstudios.guilds.Guilds;
import com.yewstudios.guilds.backend.db.Database;
import com.yewstudios.guilds.backend.network.Callback;
import com.yewstudios.guilds.util.TableNames;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

/**
 * Created by Mat
 */
public class PlayerProfileGenerator {

    private String idString;

    static Database db = Guilds.getDatabase();

    public PlayerProfileGenerator(UUID id)
    {
        this.idString = id.toString();
        beginGen();
    }

    private void beginGen()
    {
        Callback<String> registerCallback = new Callback<String>() {
            @Override
            public void onCallback(String toReturn)
            {
                new BukkitRunnable()
                {
                    @Override
                    public void run()
                    {
                        Player p = Bukkit.getPlayer(UUID.fromString(idString));
                        p.sendMessage(ChatColor.GREEN + "Registry complete");
                    }
                }.runTask(Guilds.getPlugin());
            }
        };

        checkRegister(registerCallback);

    }

    public synchronized void checkRegister(Callback<String> callback)
    {
        Bukkit.broadcastMessage("Checking register");
        new BukkitRunnable()
        {
            public void run()
            {
                Connection connection = null;
                PreparedStatement statement = null;

                try {
                    connection = db.getSource().getConnection();
                    statement = connection.prepareStatement("SELECT * FROM " + TableNames.PLAYER_PROFILES + " WHERE UUID = ?;");
                    statement.setString(1, idString);

                    ResultSet set = statement.executeQuery();

                    if(!set.next()) //not registered
                    {
                        Guilds.log("Registering new player profile.");
                        PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO player_profiles (profile_id, uuid, guild, bowtrails, tagcolours, walktrails) VALUES(DEFAULT,?,?,?,?,?);");
                        insertStatement.setString(2, idString);
                        insertStatement.setString(3, "");
                        insertStatement.setString(4, "");
                        insertStatement.setString(5, "");
                        insertStatement.setString(6, "");
                        insertStatement.executeUpdate();

                        insertStatement.close();

                    }

                    statement.close();

                    new BukkitRunnable()
                    {
                        public void run()
                        {
                            callback.onCallback("Completed");
                        }
                    }.runTask(Guilds.getPlugin());

                }  catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (connection != null) {
                            connection.close();
                        }
                        if(statement != null) {
                            statement.close();
                        }
                    }catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

            }
        }.runTaskAsynchronously(Guilds.getPlugin());
    }




}
