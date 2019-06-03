package com.yewstudios.guilds.backend.db;

import com.yewstudios.guilds.Guilds;
import com.zaxxer.hikari.HikariDataSource;

/**
 * Created by Mat
 */
public abstract class DatabaseWrapper {

    private String username;
    private String database;
    private String password;
    private String port;
    private String hostname;

    private HikariDataSource dataSource;

    public DatabaseWrapper()
    {

    }

    protected void loadConnection()
    {
        dataSource = new HikariDataSource();

        getSource().setMaximumPoolSize(10);
        getSource().setDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlDataSource");
        getSource().addDataSourceProperty("serverName", hostname);
        getSource().addDataSourceProperty("port", port);
        getSource().addDataSourceProperty("databaseName", database);
        getSource().addDataSourceProperty("user", username);
        getSource().addDataSourceProperty("password", password);

        Guilds.bigLogMessage("Connection pool loaded!");
    }

    protected void setUser(String user)
    {
        this.username = user;
    }

    protected void setDatabase(String database)
    {
        this.database = database;
    }

    protected void setPort(String port)
    {
        this.port = port;
    }

    protected void setHostname(String hostName)
    {
        this.hostname = hostName;
    }

    protected void setPassword(String password)
    {
        this.password = password;
    }


    public HikariDataSource getSource()
    {
        return this.dataSource;
    }

}
