package Optimalisatie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class OptimalisatieDialog extends JDialog implements ActionListener {
    private JDialog dialog;
    private JTextField jtBeschikbaarheid;
    private JTextField jtAantalservers;
    private JLabel jlServersamenstelling;
    private JButton jbBereken;
    private int aantalServers;
    private ArrayList<Server> serverArrayList;
    private ArrayList<Double> doubleArrayList;

    public OptimalisatieDialog(ArrayList<Server> serverArrayList, ArrayList<Double> doubleArrayList){
        this.aantalServers = aantalServers;
        this.serverArrayList = serverArrayList;
        this.doubleArrayList = doubleArrayList;
        //Aanmaken optimalisatie dialoog
        dialog = new JDialog();
        dialog.setModal(true);
        dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        dialog.setSize(600,400);
        dialog.setTitle("Optimalisatiefunctie");
        dialog.setLayout(new FlowLayout());

        //Aanmaken JLabel tekst
        JLabel panel1 = new JLabel("<html><div>Voer hieronder een beschikbaarheidspercentage en het aantal servers in om een server samenstelling te maken.</div></html>");
        Dimension d2 = new Dimension(500,30);
        panel1.setPreferredSize(d2);
        dialog.add(panel1);


        //Aanmaken JTextField om de beschikbaarheid in te voeren
        jtBeschikbaarheid = new JTextField();
        Dimension d = new Dimension(200,30);
        jtBeschikbaarheid.setPreferredSize(d);
        dialog.add(jtBeschikbaarheid);
        

        //Aanmaken JTextField om aantal servers in te voeren
        jtAantalservers = new JTextField();
        jtAantalservers.setPreferredSize(d);
        dialog.add(jtAantalservers);

        //Aanmaken Button Bereken
        jbBereken = new JButton("Bereken");
        jbBereken.addActionListener(this);
        dialog.add(jbBereken);

        //Aanmaken JLabel voor antwoord
        jlServersamenstelling = new JLabel();
        dialog.add(jlServersamenstelling);

        dialog.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jbBereken){
            Double bh = Double.parseDouble(jtBeschikbaarheid.getText());
            bh = bh / 100;
            int aantalServers = Integer.parseInt(jtAantalservers.getText());
            jlServersamenstelling.setText(Server.serversUitrekenen(bh, aantalServers, serverArrayList, doubleArrayList));
        }
    }
}
