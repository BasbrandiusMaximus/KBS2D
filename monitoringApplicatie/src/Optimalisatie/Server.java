package Optimalisatie;


import java.util.ArrayList;

public class Server {
    private String naam;
    private int prijs;
    private double beschikbaarheid;
    private int type;  //0 = pfSense, 1 = dbserver, 2=wbserver
    //TO DO: lijstje maken met servers, ophalen serverinfo en dan backtracking. Aflsuiten en dan info behouden bij weer opstarten

    public Server(String naam, int prijs, double beschikbaarheid, int type){
        this.naam = naam;
        this.prijs = prijs;
        this.beschikbaarheid = beschikbaarheid;
    }

    public String toString(){
        beschikbaarheid = beschikbaarheid * 100;
        return "Naam: " + naam + ", prijs: " + prijs + " euro, beschikbaarheidspercentage: " + beschikbaarheid + "%";
    }

    //percentage berekening voor 2 servers
    public static void BerekenBeschikbaarheid(Server server1, Server server2){
        //bereken de beschikbaarheid
        double beschikbaarheid = 1-(1-server1.beschikbaarheid)*(1-server2.beschikbaarheid);
        System.out.println("de beschikbaarheid is: " + beschikbaarheid);
        //bereken de prijs
        int prijs = server1.prijs+server2.prijs;
        System.out.println("de jaarlijkse prijs is: " + prijs);
    }

    //percentage berekening voor 3 servers
    public static void BerekenBeschikbaarheid(Server server1, Server server2, Server server3){
        //bereken de beschikbaarheid
        double beschikbaarheid = 1-(1-server1.beschikbaarheid)*(1-server2.beschikbaarheid)*(1-server3.beschikbaarheid);
        System.out.println("de beschikbaarheid is: " + beschikbaarheid);
        //bereken de prijs
        int prijs = server1.prijs+server2.prijs+server3.prijs;
        System.out.println("de jaarlijkse prijs is: " + prijs);
    }

    //percentage berekening voor 4 servers
    public static void BerekenBeschikbaarheid(Server server1, Server server2, Server server3, Server server4){
        //bereken de beschikbaarheid
        double beschikbaarheid = 1-(1-server1.beschikbaarheid)*(1-server2.beschikbaarheid)*(1-server3.beschikbaarheid)*(1-server4.beschikbaarheid);
        System.out.println("de beschikbaarheid is: " + beschikbaarheid);
        //bereken de prijs
        int prijs = server1.prijs+server2.prijs+server3.prijs+server4.prijs;
        System.out.println("de jaarlijkse prijs is: " + prijs);
    }

    //percentage berekening voor 5 servers
    public static void BerekenBeschikbaarheid(Server server1, Server server2, Server server3, Server server4, Server server5){
        //bereken de beschikbaarheid
        double beschikbaarheid = 1-(1-server1.beschikbaarheid)*(1-server2.beschikbaarheid)*(1-server3.beschikbaarheid)*(1-server4.beschikbaarheid)*(1-server5.beschikbaarheid);
        System.out.println("de beschikbaarheid is: " + beschikbaarheid);
        //bereken de prijs
        int prijs = server1.prijs+server2.prijs+server3.prijs+server4.prijs+server5.prijs;
        System.out.println("de jaarlijkse prijs is: " + prijs);
    }

    //percentage berekening voor 6 servers
    public static void BerekenBeschikbaarheid(Server server1, Server server2, Server server3, Server server4, Server server5, Server server6){
        //bereken de beschikbaarheid
        double beschikbaarheid = 1-(1-server1.beschikbaarheid)*(1-server2.beschikbaarheid)*(1-server3.beschikbaarheid)*(1-server4.beschikbaarheid)*(1-server5.beschikbaarheid)*(1-server6.beschikbaarheid);
        System.out.println("de beschikbaarheid is: " + beschikbaarheid);
        //bereken de prijs
        int prijs = server1.prijs+server2.prijs+server3.prijs+server4.prijs+server5.prijs+server6.prijs;
        System.out.println("de jaarlijkse prijs is: " + prijs);
    }

