package Applicatie;



import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

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
        double beschikbaarheid = 0;
        double beschikbaarheidd = 1; //beschikbaarheid db servers
        double beschikbaarheidw = 1; //beschikbaarheid web servers
        double beschikbaarheidp = 1; //Beschikbaarheid firewall
        int prijs = 0;
        for(Server server : servers) {
            if (server != null) {
                   prijs += server.getPrijs();
                if(server.getType() == 1){
                    beschikbaarheidd = beschikbaarheidd * (1-server.getBeschikbaarheid());
                }
                if(server.getType() == 2){
                    beschikbaarheidw = beschikbaarheidw * (1-server.getBeschikbaarheid());
                }
                if(server.getType() == 0){
                    beschikbaarheidp = server.getBeschikbaarheid();
                }
            }
        }
        // doet achteraf nog 1x 1-berekende getal
        beschikbaarheidd = 1 - beschikbaarheidd;
        beschikbaarheidw = 1 - beschikbaarheidw;

        beschikbaarheid = beschikbaarheidp * beschikbaarheidd * beschikbaarheidw;
        beschikbaarheid = beschikbaarheid * 100;

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
        return serveropstelling;}

    public static ArrayList<Server> serversOphalen(){
        ArrayList<String> lijst = new ArrayList<>(); //ArrayList voor het ophalen van de tekst uit servers.txt

        try {
            File Servers = new File("./Servers.txt");
            Scanner Reader = new Scanner(Servers);
            while (Reader.hasNextLine()) {
                String data = Reader.nextLine();
                lijst.add(data);
            }
            Reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        ArrayList<Server> serverArrayList = new ArrayList<>(); //Arraylist voor de servers

        for (String data : lijst) {
            try { // Omzetten van data uit servers.txt in Server objecten.
                String[] server = data.split(",", 0);
                int prijs = Integer.parseInt(server[1]);
                double beschikbaarheid = Double.parseDouble(server[2]);
                int type = Integer.parseInt(server[3]);
                Server serverObject = new Server(server[0], prijs, beschikbaarheid, type);
                ServerList.voegServerToe(serverObject);
                serverArrayList.add(serverObject);
            }
            catch(IndexOutOfBoundsException ignore) {}
            catch(Exception e) {
                java.lang.System.exit(10);
            }
        }
        return serverArrayList;
    }

    public static File getDynamicUrl(String url){
        File path = new File(url);
        File files = new File(path.getAbsolutePath()); //Maak dynamische url
        return files;
    }
}