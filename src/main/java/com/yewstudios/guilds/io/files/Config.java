package com.yewstudios.guilds.io.files;

import com.yewstudios.guilds.Guilds;
import com.yewstudios.guilds.io.IFile;
import com.yewstudios.guilds.io.XFile;

/**
 * Main config.
 *
 * Not finished yet, lot more to add.
 */
public class Config extends XFile implements IFile {


    public Config()
    {
        super("config");
        loadDefaults();
    }

    @Override
    public void loadDefaults()
    {
        if(!getFile().exists())
        {
            Guilds.bigLogMessage("No Config found! Creating one now!");

            set("sql.username", "vpscraft_10786");
            set("sql.password", "7bb1ba6b53");
            set("sql.hostname", "192.3.211.99");
            set("sql.database", "vpscraft_10786");
            set("sql.port", "3306");

            set("guilds.priceclaim", 1000);
            set("guilds.maxplayers", 8);


        }
    }
}
