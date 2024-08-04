package Gui;

import Verwaltungsklassen.Kundenverwaltung;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Auftraguebersicht extends JPanel {
    private static final long serialVersionUID = 1L;

    private JPanel mainPanel;
    private JList<String> list;
    private DefaultListModel<String> listModel;
    private JButton btnZurueck, btnNeuesAutoMieten;
    private Kundenverwaltung kundenverwaltung;

    public Auftraguebersicht(Kundenverwaltung kundenverwaltung) {
        if (kundenverwaltung == null) {
            throw new IllegalArgumentException("Kundenverwaltung darf nicht null sein.");
        }
        this.kundenverwaltung = kundenverwaltung;
        
       mainPanel = new BackgroundPanel("bilder/DFF4179E-6663-4C59-9991-ACE68B2C9392.jpeg"); // Update with the correct path to your image
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.CENTER;

        // Header-Label erstellen und hinzufügen
        JLabel lblHeader = new JLabel("Buchungsverlauf");
        lblHeader.setFont(new Font("Arial", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        mainPanel.add(lblHeader, gbc);

        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;

        // ListModel erstellen und mit Daten füllen
        listModel = new DefaultListModel<>();
        listModel.addElement("<html> ---Modell---- <br/> ---Buchungszeitraum---- <br/> ----Abgeschlossen---- <br/>------</html>");
        listModel.addElement("<html>----Modell---- <br/>----Buchungszeitraum---- <br/> ----Offen---- <br/>------</html>");
        listModel.addElement("Element 3");
        listModel.addElement("Element 4");

        // JList mit dem ListModel erstellen
        list = new JList<>(listModel);
        list.setCellRenderer(new CustomListCellRenderer());
        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setPreferredSize(new Dimension(300, 200));

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        mainPanel.add(scrollPane, gbc);

        // Buttons erstellen
        btnZurueck = new JButton("Zurück");
        btnNeuesAutoMieten = new JButton("Neues Auto mieten");

        // Buttons zum Panel hinzufügen
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(btnZurueck, gbc);

        gbc.gridx = 1;
        mainPanel.add(btnNeuesAutoMieten, gbc);

        // Layout setzen und mainPanel zum Hauptpanel hinzufügen
        setLayout(new BorderLayout());
        add(mainPanel, BorderLayout.CENTER);

        // ActionListener für den Zurück-Button
        btnZurueck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aktion für den Zurück-Button implementieren
                JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(mainPanel);
                parentFrame.getContentPane().removeAll();
                parentFrame.getContentPane().add(new LoginPage().getMainPanel());
                parentFrame.revalidate();
                parentFrame.repaint();
            }
        });

        // ActionListener für den Neues Auto mieten-Button
        btnNeuesAutoMieten.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aktion für den Neues Auto mieten-Button implementieren
                JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(mainPanel);
                parentFrame.getContentPane().removeAll();
                parentFrame.getContentPane().add(new KalenderPage().getMainPanel());
                parentFrame.revalidate();
                parentFrame.repaint();
            }
        });

        // MouseListener zur Liste hinzufügen
        list.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    // Doppelklick erkannt, zeige die benutzerdefinierte Nachricht an
                    showCustomMessageDialog();
                }
            }
        });
    }

    // Methode zur Anzeige einer benutzerdefinierten Nachricht
    private void showCustomMessageDialog() {
        // Panel für die benutzerdefinierte Nachricht erstellen
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        // Auto-Details (linke Seite)
        JLabel lblMarke = new JLabel("Marke:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(lblMarke, gbc);

        JTextField txtMarke = new JTextField(20);
        txtMarke.setEditable(false);
        gbc.gridx = 1;
        panel.add(txtMarke, gbc);

        JLabel lblGetriebe = new JLabel("Getriebe:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(lblGetriebe, gbc);

        JTextField txtGetriebe = new JTextField(20);
        txtGetriebe.setEditable(false);
        gbc.gridx = 1;
        panel.add(txtGetriebe, gbc);

        JLabel lblKraftstoff = new JLabel("Kraftstoff:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(lblKraftstoff, gbc);

        JTextField txtKraftstoff = new JTextField(20);
        txtKraftstoff.setEditable(false);
        gbc.gridx = 1;
        panel.add(txtKraftstoff, gbc);

        JLabel lblMotorleistung = new JLabel("Motorleistung:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(lblMotorleistung, gbc);

        JTextField txtMotorleistung = new JTextField(20);
        txtMotorleistung.setEditable(false);
        gbc.gridx = 1;
        panel.add(txtMotorleistung, gbc);

        JLabel lblBaujahr = new JLabel("Baujahr:");
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(lblBaujahr, gbc);

        JTextField txtBaujahr = new JTextField(20);
        txtBaujahr.setEditable(false);
        gbc.gridx = 1;
        panel.add(txtBaujahr, gbc);

        JLabel lblFarbe = new JLabel("Farbe:");
        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(lblFarbe, gbc);

        JTextField txtFarbe = new JTextField(20);
        txtFarbe.setEditable(false);
        gbc.gridx = 1;
        panel.add(txtFarbe, gbc);

        // Ausstattung Checkboxes erstellen und hinzufügen
        JPanel subPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbcSub = new GridBagConstraints();
        gbcSub.insets = new Insets(5, 5, 5, 5);
        gbcSub.anchor = GridBagConstraints.WEST;

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

        // Bild hinzufügen
        ImageIcon imageIcon = new ImageIcon("bilder/DFF4179E-6663-4C59-9991-ACE68B2C9392.jpeg");
        Image image = imageIcon.getImage();

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

        // Zusatzbuchungen erstellen und hinzufügen
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
            gbc.gridy = 9 + i * 2; // Y-Position anpassen, um Platz für das Textfeld zu schaffen
            panel.add(checkBox, gbc);

            // ActionListener hinzufügen, um das Textfeld für "Kindersitz" ein-/auszublenden
            if (zusatzbuchungenItems[i].equals("Kindersitz")) {
                gbc.gridy = 9 + i * 2 + 1; // Position direkt unterhalb der Checkbox
                panel.add(txtKindersitz, gbc);

                checkBox.addActionListener(e -> {
                    txtKindersitz.setVisible(checkBox.isSelected());
                    panel.revalidate();
                    panel.repaint();
                });
            }

            // Preisfeld hinzufügen
            JLabel lblPreis = new JLabel("Preis:");
            gbc.gridx = 0;
            gbc.gridy = 16;
            panel.add(lblPreis, gbc);

            JTextField txtPreis = new JTextField("100", 20);
            txtPreis.setEditable(false);
            gbc.gridx = 1;
            panel.add(txtPreis, gbc);
        }

        // Versicherungspaket erstellen und hinzufügen
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

        // Kundendaten (rechte Seite) erstellen und hinzufügen
        JPanel kundenPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbcKunden = new GridBagConstraints();
        gbcKunden.insets = new Insets(5, 5, 5, 5);
        gbcKunden.anchor = GridBagConstraints.WEST;

        addLabelAndTextField1(kundenPanel, gbcKunden, "Vorname:", "", 0);
        addLabelAndTextField1(kundenPanel, gbcKunden, "Name:", "", 1);
        addLabelAndTextField1(kundenPanel, gbcKunden, "Geburtsdatum:", "", 2);
        addLabelAndTextField1(kundenPanel, gbcKunden, "Alter:", "", 3);
        addLabelAndTextField1(kundenPanel, gbcKunden, "Telefonnummer:", "", 4);
        addLabelAndTextField1(kundenPanel, gbcKunden, "Email:", "", 5);
        addLabelAndTextField1(kundenPanel, gbcKunden, "Straße:", "", 6);
        addLabelAndTextField1(kundenPanel, gbcKunden, "Nr.:", "", 7);
        addLabelAndTextField1(kundenPanel, gbcKunden, "Ort:", "", 8);
        addLabelAndTextField1(kundenPanel, gbcKunden, "PLZ:", "", 9);
        addLabelAndTextField1(kundenPanel, gbcKunden, "Kundenkarte:", "Nein", 10);
        addLabelAndTextField1(kundenPanel, gbcKunden, "Führerscheinklasse:", "", 11);
        addLabelAndTextField1(kundenPanel, gbcKunden, "Führerscheinzeit:", "", 12);

        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridheight = 8;
        panel.add(kundenPanel, gbc);

        // Benutzerdefinierte Buttons für das JOptionPane
        JButton btnZurueck = new JButton("Zurück");
        btnZurueck.addActionListener(e -> {
            // Schließt den Dialog
            Window window = SwingUtilities.getWindowAncestor(btnZurueck);
            if (window != null) {
                window.dispose();
            }
        });

        JButton btnLoeschen = new JButton("Löschen");
        btnLoeschen.addActionListener(e -> {
            // Aktion ausführen, wenn "Löschen" angeklickt wird
            int confirmation = JOptionPane.showConfirmDialog(panel, "Möchten Sie wirklich löschen?", "Bestätigung", JOptionPane.YES_NO_OPTION);
            if (confirmation == JOptionPane.YES_OPTION) {
                // Löschen-Aktion hier ausführen
                // Vorläufig wird nur der Dialog geschlossen
                Window window = SwingUtilities.getWindowAncestor(btnLoeschen);
                if (window != null) {
                    window.dispose();
                }
            }
        });

        // Benutzerdefiniertes Panel in einem JOptionPane anzeigen
        JOptionPane optionPane = new JOptionPane(panel, JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{btnZurueck, btnLoeschen});
        JDialog dialog = optionPane.createDialog(this, "Vertragsübersicht");
        dialog.setVisible(true);
    }

    // Hilfsmethode zum Hinzufügen von Labels und Textfeldern zum Panel
    private void addLabelAndTextField1(JPanel panel, GridBagConstraints gbc, String labelText, String textFieldText, int yPosition) {
        JLabel label = new JLabel(labelText);
        gbc.gridx = 0;
        gbc.gridy = yPosition;
        panel.add(label, gbc);

        JTextField textField = new JTextField(textFieldText, 20);
        textField.setEditable(false);
        gbc.gridx = 1;
        panel.add(textField, gbc);
    }

    // Benutzerdefinierte ListCellRenderer-Klasse
    static class CustomListCellRenderer extends DefaultListCellRenderer {
        private static final long serialVersionUID = 1L;

        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            Component component = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

            String text = value.toString();
            if (text.contains("Abgeschlossen")) {
                component.setBackground(Color.RED);
            } else if (text.contains("Offen")) {
                component.setBackground(Color.GREEN);
            } else {
                component.setBackground(Color.WHITE);
            }

            if (isSelected) {
                component.setBackground(component.getBackground().darker());
            }

            return component;
        }
    }

    // Getter für das Hauptpanel
    public JPanel getMainPanel() {
        return mainPanel;
    }
}
