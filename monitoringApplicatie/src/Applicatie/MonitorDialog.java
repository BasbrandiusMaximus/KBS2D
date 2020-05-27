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

public class MonitorDialog extends JDialog implements ActionListener {

    ServerList serverList;
    //TekenTaart tekenTaart;
    SSHdownloaden ssHdownloaden;

    static Timer timer;

    JButton update;
    JButton laatDiagramZien;

    JLabel CPULinux1;
    JLabel MEMORYLinux1;
    JLabel DISKLinux1;

    JLabel percCPULinux1;
    JLabel percMEMLinux1;
    JLabel percDISKLinux1;

    JLabel CPULinux2;
    JLabel MEMORYLinux2;
    JLabel DISKLinux2;

    JLabel percCPULinux2;
    JLabel percMEMLinux2;
    JLabel percDISKLinux2;

    JLabel CPUWindows1;
    JLabel MEMORYWindows1;
    JLabel DISKWindows1;

    JLabel percCPUWindows1;
    JLabel percMEMWindows1;
    JLabel percDISKWindows1;

    JLabel CPUWindows2;
    JLabel MEMORYWindows2;
    JLabel DISKWindows2;

    JLabel percCPUWindows2;
    JLabel percMEMWindows2;
    JLabel percDISKWindows2;

    JLabel CPUPfSense;
    JLabel MEMORYPfSense;
    JLabel DISKPfSense;

    JLabel percCPUPfsense;
    JLabel percMEMPfSense;
    JLabel percDISKPfSense;

    private Boolean IsDialoogActief;

    public class OnzeTimerTask extends TimerTask {

        OnzeTimerTask() {

        }

