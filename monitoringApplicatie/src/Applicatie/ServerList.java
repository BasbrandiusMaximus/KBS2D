package Applicatie;

import java.util.ArrayList;

final class ReturnValues {
    private final ArrayList<Server> servers;
    private final int prijs;

    public ReturnValues(ArrayList<Server> servers, Integer prijs)
    {
        this.servers = servers;
        this.prijs = prijs;
    }

    public ArrayList<Server> getServers()
    {
        return servers;
    }

    public int getPrijs()
    {
        return prijs;
    }
}

public class ServerList {
    public static ArrayList<Server> serverList = new ArrayList<Server>();
    private Server Servers;

    public ServerList()
    {
    }

    public static void voegServerToe(Server server)
    {
        serverList.add(server);
    }

    public String printServerList(){
        String servers = "<html><div style='text-align: center;'>Beschikbare servers: <br/>";
        for(Server server : serverList){
            servers += server + "<br/>";
        }
        servers += "</div></html>";
        return servers;
    }

    public static ReturnValues kiesServers(double beschikbaarheid, int aantal) {
        ArrayList<Server> geselecteerdeServers = new ArrayList<>();
        ArrayList<Server> allServers = new ArrayList<>();

        ArrayList<Server> besteCombinatie = new ArrayList<>();
        double firewallBeschikbaarheid = 1.00;
        int firewallPrijs = 0;
        int goedkoopstePrijs = 0;

        for (Server server : serverList) {
            if (server.getType() == 0) {
                geselecteerdeServers.add(server);
                firewallBeschikbaarheid = server.getBeschikbaarheid();
                firewallPrijs = server.getPrijs();
            } else {
                allServers.add(server);
            }
        }

        char[] serverSet = {'0','1','2','3','4','5'};
        Combinaties.combinaties.clear();
        Combinaties.wrapCombinaties(serverSet, aantal - 1);
        ArrayList<String> mogelijkeCombinaties = new ArrayList<>(Combinaties.getCombinaties());

        // Bereken mogelijke combinaties, dit zou eigenlijk een aparte class moeten zijn.
        for (String c : mogelijkeCombinaties)
        {
            ArrayList<Server> combinatie = new ArrayList<>();
            ArrayList<Double> beschikbaarheidsPercentages = new ArrayList<>();

            int web = 0;
            int database = 0;
            int prijs = 0;

            if (c.length() == aantal - 1)
            {
                for (char i : c.toCharArray())
                {
                    int n = Integer.parseInt(String.valueOf(i));
                    combinatie.add(allServers.get(n));
                }
                for (Server s : combinatie)
                {
                    prijs += s.getPrijs();
                    if (s.getType() == 1) {
                        ++database;
                    }
                    if (s.getType() == 2) {
                        ++web;
                    }
                    beschikbaarheidsPercentages.add(s.getBeschikbaarheid());
                }

                double somBeschikbaarheidServers = 1;
                for (Double beschikbaarheidsPercentage : beschikbaarheidsPercentages)
                {
                    somBeschikbaarheidServers = somBeschikbaarheidServers * (1 - beschikbaarheidsPercentage);
                }
                double serverBeschikbaarheid = 1 - somBeschikbaarheidServers;

                double combinatieBeschikbaarheid = (firewallBeschikbaarheid * serverBeschikbaarheid);

                // Validatie op basis van regels
                if (web != 0 && database != 0)
                {
                    if (((prijs < goedkoopstePrijs) || (goedkoopstePrijs == 0)) && combinatieBeschikbaarheid >= beschikbaarheid)
                    {
                        goedkoopstePrijs = prijs;
                        besteCombinatie.clear();
                        besteCombinatie.addAll(combinatie);
                    }
                }
            }
        }
        geselecteerdeServers.addAll(besteCombinatie);

        return new ReturnValues(geselecteerdeServers, goedkoopstePrijs + firewallPrijs);
    }

    public static String serversUitrekenen(double beschikbaarheid, int aantal) {
        ReturnValues r = kiesServers(beschikbaarheid, aantal);
        ArrayList<Server> servers = r.getServers();

        String returnString = "<html><div style='text-align: center;'>";
        if (aantal<3){
            returnString += "U heeft minder dan 3 servers ingevuld.<br/>Vul 3 of meer servers in en probeer opnieuw.<br/><br/>";
        }

        else{
            if (servers.size() == 1) {
                returnString += "Kon geen combinatie vinden met deze gegevens.<br/> Verander uw gegevens en probeer opnieuw.";
            } else { returnString += "Beste combinatie:<br/><br/>";
                for (Server server : servers)
                {
                    returnString += server + "<br/>";
                }
                returnString += "<br/>Totale kosten: " + r.getPrijs();
            }}

        returnString += "</div></html>";

        return returnString;
    }

    public Server getServer(int positie){
        if(serverList.size() > 0) {
            for (int i = 0; i < serverList.size(); i++) {
                if (i == positie) {
                    Servers = serverList.get(i);
                }
            }
        }
        return Servers;
    }
}
