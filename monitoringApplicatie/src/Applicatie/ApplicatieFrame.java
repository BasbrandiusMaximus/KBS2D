package Applicatie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ApplicatieFrame extends JFrame implements ActionListener, MouseListener {
    private ArrayList<Server> serverArrayList;
    private ArrayList<Double> doubleArrayList;
    private JButton jboptimalisatie;
    private JButton jbontwerpen;
    private JButton jbservers;
    private JButton jbmonitor;

    public ApplicatieFrame() {
        //Aanmaken applicatie frame
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setTitle("Applicatie");
        frame.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        Color background = new Color(230, 244, 255); //230, 244, 255
        frame.getContentPane().setBackground(background);

        JPanel navbar = new JPanel();
        Dimension dnavbar = new Dimension(175,400);
        Color cnavbar = new Color(143, 163, 179); //143, 163, 179
        navbar.setPreferredSize(dnavbar);
        navbar.setLayout(new GridLayout(7,1 , 10,12));
        navbar.setBackground(cnavbar);
        frame.add(navbar);

        //Servers button
        jbservers = new JButton("Servers");
        jbservers.setBackground(cnavbar);
        jbservers.setBorder(BorderFactory.createLineBorder(cnavbar));
        jbservers.addActionListener(this);
        jbservers.addMouseListener(this);
        navbar.add(jbservers);

        //Optimalisatie button
        jboptimalisatie = new JButton("Optimaliseren");
        jboptimalisatie.setBorder(BorderFactory.createLineBorder(cnavbar));
        jboptimalisatie.setBackground(cnavbar);
        jboptimalisatie.addActionListener(this);
        jboptimalisatie.addMouseListener(this);
        navbar.add(jboptimalisatie);

        //Ontwerpen button
        jbontwerpen = new JButton("Ontwerpen maken");
        jbontwerpen.setBackground(cnavbar);
        jbontwerpen.setBorder(BorderFactory.createLineBorder(cnavbar));
        jbontwerpen.addActionListener(this);
        jbontwerpen.addMouseListener(this);
        navbar.add(jbontwerpen);

        //Monitoring button
        jbmonitor = new JButton("Monitoring");
        jbmonitor.setBackground(cnavbar);
        jbmonitor.setBorder(BorderFactory.createLineBorder(cnavbar));
        jbmonitor.addActionListener(this);
        jbmonitor.addMouseListener(this);
        navbar.add(jbmonitor);

        ArrayList<String> lijst = new ArrayList<>();
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


        for (String data : lijst) {
            try {
                String[] server = data.split(",", 0);
                int prijs = Integer.parseInt(server[1]);
                double beschikbaarheid = Double.parseDouble(server[2]);
                int type = Integer.parseInt(server[3]);
                Server serverObject = new Server(server[0], prijs, beschikbaarheid, type);
                ServerList.voegServerToe(serverObject);
                serverArrayList.add(serverObject);
            }
            catch(IndexOutOfBoundsException ignore) {}
            catch(Exception e)
            {
                java.lang.System.exit(10);
            }
        }



        JPanel jpinfo = new JPanel();
        Dimension dinfo = new Dimension(411,400);
        jpinfo.setPreferredSize(dinfo);
        jpinfo.setBackground(background);
        jpinfo.setLayout(new FlowLayout(FlowLayout.CENTER));
        jpinfo.setBorder(BorderFactory.createLineBorder(background));
        frame.add(jpinfo);

        JPanel jpgrid = new JPanel();
        jpgrid.setLayout(new GridLayout(2,1));
        jpgrid.setBackground(background);
        jpinfo.add(jpgrid);

        JLabel jlheader = new JLabel("Nerdy Gadgets");
        jlheader.setForeground(new Color(255, 188, 50)); //255, 188, 50
        jlheader.setFont(new Font("Impact", Font.BOLD, 30 ));
        jpgrid.add(jlheader);

        JLabel jlinfo = new JLabel("Informatie over Nerdy Gadgets");
        jpgrid.add(jlinfo);

        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        //Als er op de optimalisatie button gedrukt wordt, dan wordt je naar de optimalisatie dialoog gestuurd. Zie OptimalisatieDialog.java
        if (e.getSource() == jboptimalisatie) {
            OptimalisatieDialog optimalisatiedialog = new OptimalisatieDialog(serverArrayList, doubleArrayList);
        }

        if (e.getSource() == jbontwerpen) {
            BekijkDialog bekijkDialog = new BekijkDialog(serverArrayList);
        }

        if(e.getSource() == jbservers){
            ServersBekijkenDialog serversBekijkenDialog = new ServersBekijkenDialog(serverArrayList);
        }
        if (e.getSource() == jbmonitor) {
            MonitorDialog monitorDialog = new MonitorDialog();
        }
    }

    public void mouseClicked(MouseEvent e) { }

    public void mousePressed(MouseEvent e) { }

    public void mouseReleased(MouseEvent e) { }

    public void mouseEntered(MouseEvent e) {
        if(e.getSource() == jbservers){
            jbservers.setBackground(new Color(230, 244, 255));
        }

        if(e.getSource() == jbmonitor){
            jbmonitor.setBackground(new Color(230, 244, 255));
        }

        if(e.getSource() == jboptimalisatie){
            jboptimalisatie.setBackground(new Color(230, 244, 255));
        }

        if(e.getSource() == jbontwerpen){
            jbontwerpen.setBackground(new Color(230, 244, 255));
        }
    }

    public void mouseExited(MouseEvent e) {
        if(e.getSource() == jbservers){
            jbservers.setBackground(new Color(143, 163, 179));
        }

        if(e.getSource() == jbmonitor){
            jbmonitor.setBackground(new Color(143, 163, 179));
        }

        if(e.getSource() == jboptimalisatie){
            jboptimalisatie.setBackground(new Color(143, 163, 179));
        }

        if(e.getSource() == jbontwerpen){
            jbontwerpen.setBackground(new Color(143, 163, 179));
        }
    }
}
