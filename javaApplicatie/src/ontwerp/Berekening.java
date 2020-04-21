package ontwerp;

public class Berekening {

    //berekening voor 2 servers
    public static void Bereken(Server server1, Server server2) {
        //bereken de beschikbaarheid
        double beschikbaarheid = 1 - (1 - server1.beschikbaarheid) * (1 - server2.beschikbaarheid);
        System.out.println("de beschikbaarheid is: " + beschikbaarheid);
        //bereken de prijs
        int prijs = server1.prijs + server2.prijs;
        System.out.println("de jaarlijkse prijs is: " + prijs);
    }

    //berekening voor 3 servers
    public static void Bereken(Server server1, Server server2, Server server3) {
        //bereken de beschikbaarheid
        double beschikbaarheid = 1 - (1 - server1.beschikbaarheid) * (1 - server2.beschikbaarheid) * (1 - server3.beschikbaarheid);
        System.out.println("de beschikbaarheid is: " + beschikbaarheid);
        //bereken de prijs
        int prijs = server1.prijs + server2.prijs + server3.prijs;
        System.out.println("de jaarlijkse prijs is: " + prijs);
    }

    //berekening voor 4 servers
    public static void Bereken(Server server1, Server server2, Server server3, Server server4) {
        //bereken de beschikbaarheid
        double beschikbaarheid = 1 - (1 - server1.beschikbaarheid) * (1 - server2.beschikbaarheid) * (1 - server3.beschikbaarheid) * (1 - server4.beschikbaarheid);
        System.out.println("de beschikbaarheid is: " + beschikbaarheid);
        //bereken de prijs
        int prijs = server1.prijs + server2.prijs + server3.prijs + server4.prijs;
        System.out.println("de jaarlijkse prijs is: " + prijs);
    }

    //berekening voor 5 servers
    public static void Bereken(Server server1, Server server2, Server server3, Server server4, Server server5) {
        //bereken de beschikbaarheid
        double beschikbaarheid = 1 - (1 - server1.beschikbaarheid) * (1 - server2.beschikbaarheid) * (1 - server3.beschikbaarheid) * (1 - server4.beschikbaarheid) * (1 - server5.beschikbaarheid);
        System.out.println("de beschikbaarheid is: " + beschikbaarheid);
        //bereken de prijs
        int prijs = server1.prijs + server2.prijs + server3.prijs + server4.prijs + server5.prijs;
        System.out.println("de jaarlijkse prijs is: " + prijs);
    }

    //berekening voor 6 servers
    public static void Bereken(Server server1, Server server2, Server server3, Server server4, Server server5, Server server6) {
        //bereken de beschikbaarheid
        double beschikbaarheid = 1 - (1 - server1.beschikbaarheid) * (1 - server2.beschikbaarheid) * (1 - server3.beschikbaarheid) * (1 - server4.beschikbaarheid) * (1 - server5.beschikbaarheid) * (1 - server6.beschikbaarheid);
        System.out.println("de beschikbaarheid is: " + beschikbaarheid);
        //bereken de prijs
        int prijs = server1.prijs + server2.prijs + server3.prijs + server4.prijs + server5.prijs + server6.prijs;
        System.out.println("de jaarlijkse prijs is: " + prijs);
    }
}
