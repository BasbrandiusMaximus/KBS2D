package Optimalisatie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ApplicatieFrame extends JFrame implements ActionListener {
    private ArrayList<String> lijst;
    private ArrayList<Server> serverArrayList;
    private JFrame frame;
    private JButton jboptimalisatie;
    private JLabel jlservers;

    public ApplicatieFrame(){
        //Aanmaken applicatie frame
        frame = new JFrame();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(600,400);
        frame.setTitle("Applicatie");
        frame.setLayout(new FlowLayout());

        //Aanmaken optimaliatie button en toevoegen ActionListener
        jboptimalisatie = new JButton("Optimalisatie functie");
        jboptimalisatie.addActionListener(this);
        frame.add(jboptimalisatie);

        lijst = new ArrayList<>();
        serverArrayList = new ArrayList<>();


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

        ServerList serverLijst = new ServerList(); //ServerList aanmaken

        for(String data : lijst){
            String[] test = data.split(",", 0);
            try {
                int test1 = Integer.parseInt(test[1]); //prijs
                double test2 = Double.parseDouble(test[2]); //beschikbaarheid
                int test3 = Integer.parseInt(test[3]); //type
                Server server = new Server(test[0], test1, test2, test3);
                serverLijst.voegServerToe(server);
                serverArrayList.add(server);
            }
            catch(ArrayIndexOutOfBoundsException ignored){ }
        }
        System.out.println(serverLijst.printServerList());
        //Berekenen optimale samenstelling bij 99,99%
        //Server.BerekenBeschikbaarheid(serverLijst.getServer(0), serverLijst.getServer(1), serverLijst.getServer(1), serverLijst.getServer(1), serverLijst.getServer(2), serverLijst.getServer(4),serverLijst.getServer(5), serverLijst.getServer(5), serverLijst.getServer(5), serverLijst.getServer(5));
        //Server.BerekenBeschikbaarheid(serverLijst.getServer(0), serverLijst.getServer(1));
        //Server.serversUitrekenen(0.9999999, 3, serverArrayList);

        //aanmaken nieuwe JLabel voor de lijst met beschikbare servers
        jlservers = new JLabel();
        System.out.println(serverLijst.printServerList());
        jlservers.setText(serverLijst.printServerList());
        jlservers.setHorizontalAlignment(SwingConstants.CENTER);
        Dimension d1 = new Dimension(500,150);
        jlservers.setPreferredSize(d1);
        frame.add(jlservers);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        //Als er op de optimalisatie button gedrukt wordt, dan wordt je naar de optimalisatie dialoog gestuurd. Zie OptimalisatieDialog.java
        if (e.getSource() == jboptimalisatie){
            OptimalisatieDialog optimalisatiedialog = new OptimalisatieDialog();
        }
    }
}
