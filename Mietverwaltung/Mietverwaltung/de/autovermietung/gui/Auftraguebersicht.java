package Gui;

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

    public Auftraguebersicht() {
        mainPanel = new BackgroundPanel("bilder/DFF4179E-6663-4C59-9991-ACE68B2C9392.jpeg"); // Update with the correct path to your image
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.CENTER;

        // Header label
        JLabel lblHeader = new JLabel("Buchungsverlauf");
        lblHeader.setFont(new Font("Arial", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        mainPanel.add(lblHeader, gbc);

        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;

        // Create the list model and populate it
        listModel = new DefaultListModel<>();
        listModel.addElement("<html> ---Modell---- <br/> ---Buchungszeitraum---- <br/> ----Abgeschlossen---- <br/>------</html>");
        listModel.addElement("<html>----Modell---- <br/>----Buchungszeitraum---- <br/> ----Offen---- <br/>------</html>");
        listModel.addElement("Element 3");
        listModel.addElement("Element 4");

        // Create the JList with the list model
        list = new JList<>(listModel);
        list.setCellRenderer(new CustomListCellRenderer());
        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setPreferredSize(new Dimension(300, 200));

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        mainPanel.add(scrollPane, gbc);

        // Create buttons
        btnZurueck = new JButton("Zurück");
        btnNeuesAutoMieten = new JButton("Neues Auto mieten");

        // Add buttons to the panel
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(btnZurueck, gbc);

        gbc.gridx = 1;
        mainPanel.add(btnNeuesAutoMieten, gbc);

        // Set layout and add main panel to this panel
        setLayout(new BorderLayout());
        add(mainPanel, BorderLayout.CENTER);

        // Add action listeners for buttons
        btnZurueck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement the action for the Zurück button
                JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(mainPanel);
                parentFrame.getContentPane().removeAll();
                parentFrame.getContentPane().add(new LoginPage().getMainPanel());
                parentFrame.revalidate();
                parentFrame.repaint();
            }
        });
        btnNeuesAutoMieten.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement the action for the Neues Auto mieten button
                JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(mainPanel);
                parentFrame.getContentPane().removeAll();
                parentFrame.getContentPane().add(new KalenderPage().getMainPanel());
                parentFrame.revalidate();
                parentFrame.repaint();
            }
        });

        // Add mouse listener to the list
        list.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                if (evt.getClickCount() == 1) {
                    // Single-click detected, show the message box
                    showCustomMessageDialog();
                }
            }
        });
    }

    private void showCustomMessageDialog() {
        // Create a custom panel for the message dialog
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        // Auto details (left side)
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

        // Ausstattung checkboxes
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

        // Set checkbox states based on PKW attributes
       /*checkBoxes[0].setSelected(pkw.isKlimatisiert());
        checkBoxes[1].setSelected(pkw.isBeheizt());
        checkBoxes[2].setSelected(pkw.isNavi());
        checkBoxes[3].setSelected(pkw.isFahrassistent());
        checkBoxes[4].setSelected(autoscrolls);*/

        // add image
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
            JLabel lblPreis = new JLabel("Preis:");
            gbc.gridx = 0;
            gbc.gridy = 16;
            panel.add(lblPreis, gbc);

            JTextField txtPreis = new JTextField("100", 20);
            txtPreis.setEditable(false);
            gbc.gridx = 1;
            panel.add(txtPreis, gbc);
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

        // Kundendaten (right side)
        JPanel kundenPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbcKunden = new GridBagConstraints();
        gbcKunden.insets = new Insets(5, 5, 5, 5);
        gbcKunden.anchor = GridBagConstraints.WEST;

        addLabelAndTextField(kundenPanel, gbcKunden, "Vorname:", "", 0);
        addLabelAndTextField(kundenPanel, gbcKunden, "Name:", "", 1);
        addLabelAndTextField(kundenPanel, gbcKunden, "Geburtsdatum:", "", 2);
        addLabelAndTextField(kundenPanel, gbcKunden, "Alter:", "", 3);
        addLabelAndTextField(kundenPanel, gbcKunden, "Telefonnummer:", "", 4);
        addLabelAndTextField(kundenPanel, gbcKunden, "Email:", "", 5);
        addLabelAndTextField(kundenPanel, gbcKunden, "Straße:", "", 6);
        addLabelAndTextField(kundenPanel, gbcKunden, "Nr.:", "", 7);
        addLabelAndTextField(kundenPanel, gbcKunden, "Ort:", "", 8);
        addLabelAndTextField(kundenPanel, gbcKunden, "PLZ:", "", 9);
        addLabelAndTextField(kundenPanel, gbcKunden, "Kundenkarte:", "Nein", 10);
        addLabelAndTextField(kundenPanel, gbcKunden, "Führerscheinklasse:", "", 11);
        addLabelAndTextField(kundenPanel, gbcKunden, "Führerscheinzeit:", "", 12);

        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridheight = 8;
        panel.add(kundenPanel, gbc);

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
        JDialog dialog = optionPane.createDialog(this, "Vertragsübersicht");
        dialog.setVisible(true);
    }

    private void addLabelAndTextField(JPanel panel, GridBagConstraints gbc, String labelText, String textFieldText, int yPos) {
        JLabel label = new JLabel(labelText);
        JTextField textField = new JTextField(15);
        textField.setText(textFieldText);
        gbc.gridx = 0;
        gbc.gridy = yPos;
        panel.add(label, gbc);
        gbc.gridx = 1;
        panel.add(textField, gbc);
    }

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

    public JPanel getMainPanel() {
        return mainPanel;
    }
}


