package Gui;

import javax.swing.*;
import java.util.List;
import java.util.stream.Collectors;
import fachklassen.PKW;
import Verwaltungsklassen.Kundenverwaltung;
import Verwaltungsklassen.PKWVerwaltung;
import Verwaltungsklassen.TerminVerwaltung;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FilterPage extends JPanel {
    private static final long serialVersionUID = 1L;
     private Kundenverwaltung kundenverwaltung; 
    private JPanel mainPanel;
    private JComboBox<String> cmbMarke, cmbKategorie, cmbGetriebe, cmbFarbe, cmbSortierenNach;
    private JRadioButton rdbJa, rdbNein;
    private JList<String> list;
    private DefaultListModel<String> listModel;

    private PKWVerwaltung pkwVerwaltung = new PKWVerwaltung();
    private TerminVerwaltung terminVerwaltung = new TerminVerwaltung();
    private List<PKW> filteredPKWs; // List to store the filtered PKWs

    private int startTag, startMonat, startJahr, endeTag, endeMonat, endeJahr;

    
    public FilterPage(int startTag, int startMonat, int startJahr, int endeTag, int endeMonat, int endeJahr) {
        this.startTag = startTag;
        this.startMonat = startMonat;
        this.startJahr = startJahr;
        this.endeTag = endeTag;
        this.endeMonat = endeMonat;
        this.endeJahr = endeJahr;

        mainPanel = new BackgroundPanel("bilder/DFF4179E-6663-4C59-9991-ACE68B2C9392.jpeg"); // Update with the correct path to your image
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        // Left side components
        JLabel lblMarke = new RoundedLabel(" Marke: ");
        cmbMarke = new JComboBox<>(new String[]{"", "BMW", "Audi", "Mercedes", "Opel", "VW", "Porsche"});
        gbc.gridx = 0;
        gbc.gridy = 0;
        lblMarke.setBackground(Color.WHITE);
        lblMarke.setForeground(Color.BLACK);
        mainPanel.add(lblMarke, gbc);
        gbc.gridx = 1;
        mainPanel.add(cmbMarke, gbc);

        JLabel lblKategorie = new RoundedLabel(" Kategorie: ");
        cmbKategorie = new JComboBox<>(new String[]{"", "Kleinwagen", "Kombi", "Limousine", "SUV", "Coupe", "Cabrio"});
        gbc.gridx = 0;
        gbc.gridy = 1;
        lblKategorie.setBackground(Color.WHITE);
        lblKategorie.setForeground(Color.BLACK);
        mainPanel.add(lblKategorie, gbc);
        gbc.gridx = 1;
        mainPanel.add(cmbKategorie, gbc);

        JLabel lblGetriebe = new RoundedLabel(" Getriebe: ");
        cmbGetriebe = new JComboBox<>(new String[]{"", "Schaltgetriebe", "Automatik"});
        gbc.gridx = 0;
        gbc.gridy = 2;
        lblGetriebe.setBackground(Color.WHITE);
        lblGetriebe.setForeground(Color.BLACK);
        mainPanel.add(lblGetriebe, gbc);
        gbc.gridx = 1;
        mainPanel.add(cmbGetriebe, gbc);

        JLabel lblElektro = new RoundedLabel(" Elektro: ");
        rdbJa = new JRadioButton("ja");
        rdbNein = new JRadioButton("nein");
        ButtonGroup bgElektro = new ButtonGroup();
        bgElektro.add(rdbJa);
        bgElektro.add(rdbNein);
        gbc.gridx = 0;
        gbc.gridy = 3;
        lblElektro.setBackground(Color.WHITE);
        lblElektro.setForeground(Color.BLACK);
        mainPanel.add(lblElektro, gbc);

        // Ensure the buttons are directly next to each other
        JPanel radioPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        radioPanel.add(rdbJa);
        radioPanel.add(rdbNein);
        gbc.gridx = 1;
        gbc.gridy = 3;
        mainPanel.add(radioPanel, gbc);

        JLabel lblFarbe = new RoundedLabel(" Farbe: ");
        cmbFarbe = new JComboBox<>(new String[]{"", "Schwarz", "Weiß", "Silber", "Blau", "Rot"});
        gbc.gridx = 0;
        gbc.gridy = 4;
        lblFarbe.setBackground(Color.WHITE);
        lblFarbe.setForeground(Color.BLACK);
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
                filterPKWs();
            }
        });

        // Right side components
        JLabel lblSortierenNach = new JLabel("Sortieren nach:");
        cmbSortierenNach = new JComboBox<>(new String[]{"Preis", "Baujahr", "Motorisierung"});
        gbc.gridx = 3;
        gbc.gridy = 0;
        mainPanel.add(lblSortierenNach, gbc);
        gbc.gridx = 4;
        mainPanel.add(cmbSortierenNach, gbc);

        listModel = new DefaultListModel<>();
        list = new JList<>(listModel);
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
                if (evt.getClickCount() == 2) {
                    // Double-click detected
                    int index = list.locationToIndex(evt.getPoint());
                    PKW selectedPKW = filteredPKWs.get(index);
                    showCustomMessageDialog(selectedPKW);
                }
            }
        });

        // Add action listeners for buttons (if needed, e.g., navigation)
        btnZurueck.addActionListener(e -> {
            JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(mainPanel);
            parentFrame.getContentPane().removeAll();
            parentFrame.getContentPane().add(new KalenderPage(kundenverwaltung).getMainPanel());
            parentFrame.revalidate();
            parentFrame.repaint();
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    // --------- Message Box
    private void showCustomMessageDialog(PKW pkw) {
        // Create a custom panel for the message dialog
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        JLabel lblMarke = new JLabel("Marke:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(lblMarke, gbc);

        JTextField txtMarke = new JTextField(pkw.getFzgmarke(), 20);
        txtMarke.setEditable(false);
        gbc.gridx = 1;
        panel.add(txtMarke, gbc);

        JLabel lblGetriebe = new JLabel("Getriebe:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(lblGetriebe, gbc);

        JTextField txtGetriebe = new JTextField(pkw.getGetriebe(), 20);
        txtGetriebe.setEditable(false);
        gbc.gridx = 1;
        panel.add(txtGetriebe, gbc);

        JLabel lblKraftstoff = new JLabel("Kraftstoff:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(lblKraftstoff, gbc);

        JTextField txtKraftstoff = new JTextField(pkw.getKraftstoff(), 20);
        txtKraftstoff.setEditable(false);
        gbc.gridx = 1;
        panel.add(txtKraftstoff, gbc);

        JLabel lblMotorleistung = new JLabel("Motorleistung:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(lblMotorleistung, gbc);

        JTextField txtMotorleistung = new JTextField(String.valueOf(pkw.getMotorleistung()), 20);
        txtMotorleistung.setEditable(false);
        gbc.gridx = 1;
        panel.add(txtMotorleistung, gbc);

        JLabel lblBaujahr = new JLabel("Baujahr:");
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(lblBaujahr, gbc);

        JTextField txtBaujahr = new JTextField(String.valueOf(pkw.getBaujahr()), 20);
        txtBaujahr.setEditable(false);
        gbc.gridx = 1;
        panel.add(txtBaujahr, gbc);

        JLabel lblFarbe = new JLabel("Farbe:");
        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(lblFarbe, gbc);

        JTextField txtFarbe = new JTextField(pkw.getFarbe(), 20);
        txtFarbe.setEditable(false);
        gbc.gridx = 1;
        panel.add(txtFarbe, gbc);

        // Create a subpanel to hold the checkboxes and the image placeholder
        JPanel subPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbcSub = new GridBagConstraints();
        gbcSub.insets = new Insets(5, 5, 5, 5);
        gbcSub.anchor = GridBagConstraints.WEST;

        // Ausstattung checkboxes
        String[] ausstattungItems1 = {"Klimaanlage", "Heizung", "Navi", "Fahrassistent", "Parkassistent"};
        JCheckBox[] checkBoxes = new JCheckBox[ausstattungItems1.length];

        for (int i = 0; i < ausstattungItems1.length; i++) {
            checkBoxes[i] = new JCheckBox(ausstattungItems1[i]);
            checkBoxes[i].setSelected(false);
            checkBoxes[i].setEnabled(false);
            checkBoxes[i].setDisabledIcon(checkBoxes[i].getIcon());
            checkBoxes[i].setDisabledSelectedIcon(checkBoxes[i].getIcon());
            gbcSub.gridx = 0;
            gbcSub.gridy = i;
            subPanel.add(checkBoxes[i], gbcSub);
        }

        // Set checkbox states based on PKW attributes
        checkBoxes[0].setSelected(pkw.isKlimatisiert());
        checkBoxes[1].setSelected(pkw.isBeheizt());
        checkBoxes[2].setSelected(pkw.isNavi());
        checkBoxes[3].setSelected(pkw.isFahrassistent());
        checkBoxes[4].setSelected(pkw.isParkassistent());

        // add image
        ImageIcon imageIcon = new ImageIcon("bilder/DFF4179E-6663-4C59-9991-ACE68B2C9392.jpeg");
        Image image = imageIcon.getImage();

        // Add the image placeholder to the right of the checkboxes
        JPanel imagePlaceholder = new JPanel() {
            private static final long serialVersionUID = 1L;

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (image != null) {
                    g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };
        imagePlaceholder.setPreferredSize(new Dimension(200, 150));
        gbcSub.gridx = 1;
        gbcSub.gridy = 0;
        gbcSub.gridheight = ausstattungItems1.length;
        gbcSub.fill = GridBagConstraints.BOTH;
        subPanel.add(imagePlaceholder, gbcSub);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        panel.add(subPanel, gbc);

        gbc.gridwidth = 1;

        JLabel lblZeitraum = new JLabel("Zeitraum:");
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        panel.add(lblZeitraum, gbc);

        JTextField txtZeitraum = new JTextField(20);
        txtZeitraum.setEditable(false);
        gbc.gridx = 1;
        panel.add(txtZeitraum, gbc);

        // Zusatzbuchungen
        JLabel lblZusatzbuchungen = new JLabel("Zusatzbuchungen:");
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 1;
        panel.add(lblZusatzbuchungen, gbc);

        String[] zusatzbuchungenItems = {"Kindersitz", "Dachbox", "Auslandsfahrt", "Kilometerpaket"};
        JTextField txtKindersitz = new JTextField(2);
        txtKindersitz.setVisible(false);

        for (int i = 0; i < zusatzbuchungenItems.length; i++) {
            JCheckBox checkBox = new JCheckBox(zusatzbuchungenItems[i]);
            gbc.gridx = 0;
            gbc.gridy = 9 + i * 2; // Adjust y position to make room for the text field
            panel.add(checkBox, gbc);

            // Add action listener to show/hide text field for "Kindersitz"
            if (zusatzbuchungenItems[i].equals("Kindersitz")) {
                gbc.gridy = 9 + i * 2 + 1; // Position directly below the checkbox
                panel.add(txtKindersitz, gbc);

                checkBox.addActionListener(e -> {
                    txtKindersitz.setVisible(checkBox.isSelected());
                    panel.revalidate();
                    panel.repaint();
                });
            }
        }

        // Versicherungspaket
        JLabel lblVersicherungspaket = new JLabel("Versicherungspaket:");
        gbc.gridx = 1;
        gbc.gridy = 8;
        panel.add(lblVersicherungspaket, gbc);

        String[] versicherungspaketItems = {"Teilkasko", "Vollkasko", "Vollkasko Plus"};
        ButtonGroup versicherungspaketGroup = new ButtonGroup();

        for (int i = 0; i < versicherungspaketItems.length; i++) {
            JRadioButton radioButton = new JRadioButton(versicherungspaketItems[i]);
            gbc.gridx = 1;
            gbc.gridy = 9 + i;
            panel.add(radioButton, gbc);
            versicherungspaketGroup.add(radioButton);
        }

        JLabel lblPreis = new JLabel("Preis:");
        gbc.gridx = 0;
        gbc.gridy = 16;
        panel.add(lblPreis, gbc);

        JTextField txtPreis = new JTextField("100", 20);
        txtPreis.setEditable(false);
        gbc.gridx = 1;
        panel.add(txtPreis, gbc);

        JButton btnBuchen = new JButton("Buchen");
        btnBuchen.setBackground(Color.ORANGE);
        gbc.gridx = 1;
        gbc.gridy = 17;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(btnBuchen, gbc);

        // Custom button for the JOptionPane
        JButton btnZurueck = new JButton("Zurück");
        btnZurueck.addActionListener(e -> {
            // Close the dialog
            Window window = SwingUtilities.getWindowAncestor(btnZurueck);
            if (window != null) {
                window.dispose();
            }
        });

        // Display the custom panel in a JOptionPane
        JOptionPane optionPane = new JOptionPane(panel, JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{btnZurueck});
        JDialog dialog = optionPane.createDialog(this, "Auto Details");

        btnBuchen.addActionListener(e -> {
            try {
                terminVerwaltung.buchePKW(pkw.getId(), startTag, startMonat, startJahr, endeTag, endeMonat, endeJahr);
                //JOptionPane.showMessageDialog(this, "PKW erfolgreich gebucht!");
                dialog.dispose();
             // Show the SchlussPage after booking
                JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(mainPanel);
                parentFrame.getContentPane().removeAll();
                parentFrame.getContentPane().add(new SchlussPage(kundenverwaltung).getMainPanel());
                parentFrame.revalidate();
                parentFrame.repaint();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Fehler bei der Buchung: " + ex.getMessage(), "Fehler", JOptionPane.ERROR_MESSAGE);
            }
        });

        dialog.setVisible(true);
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
        filteredPKWs = tempList; // Store the filtered PKWs in the list
        for (PKW pkw : tempList) {
            listModel.addElement("<html>Marke: " + pkw.getFzgmarke() + "<br/>Preis: " + pkw.getAnzahltüren() + "<br/>Baujahr: " + pkw.getBaujahr() + "<br/>------" + "</html>");
        }
    }
}