        public void run() {
            try {
                while (IsDialoogActief) {
                    SSHdownloaden.downloadLinuxServer1();
                    SSHdownloaden.downloadLinuxServer2();
                    //SSHdownloaden.downloadWindowsServer1();
                    SSHdownloaden.downloadWindowsServer2();
                    //SSHdownloaden.downloadPfSense();


                    // SSHdownloaden.downloadLinuxServer1();
                    // SSHdownloaden.downloadLinuxServer2();
                    // SSHdownloaden.downloadWindowsServer1();
                    // SSHdownloaden.downloadWindowsServer2();
                    // SSHdownloaden.downloadPfSense();


                    try {
                        //ssHdownloaden.downloadLinuxServer1();
                        percDISKLinux1.setText("= " + ServerBeschikbaarheid.getDISKprocentLinux1() + "vrij");
                        percMEMLinux1.setText("= " + ServerBeschikbaarheid.getMEMprocentLinux1());
                        percCPULinux1.setText("= " + ServerBeschikbaarheid.getCPUprocentLinux1());
                    } catch (NullPointerException | IOException e1) {
                        percCPULinux1.setText(" = Kan gegevens niet ophalen");
                        percMEMLinux1.setText(" = Kan gegevens niet ophalen");
                        percDISKLinux1.setText(" = Kan gegevens niet ophalen");
                    }

                    try {
                        //ssHdownloaden.downloadLinuxServer2();
                        percDISKLinux2.setText("= " + ServerBeschikbaarheid.getDISKprocentLinux2() + "vrij");
                        percMEMLinux2.setText("= " + ServerBeschikbaarheid.getMEMprocentLinux2());
                        percCPULinux2.setText("= " + ServerBeschikbaarheid.getCPUprocentLinux2());
                    } catch (NullPointerException | IOException e2) {
                        percCPULinux2.setText(" = Kan gegevens niet ophalen");
                        percMEMLinux2.setText(" = Kan gegevens niet ophalen");
                        percDISKLinux2.setText(" = Kan gegevens niet ophalen");
                    }

                    try {
                        //ssHdownloaden.downloadWindowsServer1();
                        percDISKWindows1.setText("= " + ServerBeschikbaarheid.getDISKprocentWindows1() + " bytes vrij");
                        percMEMWindows1.setText("= " + ServerBeschikbaarheid.getMEMprocentWindows1());
                        percCPUWindows1.setText("= " + ServerBeschikbaarheid.getCPUprocentWindows1());
                    } catch (NullPointerException | IOException e3) {
                        percCPUWindows1.setText(" = Kan gegevens niet ophalen");
                        percMEMWindows1.setText(" = Kan gegevens niet ophalen");
                        percDISKWindows1.setText(" = Kan gegevens niet ophalen");
                    }

                    try {
                        //ssHdownloaden.downloadWindowsServer2();
                        percDISKWindows2.setText("= " + ServerBeschikbaarheid.getDISKprocentWindows2() + "vrij");
                        percMEMWindows2.setText("= " + ServerBeschikbaarheid.getMEMprocentWindows2());
                        percCPUWindows2.setText("= " + ServerBeschikbaarheid.getCPUprocentWindows2());
                    } catch (NullPointerException | IOException e4) {
                        percCPUWindows2.setText(" = Kan gegevens niet ophalen");
                        percMEMWindows2.setText(" = Kan gegevens niet ophalen");
                        percDISKWindows2.setText(" = Kan gegevens niet ophalen");
                    }

                    try {
                        //ssHdownloaden.downloadPfSense();
                        percDISKPfSense.setText("= " + ServerBeschikbaarheid.getDISKprocentPfSense() + "vrij");
                        percMEMPfSense.setText("= " + ServerBeschikbaarheid.getMEMprocentPfSense());
                        percCPUPfsense.setText("= " + ServerBeschikbaarheid.getCPUprocentPfSense());
                    } catch (NullPointerException | IOException e5) {
                        percCPUPfsense.setText(" = Kan gegevens niet ophalen");
                        percMEMPfSense.setText(" = Kan gegevens niet ophalen");
                        percDISKPfSense.setText(" = Kan gegevens niet ophalen");
                    }

                    Thread.sleep(5000);
                }
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
    }

    public MonitorDialog() {
        IsDialoogActief = true;
        setTitle("Server Beschikbaarheid");
        setSize(325, 300);
        getContentPane().setBackground(new Color(230, 244, 255));
        //setDefaultCloseOperation(HIDE_ON_CLOSE);
        setLayout(new FlowLayout());
        Dimension d = new Dimension(150, 50);

        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
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

        update = new JButton("Update");
        update.setHorizontalAlignment(SwingConstants.CENTER);
        update.setPreferredSize(d);
        update.addActionListener(this);
        add(update);

        JLabel servervraag = new JLabel("IP servers:");
        add(servervraag);


        Dimension d1 = new Dimension(300, 15);
        JLabel server1 = new JLabel("\n Linux DatabaseServer 1 = 192.168.1.102");
        server1.setPreferredSize(d1);
        server1.setHorizontalAlignment(SwingConstants.CENTER);
        add(server1);
        CPULinux1 = new JLabel("CPU");
        add(CPULinux1);
        percCPULinux1 = new JLabel();
        add(percCPULinux1);

        MEMORYLinux1 = new JLabel("MEMORY");
        add(MEMORYLinux1);
        percMEMLinux1 = new JLabel();
        add(percMEMLinux1);

        DISKLinux1 = new JLabel("DISK");
        add(DISKLinux1);
        percDISKLinux1 = new JLabel();
        add(percDISKLinux1);


        JLabel server2 = new JLabel("\n Linux DatabaseServer 2 = 192.168.1.103");
        server2.setPreferredSize(d1);
        server2.setHorizontalAlignment(SwingConstants.CENTER);
        add(server2);
        CPULinux2 = new JLabel("CPU");
        add(CPULinux2);
        percCPULinux2 = new JLabel();
        add(percCPULinux2);

        MEMORYLinux2 = new JLabel("MEMORY");
        add(MEMORYLinux2);
        percMEMLinux2 = new JLabel();
        add(percMEMLinux2);

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

        MEMORYWindows1 = new JLabel("MEMORY");
        add(MEMORYWindows1);
        percMEMWindows1 = new JLabel();
        add(percMEMWindows1);

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

        MEMORYWindows2 = new JLabel("MEMORY");
        add(MEMORYWindows2);
        percMEMWindows2 = new JLabel();
        add(percMEMWindows2);

        DISKWindows2 = new JLabel("DISK");
        add(DISKWindows2);
        percDISKWindows2 = new JLabel();
        add(percDISKWindows2);


        JLabel server5 = new JLabel("\n Windows PfSense = 145.44.233.21");
        server5.setPreferredSize(d1);
        server5.setHorizontalAlignment(SwingConstants.CENTER);
        add(server5);
        CPUPfSense = new JLabel("CPU");
        add(CPUPfSense);
        percCPUPfsense = new JLabel();
        add(percCPUPfsense);

        MEMORYPfSense = new JLabel("MEMORY");
        add(MEMORYPfSense);
        percMEMPfSense = new JLabel();
        add(percMEMPfSense);

        DISKPfSense = new JLabel("DISK");
        add(DISKPfSense);
        percDISKPfSense = new JLabel();
        add(percDISKPfSense);

        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        /*
    }
        if (e.getSource() == update) {
            try {
                while (IsDialoogActief) {
                    SSHdownloaden.downloadLinuxServer1();
                    SSHdownloaden.downloadLinuxServer2();
                    //SSHdownloaden.downloadWindowsServer1();
                    SSHdownloaden.downloadWindowsServer2();
                    //SSHdownloaden.downloadPfSense();


                    // SSHdownloaden.downloadLinuxServer1();
                    // SSHdownloaden.downloadLinuxServer2();
                    // SSHdownloaden.downloadWindowsServer1();
                    // SSHdownloaden.downloadWindowsServer2();
                    // SSHdownloaden.downloadPfSense();


                    try {
                        //ssHdownloaden.downloadLinuxServer1();
                        percDISKLinux1.setText("= " + ServerBeschikbaarheid.getDISKprocentLinux1() + "vrij");
                        percMEMLinux1.setText("= " + ServerBeschikbaarheid.getMEMprocentLinux1());
                        percCPULinux1.setText("= " + ServerBeschikbaarheid.getCPUprocentLinux1());
                        System.out.println("hier komt hij langs");
                    } catch (NullPointerException | IOException e1) {
                        percCPULinux1.setText(" = Kan gegevens niet ophalen");
                        percMEMLinux1.setText(" = Kan gegevens niet ophalen");
                        percDISKLinux1.setText(" = Kan gegevens niet ophalen");
                    }

                    try {
                        //ssHdownloaden.downloadLinuxServer2();
                        percDISKLinux2.setText("= " + ServerBeschikbaarheid.getDISKprocentLinux2() + "vrij");
                        percMEMLinux2.setText("= " + ServerBeschikbaarheid.getMEMprocentLinux2());
                        percCPULinux2.setText("= " + ServerBeschikbaarheid.getCPUprocentLinux2());
                    } catch (NullPointerException | IOException e2) {
                        percCPULinux2.setText(" = Kan gegevens niet ophalen");
                        percMEMLinux2.setText(" = Kan gegevens niet ophalen");
                        percDISKLinux2.setText(" = Kan gegevens niet ophalen");
                    }

                    try {
                        //ssHdownloaden.downloadWindowsServer1();
                        percDISKWindows1.setText("= " + ServerBeschikbaarheid.getDISKprocentWindows1() + " bytes vrij");
                        percMEMWindows1.setText("= " + ServerBeschikbaarheid.getMEMprocentWindows1());
                        percCPUWindows1.setText("= " + ServerBeschikbaarheid.getCPUprocentWindows1());
                    } catch (NullPointerException | IOException e3) {
                        percCPUWindows1.setText(" = Kan gegevens niet ophalen");
                        percMEMWindows1.setText(" = Kan gegevens niet ophalen");
                        percDISKWindows1.setText(" = Kan gegevens niet ophalen");
                    }

                    try {
                        //ssHdownloaden.downloadWindowsServer2();
                        percDISKWindows2.setText("= " + ServerBeschikbaarheid.getDISKprocentWindows2() + "vrij");
                        percMEMWindows2.setText("= " + ServerBeschikbaarheid.getMEMprocentWindows2());
                        percCPUWindows2.setText("= " + ServerBeschikbaarheid.getCPUprocentWindows2());
                    } catch (NullPointerException | IOException e4) {
                        percCPUWindows2.setText(" = Kan gegevens niet ophalen");
                        percMEMWindows2.setText(" = Kan gegevens niet ophalen");
                        percDISKWindows2.setText(" = Kan gegevens niet ophalen");
                    }

                    try {
                        //ssHdownloaden.downloadPfSense();
                        percDISKPfSense.setText("= " + ServerBeschikbaarheid.getDISKprocentPfSense() + "vrij");
                        percMEMPfSense.setText("= " + ServerBeschikbaarheid.getMEMprocentPfSense());
                        percCPUPfsense.setText("= " + ServerBeschikbaarheid.getCPUprocentPfSense());
                    } catch (NullPointerException | IOException e5) {
                        percCPUPfsense.setText(" = Kan gegevens niet ophalen");
                        percMEMPfSense.setText(" = Kan gegevens niet ophalen");
                        percDISKPfSense.setText(" = Kan gegevens niet ophalen");
                    }

                    Thread.sleep(5000);
                }
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();

 */

    }
}

