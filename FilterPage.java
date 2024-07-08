package de.autovermietung.gui;
import javax.swing.*;
import java.util.List;
import java.util.stream.Collectors;

import de.autovermietung.fachklassen.PKW;
import de.autovermietung.verwaltungsklassen.PKWVerwaltung;
import de.autovermietung.verwaltungsklassen.Terminplanung;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FilterPage extends JPanel {
    private static final long serialVersionUID = 1L;

    private JPanel mainPanel;
    private JComboBox<String> cmbMarke, cmbKategorie, cmbGetriebe, cmbFarbe, cmbSortierenNach;
    private JRadioButton rdbJa, rdbNein;
    private JList<String> list;
    private DefaultListModel<String> listModel;

    private PKWVerwaltung pkwVerwaltung = new PKWVerwaltung();

    public FilterPage() {
        mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        // Left side components
        JLabel lblMarke = new JLabel("Marke:");
        cmbMarke = new JComboBox<>(new String[]{"","BMW", "Audi", "Mercedes", "Opel", "VW", "Porsche"});
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(lblMarke, gbc);
        gbc.gridx = 1;
        mainPanel.add(cmbMarke, gbc);

        JLabel lblKategorie = new JLabel("Kategorie:");
        cmbKategorie = new JComboBox<>(new String[]{"","Kleinwagen", "Kombi", "Limousine", "SUV", "Coupe", "Cabrio"});
        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(lblKategorie, gbc);
        gbc.gridx = 1;
        mainPanel.add(cmbKategorie, gbc);

        JLabel lblGetriebe = new JLabel("Getriebe:");
        //cmbGetriebe = new JComboBox<>(new String[]{"","Manuell", "Automatik"});                   Das wieder entkommentieren, sobald die Testobjekte zw Manuell und Automatik unterscheiden nicht SCjaltgetriebe
        cmbGetriebe = new JComboBox<>(new String[]{"","Schaltgetriebe", "Automatik"});
        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(lblGetriebe, gbc);
        gbc.gridx = 1;
        mainPanel.add(cmbGetriebe, gbc);

        JLabel lblElektro = new JLabel("Elektro:");
        rdbJa = new JRadioButton("ja");
        rdbNein = new JRadioButton("nein");
        ButtonGroup bgElektro = new ButtonGroup();
        bgElektro.add(rdbJa);
        bgElektro.add(rdbNein);
        gbc.gridx = 0;
        gbc.gridy = 3;
        mainPanel.add(lblElektro, gbc);
        //mainPanel.add(bgElektro,gbc);  
     // Ensure the buttons are directly next to each other
        JPanel radioPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        radioPanel.add(rdbJa);
        radioPanel.add(rdbNein);
        gbc.gridx = 1;
        gbc.gridy = 3;
        mainPanel.add(radioPanel, gbc);
       

        JLabel lblFarbe = new JLabel("Farbe:");
        cmbFarbe = new JComboBox<>(new String[]{"","Schwarz", "Weiß", "Silber", "Blau", "Rot"});
        gbc.gridx = 0;
        gbc.gridy = 4;
        mainPanel.add(lblFarbe, gbc);
        gbc.gridx = 1;
        mainPanel.add(cmbFarbe, gbc);

        JButton btnZurueck = new JButton("Zurück");
        JButton btnSpeichern = new JButton("Speichern");
        gbc.gridx = 0;
        gbc.gridy = 5;
        mainPanel.add(btnZurueck, gbc);
        gbc.gridx = 1;
        mainPanel.add(btnSpeichern, gbc);
        
     // Add action listener for the Speichern button
        btnSpeichern.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	//btnSpeichern.addActionListener(e -> {
                filterPKWs();
                    // checkMarke();
                    // filterByMarke();
                    // filterByKategorie();
                    // filterByGetriebe();
            	//});
        };
        });

        // Right side components
        JLabel lblSortierenNach = new JLabel("Sortieren nach:");
        cmbSortierenNach = new JComboBox<>(new String[]{"Preis", "Baujahr" , "Motorisierung"});
        gbc.gridx = 3;
        gbc.gridy = 0;
        mainPanel.add(lblSortierenNach, gbc);
        gbc.gridx = 4;
        mainPanel.add(cmbSortierenNach, gbc);

        listModel = new DefaultListModel<>();
        list = new JList<>(listModel);
        // listModel.addElement("Auto 1");
        // listModel.addElement("Auto 2");
        // listModel.addElement("<html>Marke: Audi<br/>Preis: 123<br/>Baujahr: 2014</html>");
        // listModel.addElement("<html>Marke: BMW<br/>Preis: 150<br/>Baujahr: 2015</html>");
        // listModel.addElement("<html>Marke: Mercedes<br/>Preis: 200<br/>Baujahr: 2016</html>");
        
    
        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setPreferredSize(new Dimension(200, 300));
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.gridheight = 4;
        mainPanel.add(scrollPane, gbc);
        gbc.gridwidth = 1;
        gbc.gridheight = 1;

        // Add action listener for list selection
        list.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                @SuppressWarnings("unchecked")
                JList<String> list = (JList<String>) evt.getSource();
                if (evt.getClickCount() == 2) {
                    // Double-click detected
                    int index = list.locationToIndex(evt.getPoint());
                    String item = listModel.getElementAt(index);
                    JOptionPane.showMessageDialog(mainPanel, "Selected: " + item);
                }
            }
        });

        // Add action listeners for buttons (if needed, e.g., navigation)
        btnZurueck.addActionListener(e -> {
            JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(mainPanel);
            parentFrame.getContentPane().removeAll();
            parentFrame.getContentPane().add(new KalenderPage().getMainPanel());
            parentFrame.revalidate();
            parentFrame.repaint();
        });

        
        
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
    
   

    private void filterPKWs() {
        List<PKW> tempList = pkwVerwaltung.getPkwListe(); // start mit allen PKWs in der Liste
        
       // Filter für alle gebuchten PKWs
    tempList = tempList.stream()
            .filter(pkw -> !pkw.isGebucht())
            .collect(Collectors.toList());
            
        
        if (!cmbMarke.getSelectedItem().toString().isEmpty()) {
            tempList = pkwVerwaltung.filterPKW("marke", cmbMarke.getSelectedItem().toString(), tempList);
        }
        if (!cmbKategorie.getSelectedItem().toString().isEmpty()) {
            tempList = pkwVerwaltung.filterPKW("fahrzeugtyp", cmbKategorie.getSelectedItem().toString(), tempList);
        }
        if (!cmbGetriebe.getSelectedItem().toString().isEmpty()) {
            tempList = pkwVerwaltung.filterPKW("antrieb", cmbGetriebe.getSelectedItem().toString(), tempList);
        }
        if (rdbJa.isSelected()) {
            tempList = pkwVerwaltung.filterPKW("elektrofahrzeug", "true", tempList);
        }
        if (!cmbFarbe.getSelectedItem().toString().isEmpty()) {
            tempList = pkwVerwaltung.filterPKW("farbe", cmbFarbe.getSelectedItem().toString(), tempList);
        }

        String sortBy = (String) cmbSortierenNach.getSelectedItem();
    switch (sortBy) {
        case "Preis":
            pkwVerwaltung.sortierePKWListeNachID(tempList);
            break;
        case "Baujahr":
            pkwVerwaltung.sortierePKWListeNachBaujahr(tempList);
            break;
        case "Motorisierung":
        pkwVerwaltung.sortierePKWListeNachMotorisierung(tempList);
            break;
        // Add more sort options as needed
        default:
            break;
    }
    
        // Update the list model with the filtered results
        listModel.clear();
        for (PKW pkw : tempList) {
            listModel.addElement("<html>Marke: " + pkw.getFzgmarke() + "<br/>Preis: " + pkw.getAnzahltüren() + "<br/>Baujahr: " + pkw.getBaujahr() + "<br/>------"+ "</html>");
        }
    }
}


