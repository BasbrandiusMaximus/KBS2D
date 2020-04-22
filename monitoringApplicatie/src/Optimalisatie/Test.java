package Optimalisatie;

import java.util.ArrayList;

public class Test {
    private double beschikbaarheid;
    private double server1 = 0.95; //db
    private double server2 = 0.90; //db
    private double server3 = 0.98; //db
    private int teller = 0;
    private int mogelijkheden = 1;
    private double uitkomst;
    private ArrayList<Double> lijst1;
    private ArrayList<Double> lijst2;
    private ArrayList<Double> lijst3;


    public Test(double beschikbaarheid){
        this.beschikbaarheid = beschikbaarheid;
        lijst1 = new ArrayList<>();
        lijst1.add(0.95);
        lijst1.add(0.90);
        lijst1.add(0.98);

        lijst2 = new ArrayList<>();
        lijst2.add(0.80);
        lijst2.add(0.90);
        lijst2.add(0.95);
    }


    public void serversUitrekenen(double beschikbaarheid) {
        //beschikbaarheid = 1-(1-server1)*(1-server2);
        //System.out.println(beschikbaarheid);
        //antwoord moet zijn 0.95 en 0.90. We voeren in 0.995.

        //met 2 servers
        for (int i = 0; i < lijst1.size(); i++) {
           for (int k = 0; k < lijst2.size(); k++) {
           uitkomst = 1 - (1 - lijst1.get(i)) * (1 - lijst2.get(k));
               if (uitkomst == beschikbaarheid) {
                   System.out.println("Beschikbaarheid: " + uitkomst + ", Server 1: " + lijst1.get(i) + ", Server 2: " + lijst2.get(k));
                }
           }
        }

        for (int i = 0; i < lijst1.size(); i++) {
            for (int k = 0; k < lijst1.size(); k++) {
                for(int l = 0; l < lijst1.size(); l++) {
                    uitkomst = 1-(1-lijst1.get(i))*(1-lijst1.get(k))*(1-lijst1.get(l));
                    if (uitkomst == beschikbaarheid) {
                        System.out.println("Beschikbaarheid: " + uitkomst + ", Server 1: " + lijst1.get(i) + ", Server 2: " + lijst1.get(k) + ", Server 3: " + lijst1.get(l));
                    }
                }
            }
        }
    }
}
