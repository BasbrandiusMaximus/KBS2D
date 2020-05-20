package Applicatie;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ServersBekijkenDialog extends JDialog implements ActionListener {
    private JButton jbBewerken;
    private JButton jbTerug;
    private ArrayList<Server> serverArrayList;
    private JDialog dialog;

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
        dialog.setLayout(new FlowLayout());

        JLabel info = new JLabel("Hier ziet u alle servers die beschikbaar zijn. Om een server te bewerken of om een nieuwe toe te voegen, drukt u op 'bewerken'");
        dialog.add(info);

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

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer(); //Makes cellrenderer
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        for(int i = 0; i < 4; i++) { //Center all data in table
            listTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        JPanel showWholeTable = new JPanel();
        showWholeTable.setLayout(new BorderLayout());
        Dimension d = new Dimension(650, 250);
        showWholeTable.setPreferredSize(d);
        dialog.add(showWholeTable);
        showWholeTable.add(listTable.getTableHeader(), BorderLayout.NORTH);
        showWholeTable.add(listTable, BorderLayout.CENTER);

        //Aanmaken en toevoegen bewerken JButton
        jbBewerken = new JButton("Bewerken");
        jbBewerken.addActionListener(this);
        dialog.add(jbBewerken);

        //Aanmaken en toevoegen terug JButton
        jbTerug = new JButton("Terug");
        jbTerug.addActionListener(this);
        dialog.add(jbTerug);

        dialog.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jbBewerken) { //Als er op bewerken wordt gedrukt, open dan de serversToevoegenDialog
            serversToevoegenDialog toevoegen = new serversToevoegenDialog(serverArrayList);
            dialog.dispose();
        }
        if(e.getSource() == jbTerug){
            ApplicatieFrame frame = new ApplicatieFrame();
            dialog.dispose();
        }
    }
}
