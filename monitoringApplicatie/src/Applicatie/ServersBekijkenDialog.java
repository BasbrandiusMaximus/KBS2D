package Applicatie;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ServersBekijkenDialog extends JDialog implements ActionListener, MouseListener {
    private JButton jbBewerken;
    private JButton jbTerug;
    private ArrayList<Server> serverArrayList;
    private JDialog dialog;
    private Color background;
    private Color cnavbar;

    public ServersBekijkenDialog(){
        //Zelf ophalen van de servers uit servers.txt zodat na het bewerken, toevoegen of verwijderen de lijst automatisch wordt geupdatet.
        ArrayList<String> lijst = new ArrayList<>();
        serverArrayList = new ArrayList<>();

        try {
            File Servers = new File("./Servers.txt");
            Scanner Reader = new Scanner(Servers);
            while (Reader.hasNextLine()) {
                String data = Reader.nextLine();
                lijst.add(data);
            }
            Reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        for (String data : lijst) {
            try {
                String[] server = data.split(",", 0);
                int prijs = Integer.parseInt(server[1]);
                double beschikbaarheid = Double.parseDouble(server[2]);
                int type = Integer.parseInt(server[3]);
                Server serverObject = new Server(server[0], prijs, beschikbaarheid, type);
                serverArrayList.add(serverObject);
            }
            catch(IndexOutOfBoundsException ignore) {}
        }

        dialog = new JDialog();
        dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        dialog.setSize(900,250);
        dialog.setTitle("Serverlijst");
        dialog.setLayout(new BorderLayout());
        background = new Color(230, 244, 255); //230, 244, 255
        cnavbar = new Color(143, 163, 179); //143, 163, 179
        dialog.getContentPane().setBackground(background);

        JLabel info = new JLabel("Hier ziet u alle servers die aan een ontwerp toegevoegd kunnen worden. Om een server te bewerken of om een nieuwe toe te voegen, drukt u op 'bewerken'");
        info.setBorder(new EmptyBorder(10,70,10,30));//top,left,bottom,right
        dialog.add(info, BorderLayout.NORTH);

        String[] columnNames = {"Naam", "Type", "Prijs", "Beschikbaarheidspercentage"};
        Object[][] rowData = {};
        DefaultTableModel listTableModel = new DefaultTableModel(rowData, columnNames);
        for (Server servers : serverArrayList) {
            String type = "";
            if(servers.getType() == 0){
                type += "Firewall/Router";
            }
            if(servers.getType() == 1){
                type += "Database";
            }
            if(servers.getType() == 2){
                type += "Web";
            }
            String prijs = servers.getPrijs() + " euro";
            Double beschik = servers.getBeschikbaarheid() * 100;
            String beschikbaarheid = beschik + "%";
            listTableModel.addRow(new Object[]{servers.getNaam(), type , prijs, beschikbaarheid});
        }

        JTable listTable = new JTable(listTableModel);
        listTable.setEnabled(false); //Makes cells uneditable
        listTable.setBackground(background);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer(); //Makes cellrenderer
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        for(int i = 0; i < 4; i++) { //Center all data in table
            listTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        JPanel showWholeTable = new JPanel();
        showWholeTable.setBorder(new EmptyBorder(0,10,10,0));//top,left,bottom,right
        showWholeTable.setBackground(background);
        showWholeTable.setLayout(new BorderLayout());
        Dimension d = new Dimension(650, 250);
        showWholeTable.setPreferredSize(d);
        dialog.add(showWholeTable, BorderLayout.WEST);
        listTable.getTableHeader().setBackground(cnavbar);
        listTable.getTableHeader().setBorder(BorderFactory.createLineBorder(cnavbar));
        showWholeTable.add(listTable.getTableHeader(), BorderLayout.NORTH);
        showWholeTable.add(listTable, BorderLayout.CENTER);

        JPanel jpbuttons = new JPanel();
        jpbuttons.setLayout(new GridBagLayout());
        Dimension djp = new Dimension(230,250);
        jpbuttons.setPreferredSize(djp);
        jpbuttons.setBackground(background);
        dialog.add(jpbuttons);

        //Aanmaken en toevoegen bewerken JButton
        jbBewerken = new JButton("Bewerken");
        jbBewerken.addActionListener(this);
        jbBewerken.addMouseListener(this);
        Dimension dbuttons = new Dimension(100,30);
        jbBewerken.setPreferredSize(dbuttons);
        jbBewerken.setBackground(cnavbar);
        jbBewerken.setBorder(BorderFactory.createLineBorder(cnavbar));
        jbBewerken.setAlignmentY(Component.CENTER_ALIGNMENT);
        jpbuttons.add(jbBewerken);

        //Aanmaken en toevoegen terug JButton
        jbTerug = new JButton("Terug");
        jbTerug.setBackground(cnavbar);
        jbTerug.setPreferredSize(dbuttons);
        jbTerug.setBorder(BorderFactory.createLineBorder(cnavbar));
        jbTerug.addActionListener(this);
        jbTerug.addMouseListener(this);
        jpbuttons.add(jbTerug);

        dialog.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jbBewerken) { //Als er op bewerken wordt gedrukt, open dan de serversToevoegenDialog
            serversToevoegenDialog toevoegen = new serversToevoegenDialog(serverArrayList);
            dialog.setVisible(false);
        }
        if(e.getSource() == jbTerug){
            ApplicatieFrame frame = new ApplicatieFrame();
            dialog.dispose();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) { }
    @Override
    public void mousePressed(MouseEvent e) { }
    @Override
    public void mouseReleased(MouseEvent e) { }
    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource() == jbTerug){
            jbTerug.setBackground(background);
            jbTerug.setBorder(BorderFactory.createLineBorder(background));
        }
        if(e.getSource() == jbBewerken){
            jbBewerken.setBackground(background);
            jbBewerken.setBorder(BorderFactory.createLineBorder(background));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() == jbTerug){
            jbTerug.setBackground(cnavbar);
            jbTerug.setBorder(BorderFactory.createLineBorder(cnavbar));
        }
        if(e.getSource() == jbBewerken){
            jbBewerken.setBackground(cnavbar);
            jbBewerken.setBorder(BorderFactory.createLineBorder(cnavbar));
        }
    }
}
