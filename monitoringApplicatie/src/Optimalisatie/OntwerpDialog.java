package Optimalisatie;

import javax.swing.*;
import java.awt.*;

public class OntwerpDialog extends JDialog{
    private JDialog dialog;

    public OntwerpDialog(){
        //Aanmaken ontwerp dialoog
        dialog = new JDialog();
        dialog.setModal(true);
        dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        dialog.setSize(600,400);
        dialog.setTitle("Ontwerp functie");
        dialog.setLayout(new FlowLayout());

        dialog.setVisible(true);
    }
}
