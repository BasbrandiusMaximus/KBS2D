package Applicatie;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class OntwerpDialog extends JDialog implements ActionListener, MouseListener {
    private static ArrayList<Server> serverArrayList;
    private JPanel[] arrayComponent;
    private JButton jbopslaan;
    private ArrayList<String> stringArrayList;
    private String ontwerpSelected;
    private JLabel jlbeschikbaarheid;
    private JLabel jlprijs;
    private JLabel jlfoutmelding;
    private JLabel jlsucces;
    private JDialog dialog;

    public OntwerpDialog(String ontwerpSelected){
        this.ontwerpSelected = ontwerpSelected;
        //Aanmaken ontwerp dialoog
        dialog = new JDialog();
        dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        dialog.setSize(800,500);
        dialog.setTitle("Ontwerp maken");
        dialog.setLayout(new FlowLayout());
        Color background = new Color(230, 244, 255);
        Color cnavbar = new Color(143, 163, 179);
        dialog.getContentPane().setBackground(background);

        //Aanmaken JPanel voor de infrastructuurcomponenten
        JPanel jpComponents = new JPanel();
        jpComponents.setLayout(new FlowLayout());
        Dimension dimensionPanelComponents = new Dimension(200, 400);
        jpComponents.setPreferredSize(dimensionPanelComponents);
        jpComponents.setBackground(background);
        jpComponents.setBorder(BorderFactory.createLineBorder(cnavbar)); //setborder naar zwart

        Border borderC = jpComponents.getBorder();
        Border marginC = new EmptyBorder(10,10,5,10);
        jpComponents.setBorder(new CompoundBorder(marginC, borderC)); //add margin aan de JPanel
        dialog.add(jpComponents);

        //JLabel Header componentselectie
        JLabel textComponenten = new JLabel("Componentselectie");
        textComponenten.setBackground(background);
        jpComponents.add(textComponenten, BorderLayout.NORTH);

        //JPanel componenten
        JPanel jpcomponent = new JPanel();
        jpcomponent.setLayout(new GridLayout(5,2));
        jpcomponent.setBackground(background);

        //Voeg server naam en icoon toe aan commponentselectie
        serverArrayList = Server.serversOphalen();
        for (Server serverObject : serverArrayList) {
            JPanel component = new JPanel();
            component.setBorder(new EmptyBorder(10,10,0,10));
            component.setLayout(new GridLayout(2, 1));
            JLabel icon = new JLabel(); //Maak JLabel voor icoon
            icon.setIcon(getImage("/server.png", 30, 30)); //Voeg icoon toe aan JLabel
            icon.setHorizontalAlignment(JLabel.CENTER);
            component.add(icon);
            JLabel name = new JLabel(serverObject.getNaam()); //Maak JLabel met naam van server
            name.setHorizontalAlignment(JLabel.CENTER);
            component.add(name);
            component.setBackground(background);
            name.addMouseListener(this); //voeg mouselistener toe aan naam JLabel
            jpcomponent.add(component);
        }

        jpComponents.add(jpcomponent);

        //Aanmaken JPanel voor ontwerp
        JPanel jpOntwerp = new JPanel();
        Dimension d = new Dimension(320,400);
        jpOntwerp.setPreferredSize(d);
        jpOntwerp.setBackground(background);
        jpOntwerp.setBorder(BorderFactory.createLineBorder(cnavbar)); //setborder naar zwart
        jpOntwerp.setLayout(new GridLayout(4,7));
        Border borderO = jpOntwerp.getBorder();
        Border marginO = new EmptyBorder(10,30,5,30);
        jpOntwerp.setBorder(new CompoundBorder(marginO, borderO)); //add margin aan de JPanel
        dialog.add(jpOntwerp);

        dialog.add(jpOntwerp);

        int aantalServers = 10; //max aantal servers. Dit is 10 omdat de optimalisatiefunctie max opstellingen met 10 servers kan uitrekenen ivm memory issues. Meerdere is mogelijk, maar het apparaat heeft dan signifanct veel meer memory opslag nodig.
        arrayComponent = new JPanel[aantalServers];
        //Aanmaken JPanels voor servers die aan het ontwerp toe worden gevoegd. Ze staan eerst onzichtbaar omdat je anders de servers niet kan toevoegen
        //en zou je een andere dialog nodig hebben. Daarom staan ze eerst op setVisible(false) en worden ze op setVisible(true) gezet als er een server aan wordt
        //toegevoegd.
        for (int i = 0; i < aantalServers; i++) {
            JPanel component = new JPanel();
            component.setLayout(new GridLayout(2, 1));
            component.setBorder(new EmptyBorder(10,10,0,10));//top,left,bottom,right
            JLabel icon = new JLabel(); //Maak JLabel voor icoon
            icon.setIcon(getImage("/server.png", 30, 30)); //Voeg icoon toe aan JLabel
            icon.setHorizontalAlignment(JLabel.CENTER);
            component.add(icon);
            JLabel Ontwerpnaam = new JLabel(); //Maak JLabel met naam van server
            Ontwerpnaam.setText("server");
            Ontwerpnaam.setHorizontalAlignment(JLabel.CENTER);
            component.add(Ontwerpnaam);
            Ontwerpnaam.addMouseListener(this); //voeg mouselistener toe aan naam JLabel
            component.setVisible(false);
            component.setBackground(background);
            arrayComponent[i] = component; //voeg component toe aan array
            jpOntwerp.add(component);
        }

        jlbeschikbaarheid = new JLabel("");
        jlbeschikbaarheid.setVisible(false);
        jlprijs = new JLabel("");
        jlprijs.setVisible(false);
        stringArrayList = new ArrayList<>();
        if(!(ontwerpSelected.equals("Geen"))){//Als de bewerken button is ingedrukt dan krijg je een Panel te zien met alle servers uit het ontwerp.
            int teller = 0;
            try { //Lees Ontwerp text file
                File file = Server.getDynamicUrl("monitoringApplicatie/src/Ontwerpen/" + ontwerpSelected);
                Scanner myReader = new Scanner(file);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    if(data.startsWith("Beschikbaarheid")){
                        jlbeschikbaarheid.setText(data);
                        jlbeschikbaarheid.setVisible(true);
                    }
                    else if(data.startsWith("Prijs")){
                        jlprijs.setText(data);
                        jlprijs.setVisible(true);
                    }
                    else {
                        JLabel lbl = (JLabel) arrayComponent[teller].getComponent(1); //Voeg servers toe aan de Bekijk JPanel
                        lbl.setText(data);
                        stringArrayList.add(data);
                        arrayComponent[teller].setVisible(true);
                        teller++;
                    }
                }

                myReader.close();
            }
            catch (FileNotFoundException ignored) {
            }
        }

        //JPanel knoppen
        JPanel jpKnoppen = new JPanel();
        jpKnoppen.setLayout(new BorderLayout());
        jpKnoppen.setBackground(background);
        Dimension dpanel = new Dimension(175,100);
        jpKnoppen.setPreferredSize(dpanel);
        dialog.add(jpKnoppen);

        //Opslaan button
        jbopslaan = new JButton("Opslaan");
        jbopslaan.addActionListener(this);

        Dimension dd = new Dimension(100,30);
        jbopslaan.setPreferredSize(dd);
        jbopslaan.setBackground(cnavbar);

        jpKnoppen.add(jbopslaan, BorderLayout.SOUTH);
        jbopslaan.setBorder(new EmptyBorder(5,0,5,0));//top,left,bottom,right
        jpKnoppen.add(jlbeschikbaarheid, BorderLayout.NORTH);
        jlbeschikbaarheid.setBorder(new EmptyBorder(5,0,5,0));//top,left,bottom,right
        jpKnoppen.add(jlprijs, BorderLayout.CENTER);
        jlprijs.setBorder(new EmptyBorder(5,0,5,0));//top,left,bottom,right

        jlfoutmelding = new JLabel("");
        jlfoutmelding.setVisible(false);
        dialog.add(jlfoutmelding);

        jlsucces = new JLabel("");
        jlsucces.setVisible(false);
        dialog.add(jlsucces);

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
            // label = (JLabel) e.getComponent();
            for (JPanel componenten : arrayComponent) {
                JLabel lbl = (JLabel) componenten.getComponent(1); //JLabel in ontwerp JPanel bij default is dit 'server'
                if (lbl.getText().equals("server")) { //Check of er een JLabel is in de lijst die 'server' heet.
                    lbl.setText(label.getText()); //Veranderd 'server' in de naam van de aangeklikte server.
                    componenten.setVisible(true); //Laat ontwerp component zien
                    stringArrayList.add(lbl.getText());
                    if(stringArrayList.isEmpty()){
                        jlbeschikbaarheid.setText("");
                        jlbeschikbaarheid.setVisible(false);
                        jlprijs.setText("");
                        jlprijs.setVisible(false);
                    }
                    if(stringArrayList.size() != 0) {
                        int teller = 0;
                        Server[] berekenen = new Server[10];
                        for(String namen : stringArrayList){
                            for(Server serverObject : serverArrayList){
                                if(serverObject.getNaam().equals(namen)){
                                    berekenen[teller] = serverObject;
                                    teller++;
                                }
                            }
                        }

                        List<Object> benp = Server.berekenBeschikbaarheid(berekenen);
                        if (this.isValid(stringArrayList)) { //Als het ontwerp valide is dan laat hij het beschikbaarheidspercentage en de prijs zien.
                            jlbeschikbaarheid.setText("Beschikbaarheid: " + benp.get(0) + "%");
                            jlbeschikbaarheid.setVisible(true);
                            jlprijs.setText("Prijs: " + benp.get(1) + " euro");
                            jlprijs.setVisible(true);
                        }
                        else{
                            jlbeschikbaarheid.setText("Beschikbaarheid: 0%");
                            jlbeschikbaarheid.setVisible(true);
                            jlprijs.setText("Prijs: " + benp.get(1) + " euro");
                            jlprijs.setVisible(true);
                        }
                    }
                    break; //Zorgt ervoor dat de server maar 1 keer toegevoegd wordt.
                }
            }
        }

        //Kijkt of er op de rechter muis is gedrukt.
        if (SwingUtilities.isRightMouseButton(e) && e.getClickCount() == 1) {
            JLabel label = (JLabel) e.getSource(); //JLabel waarop geklikt is. Dit is een servernaam.
            //JLabel label = (JLabel) e.getComponent();
            for (int i = 0; i < arrayComponent.length; i++) { //for loop kan !niet! vervangen worden door een foreach omdat je de int i nodig hebt in de loop.
                if (arrayComponent[i].getComponent(1) == label) { //Kijkt welke component in de array hetzelfde is als de label waarop geklikt is.
                    JLabel lbl = (JLabel) arrayComponent[i].getComponent(1); //Haalt JLabel op van JPanel Component waarop met de rechtermuis is geklikt.
                    stringArrayList.remove(lbl.getText());
                    lbl.setText("server"); //Veranderd JLabel naar 'server'
                    arrayComponent[i].setVisible(false); //Zet JPanel op invisble

                    int teller = 0;
                    Server[] berekenen = new Server[10];
                    for(String namen : stringArrayList){
                        for(Server servers : serverArrayList){
                            if(servers.getNaam().equals(namen)){
                                berekenen[teller] = servers;
                                teller++;
                            }
                        }
                    }

                    List<Object> benp = Server.berekenBeschikbaarheid(berekenen);
                    if(benp.get(0).equals(1.0) && benp.get(1).equals(0)){
                        jlprijs.setText("");
                        jlbeschikbaarheid.setText("");
                        jlprijs.setVisible(false);
                        jlbeschikbaarheid.setVisible(false);
                    }
                    else if(this.isValid(stringArrayList)){
                        jlbeschikbaarheid.setText("Beschikbaarheid: " + benp.get(0) + "%");
                        jlbeschikbaarheid.setVisible(true);
                        jlprijs.setText("Prijs: " + benp.get(1) + " euro");
                        jlprijs.setVisible(true);
                    }
                    else{
                        jlbeschikbaarheid.setText("Beschikbaarheid: 0%");
                        jlbeschikbaarheid.setVisible(true);
                        jlprijs.setText("Prijs: " + benp.get(1) + " euro");
                        jlprijs.setVisible(true);
                    }
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) { }
    @Override
    public void mouseReleased(MouseEvent e) { }
    @Override
    public void mouseEntered(MouseEvent e) { }
    @Override
    public void mouseExited(MouseEvent e) { }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jbopslaan) { //Als op de Opslaan button is gedrukt
            if (stringArrayList.size() == 0) {
                jlfoutmelding.setVisible(true);
                jlfoutmelding.setText("Het ontwerp is leeg, voeg een component toe aan het ontwerp om hem op te kunnen slaan.");
            } else if (!(ontwerpSelected.equals("Geen"))) { //Als er een ontwerp geselecteerd is.
                if (this.isValid(stringArrayList)) { //checkt of ontwerp valid is.
                    jlfoutmelding.setText("");
                    jlfoutmelding.setVisible(false);
                    jlsucces.setText("");
                    jlsucces.setVisible(false);
                    String url = "monitoringApplicatie/src/Ontwerpen/";
                    url += ontwerpSelected;

                    StringBuilder text = new StringBuilder();
                    for (String strings : stringArrayList) { //Maakt een string met alle servers om in het Ontwerp[nummer].txt bestand te duwen
                        text.append(strings).append("\n");
                    }

                    text.append(jlbeschikbaarheid.getText()).append("\n");
                    text.append(jlprijs.getText());

                    try {
                        File path = new File(url);
                        File file = new File(path.getAbsolutePath()); //Maak dynamische url
                        FileWriter Writer = new FileWriter(file);
                        Writer.write(text.toString());
                        Writer.close();
                        for (JPanel component : arrayComponent) { //Clear componenten in ontwerp JPanel
                            JLabel removeall = (JLabel) component.getComponent(1);
                            removeall.setText("server");
                            component.setVisible(false);
                        }
                    } catch (IOException ioe) {
                        System.out.println("An error occurred.");
                        ioe.printStackTrace();//error handling
                    }

                    jlbeschikbaarheid.setText("");
                    jlbeschikbaarheid.setVisible(false);
                    jlprijs.setText("");
                    jlprijs.setVisible(false);
                    jlsucces.setText("Ontwerp is succesvol opgeslagen!");
                    jlsucces.setVisible(true);
                    dialog.dispose();
                }
                else{
                    jlfoutmelding.setVisible(true);
                    jlfoutmelding.setText("Dit is geen geldig ontwerp. Een ontwerp moet minimaal 1 pfSense, 1 databaseserver en 1 webserver hebben.");
                }
            }
            else{ //Als er geen ontwerp is geselecteerd
                if (this.isValid(stringArrayList)) {
                    jlfoutmelding.setText("");
                    jlfoutmelding.setVisible(false);
                    jlsucces.setText("");
                    jlsucces.setVisible(false);
                    StringBuilder text = new StringBuilder();
                    for (String strings : stringArrayList) { //Maakt een string met alle servers om in het Ontwerp[nummer].txt bestand te duwen
                        text.append(strings).append("\n");
                    }

                    text.append(jlbeschikbaarheid.getText()).append("\n");
                    text.append(jlprijs.getText());

                    String url = "monitoringApplicatie/src/Ontwerpen/";
                    File folder = new File(url);
                    File[] listOfFiles = folder.listFiles();

                    ArrayList<File> fileArrayList = new ArrayList<>();
                    for (File file : listOfFiles) { //Er wordt geen nullpointerexception gegeven als er geen files in de directory staan. Er wordt dan simpelweg een 0 aan de fileArrayList meegegeven.
                        if (file.isFile()) {
                            fileArrayList.add(file); //Voeg alle ontwerpen toe aan de array.
                        }
                    }

                    int TellerOntwerp = fileArrayList.size() + 1; //Haal nummer ontwerp op: aantal ontwerpen + 1

                    url += "Ontwerp" + TellerOntwerp + ".txt";
                    //Maak file als het nog niet bestaat en schrijf erin.
                    try {
                        File path = new File(url);
                        File file = new File(path.getAbsolutePath()); //Maak dynamische url
                        FileWriter Writer = new FileWriter(file);
                        Writer.write(text.toString());
                        Writer.close();
                        stringArrayList.clear(); //Clear arraylist met servers
                        for (JPanel component : arrayComponent) { //Clear componenten in ontwerp JPanel
                            JLabel removeall = (JLabel) component.getComponent(1);
                            removeall.setText("server");
                            component.setVisible(false);
                        }
                    } catch (IOException ioe) {
                        System.out.println("An error occurred.");
                        ioe.printStackTrace();//error handling
                    }

                    jlbeschikbaarheid.setText("");
                    jlbeschikbaarheid.setVisible(false);
                    jlprijs.setText("");
                    jlprijs.setVisible(false);
                    jlsucces.setText("Ontwerp is succesvol opgeslagen!");
                    jlsucces.setVisible(true);
                }
                else{
                    jlfoutmelding.setVisible(true);
                    jlfoutmelding.setText("Dit is geen geldig ontwerp. Een ontwerp moet minimaal 1 pfSense, 1 databaseserver en 1 webserver hebben.");
                }
            }
        }
    }

    public boolean isValid(ArrayList<String> stringArrayList){ //checkt of het ontwerp valide is. Return true als het ontwerp valide is.
        int checkpf = 0;
        int checkdb = 0;
        int checkwb = 0;

        if(stringArrayList.isEmpty()){ //Als er geen componenten in het ontwerp staan, return dan altijd false.
            return false;
        }
        else { //Kijkt of een ontwerp minimaal 1 pfSense, 1 dbserver en 1webserver bevat.
            for (String strings : stringArrayList) {
                for (Server servers : serverArrayList) {
                    if (strings.equals(servers.getNaam())) {
                        if (servers.getType() == 0) {
                            checkpf++;
                        }
                        if (servers.getType() == 1) {
                            checkdb++;
                        }
                        if (servers.getType() == 2) {
                            checkwb++;
                        }
                    }
                }
            }

            return checkpf >= 1 && checkdb >= 1 && checkwb >= 1; //returnt true als een opstelling een pfSense, een webserver en een databaseserver heeft.
        }
    }
}

