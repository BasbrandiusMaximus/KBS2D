package Optimalisatie;

import java.util.ArrayList;

public class ServerList {
    private ArrayList<Server> serverList;

    public ServerList(){
        serverList = new ArrayList<>();
    }

    public void voegServerToe(Server server){
        serverList.add(server);
    }

    public String printServerList(){
        String server = "<html><div style='text-align: center;'>Beschikbare servers: <br/>";
        for(Server servers : serverList){
            server += servers + "<br/>";
        }
        server += "</div></html>";
        return server;
    }
}