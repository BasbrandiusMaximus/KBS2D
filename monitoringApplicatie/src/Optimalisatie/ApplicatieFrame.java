package Optimalisatie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ApplicatieFrame extends JFrame implements ActionListener {
    private ServerList serverList;
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

        //declaratie van Serverlist
        ServerList list = new ServerList();

        //declaratie en initializatie van servers
        Server pfSense = new Server("pfSense", 4000, 0.99998);

        Server HAL9001DB = new Server("HAL9001DB", 5100, 0.90);
        Server HAL9002DB = new Server("HAL9002DB",7700, 0.95);
        Server HAL9003DB = new Server("HAL9003DB",12200, 0.98);

        Server HAL9001W = new Server("HAL9001W",2200, 0.80);
        Server HAL9002W = new Server("HAL9002W",3200, 0.90);
        Server HAL9003W = new Server("HAL9003W",5100, 0.95);

        //Voeg server toe aan ServerList
        list.voegServerToe(pfSense);
        list.voegServerToe(HAL9001DB);
        list.voegServerToe(HAL9002DB);
        list.voegServerToe(HAL9003DB);
        list.voegServerToe(HAL9001W);
        list.voegServerToe(HAL9002W);
        list.voegServerToe(HAL9003W);

        //Berkenen optimale samenstelling bij 99,99%
        Server.Bereken(HAL9001DB, HAL9002DB, HAL9002DB, HAL9002DB, HAL9001W, HAL9001W, HAL9001W, HAL9002W, pfSense);
        Server.Bereken(HAL9001DB, HAL9002DB, HAL9003DB);

        //aanmaken nieuwe JLabel voor de lijst met beschikbare servers
        jlservers = new JLabel();
        jlservers.setText(list.printServerList());
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
