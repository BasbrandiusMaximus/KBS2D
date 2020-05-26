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
    private JFrame frame;
    private ArrayList<Server> serverArrayList;
    private JButton jboptimalisatie;
    private JButton jbontwerpen;
    private JButton jbservers;
    private JButton jbmonitor;
    private Color background;
    private Color cnavbar;

    public ApplicatieFrame() {
        //Aanmaken applicatie frame
        frame = new JFrame();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setTitle("Nerdy Gadgets");
        frame.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        background = new Color(230, 244, 255); //230, 244, 255
        frame.getContentPane().setBackground(background);

        //JPanel navigatie bar
        JPanel navbar = new JPanel();
        Dimension dnavbar = new Dimension(175,400);
        cnavbar = new Color(143, 163, 179); //143, 163, 179
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

        serverArrayList = Server.serversOphalen(); //Ophalen van servers uit servers.txt

        //Info JPanel
        JPanel jpinfo = new JPanel();
        Dimension dinfo = new Dimension(411,400);
        jpinfo.setPreferredSize(dinfo);
        jpinfo.setBackground(background);
        jpinfo.setLayout(new FlowLayout(FlowLayout.CENTER));
        jpinfo.setBorder(BorderFactory.createLineBorder(background));
        frame.add(jpinfo);

        //JPanel om de header van de tekst en de tekst zelf onder elkaar te krijgen
        JPanel jpgrid = new JPanel();
        jpgrid.setLayout(new GridLayout(2,1));
        jpgrid.setBackground(background);
        jpinfo.add(jpgrid);

        //JPanel tekst header
        JLabel jlheader = new JLabel("Nerdy Gadgets");
        jlheader.setForeground(new Color(255, 188, 50)); //255, 188, 50
        jlheader.setFont(new Font("Impact", Font.BOLD, 30 ));
        jpgrid.add(jlheader);

        //JPanel tekst voor info
        JLabel jlinfo = new JLabel("Informatie over Nerdy Gadgets");
        jpgrid.add(jlinfo);

        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        //Openen van de respectievelijke dialogs
        if (e.getSource() == jboptimalisatie) {
            OptimalisatieDialog optimalisatiedialog = new OptimalisatieDialog();
        }

        if (e.getSource() == jbontwerpen) {
            BekijkDialog bekijkDialog = new BekijkDialog();
            frame.dispose();
        }

        if(e.getSource() == jbservers){
            ServersBekijkenDialog serversBekijkenDialog = new ServersBekijkenDialog();
            frame.dispose();
        }

        if (e.getSource() == jbmonitor) {
            MonitorDialog monitorDialog = new MonitorDialog();
        }
    }

    //MouseListeners zorgen ervoor dat de button van kleur veranderd als je met je cursor erin of erin gaat.

    public void mouseClicked(MouseEvent e) { }

    public void mousePressed(MouseEvent e) { }

    public void mouseReleased(MouseEvent e) { }

    public void mouseEntered(MouseEvent e) {
        if(e.getSource() == jbservers){
            jbservers.setBackground(background);
        }

        if(e.getSource() == jbmonitor){
            jbmonitor.setBackground(background);
        }

        if(e.getSource() == jboptimalisatie){
            jboptimalisatie.setBackground(background);
        }

        if(e.getSource() == jbontwerpen){
            jbontwerpen.setBackground(background);
        }
    }

    public void mouseExited(MouseEvent e) {
        if(e.getSource() == jbservers){
            jbservers.setBackground(cnavbar);
        }

        if(e.getSource() == jbmonitor){
            jbmonitor.setBackground(cnavbar);
        }

        if(e.getSource() == jboptimalisatie){
            jboptimalisatie.setBackground(cnavbar);
        }

        if(e.getSource() == jbontwerpen){
            jbontwerpen.setBackground(cnavbar);
        }
    }
}
