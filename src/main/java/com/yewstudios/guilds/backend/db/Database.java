package com.yewstudios.guilds.backend.db;

import com.yewstudios.guilds.Guilds;
import com.yewstudios.guilds.io.files.Config;

/**
 * Created by Mat
 */
public class Database extends DatabaseWrapper {

    public Database()
    {
        beginSetup();
        loadConnection();
    }

    private void beginSetup()
    {
        Config config = (Config) Guilds.getFileManager().getFile("config");
        String userName = config.getString("sql.username");
        String password = config.getString("sql.password");
        String hostName = config.getString("sql.hostname");
        String database = config.getString("sql.database");
        String port = config.getString("sql.port");

        this.setDatabase(database);
        this.setHostname(hostName);
        this.setPort(port);
        this.setUser(userName);
        this.setPassword(password);
    }





}
