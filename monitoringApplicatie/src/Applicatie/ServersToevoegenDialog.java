package Applicatie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class ServersToevoegenDialog implements ActionListener, MouseListener {
    private Boolean hasDisposed = false; //Zodat deze dialog, maar 1 keer gesloten word. Er was een bug dat deze dialog ook geopend werd als je op terug klikt naar de ApplicatieFrame. Dit is de oplossing hiervoor.
    private JDialog dialog;             //Een andere oplossing is om alle klasses te extenden met JDialog en dan de code dialog = new JDialog(); Te verwijderen en overal waar dialog staat te veranderen door this.
    private JButton jbOpslaan;
    private JButton jbbewerken;
    private JButton jbverwijderen;
    private JButton jbterug;
    private JLabel jlnaam;
    private JLabel jltype;
    private JLabel jlbeschikbaarheid;
    private JLabel jlprijs;
    private JLabel jlfoutmelding;
    private JLabel jlsucces;
    private JTextField jtnaam;
    private JTextField jttype;
    private JTextField jtbeschikbaarheid;
    private JTextField jtprijs;
    private JComboBox<String> serverNamen;
    private ArrayList<Server> serverArrayList;
    private Color background;
    private Color cnavbar;
    private Boolean bewerkenPressed = false;

    public ServersToevoegenDialog(ArrayList<Server> serverArrayList) {
        this.serverArrayList = serverArrayList;
        //Aanmaken dialog]
        dialog = new JDialog();
        dialog.setDefaultCloseOperation(dialog.DISPOSE_ON_CLOSE);
        dialog.setTitle("Serverlijst bewerken");
        dialog.setSize(600, 200);
        dialog.setLayout(new BorderLayout());
        background = new Color(230, 244, 255); //230, 244, 255
        cnavbar = new Color(143, 163, 179); //143, 163, 179
        dialog.getContentPane().setBackground(background);

        //Aanmaken JPanel buttons
        JPanel jpconf = new JPanel();
        jpconf.setBackground(background);
        dialog.add(jpconf, BorderLayout.NORTH);

        serverNamen = new JComboBox<>();
        serverNamen.setBackground(cnavbar);
        serverNamen.addItem("<Nieuw>");
        for (Server server : serverArrayList) {
            serverNamen.addItem(server.getNaam()); //Add servers to comboBox
        }

        jpconf.add(serverNamen);

        Dimension dbuttons = new Dimension(100,30);

        //Aanmaken button Bewerken
        jbbewerken = new JButton("Bewerken");
        jbbewerken.setBackground(cnavbar);
        jbbewerken.setBorder(BorderFactory.createLineBorder(cnavbar));
        jbbewerken.setPreferredSize(dbuttons);
        jbbewerken.addActionListener(this);
        jbbewerken.addMouseListener(this);
        jpconf.add(jbbewerken);

        //Aanmaken button Opslaan
        jbOpslaan = new JButton("Opslaan");
        jbOpslaan.setBackground(cnavbar);
        jbOpslaan.setPreferredSize(dbuttons);
        jbOpslaan.setBorder(BorderFactory.createLineBorder(cnavbar));
        jbOpslaan.addActionListener(this);
        jbOpslaan.addMouseListener(this);
        jpconf.add(jbOpslaan);

        //Aanmaken button Verwijderen
        jbverwijderen = new JButton("Verwijderen");
        jbverwijderen.setBackground(cnavbar);
        jbverwijderen.setPreferredSize(dbuttons);
        jbverwijderen.setBorder(BorderFactory.createLineBorder(cnavbar));
        jbverwijderen.addActionListener(this);
        jbverwijderen.addActionListener(this);
        jpconf.add(jbverwijderen);

        //Aanmaken button Terug
        jbterug = new JButton("Terug");
        jbterug.setBackground(cnavbar);
        jbterug.setPreferredSize(dbuttons);
        jbterug.setBorder(BorderFactory.createLineBorder(cnavbar));
        jbterug.addActionListener(this);
        jbterug.addActionListener(this);
        jpconf.add(jbterug);

        //JPanel voor input
        JPanel jpinput = new JPanel();
        jpinput.setBackground(background);
        dialog.add(jpinput, BorderLayout.CENTER);

        //JLabel Naam
        jlnaam = new JLabel("Naam:");
        jlnaam.setVisible(false);
        jpinput.add(jlnaam);

        //Input field Naam
        jtnaam = new JTextField();
        Dimension dnaam = new Dimension(110, 25);
        jtnaam.setPreferredSize(dnaam);
        jtnaam.setBackground(background);
        jtnaam.setBorder(BorderFactory.createLineBorder(cnavbar));
        jtnaam.setVisible(false);
        jpinput.add(jtnaam);

        Dimension dcijfer = new Dimension(50, 25);

        //JLabel Type
        jltype = new JLabel("Type:");
        jltype.setVisible(false);
        jpinput.add(jltype);

        //Input field Type
        jttype = new JTextField();
        jttype.setPreferredSize(dcijfer);
        jttype.setBackground(background);
        jttype.setBorder(BorderFactory.createLineBorder(cnavbar));
        jttype.setVisible(false);
        jpinput.add(jttype);

        //JLabel Beschikbaarheid
        jlbeschikbaarheid = new JLabel("Beschikbaarheidspercentage:");
        jlbeschikbaarheid.setVisible(false);
        jpinput.add(jlbeschikbaarheid);

        //Input field Beschikbaarheid
        jtbeschikbaarheid = new JTextField();
        jtbeschikbaarheid.setPreferredSize(dcijfer);
        jtbeschikbaarheid.setBackground(background);
        jtbeschikbaarheid.setBorder(BorderFactory.createLineBorder(cnavbar));
        jtbeschikbaarheid.setVisible(false);
        jpinput.add(jtbeschikbaarheid);

        //JLabel Prijs
        jlprijs = new JLabel("Prijs:");
        jlprijs.setVisible(false);
        jpinput.add(jlprijs);

        //Input field Prijs
        jtprijs = new JTextField();
        jtprijs.setPreferredSize(dcijfer);
        jtprijs.setBackground(background);
        jtprijs.setBorder(BorderFactory.createLineBorder(cnavbar));
        jtprijs.setVisible(false);
        jpinput.add(jtprijs);

        //JPanel foutmelding en succesmeling
        JPanel jpfout = new JPanel();
        jpfout.setBackground(background);
        dialog.add(jpfout, BorderLayout.SOUTH);

        //Foutmelding
        jlfoutmelding = new JLabel();
        jlfoutmelding.setVisible(false);
        jpfout.add(jlfoutmelding);

        //Succesmelding
        jlsucces = new JLabel();
        jlsucces.setVisible(false);
        jpfout.add(jlsucces);

        dialog.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jbterug && !hasDisposed){ //Openen nieuwe dialog
            hasDisposed = true;
            ServersBekijkenDialog serversBekijkenDialog = new ServersBekijkenDialog();
            dialog.dispose();
        }
        if (e.getSource() == jbbewerken) {
            String x = Objects.requireNonNull(serverNamen.getSelectedItem()).toString(); //Ophalen geselecteerde item in de comboBox
            changeVisibility(true);
            if(!(x.equals("<Nieuw>"))) { //Als een server wordt gekozen.
                for (Server server : serverArrayList) {
                    if (server.getNaam().equals(x)) { //Invullen van de waardes in de JTextFields
                        jtnaam.setText(server.getNaam());
                        jtprijs.setText(String.valueOf(server.getPrijs()));
                        double beschikbaarheid = server.getBeschikbaarheid() * 100;
                        jtbeschikbaarheid.setText(String.valueOf(beschikbaarheid));
                        jttype.setText(String.valueOf(server.getType()));
                    }
                }
            }
        }

        if (e.getSource() == jbOpslaan) {
            try {
                if (bewerkenPressed) { //Check of een server is bewerkt. Checkt niet of de waardes hetzelfde zijn gebleven.
                    //Input check, gooit een exception als de variabele niet omgezet kan worden en niet voldoet aan de voorwaarden.
                    jlfoutmelding.setText("");
                    jlfoutmelding.setVisible(false);
                    jlsucces.setVisible(false);
                    jlsucces.setText("");
                    String naam = jtnaam.getText();
                    int prijs = Integer.parseInt(jtprijs.getText());
                    Double beschikbaarheid = Double.parseDouble(jtbeschikbaarheid.getText());
                    int type = Integer.parseInt(jttype.getText());
                    if (!(prijs > 0)) { //check of de prijs groter is dan 0, zo niet throw exception
                        throw new NumberFormatException();
                    }
                    if (!(beschikbaarheid >= 1 && beschikbaarheid < 100)) { //check of de beschikbaarheid tussen 1 en 100 zit, zo niet throw exception
                        throw new NumberFormatException();
                    }
                    if (!(type == 0 || type == 1 || type == 2)) { //check of type 0,1 of 2 is, zo niet throw exception
                        throw new NumberFormatException();
                    }

                    beschikbaarheid = beschikbaarheid / 100;

                    String x = Objects.requireNonNull(serverNamen.getSelectedItem()).toString(); //Ophalen geselecteerde item in de comboBox
                    String url = "./Servers.txt"; //Maak url
                    try {
                        File path = new File(url);
                        File file = new File(path.getAbsolutePath()); //Maak dynamische url
                        FileWriter Writer = new FileWriter(file);
                        for (Server server : serverArrayList) { //Als een server is geselecteerd, voeg de informatie vanuit de JTextFields toe aan servers.txt
                            if (server.getNaam().equals(x)) {
                                Writer.write(naam + "," + prijs + "," + beschikbaarheid + "," + type + "\n");
                                jlsucces.setVisible(true);
                                jlsucces.setText("Server is succesvol bewerkt.");
                                jlfoutmelding.setVisible(false);
                                jlfoutmelding.setText("");
                            } else {
                                Writer.write(server.getNaam() + "," + server.getPrijs() + "," + server.getBeschikbaarheid() + "," + server.getType() + "\n");
                            }
                        }
                        if (x.equals("<Nieuw>")) { //Als een nieuwe server wordt toegevoegd, voeg hem dan pas toe nadat de al bestaande servers zijn toegevoegd aan servers.txt
                            Writer.write(naam + "," + prijs + "," + beschikbaarheid + "," + type);
                            jlsucces.setText("Server is succesvol toegevoegd");
                            jlsucces.setVisible(true);
                            jlfoutmelding.setVisible(false);
                            jlfoutmelding.setText("");
                        }
                        Writer.close();
                    } catch (IOException ioe) {
                        System.out.println("An error occurred.");
                        ioe.printStackTrace();//error handling
                    }
                }
                else{
                    jlfoutmelding.setText("Voordat u een bewerk kunt opslaan, moet u hem eerst bewerken.");
                    jlfoutmelding.setVisible(true);
                    jlsucces.setVisible(false);
                }
            }
            catch(NumberFormatException ne){
                jlfoutmelding.setText("Ongeldige invoer!");
                jlfoutmelding.setVisible(true);
                jlsucces.setVisible(false);
            }
            changeVisibility(false);
        }

        if (e.getSource() == jbverwijderen) {
            String x = Objects.requireNonNull(serverNamen.getSelectedItem()).toString(); //Ophalen geselecteerde item in de comboBox
            if(x.equals("<Nieuw>")){
                jlfoutmelding.setText("Selecteer een bestaande server om hem te kunnen verwijderen.");
                jlfoutmelding.setVisible(true);
            }
            else{
                jlfoutmelding.setVisible(false);
                jlsucces.setVisible(false);
                String url = "./Servers.txt"; //Maak url
                try {
                    File file = Server.getDynamicUrl(url);
                    FileWriter Writer = new FileWriter(file);
                    for (Server server : serverArrayList) {
                        if (server.getNaam().equals(x)) { //Verwijder alleen het geselecteerde ontwerp. Schrijf de rest van de servers wel.
                            jlsucces.setVisible(true);
                            jlsucces.setText("Server is succesvol verwijderd!");
                        } else {
                            Writer.write(server.getNaam() + "," + server.getPrijs() + "," + server.getBeschikbaarheid() + "," + server.getType() + "\n");
                        }
                    }
                    Writer.close();
                } catch (IOException ioe) {
                    System.out.println("An error occurred.");
                    ioe.printStackTrace();//error handling
                }
            }

        }
    }

    @Override
    public void mouseClicked(MouseEvent e) { }
    @Override
    public void mousePressed(MouseEvent e) { }
    @Override
    public void mouseReleased(MouseEvent e) { }

    @Override
    //Layout buttons
    public void mouseEntered(MouseEvent e) {
        if(e.getSource() == jbterug){
            jbterug.setBackground(background);
        }
        if(e.getSource() == jbverwijderen){
            jbverwijderen.setBackground(background);
        }
        if(e.getSource() == jbOpslaan){
            jbOpslaan.setBackground(background);
        }
        if(e.getSource() == jbbewerken){
            jbbewerken.setBackground(background);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() == jbterug){
            jbterug.setBackground(cnavbar);
        }
        if(e.getSource() == jbverwijderen){
            jbverwijderen.setBackground(cnavbar);
        }
        if(e.getSource() == jbOpslaan){
            jbOpslaan.setBackground(cnavbar);
        }
        if(e.getSource() == jbbewerken){
            jbbewerken.setBackground(cnavbar);
        }
    }

    public void changeVisibility(Boolean bool){
        bewerkenPressed = bool;
        jlnaam.setVisible(bool); // if true: 'Toevoegen' van JTextfields als een server is geselecteerd. Er is altijd of een Server of <Nieuw> geselecteerd in de comboBox dus een if-statement is niet nodig.
        jtnaam.setVisible(bool); // if false: 'Verwijderen' van JTextfields als een server is bewerkt of verwijderd.
        jltype.setVisible(bool);
        jttype.setVisible(bool);
        jlbeschikbaarheid.setVisible(bool);
        jtbeschikbaarheid.setVisible(bool);
        jlprijs.setVisible(bool);
        jtprijs.setVisible(bool);
        jlfoutmelding.setVisible(!bool);
        jlsucces.setVisible(!bool);
    }
}
