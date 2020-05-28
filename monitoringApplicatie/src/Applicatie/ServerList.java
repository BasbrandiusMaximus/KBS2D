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
    public Server server;

    public static final int MaxServers = 10;

    public ServerList()
    { }

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

    public static ReturnValues kiesServers(double beschikbaarheid) {
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

        // Bereken mogelijke combinaties, dit zou eigenlijk een aparte class moeten zijn.
        try {
            for (int t = 0; t < MaxServers; t++) {
                Combinaties.combinaties.clear();
                Combinaties.wrapCombinaties(serverSet, t);
                ArrayList<String> mogelijkeCombinaties = new ArrayList<>(Combinaties.getCombinaties());

                for (String c : mogelijkeCombinaties) {
                    ArrayList<Server> combinatie = new ArrayList<>();
                    ArrayList<Double> beschikbaarheidsPercentages = new ArrayList<>();

                    ArrayList<Server> tempDatabase = new ArrayList<>();
                    ArrayList<Server> tempWeb = new ArrayList<>();
                    int prijs = 0;

                    if (c.length() == t) {
                        for (char i : c.toCharArray()) {
                            int n = Integer.parseInt(String.valueOf(i));
                            combinatie.add(allServers.get(n));
                        }
                        for (Server s : combinatie) {
                            prijs += s.getPrijs();
                            if (s.getType() == 1) {
                                tempDatabase.add(s);
                            }
                            if (s.getType() == 2) {
                                tempWeb.add(s);
                            }
                            beschikbaarheidsPercentages.add(s.getBeschikbaarheid());
                        }

                        double somWebBeschikbaarheid = 1;
                        double somDatabaseBeschikbaarheid = 1;

                        // Bereken totale beschikbaarheid van de webservers
                        for (Server server : tempWeb) {
                            somWebBeschikbaarheid = somWebBeschikbaarheid * (1 - server.getBeschikbaarheid());
                        }

                        // Bereken totale beschikbaarheid van de database servers
                        for (Server server : tempDatabase) {
                            somDatabaseBeschikbaarheid = somDatabaseBeschikbaarheid * (1 - server.getBeschikbaarheid());
                        }

                        somWebBeschikbaarheid = 1 - somWebBeschikbaarheid;
                        somDatabaseBeschikbaarheid = 1 - somDatabaseBeschikbaarheid;

                        double combinatieBeschikbaarheid = firewallBeschikbaarheid * somWebBeschikbaarheid * somDatabaseBeschikbaarheid;

                        // Validatie op basis van regels
                        if (tempWeb.size() != 0 && tempDatabase.size() != 0) {
                            if (((prijs < goedkoopstePrijs) || (goedkoopstePrijs == 0)) && combinatieBeschikbaarheid >= beschikbaarheid) {
                                goedkoopstePrijs = prijs;
                                besteCombinatie.clear();
                                besteCombinatie.addAll(combinatie);
                            }
                        }
                        tempWeb.clear();
                        tempDatabase.clear();
                    }
                }
            }
        }
        catch (java.lang.OutOfMemoryError err)
        {
            System.out.println("De gevraagde bewerking kostte teveel rekenkracht. Het programma is afgesloten. Verander MaxServers en probeer het opnieuw.");
            System.out.println("Deze foutmelding trad op bij een waarde van MaxServers van " + MaxServers);
            System.exit(10);
        }

        if (!besteCombinatie.isEmpty()) {
            geselecteerdeServers.addAll(besteCombinatie);
        }

        return new ReturnValues(geselecteerdeServers, goedkoopstePrijs + firewallPrijs);
    }

    public static String serversUitrekenen(double beschikbaarheid) {
        ReturnValues r = kiesServers(beschikbaarheid);
        ArrayList<Server> servers = r.getServers();

        String returnString = "<html><div style='text-align: center;'>";

        if (servers.size() == 1) {
            returnString += "Kon geen combinatie vinden met deze gegevens.<br/> Verander uw gegevens en probeer opnieuw.";
        } else { returnString += "Beste combinatie:<br/><br/>";
            for (Server server : servers)
            {
                returnString += server + "<br/>";
            }
            returnString += "<br/>Totale kosten: " + r.getPrijs();
        }

        returnString += "</div></html>";

        return returnString;
    }

    public static ArrayList<Server> getServers(){
        ArrayList<Server> serverArrayList = new ArrayList<>();
        for(Server server : serverList){
            serverArrayList.add(server);
        }
        return serverArrayList;
    }
}
