package Applicatie;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ServersBekijkenDialog extends JDialog implements ActionListener {
    private JButton jbBewerken;
    private JTable listTable;
    private DefaultTableModel listTableModel;

    public ServersBekijkenDialog(ArrayList<Server> serverArrayList){
        JDialog dialog = new JDialog();
        dialog.setModal(true);
        dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        dialog.setSize(900,400);
        dialog.setTitle("Servers aanpassen en toevoegen");
        dialog.setLayout(new FlowLayout());

        String[] columnNames = {"Naam", "Type", "Prijs", "Beschikbaarheidspercentage"};
        Object[][] rowData = {};
        listTableModel = new DefaultTableModel(rowData, columnNames);
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
            String beschikbaarheid = servers.getBeschikbaarheid() + "%";
            listTableModel.addRow(new Object[]{servers.getNaam(), type , prijs, beschikbaarheid});
        }

        listTable = new JTable(listTableModel);
        listTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listTable.setEnabled(false);
        dialog.add(listTable);

        //Aanmaken en toevoegen bewerken JButton
        jbBewerken = new JButton("Bewerken");
        jbBewerken.addActionListener(this);
        dialog.add(jbBewerken);

        dialog.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jbBewerken){
            System.out.println(listTableModel.getDataVector().elementAt(listTable.getSelectedRow()));
        }
    }
}
