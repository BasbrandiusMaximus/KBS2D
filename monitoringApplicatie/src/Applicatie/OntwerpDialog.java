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
import java.util.ArrayList;

public class OntwerpDialog extends JDialog implements MouseListener{
    private JDialog dialog;
    private JPanel jpComponents;
    private JPanel jpOntwerp;
    private JLabel test;
    private ArrayList<Server> serverArrayList;

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
        jpOntwerp.setLayout(new GridLayout(2,5));
        Border borderO = jpOntwerp.getBorder();
        Border marginO = new EmptyBorder(10,30,5,30);
        jpOntwerp.setBorder(new CompoundBorder(marginO, borderO)); //add margin aan de JPanel
        dialog.add(jpOntwerp, BorderLayout.CENTER); //set JPanel naar het midden (center) van de JDialog

        test = new JLabel("test");
        test.setVisible(false);
        jpOntwerp.add(test);

        dialog.add(jpOntwerp);


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
        JLabel label = (JLabel) e.getSource();
        System.out.println(label.getText());
        for(Server server : serverArrayList){
            if(server.getNaam().equals(label.getText())){
                test.setText(server.getNaam());
                test.setVisible(true);
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

