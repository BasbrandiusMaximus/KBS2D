package Applicatie;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;

public class OntwerpDialog extends JDialog{
    private JDialog dialog;
    private JPanel jpComponents;
    private JPanel jpOntwerp;

    public OntwerpDialog(ArrayList<Server> serverArrayList) {
        //Aanmaken ontwerp dialoog
        dialog = new JDialog();
        dialog.setModal(true);
        dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        dialog.setSize(900,400);
        dialog.setTitle("Ontwerp functie");
        dialog.setLayout(new BorderLayout());

        //Aanmaken JPanel voor de infrastructuurcomponenten
        jpComponents = new JPanel();
        jpComponents.setLayout(new GridLayout(8, 2));
        Dimension dimensionPanelComponents = new Dimension(200, 350);
        jpComponents.setPreferredSize(dimensionPanelComponents);
        jpComponents.setBorder(BorderFactory.createLineBorder(Color.black)); //setborder naar zwart

        Border borderC = jpComponents.getBorder();
        Border marginC = new EmptyBorder(10,30,5,10);
        jpComponents.setBorder(new CompoundBorder(marginC, borderC)); //add margin aan de JPanel
        dialog.add(jpComponents, BorderLayout.WEST); //set JPanel naar links (westen) van de JDialog

        //Voeg tekst toe aan componentselectie (panelcomponents)
        JLabel textComponenten = new JLabel("Componentselectie");
        jpComponents.add(textComponenten, BorderLayout.NORTH);


        //Voeg server icoon en server naam toe aan commponentselectie (panelcomponents)
        for(Server servers : serverArrayList) {
            JPanel panelComponent = new JPanel();
            panelComponent.setLayout(new GridLayout(2, 1));
            panelComponent.setSize(70, 70);
            getImage("/server.png", panelComponent, 25, 30);
            JLabel componentNaam = new JLabel(servers.getNaam());
            panelComponent.add(componentNaam);
            jpComponents.add(panelComponent);
        }

        //Aanmaken JPanel voor ontwerp
        jpOntwerp = new JPanel();
        jpOntwerp.setSize(400, 350);
        jpOntwerp.setBorder(BorderFactory.createLineBorder(Color.black)); //setborder naar zwart

        Border borderO = jpOntwerp.getBorder();
        Border marginO = new EmptyBorder(10,30,5,30);
        jpOntwerp.setBorder(new CompoundBorder(marginO, borderO)); //add margin aan de JPanel
        dialog.add(jpOntwerp, BorderLayout.CENTER); //set JPanel naar het midden (center) van de JDialog
        dialog.add(jpOntwerp);

        dialog.setVisible(true);
    }

    //Methode om image op te vragen, het te veranderen in een icoon en toe te voegen aan een JPanel
    public void getImage(String url, JPanel jp, int width, int height){
        try {
            Image image = ImageIO.read(getClass().getResource(url));
            image = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
            ImageIcon ImageIcon = new ImageIcon(image);
            JLabel jlicon = new JLabel();
            jlicon.setIcon(ImageIcon);
            jp.add(jlicon);
        }
        catch(IOException ie){
            ie.getMessage();
        }
    }
}

