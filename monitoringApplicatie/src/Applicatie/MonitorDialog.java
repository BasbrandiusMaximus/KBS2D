package Applicatie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class MonitorDialog extends JDialog {

    static Timer timer;

    JLabel CPULinux1;
    JLabel DISKLinux1;

    JLabel percCPULinux1;
    JLabel percDISKLinux1;

    JLabel CPULinux2;
    JLabel DISKLinux2;

    JLabel percCPULinux2;
    JLabel percDISKLinux2;

    JLabel CPUWindows1;
    JLabel DISKWindows1;

    JLabel percCPUWindows1;
    JLabel percDISKWindows1;

    JLabel CPUWindows2;
    JLabel DISKWindows2;

    JLabel percCPUWindows2;
    JLabel percDISKWindows2;


    private Boolean IsDialoogActief;;

    public class OnzeTimerTask extends TimerTask {

        OnzeTimerTask() {

        }

        public void run() { // deze task zorgt ervoor dat deze actie om te zoveel tijd wordt uitgevoerd.
            try {
                while (IsDialoogActief) { // terwijl deze dialoog opent refresht hij de waarden door de files van de servers te dowloaden en deze te updaten met de setText();
                    SSHdownloaden.downloadLinuxServer1();
                    SSHdownloaden.downloadLinuxServer2();
                    SSHdownloaden.downloadWindowsServer1();
                    SSHdownloaden.downloadWindowsServer2();

                    try {
                        //ssHdownloaden.downloadLinuxServer1();
                        if ((ServerBeschikbaarheid.getCPUprocentLinux1().isEmpty() && ServerBeschikbaarheid.getDISKprocentLinux1().isEmpty()) || (!SSHdownloaden.downloadLinuxServer1())) {
                            percCPULinux1.setText(" = Server is niet beschikbaar");
                            percDISKLinux1.setText(" = Server is niet beschikbaar");
                        } else {
                            SSHdownloaden.downloadLinuxServer1();
                            percDISKLinux1.setText("= " + ServerBeschikbaarheid.getDISKprocentLinux1() + " vrij");
                            percCPULinux1.setText("= " + ServerBeschikbaarheid.getCPUprocentLinux1());
                        }
                    } catch (NullPointerException | IOException e1) {
                        percCPULinux1.setText(" = Kan gegevens niet ophalen");
                        percDISKLinux1.setText(" = Kan gegevens niet ophalen");
                    }

                    try {
                        //ssHdownloaden.downloadLinuxServer2();
                        if ((ServerBeschikbaarheid.getCPUprocentLinux2().isEmpty() && ServerBeschikbaarheid.getDISKprocentLinux2().isEmpty()) || !SSHdownloaden.downloadLinuxServer2()) {
                            percCPULinux2.setText(" = Server is niet beschikbaar");
                            percDISKLinux2.setText(" = Server is niet beschikbaar");
                        } else {
                            SSHdownloaden.downloadLinuxServer2();
                            percDISKLinux2.setText("= " + ServerBeschikbaarheid.getDISKprocentLinux2() + " vrij" );
                            percCPULinux2.setText("= " + ServerBeschikbaarheid.getCPUprocentLinux2());
                        }
                    } catch (NullPointerException | IOException e1) {
                        percCPULinux2.setText(" = Kan gegevens niet ophalen");
                        percDISKLinux2.setText(" = Kan gegevens niet ophalen");
                    }

                    try {
                        //ssHdownloaden.downloadWindowsServer1();
                        String cpuWindw1 = ServerBeschikbaarheid.getCPUprocentWindows1();
                        cpuWindw1 = cpuWindw1.replaceAll("��", "");
                        cpuWindw1 = cpuWindw1.replaceAll("L", "");
                        cpuWindw1 = cpuWindw1.replaceAll("o", "");
                        cpuWindw1 = cpuWindw1.replaceAll("a", "");
                        cpuWindw1 = cpuWindw1.replaceAll("d", "");
                        cpuWindw1 = cpuWindw1.replaceAll("P", "");
                        cpuWindw1 = cpuWindw1.replaceAll("e", "");
                        cpuWindw1 = cpuWindw1.replaceAll("r", "");
                        cpuWindw1 = cpuWindw1.replaceAll("c", "");
                        cpuWindw1 = cpuWindw1.replaceAll("e", "");
                        cpuWindw1 = cpuWindw1.replaceAll("n", "");
                        cpuWindw1 = cpuWindw1.replaceAll("t", "");
                        cpuWindw1 = cpuWindw1.replaceAll("a", "");
                        cpuWindw1 = cpuWindw1.replaceAll("g", "");
                        cpuWindw1 = cpuWindw1.replaceAll("e", "");
                        cpuWindw1 = cpuWindw1.trim();

                        String diskWindw2 = ServerBeschikbaarheid.getDISKprocentWindows1();
                        diskWindw2 = diskWindw2.replaceAll("��", "");
                        diskWindw2 = diskWindw2.replaceAll("D", "");
                        diskWindw2 = diskWindw2.replaceAll("e", "");
                        diskWindw2 = diskWindw2.replaceAll("v", "");
                        diskWindw2 = diskWindw2.replaceAll("i", "");
                        diskWindw2 = diskWindw2.replaceAll("c", "");
                        diskWindw2 = diskWindw2.replaceAll("I", "");
                        diskWindw2 = diskWindw2.replaceAll("D", "");
                        diskWindw2 = diskWindw2.replaceAll("F", "");
                        diskWindw2 = diskWindw2.replaceAll("r", "");
                        diskWindw2 = diskWindw2.replaceAll("S", "");
                        diskWindw2 = diskWindw2.replaceAll("p", "");
                        diskWindw2 = diskWindw2.replaceAll("a", "");
                        diskWindw2 = diskWindw2.trim();

                        if ((diskWindw2.isEmpty() && cpuWindw1.isEmpty()) || !SSHdownloaden.downloadWindowsServer1()){
                            percDISKWindows1.setText("= Server is niet beschikbaar");
                            percCPUWindows1.setText("= Server is niet beschikbaar");
                        } else {
                            percDISKWindows1.setText("= " + diskWindw2 + " bytes vrij");
                            percCPUWindows1.setText("= " + cpuWindw1 + "%");
                        }
                    } catch (NullPointerException | IOException e3) {
                        percCPUWindows1.setText(" = Kan gegevens niet ophalen");
                        percDISKWindows1.setText(" = Kan gegevens niet ophalen");
                    }

                    try {
                        //ssHdownloaden.downloadWindowsServer2();
                        String cpuWindw = ServerBeschikbaarheid.getCPUprocentWindows2();
                        cpuWindw = cpuWindw.replaceAll("��", "");
                        cpuWindw = cpuWindw.replaceAll("L", "");
                        cpuWindw = cpuWindw.replaceAll("o", "");
                        cpuWindw = cpuWindw.replaceAll("a", "");
                        cpuWindw = cpuWindw.replaceAll("d", "");
                        cpuWindw = cpuWindw.replaceAll("P", "");
                        cpuWindw = cpuWindw.replaceAll("e", "");
                        cpuWindw = cpuWindw.replaceAll("r", "");
                        cpuWindw = cpuWindw.replaceAll("c", "");
                        cpuWindw = cpuWindw.replaceAll("e", "");
                        cpuWindw = cpuWindw.replaceAll("n", "");
                        cpuWindw = cpuWindw.replaceAll("t", "");
                        cpuWindw = cpuWindw.replaceAll("a", "");
                        cpuWindw = cpuWindw.replaceAll("g", "");
                        cpuWindw = cpuWindw.replaceAll("e", ""); // alles hierboven haalt tekst uit de txt file waar de waarden uitgehaald worden. Anders zet hij deze ook in de GUI
                        cpuWindw = cpuWindw.trim(); // haalt spaties weg voor display in GUI

                        String diskWindw = ServerBeschikbaarheid.getDISKprocentWindows2();
                        diskWindw = diskWindw.replaceAll("��", "");
                        diskWindw = diskWindw.replaceAll("D", "");
                        diskWindw = diskWindw.replaceAll("e", "");
                        diskWindw = diskWindw.replaceAll("v", "");
                        diskWindw = diskWindw.replaceAll("i", "");
                        diskWindw = diskWindw.replaceAll("c", "");
                        diskWindw = diskWindw.replaceAll("I", "");
                        diskWindw = diskWindw.replaceAll("D", "");
                        diskWindw = diskWindw.replaceAll("F", "");
                        diskWindw = diskWindw.replaceAll("r", "");
                        diskWindw = diskWindw.replaceAll("S", "");
                        diskWindw = diskWindw.replaceAll("p", "");
                        diskWindw = diskWindw.replaceAll("a", "");
                        diskWindw = diskWindw.trim();


                        if ((diskWindw.isEmpty() && cpuWindw.isEmpty()) || !SSHdownloaden.downloadWindowsServer2()){
                            percDISKWindows2.setText("= Server is niet beschikbaar" );
                            percCPUWindows2.setText("= Server is niet beschikbaar");
                        } else {
                            percDISKWindows2.setText("= " + diskWindw + " bytes vrij");
                            percCPUWindows2.setText("= " + cpuWindw + "%");
                        }

                    } catch (NullPointerException | IOException e4) {
                        percCPUWindows2.setText(" = Kan gegevens niet ophalen");
                        percDISKWindows2.setText(" = Kan gegevens niet ophalen");
                    }

                    Thread.sleep(1000); // de tijd die nodig is om te refreshen
                }
            } catch (InterruptedException | IOException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
    }

    public MonitorDialog() {
        IsDialoogActief = true;
        setTitle("Server Beschikbaarheid");
        setSize(325, 300);

        getContentPane().setBackground(new Color(230, 244, 255));

        setLayout(new FlowLayout());
        Dimension d = new Dimension(150, 50);

        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) { //als de window open is dan zet hij de boolean op true en activeert hij het ssh downloaden
                IsDialoogActief = true;
                System.out.println(IsDialoogActief);
                timer = new Timer();
                timer.schedule(new OnzeTimerTask(), 1000, 1000);
            }

            @Override
            public void windowClosing(WindowEvent e) {
                IsDialoogActief = false;
                System.out.println(IsDialoogActief);
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });

        JLabel servervraag = new JLabel("IP servers:");
        add(servervraag);


        Dimension d1 = new Dimension(300, 15);
        JLabel server1 = new JLabel("\n Linux DatabaseServer 1 = 192.168.2.100");
        server1.setPreferredSize(d1);
        server1.setHorizontalAlignment(SwingConstants.CENTER);
        add(server1);
        CPULinux1 = new JLabel("CPU");
        add(CPULinux1);
        percCPULinux1 = new JLabel();
        add(percCPULinux1);


        DISKLinux1 = new JLabel("DISK");
        add(DISKLinux1);
        percDISKLinux1 = new JLabel();
        add(percDISKLinux1);


        JLabel server2 = new JLabel("\n Linux DatabaseServer 2 = 192.168.2.101");
        server2.setPreferredSize(d1);
        server2.setHorizontalAlignment(SwingConstants.CENTER);
        add(server2);
        CPULinux2 = new JLabel("CPU");
        add(CPULinux2);
        percCPULinux2 = new JLabel();
        add(percCPULinux2);

        DISKLinux2 = new JLabel("DISK");
        add(DISKLinux2);
        percDISKLinux2 = new JLabel();
        add(percDISKLinux2);


        JLabel server3 = new JLabel("\n Windows Webserver 1 =  192.168.1.106");
        server3.setPreferredSize(d1);
        server3.setHorizontalAlignment(SwingConstants.CENTER);
        add(server3);
        CPUWindows1 = new JLabel("CPU");
        add(CPUWindows1);
        percCPUWindows1 = new JLabel();
        add(percCPUWindows1);

        DISKWindows1 = new JLabel("DISK");
        add(DISKWindows1);
        percDISKWindows1 = new JLabel();
        add(percDISKWindows1);


        JLabel server4 = new JLabel("\n Windows Webserver 2 = 192.168.1.107");
        server4.setPreferredSize(d1);
        server4.setHorizontalAlignment(SwingConstants.CENTER);
        add(server4);
        CPUWindows2 = new JLabel("CPU");
        add(CPUWindows2);
        percCPUWindows2 = new JLabel();
        add(percCPUWindows2);

        DISKWindows2 = new JLabel("DISK");
        add(DISKWindows2);
        percDISKWindows2 = new JLabel();
        add(percDISKWindows2);


        setVisible(true);
    }
}


