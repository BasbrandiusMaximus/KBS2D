package Applicatie;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class BewerkDialog extends JDialog implements ActionListener {
    private JButton jbMaken;
    private ArrayList<Server> serverArrayList;

    public BewerkDialog(ArrayList<Server> serverArrayList){
        this.serverArrayList = serverArrayList;
        JDialog dialog = new JDialog();
        dialog.setModal(true);
        dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        dialog.setSize(900,400);
        dialog.setTitle("Ontwerpen bekijken en bewerken");
        dialog.setLayout(new FlowLayout());

        File directory= new File("");
        for (File file : directory.listFiles())
        {
            System.out.println(file.getName());
        }

        jbMaken = new JButton("Ontwerp maken");
        jbMaken.addActionListener(this);
        dialog.add(jbMaken);

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
        OntwerpDialog ontwerpDialog = new OntwerpDialog(serverArrayList);
    }
}
