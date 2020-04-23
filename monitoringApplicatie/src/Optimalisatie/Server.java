package Optimalisatie;


import java.util.ArrayList;
import java.util.ConcurrentModificationException;

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
        this.type = type;
    }

    public String toString(){
        String bheid = Double.toString(beschikbaarheid * 100);
        return "Naam: " + naam + ", prijs: " + prijs + " euro, beschikbaarheidspercentage: " + bheid + "%";
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

    public static String serversUitrekenen(double beschikbaarheid, int aantalServers, ArrayList<Server> serverList, ArrayList<Double> lijst1) {
        ArrayList<Double> lijst2 = new ArrayList<>();
        lijst1.remove(0);

        Double uitkomst;
        if (aantalServers == 3) {
            for (int a = 0; a < lijst1.size(); a++) {
                for (int b = 0; b < lijst1.size(); b++) {
                    uitkomst = 1 - (1 - lijst1.get(a)) * (1 - lijst1.get(b)) * (1 - 0.99998);
                    //System.out.println("Uitkomst: " + uitkomst);
                    if (uitkomst == beschikbaarheid) {
                        if (!(lijst2.contains(lijst1.get(a)) || lijst2.contains(lijst1.get(b)) || lijst2.contains(0.99998))) {
                            lijst2.add(lijst1.get(a));
                            lijst2.add(lijst1.get(b));
                            lijst2.add(0.99998);
                            //System.out.println(lijst1.get(a) + " " + lijst1.get(b) + " " + lijst1.get(c));
                        }
                    }
                }
            }
        }

        if (aantalServers == 4) {
            for (int d = 0; d < lijst1.size(); d++) {
                for (int e = 0; e < lijst1.size(); e++) {
                    for (int f = 0; f < lijst1.size(); f++) {
                        uitkomst = 1 - (1 - lijst1.get(d)) * (1 - lijst1.get(e)) * (1 - lijst1.get(f)) * (1 - 0.99998);
                        //System.out.println("Uitkomst: " + uitkomst);
                        if (uitkomst == beschikbaarheid) {
                            if (!(lijst2.contains(lijst1.get(d)) || lijst2.contains(lijst1.get(e)) || lijst2.contains(lijst1.get(f)) || lijst2.contains(0.99998))) {
                                lijst2.add(lijst1.get(d));
                                lijst2.add(lijst1.get(e));
                                lijst2.add(lijst1.get(f));
                                lijst2.add(0.99998);
                                //System.out.println(lijst1.get(d) + " " + lijst1.get(e) + " " + lijst1.get(f) + " " + 0.99998);
                            }
                        }
                    }
                }
            }
        }

        if (aantalServers == 5) {
            for (int h = 0; h < lijst1.size(); h++) {
                for (int i = 0; i < lijst1.size(); i++) {
                    for (int j = 0; j < lijst1.size(); j++) {
                        for (int k = 0; k < lijst1.size(); k++) {
                            uitkomst = 1 - (1 - lijst1.get(h)) * (1 - lijst1.get(i)) * (1 - lijst1.get(j)) * (1 - lijst1.get(k)) * (1 - 0.99998);
                            //System.out.println("Uitkomst: " + uitkomst);
                            if (uitkomst == beschikbaarheid) {
                                if (!(lijst2.contains(lijst1.get(h)) || lijst2.contains(lijst1.get(i)) || lijst2.contains(lijst1.get(j)) || lijst2.contains(lijst1.get(k)) || lijst2.contains(0.99998))) {
                                    lijst2.add(lijst1.get(h));
                                    lijst2.add(lijst1.get(i));
                                    lijst2.add(lijst1.get(j));
                                    lijst2.add(lijst1.get(k));
                                    lijst2.add(0.99998);
                                    //System.out.println(lijst1.get(h) + " " + lijst1.get(i) + " " + lijst1.get(j) + " " + lijst1.get(k) + " " + 0.99998);
                                }
                            }
                        }
                    }
                }
            }
        }

        if (aantalServers == 6) {
            for (int m = 0; m < lijst1.size(); m++) {
                for (int n = 0; n < lijst1.size(); n++) {
                    for (int o = 0; o < lijst1.size(); o++) {
                        for (int p = 0; p < lijst1.size(); p++) {
                            for (int q = 0; q < lijst1.size(); q++) {
                                uitkomst = 1 - (1 - lijst1.get(m)) * (1 - lijst1.get(n)) * (1 - lijst1.get(o)) * (1 - lijst1.get(p)) * (1 - lijst1.get(q)) * (1 - 0.99998);
                                //System.out.println("Uitkomst: " + uitkomst);
                                if (uitkomst == beschikbaarheid) {
                                    if (!(lijst2.contains(lijst1.get(m)) || lijst2.contains(lijst1.get(n)) || lijst2.contains(lijst1.get(o)) || lijst2.contains(lijst1.get(p)) || lijst2.contains(lijst1.get(q)) || lijst2.contains(0.99998))) {
                                        lijst2.add(lijst1.get(m));
                                        lijst2.add(lijst1.get(n));
                                        lijst2.add(lijst1.get(p));
                                        lijst2.add(lijst1.get(o));
                                        lijst2.add(lijst1.get(q));
                                        lijst2.add(0.99998);
                                        //System.out.println(lijst1.get(m) + " " + lijst1.get(n) + " " + lijst1.get(o) + " " + lijst1.get(p) + " " + lijst1.get(q) + " " + 0.99998);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        if (aantalServers == 7) {
            for (int s = 0; s < lijst1.size(); s++) {
                for (int t = 0; t < lijst1.size(); t++) {
                    for (int u = 0; u < lijst1.size(); u++) {
                        for (int v = 0; v < lijst1.size(); v++) {
                            for (int w = 0; w < lijst1.size(); w++) {
                                for (int x = 0; x < lijst1.size(); x++) {
                                    uitkomst = 1 - (1 - lijst1.get(s)) * (1 - lijst1.get(t)) * (1 - lijst1.get(u)) * (1 - lijst1.get(v)) * (1 - lijst1.get(w)) * (1 - lijst1.get(x)) * (1 - 0.99998);
                                    //System.out.println("Uitkomst: " + uitkomst);
                                    if (uitkomst == beschikbaarheid) {
                                        if (!(lijst2.contains(lijst1.get(s)) || lijst2.contains(lijst1.get(t)) || lijst2.contains(lijst1.get(u)) || lijst2.contains(lijst1.get(v)) || lijst2.contains(lijst1.get(w)) || lijst2.contains(lijst1.get(x)) || lijst2.contains(0.99998))) {
                                            lijst2.add(lijst1.get(s));
                                            lijst2.add(lijst1.get(t));
                                            lijst2.add(lijst1.get(v));
                                            lijst2.add(lijst1.get(w));
                                            lijst2.add(lijst1.get(u));
                                            lijst2.add(lijst1.get(x));
                                            lijst2.add(0.99998);
                                            //System.out.println(lijst1.get(s) + " " + lijst1.get(t) + " " + lijst1.get(u) + " " + lijst1.get(v) + " " + lijst1.get(w) + " " + lijst1.get(x) + " " + 0.99998);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        if (aantalServers == 8) {
            for (int z = 0; z < lijst1.size(); z++) {
                for (int aa = 0; aa < lijst1.size(); aa++) {
                    for (int bb = 0; bb < lijst1.size(); bb++) {
                        for (int cc = 0; cc < lijst1.size(); cc++) {
                            for (int dd = 0; dd < lijst1.size(); dd++) {
                                for (int ee = 0; ee < lijst1.size(); ee++) {
                                    for (int ff = 0; ff < lijst1.size(); ff++) {
                                        uitkomst = 1 - (1 - lijst1.get(z)) * (1 - lijst1.get(aa)) * (1 - lijst1.get(bb)) * (1 - lijst1.get(cc)) * (1 - lijst1.get(dd)) * (1 - lijst1.get(ee)) * (1 - lijst1.get(ff)) * (1 - 0.99998);
                                        //System.out.println("Uitkomst: " + uitkomst);
                                        if (uitkomst == beschikbaarheid) {
                                            if (!(lijst2.contains(lijst1.get(z)) || lijst2.contains(lijst1.get(aa)) || lijst2.contains(lijst1.get(bb)) || lijst2.contains(lijst1.get(cc)) || lijst2.contains(lijst1.get(dd)) || lijst2.contains(lijst1.get(ee)) || lijst2.contains(lijst1.get(ff)) || lijst2.contains(0.99998))) {
                                                lijst2.add(lijst1.get(z));
                                                lijst2.add(lijst1.get(aa));
                                                lijst2.add(lijst1.get(cc));
                                                lijst2.add(lijst1.get(dd));
                                                lijst2.add(lijst1.get(bb));
                                                lijst2.add(lijst1.get(ee));
                                                lijst2.add(lijst1.get(ff));
                                                lijst2.add(0.99998);
                                                //System.out.println(lijst1.get(z) + " " + lijst1.get(aa) + " " + lijst1.get(bb) + " " + lijst1.get(cc) + " " + lijst1.get(dd) + " " + lijst1.get(ee) + " " + lijst1.get(ff) + " " + 0.99998);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        if (aantalServers == 9) {
            for (int z = 0; z < lijst1.size(); z++) {
                for (int aa = 0; aa < lijst1.size(); aa++) {
                    for (int bb = 0; bb < lijst1.size(); bb++) {
                        for (int cc = 0; cc < lijst1.size(); cc++) {
                            for (int dd = 0; dd < lijst1.size(); dd++) {
                                for (int ee = 0; ee < lijst1.size(); ee++) {
                                    for (int ff = 0; ff < lijst1.size(); ff++) {
                                        for (int gg = 0; gg < lijst1.size(); gg++) {
                                            uitkomst = 1 - (1 - lijst1.get(z)) * (1 - lijst1.get(aa)) * (1 - lijst1.get(bb)) * (1 - lijst1.get(cc)) * (1- lijst1.get(dd)) * (1 - lijst1.get(ee)) * (1 - lijst1.get(ff)) * (1 - lijst1.get(gg)) * (1 - 0.99998);
                                            //System.out.println("Uitkomst: " + uitkomst);
                                            if (uitkomst == beschikbaarheid) {
                                                if (!(lijst2.contains(lijst1.get(dd)) || lijst2.contains(lijst1.get(aa)) || lijst2.contains(lijst1.get(bb)) || lijst2.contains(lijst1.get(cc)) || lijst2.contains(lijst1.get(dd)) || lijst2.contains(lijst1.get(ee)) || lijst2.contains(lijst1.get(ff)) || lijst2.contains(lijst1.get(gg)) || lijst2.contains(0.99998))) {
                                                    lijst2.add(lijst1.get(dd));
                                                    lijst2.add(lijst1.get(aa));
                                                    lijst2.add(lijst1.get(dd));
                                                    lijst2.add(lijst1.get(dd));
                                                    lijst2.add(lijst1.get(bb));
                                                    lijst2.add(lijst1.get(ee));
                                                    lijst2.add(lijst1.get(ff));
                                                    lijst2.add(lijst1.get(gg));
                                                    lijst2.add(0.99998);
                                                    //System.out.println(lijst1.get(dd) + " " + lijst1.get(aa) + " " + lijst1.get(bb) + " " + lijst1.get(dd) + " " + lijst1.get(dd) + " " + lijst1.get(ee) + " " + lijst1.get(ff) + " " + lijst1.get(gg) + " " + 0.99998);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        if (aantalServers == 10) {
            for (int z = 0; z < lijst1.size(); z++) {
                for (int aa = 0; aa < lijst1.size(); aa++) {
                    for (int bb = 0; bb < lijst1.size(); bb++) {
                        for (int cc = 0; cc < lijst1.size(); cc++) {
                            for (int dd = 0; dd < lijst1.size(); dd++) {
                                for (int ee = 0; ee < lijst1.size(); ee++) {
                                    for (int ff = 0; ff < lijst1.size(); ff++) {
                                        for (int gg = 0; gg < lijst1.size(); gg++) {
                                            for(int hh = 0; hh < lijst1.size(); hh++) {
                                                uitkomst = 1 - (1 - lijst1.get(z)) * (1 - lijst1.get(aa)) * (1 - lijst1.get(bb)) * (1 - lijst1.get(cc)) * (1 - lijst1.get(dd)) * (1 - lijst1.get(ee)) * (1 - lijst1.get(ff)) * (1 - lijst1.get(gg)) * (1 - lijst1.get(hh)) * (1 - 0.99998);
                                                //System.out.println("Uitkomst: " + uitkomst);
                                                if (uitkomst == beschikbaarheid) {
                                                    if (!(lijst2.contains(lijst1.get(dd)) || lijst2.contains(lijst1.get(aa)) || lijst2.contains(lijst1.get(bb)) || lijst2.contains(lijst1.get(cc)) || lijst2.contains(lijst1.get(dd)) || lijst2.contains(lijst1.get(ee)) || lijst2.contains(lijst1.get(ff)) || lijst2.contains(lijst1.get(gg)) || lijst2.contains(lijst1.get(hh)) || lijst2.contains(0.99998))) {
                                                        lijst2.add(lijst1.get(dd));
                                                        lijst2.add(lijst1.get(aa));
                                                        lijst2.add(lijst1.get(dd));
                                                        lijst2.add(lijst1.get(dd));
                                                        lijst2.add(lijst1.get(bb));
                                                        lijst2.add(lijst1.get(ee));
                                                        lijst2.add(lijst1.get(ff));
                                                        lijst2.add(lijst1.get(gg));
                                                        lijst2.add(lijst1.get(hh));
                                                        lijst2.add(0.99998);
                                                        //System.out.println(lijst1.get(dd) + " " + lijst1.get(aa) + " " + lijst1.get(bb) + " " + lijst1.get(dd) + " " + lijst1.get(dd) + " " + lijst1.get(ee) + " " + lijst1.get(ff) + " " + lijst1.get(gg) + " " + lijst1.get(hh) + " " + 0.99998);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        int teller90 = 0;
        int teller80 = 0;
        int teller95 = 0;
        int teller98 = 0;
        for(int zz = 0; zz < lijst2.size(); zz++){
            if(lijst2.get(zz) == 0.90){
                teller90++;
            }
            if(lijst2.get(zz) == 0.80){
                teller80++;
            }
            if(lijst2.get(zz) == 0.95){
                teller95++;
            }
            if(lijst2.get(zz) == 0.98){
                teller98++;
            }
        }

        int prijs = 0;
        int aantaldb = 0;
        int aantalwb = 0;
        ArrayList<Server> opstelling = new ArrayList<>();
        //add minimum servers
        if(teller90 >= 3 && (aantaldb == 0 || aantalwb == 0)){
            for(Server servers : serverList){
                if(servers.beschikbaarheid == 0.90 && servers.type == 1){
                    opstelling.add(servers);
                    prijs += servers.prijs;
                    opstelling.add(servers);
                    prijs += servers.prijs;
                }
                if(servers.beschikbaarheid == 0.90 && servers.type == 2){
                    opstelling.add(servers);
                    prijs += servers.prijs;
                }

            }
        }
        aantaldb = 2;
        teller90=teller90-3;


        if(teller90 != 0) {
            for (int l = 0; l < teller90; l++) {
                for(Server servers : serverList) {
                    if(aantaldb < 2 && teller90 >= 2){
                        if(servers.beschikbaarheid == 0.90 && servers.type == 1){ //if there aren't 3 servers
                            opstelling.add(servers);
                            prijs += servers.prijs;
                            aantaldb++;
                        }
                    }
                    if (servers.beschikbaarheid == 0.90 && servers.type == 2 && aantaldb == 2) {
                        opstelling.add(servers);
                        prijs += servers.prijs;
                    }
                }
            }
        }

        teller90 = 0;

        for(int k = 0; k < teller80; k++){
            for(Server servers : serverList) {
                if (servers.beschikbaarheid == 0.80) {
                    opstelling.add(servers);
                    prijs += servers.prijs;
                }
            }
        }

        for(int k = 0; k < teller95; k++){
            for(Server servers : serverList) {
                if (servers.beschikbaarheid == 0.95 && servers.type == 2) {
                    opstelling.add(servers);
                    prijs += servers.prijs;
                }
            }
        }

        for(int k = 0; k < teller98; k++){
            for(Server servers : serverList) {
                if (servers.beschikbaarheid == 0.98 && servers.type == 2) {
                    opstelling.add(servers);
                    prijs += servers.prijs;
                }
            }
        }

        for(Server servers : serverList){
            if(servers.type == 0){
                opstelling.add(servers);
                prijs += servers.prijs;
            }
        }

        String serveropstelling = "<html><div>Totale prijs: " + prijs + "<br/>";
        for(Server sopstelling : opstelling){
            serveropstelling += sopstelling + "<br/>";
        }
        serveropstelling += "</div></html>";
        return serveropstelling;




//        //Geven server opstelling
//        System.out.println("Server opstelling: ");
//        for (int zzz = 0; zzz < lijst2.size(); zzz++) {
//            for (Server servers : serverList) {
//                //System.out.println(servers);
//                if (lijst2.get(zzz).equals(servers.beschikbaarheid)) { //haalt dubbels eruit
//                    lijst3.add(servers);
//                    //System.out.println(servers);
//                }
//            }
//        }
//
//
//            ArrayList<Server> lijstpfSense = new ArrayList<>();
//            ArrayList<Server> lijstdb = new ArrayList<>();
//            ArrayList<Server> lijstwb = new ArrayList<>();
//
//            for (Server serverlijst3 : lijst3) {
//                if (serverlijst3.type == 0) {
//                    lijstpfSense.add(serverlijst3); //de pfSense
//                }
//
//                if (serverlijst3.type == 1) {
//                    lijstdb.add(serverlijst3); //alle db servers
//                }
//
//                if (serverlijst3.type == 2) {
//                    lijstwb.add(serverlijst3); //alle wb servers
//                }
//            }
//
//            ArrayList<Server> lijst500 = new ArrayList<>();
//            int test = 1;
//            //Hier kun je alle verschillende servers filteren bv op goedkoopste of aantal
//            for (Server pfSense : lijstpfSense) {
//                System.out.println(pfSense);
//            }
//
//
//
//            for (Server wbservers : lijstwb) {
//                System.out.println(wbservers);
//            }
        }
    }