    //percentage berekening voor 7 servers
    public static void BerekenBeschikbaarheid(Server server1, Server server2, Server server3, Server server4, Server server5, Server server6, Server server7){
        //bereken de beschikbaarheid
        double beschikbaarheid = 1-(1-server1.beschikbaarheid)*(1-server2.beschikbaarheid)*(1-server3.beschikbaarheid)*(1-server4.beschikbaarheid)*(1-server5.beschikbaarheid)*(1-server6.beschikbaarheid)*(1-server7.beschikbaarheid);
        System.out.println("de beschikbaarheid is: " + beschikbaarheid);
        //bereken de prijs
        int prijs = server1.prijs+server2.prijs+server3.prijs+server4.prijs+server5.prijs+server6.prijs+server7.prijs;
        System.out.println("de jaarlijkse prijs is: " + prijs);
    }

    //percentage berekening voor 8 servers
    public static void BerekenBeschikbaarheid(Server server1, Server server2, Server server3, Server server4, Server server5, Server server6, Server server7, Server server8){
        //bereken de beschikbaarheid
        double beschikbaarheid = 1-(1-server1.beschikbaarheid)*(1-server2.beschikbaarheid)*(1-server3.beschikbaarheid)*(1-server4.beschikbaarheid)*(1-server5.beschikbaarheid)*(1-server6.beschikbaarheid)*(1-server7.beschikbaarheid)*(1-server8.beschikbaarheid);
        System.out.println("de beschikbaarheid is: " + beschikbaarheid);
        //bereken de prijs
        int prijs = server1.prijs+server2.prijs+server3.prijs+server4.prijs+server5.prijs+server6.prijs+server7.prijs+server8.prijs;
        System.out.println("de jaarlijkse prijs is: " + prijs);
    }

    //percentage berekening voor 9 servers
    public static void BerekenBeschikbaarheid(Server server1, Server server2, Server server3, Server server4, Server server5, Server server6, Server server7, Server server8, Server server9){
        //bereken de beschikbaarheid
        double beschikbaarheid = 1-(1-server1.beschikbaarheid)*(1-server2.beschikbaarheid)*(1-server3.beschikbaarheid)*(1-server4.beschikbaarheid)*(1-server5.beschikbaarheid)*(1-server6.beschikbaarheid)*(1-server7.beschikbaarheid)*(1-server8.beschikbaarheid)*(1-server9.beschikbaarheid);
        System.out.println("de beschikbaarheid is: " + beschikbaarheid);
        //bereken de prijs
        int prijs = server1.prijs+server2.prijs+server3.prijs+server4.prijs+server5.prijs+server6.prijs+server7.prijs+server8.prijs+server9.prijs;
        System.out.println("de jaarlijkse prijs is: " + prijs);
    }

    //percentage berekening voor 10 servers
    public static void BerekenBeschikbaarheid(Server server1, Server server2, Server server3, Server server4, Server server5, Server server6, Server server7, Server server8, Server server9, Server server10){
        //bereken de beschikbaarheid
        double beschikbaarheid = 1-(1-server1.beschikbaarheid)*(1-server2.beschikbaarheid)*(1-server3.beschikbaarheid)*(1-server4.beschikbaarheid)*(1-server5.beschikbaarheid)*(1-server6.beschikbaarheid)*(1-server7.beschikbaarheid)*(1-server8.beschikbaarheid)*(1-server9.beschikbaarheid)*(1-server10.beschikbaarheid);
        System.out.println("de beschikbaarheid is: " + beschikbaarheid);
        //bereken de prijs
        int prijs = server1.prijs+server2.prijs+server3.prijs+server4.prijs+server5.prijs+server6.prijs+server7.prijs+server8.prijs+server9.prijs+server10.prijs;
        System.out.println("de jaarlijkse prijs is: " + prijs);
    }

//TODO:
// error messages
// rekening houden met goedkoopste optie

    public static void serversUitrekenen(double beschikbaarheid, int aantalServers) {
        ArrayList<Double> lijst1 = new ArrayList<>();
        lijst1.add(0.99998);
        lijst1.add(0.90);
        lijst1.add(0.95);
        lijst1.add(0.98);
        lijst1.add(0.90);
        lijst1.add(0.80);
        lijst1.add(0.95);
        
        Double uitkomst;
        if(aantalServers == 2){
            for (int a = 0; a < lijst1.size(); a++) {
                for (int b = 0; b < lijst1.size(); b++) {
                    uitkomst = 1 - (1 - lijst1.get(a)) * (1 - lijst1.get(b));
                    if (uitkomst == beschikbaarheid) {
                        System.out.println("Beschikbaarheid: " + uitkomst + ", Server 1: " + lijst1.get(a) + ", Server 2: " + lijst1.get(b));
                    }
                }
            }
        }
    }
}

