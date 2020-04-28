package Applicatie;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class OntwerpDialog extends JDialog implements MouseListener{
    private JDialog dialog;
    private JPanel jpComponents;
    private JPanel jpOntwerp;
    private ArrayList<Server> serverArrayList;
    private int aantalServers = 10;
    private int index = 0;
    private JPanel[] ArrayComponent;
    private JLabel Ontwerpnaam;
//TODO: Layout mooier maken
    
    public OntwerpDialog(ArrayList<Server> serverArrayList){
        this.serverArrayList = serverArrayList;
        //Aanmaken ontwerp dialoog
        dialog = new JDialog();
        dialog.setModal(true);
        dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        dialog.setSize(900,400);
        dialog.setTitle("Ontwerp functie");
        dialog.setLayout(new BorderLayout());


        //Aanmaken JPanel voor de infrastructuurcomponenten
        jpComponents = new JPanel();
        jpComponents.setLayout(new FlowLayout());
        Dimension dimensionPanelComponents = new Dimension(200, 350);
        jpComponents.setPreferredSize(dimensionPanelComponents);
        jpComponents.setBorder(BorderFactory.createLineBorder(Color.black)); //setborder naar zwart

        Border borderC = jpComponents.getBorder();
        Border marginC = new EmptyBorder(10,30,5,10);
        jpComponents.setBorder(new CompoundBorder(marginC, borderC)); //add margin aan de JPanel
        dialog.add(jpComponents, BorderLayout.WEST); //set JPanel naar links (westen) van de JDialog

        //Voeg tekst toe aan componentselectie
        JLabel textComponenten = new JLabel("Componentselectie");
        jpComponents.add(textComponenten, BorderLayout.NORTH);

        JPanel jpcomponent = new JPanel();
        jpcomponent.setLayout(new GridLayout(5,2));

        //Voeg server naam en icoon toe aan commponentselectie
        for(Server servers : serverArrayList) {
            JPanel component = new JPanel();
            component.setLayout(new GridLayout(2,1));
            JLabel icon = new JLabel(); //Maak JLabel voor icoon
            icon.setIcon(getImage("/server.png", 30, 30)); //Voeg icoon toe aan JLabel
            component.add(icon);
            JLabel name = new JLabel(servers.getNaam()); //Maak JLabel met naam van server
            component.add(name);
            name.addMouseListener(this); //voeg mouselistener toe aan naam JLabel
            jpcomponent.add(component);
        }

        jpComponents.add(jpcomponent);

        //Aanmaken JPanel voor ontwerp
        jpOntwerp = new JPanel();
        jpOntwerp.setSize(400, 350);
        jpOntwerp.setBorder(BorderFactory.createLineBorder(Color.black)); //setborder naar zwart
        jpOntwerp.setLayout(new GridLayout(4,7));
        Border borderO = jpOntwerp.getBorder();
        Border marginO = new EmptyBorder(10,30,5,30);
        jpOntwerp.setBorder(new CompoundBorder(marginO, borderO)); //add margin aan de JPanel
        dialog.add(jpOntwerp, BorderLayout.CENTER); //set JPanel naar het midden (center) van de JDialog

        dialog.add(jpOntwerp);


        ArrayComponent = new JPanel[aantalServers];
        //Aanmaken JPanels voor servers die aan het ontwerp toe worden gevoegd. Ze staan eerst onzichtbaar omdat je anders de servers niet kan toevoegen
        //en zou je een andere dialog nodig hebben. Daarom staan ze eerst op setVisible(false) en worden ze op setVisible(true) gezet als er een server aan wordt
        //toegevoegd.
        for(int i = 0; i < aantalServers; i++) {
            JPanel component = new JPanel();
            component.setLayout(new GridLayout(2,1));
            JLabel icon = new JLabel(); //Maak JLabel voor icoon
            icon.setIcon(getImage("/server.png", 30, 30)); //Voeg icoon toe aan JLabel
            component.add(icon);
            Ontwerpnaam = new JLabel(); //Maak JLabel met naam van server
            Ontwerpnaam.setText("server");
            component.add(Ontwerpnaam);
            Ontwerpnaam.addMouseListener(this); //voeg mouselistener toe aan naam JLabel
            component.setVisible(false);
            ArrayComponent[i] = component; //voeg component toe aan array
            jpOntwerp.add(component);
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
    public void mouseClicked(MouseEvent e) {
        //Kijkt of er op de linker muis gedrukt is.
        if (SwingUtilities.isLeftMouseButton(e) && e.getClickCount() == 1) {
            JLabel label = (JLabel) e.getSource(); //JLabel waarop geklikt is. Dit is een servernaam.
                    for (JPanel componenten : ArrayComponent) {
                        JLabel lbl = (JLabel) componenten.getComponent(1); //JLabel in ontwerp JPanel bij default is dit 'server'
                        if (lbl.getText().equals("server")) { //Check of er een JLabel is in de lijst die 'server' heet.
                            lbl.setText(label.getText()); //Veranderd 'server' in de naam van de aangeklikte server.
                            componenten.setVisible(true); //Laat ontwerp component zien
                            break; //Zorgt ervoor dat de server maar 1 keer toegevoegd wordt.
                        }
                    }
        }

        //Kijkt of er op de rechter muis is gedrukt.
        if (SwingUtilities.isRightMouseButton(e) && e.getClickCount() == 1) {
            JLabel label = (JLabel) e.getSource(); //JLabel waarop geklikt is. Dit is een servernaam.
            for (int i = 0; i < ArrayComponent.length; i++) {
                if (ArrayComponent[i].getComponent(1) == label) { //Kijkt welke component in de array hetzelfde is als de label waarop geklikt is.
                    JLabel lbl = (JLabel) ArrayComponent[i].getComponent(1); //Haalt JLabel op van JPanel Component waarop met de rechtermuis is geklikt.
                    lbl.setText("server"); //Veranderd JLabel naar 'server'
                    ArrayComponent[i].setVisible(false); //Zet JPanel op invisble
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

