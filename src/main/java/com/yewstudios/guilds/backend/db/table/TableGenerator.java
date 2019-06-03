package com.yewstudios.guilds.backend.db.table;

import com.yewstudios.guilds.Guilds;
import com.yewstudios.guilds.backend.db.Database;
import com.yewstudios.guilds.util.TableNames;
import com.zaxxer.hikari.HikariDataSource;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Mat
 */
public class TableGenerator {

    static Database database;

    public TableGenerator(Database db)
    {
        database = db;
    }

    public Database getDatabase()
    {
        return database;
    }

    public synchronized void generateProfileTable()
    {
        Connection connection = null;
        Statement statement = null;

        try {
             connection = getDatabase().getSource().getConnection();

             statement = connection.createStatement();

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS " + TableNames.PLAYER_PROFILES
             + " (profile_id INT AUTO INCREMENT," +
                    "uuid char (36) NOT NULL," +
                    "bowtrails varchar(22)," +
                    "tagcolours varchar(22)," +
                    "walktrails varchar(22)," +
                    " PRIMARY KEY (uuid));"
            );

            statement.close();
            connection.close();

        } catch(SQLException e)
        {
            Guilds.log("Couldn't generate profile table? Not sure why");
            e.printStackTrace();
        } finally
        {
            try {
                if(connection!=null) connection.close();
                if(statement!=null) statement.close();
            } catch (Exception e){e.printStackTrace();}
        }

    }

    public synchronized void generateGuildTable()
    {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = getDatabase().getSource().getConnection();

            statement = connection.createStatement();

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS " + TableNames.GUILDS
                    + " (guild_id INT AUTO INCREMENT," +
                    "guild_name varchar (12) NOT NULL," +
                    "balance varchar(16)," +
                    "owner varchar(36)," +
                    "co_owner varchar(36)," +
                    "members varchar(36)," +
                    "claims varchar(99)" +
                    " PRIMARY KEY (guild_name));"
            );

            statement.close();
            connection.close();

        } catch(SQLException e)
        {
            Guilds.log("Couldn't generate profile table? Not sure why");
            e.printStackTrace();
        } finally
        {
            try {
                if(connection!=null) connection.close();
                if(statement!=null) statement.close();
            } catch (Exception e){e.printStackTrace();}
        }

    }



}
