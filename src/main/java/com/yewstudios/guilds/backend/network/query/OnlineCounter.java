package com.yewstudios.guilds.backend.network.query;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mat
 */
public class OnlineCounter {


    private static List<OnlineCounter> allCounters = new ArrayList<>();
    public static  List<OnlineCounter> getAllCounters(){return allCounters;}


    public OnlineCounter()
    {
        allCounters.add(this);
    }

    /**
     * Used for querying the current amount of players on the local server to that machine.
     * using the database token for the ServerData class
     * @param databaseToken - Token that each server is given, gotten by Core.getServerData()
     * @return The current amount of online players.
     */

    public  int getOnlinePlayers(String databaseToken)
    {
        try {

            String[] tokens = databaseToken.split(":");
            String ip = tokens[0];
            int port = Integer.parseInt(tokens[1]);

            Socket socket = new Socket();
            socket.connect(new InetSocketAddress("localhost", port), 1 * 1000);

            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());
            out.write(0xFE);

            StringBuilder str = new StringBuilder();

            int b;
            while ((b = in.read()) != -1)
            {
                if (b != 0 && b > 16 &&
                        b != 255 && b != 23 &&
                             b != 24)
                {
                    str.append((char) b);
                }
            }

            String[] data = str.toString().split("§");
            socket.close(); //Always close those damn sockets
            return Integer.valueOf(data[1]);
        } catch (Exception e) {

        }

        return 0;
    }


}
