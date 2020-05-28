package Applicatie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.BigDecimal;
import java.util.ArrayList;

public class OptimalisatieDialog extends JDialog implements ActionListener, MouseListener {
    private JDialog dialog;
    private JTextField jtBeschikbaarheid;
    private JTextField jtAantalservers;
    private JLabel jlServersamenstelling;
    private JButton jbBereken;

    public OptimalisatieDialog(){
        //Aanmaken optimalisatie dialoog
        dialog = new JDialog();
        dialog.setModal(true);
        dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        dialog.setSize(600,400);
        dialog.setTitle("Optimalisatiefunctie");
        dialog.setLayout(new FlowLayout());
        Color background = new Color(230, 244, 255);
        Color cnavbar = new Color(143, 163, 179);
        dialog.getContentPane().setBackground(background);

        //Aanmaken JLabel tekst
        JLabel panel1 = new JLabel("<html><div>Voer hieronder een beschikbaarheidspercentage in om een optimale serversamenstelling te maken.</div></html>");
        Dimension d2 = new Dimension(500,30);
        panel1.setPreferredSize(d2);
        dialog.add(panel1);


        //Aanmaken JTextField om de beschikbaarheid in te voeren
        jtBeschikbaarheid = new JTextField();
        Dimension d = new Dimension(200,30);
        jtBeschikbaarheid.setPreferredSize(d);
        jtBeschikbaarheid.addMouseListener(this);
        jtBeschikbaarheid.setBorder(BorderFactory.createLineBorder(cnavbar));
        jtBeschikbaarheid.setBackground(cnavbar);
        dialog.add(jtBeschikbaarheid);

        //Aanmaken Button Bereken
        jbBereken = new JButton("Bereken");
        jbBereken.addActionListener(this);
        jbBereken.addMouseListener(this);
        jbBereken.setBackground(cnavbar);
        dialog.add(jbBereken);

        //Aanmaken JLabel voor antwoord
        jlServersamenstelling = new JLabel();
        dialog.add(jlServersamenstelling);

        dialog.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jbBereken){
            try
            {
                double original = Double.parseDouble(jtBeschikbaarheid.getText());
                original = original / 100;
                double bh = BigDecimal.valueOf(original).setScale(jtBeschikbaarheid.getText().length() + 1, java.math.RoundingMode.HALF_UP).doubleValue();
                if (bh > 0)
                {
                    jlServersamenstelling.setText(ServerList.serversUitrekenen(bh));
                }
                else
                {
                    jlServersamenstelling.setText("Een negatief getal of nul mag niet, vul A.U.B. andere waarden in.");
                }
            }
            catch (NumberFormatException | NullPointerException b)
            {
                // String printen hier
                jlServersamenstelling.setText("Een of meerdere velden bevatten een lege of onjuiste waarde.");
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == jbBereken){
            jbBereken.setBackground(new Color(230, 244, 255));
        }

        if(e.getSource() == jtBeschikbaarheid){
            jtBeschikbaarheid.setBackground(new Color(230,244,255));
        }

        if(e.getSource() == jtAantalservers){
            jtAantalservers.setBackground(new Color(230,244,255));
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
