package Applicatie;

import Applicatie.Server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class MonitorDialog extends JFrame implements ActionListener {

    JButton jButton;
    JLabel CPU;
    JLabel MEMORY;
    JLabel DISK;
    JLabel percCPU;
    JLabel percMEM;
    JLabel percDISK;
    JTextField welkeServer;

    public MonitorDialog() {
        setSize(900, 75);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setLayout(new FlowLayout());
        Dimension d = new Dimension(150, 25);

        jButton = new JButton("Update");
        jButton.setPreferredSize(d);
        jButton.addActionListener(this);
        add(jButton);

        JLabel servervraag = new JLabel("Van welke server wil je de beschikbaarheid?");
        add(servervraag);

        welkeServer = new JTextField(17);
        add(welkeServer);

        CPU = new JLabel("CPU");
        add(CPU);
        percCPU = new JLabel();
        add(percCPU);

        MEMORY = new JLabel("MEMORY");
        add(MEMORY);
        percMEM = new JLabel();
        add(percMEM);

        DISK = new JLabel("DISK");
        add(DISK);
        percDISK = new JLabel();
        add(percDISK);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jButton) {
            CPU.setText("CPU");
            MEMORY.setText("MEMORY");
            DISK.setText("DISK");
            //int serverGekozen = Integer.parseInt(welkeServer.getText());
            //serverList.getServer(serverGekozen);
            if (welkeServer.getText().equals("HAL9001DB")           //Kijkt of de naam overeenkomt met een server/database
                    || welkeServer.getText().equals("HAL9002DB")
                    || welkeServer.getText().equals("HAL9003DB")
                    || welkeServer.getText().equals("HAL9001W")
                    || welkeServer.getText().equals("HAL9002W")
                    || welkeServer.getText().equals("HAL9003W")
                    || welkeServer.getText().equals("PfSense")){
                try {
                    percDISK.setText("= " + ServerBeschikbaarheid.getDISKprocent() + "%");
                    percMEM.setText("= " + ServerBeschikbaarheid.getMEMprocent() + "%");
                    percCPU.setText("= " + ServerBeschikbaarheid.getCPUprocent() + "%");
                } catch (NullPointerException | FileNotFoundException ex) {
                    percCPU.setText("Kan gegevens niet ophalen");
                    percMEM.setText("Kan gegevens niet ophalen");
                    percDISK.setText("Kan gegevens niet ophalen");
                }
            } else {        //als er geen geldige database/server wordt gevraagd dan laat de applicatie dit weten
                CPU.setText("Voer een geldige server/database in");
                MEMORY.setText("");
                DISK.setText("");
            }
        }
    }
}
