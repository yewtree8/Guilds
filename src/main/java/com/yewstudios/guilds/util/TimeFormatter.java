package com.yewstudios.guilds.util;

import org.bukkit.ChatColor;

/**
 * Created by Mat
 *
 *
 */
public final class TimeFormatter {

    /**
     * Converts an amount of seconds into:
     * HOURS : MINUTES : SECONDS
     *  01   :   45    :   23
     *  ^ As an example if the input was "6323" seconds.
     *  Always 2 digits inbetween colons
     * @param totalSeconds The seconds to format
     * @return A nicely formatted time.
     */
    public static String convertsSecondsToHourMinutesColonFormat(int totalSeconds)
    {
        int seconds = totalSeconds % 60;
        int minutes = (totalSeconds / 60) % 60;
        int hour = totalSeconds / (60 * 60);
        String newTime = String.format("%02d:%02d:%02d", hour, minutes, seconds);
        return newTime;
    }

    /**
     * Takes the colon format and converts it into
     * seconds again.
     * @param formattedTime The colon formatted time input
     * @return The quantity of seconds
     */
    public static int convertFormattedTimeToSeconds(String formattedTime)
    {
        formattedTime = ChatColor.stripColor(formattedTime); //make sure there's no colour.
        String[] tokens = formattedTime.split(":"); //split the hours, mins etc.
        int hours = Integer.parseInt(tokens[0]); //Should all be integers, not going to check ( ._.)
        int minutes = Integer.parseInt(tokens[1]);
        int seconds = Integer.parseInt(tokens[2]);
        int hourSeconds = ( hours * (60) ) * 60;
        int minuteSeconds = minutes * 60;
        int totalSeconds = hourSeconds + minuteSeconds + seconds;
        return totalSeconds;
    }




}
