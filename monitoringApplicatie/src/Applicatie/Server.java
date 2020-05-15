package Applicatie;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Server {
    private String naam;
    private int prijs;
    private double beschikbaarheid;
    private int type;  //0 = pfSense, 1 = dbserver, 2=wbserver


    public Server(String naam, int prijs, double beschikbaarheid, int type) {
        this.naam = naam;
        this.prijs = prijs;
        this.beschikbaarheid = beschikbaarheid;
        this.type = type;
    }

    public String toString(){
        String bheid = Double.toString(beschikbaarheid * 100);
        return "Naam: " + naam + ", prijs: " + prijs + " euro, beschikbaarheidspercentage: " + bheid + "%";
    }

    public String getNaam() {
        return naam;
    }

    public int getType() { return type; }

    public int getPrijs() {
        return prijs;
    }

    public double getBeschikbaarheid() {
        return beschikbaarheid;
    }
    public static List<Object> berekenBeschikbaarheid(Server... servers) {
        double beschikbaarheid = 0d;
        int prijs = 0;
        for(Server server : servers) {
            if (server != null) {
                prijs += server.prijs;
                // berekent (1-server1.beschikbaarheid)*(1-server2.beschikbaarheid)*(1-server3.beschikbaarheid)
                if (beschikbaarheid == 0d) {
                    beschikbaarheid += 1 - server.beschikbaarheid;
                } else {
                    beschikbaarheid = beschikbaarheid * (1 - server.beschikbaarheid);
                }
            }
        }
        // doet achteraf nog 1x 1-berekende getal
        beschikbaarheid = 1 - beschikbaarheid;

        return Arrays.asList(beschikbaarheid, prijs);
    }

    public static String serversUitrekenen(double beschikbaarheid, int aantalServers, ArrayList<Server> serverList, ArrayList<Double> lijst1) {
        ArrayList<Double> lijst2 = new ArrayList<>();
        lijst1.remove(0);

        Double uitkomst;


        int prijs = 0;
        ArrayList<Server> opstelling = new ArrayList<>();
        //add minimum servers
        for (Server servers : serverList) {
            if (!(lijst2.contains(0.80))){
                if(servers.beschikbaarheid ==0.80&&servers.type==2){
                    opstelling.add(servers);
                    prijs += servers.prijs;
                }}}

        for (Server servers : serverList) {
            if (!(lijst2.contains(0.98))){
                if(servers.beschikbaarheid==0.98&&servers.type==1){
                    opstelling.add(servers);
                    prijs += servers.prijs;
                }}}

        for (Server servers : serverList) {
            if (servers.type == 0) {
                opstelling.add(servers);
                prijs += servers.prijs;
            }
        }

        String serveropstelling = "<html><div><strong>Totale prijs: " + prijs + "</strong><br/>";
        for (Server sopstelling : opstelling) {
            serveropstelling += sopstelling + "<br/>";
        }
        serveropstelling += "</div></html>";
        return serveropstelling;}}