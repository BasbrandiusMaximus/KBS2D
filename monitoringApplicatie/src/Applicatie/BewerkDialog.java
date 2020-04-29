package Applicatie;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class BewerkDialog extends JDialog implements ActionListener {
    private JButton jbMaken;
    private ArrayList<Server> serverArrayList;
    private JButton jbOpenen;
    private JComboBox<String> comboBox;
    private JPanel[] ArrayComponent;
    private JButton jbBewerken;

    public BewerkDialog(ArrayList<Server> serverArrayList){
        this.serverArrayList = serverArrayList;
        JDialog dialog = new JDialog();
        dialog.setModal(true);
        dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        dialog.setSize(900,400);
        dialog.setTitle("Ontwerpen bekijken en bewerken");
        dialog.setLayout(new FlowLayout());

        comboBox = new JComboBox<>(); //Aanmaken comboBox voor alle ontwerpen

        String url = "monitoringApplicatie/src/Ontwerpen";
        File path = new File(url);
        File files = new File(path.getAbsolutePath()); //Maak dynamische url
        File directory= new File(String.valueOf(files));

        for (File file : directory.listFiles()){ //Krijg alle bestand namen uit de Ontwerpen package.
            comboBox.addItem(file.getName()); //Voeg ontwerpen toe aan de comboBox
        }

        dialog.add(comboBox);

        //Aanmaken JButton die bestaand ontwerp opent.
        jbOpenen = new JButton("Open ontwerp");
        jbOpenen.addActionListener(this);
        dialog.add(jbOpenen);

        //Aanmaken JButton die een bestaand ontwerp bewerkt.
        jbBewerken = new JButton("Ontwerp Bewerken");
        jbBewerken.addActionListener(this);
        dialog.add(jbBewerken);

        //Aanmaken JButton ontwerp die een OntwerpDialog aanmaakt.
        jbMaken = new JButton("Ontwerp maken");
        jbMaken.addActionListener(this); //Toevoegen actionListener
        dialog.add(jbMaken);

        //Aanmaken JPanel waar ontwerp in komt te staan.
        JPanel jpBekijk = new JPanel();
        Dimension test = new Dimension(800,300);
        jpBekijk.setPreferredSize(test);
        jpBekijk.setBorder(BorderFactory.createLineBorder(Color.black));
        dialog.add(jpBekijk);

        ArrayComponent = new JPanel[10];

        for(int i = 0; i < 10; i++) {
            JPanel component = new JPanel();
            component.setLayout(new GridLayout(2,1));
            JLabel icon = new JLabel(); //Maak JLabel voor icoon
            icon.setIcon(getImage("/server.png", 30, 30)); //Voeg icoon toe aan JLabel
            component.add(icon);
            JLabel naam = new JLabel(); //Maak JLabel met naam van server
            naam.setText("server");
            component.add(naam);
            component.setVisible(false);
            ArrayComponent[i] = component; //voeg component toe aan array
            jpBekijk.add(component);
        }

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
        if(e.getSource() == jbMaken) {
            OntwerpDialog ontwerpDialog = new OntwerpDialog(serverArrayList);
        }
        if(e.getSource() == jbOpenen){
            int teller = 0;
            for(JPanel c : ArrayComponent){ //Deze for loop is om de componenten in JPanel Bekijk te resetten als er meerdere ontwerpen na elkaar bekeken worden.
                JLabel lbl = (JLabel) c.getComponent(1);
                lbl.setText("server");
                c.setVisible(false);
            }
            String url = "";
            try {
                String x = Objects.requireNonNull(comboBox.getSelectedItem()).toString(); //Pak naam van het bestand dat geselecteerd is in de comboBox
                url += "monitoringApplicatie/src/Ontwerpen/" + x; //Maak url
            }
            catch(NullPointerException ne){
                System.out.println("Er zijn geen ontwerpen! Sla een ontwerp op om hem te bekijken.");
            }
            try { //Lees Ontwerp text file
                File path = new File(url);
                File file = new File(path.getAbsolutePath());
                Scanner myReader = new Scanner(file);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    JLabel lbl = (JLabel) ArrayComponent[teller].getComponent(1); //Voeg servers toe aan de Bekijk JPanel
                    lbl.setText(data);
                    ArrayComponent[teller].setVisible(true);
                    teller++;
                }

                myReader.close();
            }
            catch (FileNotFoundException ignored) {
            }
        }

        if(e.getSource() == jbBewerken){
            System.out.println("Work in progress!");
        }
    }
}
