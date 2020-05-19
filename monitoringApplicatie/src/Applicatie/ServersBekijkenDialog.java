package Applicatie;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ServersBekijkenDialog extends JDialog implements ActionListener {
    private JButton jbBewerken;
    private ArrayList<Server> serverArrayList;

    public ServersBekijkenDialog(ArrayList<Server> serverArrayList){
        this.serverArrayList = serverArrayList;
        JDialog dialog = new JDialog();
        dialog.setModal(true);
        dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        dialog.setSize(900,250);
        dialog.setTitle("Servers aanpassen en toevoegen");
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

        dialog.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jbBewerken) { //Als er op bewerken wordt gedrukt.
            serversToevoegen toevoegen = new serversToevoegen(serverArrayList);
        }
    }
}
