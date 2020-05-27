package Applicatie;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class BekijkDialog extends JDialog implements ActionListener, MouseListener {
    private JDialog dialog;
    private JButton jbMaken;
    private JButton jbTerug;
    private JButton jbOpenen;
    private JComboBox<String> comboBox;
    private JPanel[] arrayComponent;
    private JButton jbBewerken;
    private JLabel jlbeschikbaarheid;
    private JLabel jlprijs;
    private JLabel jlfoutmelding;
    private Color background;
    private Color cnavbar;

    public BekijkDialog(){
        dialog = new JDialog();
        dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        dialog.setSize(900,250);
        dialog.setTitle("Ontwerpen bekijken en bewerken");
        dialog.setLayout(new FlowLayout());
        background = new Color(230, 244, 255);
        cnavbar = new Color(143, 163, 179);

        dialog.getContentPane().setBackground(background);
        comboBox = new JComboBox<>(); //Aanmaken comboBox voor alle ontwerpen
        comboBox.setBackground(cnavbar);

        String url = "monitoringApplicatie/src/Ontwerpen";
        File directory= new File(String.valueOf(Server.getDynamicUrl(url)));

        for (File file : directory.listFiles()){ //Krijg alle bestand namen uit de Ontwerpen package.
            comboBox.addItem(file.getName()); //Voeg ontwerpen toe aan de comboBox
        }

        dialog.add(comboBox);

        Dimension dbuttons = new Dimension(100,30);
        //Aanmaken JButton die bestaand ontwerp opent.
        jbOpenen = new JButton("Open ontwerp");
        jbOpenen.addActionListener(this);
        jbOpenen.addMouseListener(this);
        jbOpenen.setBackground(cnavbar);
        jbOpenen.setBorder(BorderFactory.createLineBorder(cnavbar));
        Dimension d3 = new Dimension(120,30);
        jbOpenen.setPreferredSize(d3);
        dialog.add(jbOpenen);

        //Aanmaken JButton die een bestaand ontwerp bewerkt.
        jbBewerken = new JButton("Ontwerp Bewerken");
        jbBewerken.addActionListener(this);
        jbBewerken.addMouseListener(this);
        jbBewerken.setBackground(cnavbar);
        Dimension d = new Dimension(150,30);
        jbBewerken.setPreferredSize(d);
        dialog.add(jbBewerken);

        //Aanmaken JButton ontwerp die een OntwerpDialog aanmaakt.
        jbMaken = new JButton("Ontwerp maken");
        jbMaken.addActionListener(this); //Toevoegen actionListener
        jbMaken.addMouseListener(this);
        jbMaken.setBackground(cnavbar);
        Dimension d1 = new Dimension(130,30);
        jbMaken.setPreferredSize(d1);
        dialog.add(jbMaken);

        //Aanmaken JButton die een ApplicatieFrame aanmaakt.
        jbTerug = new JButton("Terug");
        jbTerug.setBackground(cnavbar);
        jbTerug.setBorder(BorderFactory.createLineBorder(cnavbar));
        jbTerug.addActionListener(this);
        jbTerug.addMouseListener(this);
        jbTerug.setPreferredSize(dbuttons);
        dialog.add(jbTerug);

        //Aanmaken JPanel waar ontwerp in komt te staan.
        JPanel jpBekijk = new JPanel();
        Dimension test = new Dimension(800,150);
        jpBekijk.setPreferredSize(test);
        jpBekijk.setBackground(background);
        jpBekijk.setBorder(BorderFactory.createLineBorder(cnavbar));
        dialog.add(jpBekijk);

        arrayComponent = new JPanel[10];

        //Voeg 'lege' componenten toe aan JPanel
        for(int i = 0; i < 10; i++) {
            JPanel component = new JPanel();
            component.setLayout(new GridLayout(2,1));
            JLabel icon = new JLabel(); //Maak JLabel voor icoon
            icon.setIcon(getImage("/server.png", 30, 30)); //Voeg icoon toe aan JLabel
            icon.setHorizontalAlignment(JLabel.CENTER);
            component.add(icon);
            JLabel naam = new JLabel(); //Maak JLabel met naam van server
            naam.setText("server");
            naam.setHorizontalAlignment(JLabel.CENTER);
            component.add(naam);
            component.setBorder(new EmptyBorder(5,5,5,5));
            component.setVisible(false);
            component.setBackground(background);
            arrayComponent[i] = component; //voeg component toe aan array
            jpBekijk.add(component);
        }

        //JLabel voor beschikbaarheid
        jlbeschikbaarheid = new JLabel("");
        dialog.add(jlbeschikbaarheid);
        jlprijs = new JLabel("");
        dialog.add(jlprijs);

        //JLabel voor foutmelding
        jlfoutmelding = new JLabel("");
        jlfoutmelding.setVisible(false);
        dialog.add(jlfoutmelding);

        dialog.setVisible(true);
    }

    //Methode om image op te vragen, het te veranderen in een icoon en toe te voegen aan een JPanel
    public ImageIcon getImage(String url, int width, int height) {
        try {
            Image image = ImageIO.read(getClass().getResource(url));
            image = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
            return new ImageIcon(image);
        } catch (IOException ie) {
            ie.getMessage();
            return null;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jbTerug){
            ApplicatieFrame frame = new ApplicatieFrame();
            dialog.dispose();
        }
        if(e.getSource() == jbMaken) {
            OntwerpDialog ontwerpDialog = new OntwerpDialog("Geen");
        }
        if(e.getSource() == jbOpenen){
            int teller = 0;
            for(JPanel c : arrayComponent){ //Deze for loop is om de componenten in JPanel Bekijk te resetten als er meerdere ontwerpen na elkaar bekeken worden.
                JLabel lbl = (JLabel) c.getComponent(1);
                lbl.setText("server");
                c.setVisible(false);
            }

           String url = "";
            try {
                String x = Objects.requireNonNull(comboBox.getSelectedItem()).toString(); //Pak naam van het bestand dat geselecteerd is in de comboBox
                url += "monitoringApplicatie/src/Ontwerpen/" + x; //Maak url
                jlfoutmelding.setText("");
                jlfoutmelding.setVisible(false);
            }
            catch(NullPointerException ne){
                jlfoutmelding.setText("Er zijn geen ontwerpen! Sla een ontwerp op om hem te bekijken.");
                jlfoutmelding.setVisible(true);
            }

            try { //Lees Ontwerp text file
                File file = Server.getDynamicUrl(url);
                Scanner myReader = new Scanner(file);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    if(data.startsWith("Beschikbaarheid")){
                        jlbeschikbaarheid.setText(data);
                    }
                    else if(data.startsWith("Prijs")){
                        jlprijs.setText(data);
                    }
                    else{
                    JLabel lbl = (JLabel) arrayComponent[teller].getComponent(1); //Voeg servers toe aan de Bekijk JPanel
                    lbl.setText(data);
                    arrayComponent[teller].setVisible(true);
                    teller++;
                    }
                }

                myReader.close();
            }
            catch (FileNotFoundException ignored) {
            }
        }

        if(e.getSource() == jbBewerken){
            try {
                String x = Objects.requireNonNull(comboBox.getSelectedItem()).toString(); //Pak naam van het bestand dat geselecteerd is in de comboBox
                OntwerpDialog ontwerpDialog = new OntwerpDialog(x);
                jlfoutmelding.setText("");
                jlfoutmelding.setVisible(false);
            }

            catch(NullPointerException ne){
                jlfoutmelding.setText("Er zijn geen ontwerpen! Sla een ontwerp op om hem te bekijken.");
                jlfoutmelding.setVisible(true);
            }
        }
    }

    //Layout knoppen. Ze veranderen van kleur als je met de cursor in en uit de button gaat.
    @Override
    public void mousePressed(MouseEvent e) { }

    @Override
    public void mouseReleased(MouseEvent e) { }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource() == jbBewerken){
            jbBewerken.setBackground(background);
            jbBewerken.setBorder(BorderFactory.createLineBorder(background));
        }

        if(e.getSource() == jbMaken){
            jbMaken.setBackground(background);
            jbMaken.setBorder(BorderFactory.createLineBorder(background));
        }

        if(e.getSource() == jbOpenen){
            jbOpenen.setBackground(background);
            jbOpenen.setBorder(BorderFactory.createLineBorder(background));
        }
        if(e.getSource() == jbTerug){
            jbTerug.setBackground(background);
            jbTerug.setBorder(BorderFactory.createLineBorder(background));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() == jbBewerken){
            jbBewerken.setBackground(cnavbar);
            jbBewerken.setBorder(BorderFactory.createLineBorder(cnavbar));
        }

        if(e.getSource() == jbMaken){
            jbMaken.setBackground(cnavbar);
            jbMaken.setBorder(BorderFactory.createLineBorder(cnavbar));
        }

        if(e.getSource() == jbOpenen){
            jbOpenen.setBackground(cnavbar);
            jbOpenen.setBorder(BorderFactory.createLineBorder(cnavbar));
        }
        if(e.getSource() == jbTerug){
            jbTerug.setBackground(cnavbar);
            jbTerug.setBorder(BorderFactory.createLineBorder(cnavbar));
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) { }
}
