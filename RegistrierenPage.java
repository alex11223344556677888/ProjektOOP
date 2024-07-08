package Gui;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class RegistrierenPage extends JPanel {
    private static final long serialVersionUID = 1L;

    private BackgroundPanel mainPanel;
    private JTextField txtVorname, txtName, txtGeburtsdatum, txtAlter, txtTelefonnummer, txtEmail, txtStrasse, txtNr, txtOrt, txtPLZ, txtFuehrerscheinzeit;
    private JRadioButton rdbJa, rdbNein;
    private JComboBox<String> cmbFuehrerscheinklasse;
    private JPasswordField txtPasswort, txtPasswortWdh;

    public RegistrierenPage() {
        mainPanel = new BackgroundPanel(new GridBagLayout(), "bilder/5D363845-E5AD-4FC3-8A5F-DF965141DCED.jpeg"); // Update with the correct path to your image
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        // Header label
        JLabel lblHeader = new JLabel("Gib deine Persönliche Daten ein");
        lblHeader.setFont(new Font("Arial", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(lblHeader, gbc);
        
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;

        // Labels and text fields for the form
        JLabel lblVorname = new JLabel("Vorname:");
        txtVorname = new JTextField(15);
        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(lblVorname, gbc);
        gbc.gridx = 1;
        mainPanel.add(txtVorname, gbc);

        JLabel lblName = new JLabel("Name:");
        txtName = new JTextField(15);
        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(lblName, gbc);
        gbc.gridx = 1;
        mainPanel.add(txtName, gbc);

        JLabel lblGeburtsdatum = new JLabel("Geburtsdatum:");
        JFormattedTextField txtGeburtsdatum = createFormattedDateField();
        gbc.gridx = 0;
        gbc.gridy = 3;
        mainPanel.add(lblGeburtsdatum, gbc);
        gbc.gridx = 1;
        mainPanel.add(txtGeburtsdatum, gbc);

        JLabel lblAlter = new JLabel("Alter:");
        txtAlter = new JTextField(15);
        gbc.gridx = 0;
        gbc.gridy = 4;
        mainPanel.add(lblAlter, gbc);
        gbc.gridx = 1;
        mainPanel.add(txtAlter, gbc);

        JLabel lblTelefonnummer = new JLabel("Telefonnummer:");
        txtTelefonnummer = new JTextField(15);
        gbc.gridx = 0;
        gbc.gridy = 5;
        mainPanel.add(lblTelefonnummer, gbc);
        gbc.gridx = 1;
        mainPanel.add(txtTelefonnummer, gbc);

        JLabel lblEmail = new JLabel("Email:");
        txtEmail = new JTextField(15);
        gbc.gridx = 0;
        gbc.gridy = 6;
        mainPanel.add(lblEmail, gbc);
        gbc.gridx = 1;
        mainPanel.add(txtEmail, gbc);

        JLabel lblStrasse = new JLabel("Straße:");
        txtStrasse = new JTextField(15);
        gbc.gridx = 0;
        gbc.gridy = 7;
        mainPanel.add(lblStrasse, gbc);
        gbc.gridx = 1;
        mainPanel.add(txtStrasse, gbc);

        JLabel lblNr = new JLabel("Nr.:");
        txtNr = new JTextField(5);
        gbc.gridx = 2;
        mainPanel.add(lblNr, gbc);
        gbc.gridx = 3;
        mainPanel.add(txtNr, gbc);

        JLabel lblOrt = new JLabel("Ort:");
        txtOrt = new JTextField(15);
        gbc.gridx = 0;
        gbc.gridy = 8;
        mainPanel.add(lblOrt, gbc);
        gbc.gridx = 1;
        mainPanel.add(txtOrt, gbc);

        JLabel lblPLZ = new JLabel("PLZ:");
        txtPLZ = new JTextField(5);
        gbc.gridx = 2;
        mainPanel.add(lblPLZ, gbc);
        gbc.gridx = 3;
        mainPanel.add(txtPLZ, gbc);

        // Kundenkarte section
        JLabel lblKundenkarte = new JLabel("Kundenkarte:");
        rdbJa = new JRadioButton("Ja");
        rdbNein = new JRadioButton("Nein");
        ButtonGroup bgKundenkarte = new ButtonGroup();
        bgKundenkarte.add(rdbJa);
        bgKundenkarte.add(rdbNein);
        gbc.gridx = 0;
        gbc.gridy = 9;
        mainPanel.add(lblKundenkarte, gbc);

        // Create a JPanel with FlowLayout to hold the radio buttons side by side
        JPanel kundenkartePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        kundenkartePanel.add(rdbJa);
        kundenkartePanel.add(rdbNein);
        gbc.gridx = 1;
        mainPanel.add(kundenkartePanel, gbc);

        JLabel lblFuehrerscheinzeit = new JLabel("Führerscheinzeit:");
        txtFuehrerscheinzeit = new JTextField(15);
        gbc.gridx = 0;
        gbc.gridy = 10;
        mainPanel.add(lblFuehrerscheinzeit, gbc);
        gbc.gridx = 1;
        mainPanel.add(txtFuehrerscheinzeit, gbc);

        JLabel lblFuehrerscheinklasse = new JLabel("Führerscheinklasse:");
        String[] fuehrerscheinklassen = {"A", "B", "C", "D"};
        cmbFuehrerscheinklasse = new JComboBox<>(fuehrerscheinklassen);
        gbc.gridx = 0;
        gbc.gridy = 11;
        mainPanel.add(lblFuehrerscheinklasse, gbc);
        gbc.gridx = 1;
        mainPanel.add(cmbFuehrerscheinklasse, gbc);

        JLabel lblPasswort = new JLabel("Passwort:");
        txtPasswort = new JPasswordField(15);
        gbc.gridx = 0;
        gbc.gridy = 12;
        mainPanel.add(lblPasswort, gbc);
        gbc.gridx = 1;
        mainPanel.add(txtPasswort, gbc);

        JLabel lblPasswortWdh = new JLabel("Passwort wiederholen:");
        txtPasswortWdh = new JPasswordField(15);
        gbc.gridx = 0;
        gbc.gridy = 13;
        mainPanel.add(lblPasswortWdh, gbc);
        gbc.gridx = 1;
        mainPanel.add(txtPasswortWdh, gbc);

        // Buttons
        JButton btnZurueck = new JButton("Zurück");
        JButton btnBestaetigen = new JButton("Bestätigen");
        gbc.gridx = 0;
        gbc.gridy = 14;
        mainPanel.add(btnZurueck, gbc);
        gbc.gridx = 1;
        mainPanel.add(btnBestaetigen, gbc);

        // ActionListener zurück button
        btnZurueck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(mainPanel);
                parentFrame.dispose(); // Close the current frame

                WelcomePage welcomePage = new WelcomePage();
                welcomePage.setVisible(true); // Make the WelcomePage frame visible
            }
        });

        // Add action listener for the Confirm button
        btnBestaetigen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(mainPanel);
                parentFrame.getContentPane().removeAll();
                parentFrame.getContentPane().add(new ZusammenfassungPage(
                    txtVorname.getText(),
                    txtName.getText(),
                    txtGeburtsdatum.getText(),
                    txtAlter.getText(),
                    txtTelefonnummer.getText(),
                    txtEmail.getText(),
                    txtStrasse.getText(),
                    txtNr.getText(),
                    txtOrt.getText(),
                    txtPLZ.getText(),
                    rdbJa.isSelected() ? "Ja" : "Nein",
                    txtFuehrerscheinzeit.getText(),
                    (String) cmbFuehrerscheinklasse.getSelectedItem(),
                    new String(txtPasswort.getPassword())
                ).getMainPanel());
                parentFrame.revalidate();
                parentFrame.repaint();
            }
        });

        setLayout(new BorderLayout());
        add(mainPanel, BorderLayout.CENTER);
    }

    private static JFormattedTextField createFormattedDateField() {
        MaskFormatter dateFormatter = null;
        try {
            dateFormatter = new MaskFormatter("##.##.####");
            dateFormatter.setPlaceholderCharacter('_');
        } catch (ParseException e) {
            e.printStackTrace();
        }
        JFormattedTextField dateField = new JFormattedTextField(dateFormatter);
        dateField.setColumns(7); // Set the length of the text field to 10 columns
        return dateField;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    // Custom JPanel class to paint background image
    class BackgroundPanel extends JPanel {
        private static final long serialVersionUID = 1L;
		private Image backgroundImage;

        public BackgroundPanel(LayoutManager layout, String imagePath) {
            super(layout);
            // Load the background image
            backgroundImage = new ImageIcon(imagePath).getImage();
            if (backgroundImage == null) {
                System.err.println("Image not found: " + imagePath);
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Draw the background image
            if (backgroundImage != null) {
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            } else {
                g.setColor(Color.RED);
                g.fillRect(0, 0, getWidth(), getHeight());
                g.setColor(Color.WHITE);
                g.drawString("Image not found", getWidth() / 2, getHeight() / 2);
            }
        }
    }
}






