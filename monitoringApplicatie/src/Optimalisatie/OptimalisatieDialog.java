package Optimalisatie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OptimalisatieDialog extends JDialog implements ActionListener {
    private JDialog dialog;
    private JTextField jtBeschikbaarheid;
    private JLabel jlServersamenstelling;
    private JButton jbBereken;

    public OptimalisatieDialog(){
        dialog = new JDialog();
        dialog.setModal(true);
        dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        dialog.setSize(600,400);
        dialog.setTitle("Optimalisatiefunctie");
        dialog.setLayout(new FlowLayout());

        JLabel panel1 = new JLabel("Voer hieronder het beschikbaarheidspercentage in om een server samenstelling te maken.");
        dialog.add(panel1);

        jtBeschikbaarheid = new JTextField();
        Dimension d = new Dimension(200,30);
        jtBeschikbaarheid.setPreferredSize(d);
        dialog.add(jtBeschikbaarheid);

        jbBereken = new JButton("Bereken");
        dialog.add(jbBereken);

        jlServersamenstelling = new JLabel("Hier komt de server samenstelling te staan");
        dialog.add(jlServersamenstelling);

        dialog.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

    }
}
