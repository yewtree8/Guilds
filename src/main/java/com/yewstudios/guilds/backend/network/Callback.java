package com.yewstudios.guilds.backend.network;

/**
 * Created by Mat
 * Used for SQL queries or any form of database query to execute a process
 * once it has finished processing asynchrenously.
 */
public interface Callback<T> {

    void onCallback(T toReturn); //Give a generic type to return, remember it cannot be primative.

}
