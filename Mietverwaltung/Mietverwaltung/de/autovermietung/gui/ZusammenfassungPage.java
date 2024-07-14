package Gui;

import javax.swing.*;
import fachklassen.Kunde;
import Verwaltungsklassen.Kundenverwaltung;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ZusammenfassungPage extends JPanel {
    private static final long serialVersionUID = 1L;

    private JPanel mainPanel;
    private JTextField txtVorname, txtName, txtGeburtsdatum, txtAlter, txtTelefonnummer, txtEmail, txtStrasse, txtNr, txtOrt, txtPLZ, txtFuehrerscheinzeit;
    private JTextField txtKundenkarte, txtFuehrerscheinklasse, txtPasswort;
    
    public ZusammenfassungPage(String vorname, String name, String geburtsdatum, String alter,
                               String telefonnummer, String email, String strasse, String nr,
                               String ort, String plz, String kundenkarte, String fuehrerscheinzeit,
                               String fuehrerscheinklasse, String passwort, Kundenverwaltung kundenverwaltung) {
        mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        // Header label
        JLabel lblHeader = new JLabel("Zusammenfassung deiner Eingaben");
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
        txtVorname = new JTextField(vorname, 15);
        txtVorname.setEditable(true);
        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(lblVorname, gbc);
        gbc.gridx = 1;
        mainPanel.add(txtVorname, gbc);

        JLabel lblName = new JLabel("Name:");
        txtName = new JTextField(name, 15);
        txtName.setEditable(true);
        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(lblName, gbc);
        gbc.gridx = 1;
        mainPanel.add(txtName, gbc);

        JLabel lblGeburtsdatum = new JLabel("Geburtsdatum:");
        txtGeburtsdatum = new JTextField(geburtsdatum, 15);
        txtGeburtsdatum.setEditable(true);
        gbc.gridx = 0;
        gbc.gridy = 3;
        mainPanel.add(lblGeburtsdatum, gbc);
        gbc.gridx = 1;
        mainPanel.add(txtGeburtsdatum, gbc);

        JLabel lblAlter = new JLabel("Alter:");
        txtAlter = new JTextField(alter, 15);
        txtAlter.setEditable(true);
        gbc.gridx = 0;
        gbc.gridy = 4;
        mainPanel.add(lblAlter, gbc);
        gbc.gridx = 1;
        mainPanel.add(txtAlter, gbc);

        JLabel lblTelefonnummer = new JLabel("Telefonnummer:");
        txtTelefonnummer = new JTextField(telefonnummer, 15);
        txtTelefonnummer.setEditable(true);
        gbc.gridx = 0;
        gbc.gridy = 5;
        mainPanel.add(lblTelefonnummer, gbc);
        gbc.gridx = 1;
        mainPanel.add(txtTelefonnummer, gbc);

        JLabel lblEmail = new JLabel("Email:");
        txtEmail = new JTextField(email, 15);
        txtEmail.setEditable(true);
        gbc.gridx = 0;
        gbc.gridy = 6;
        mainPanel.add(lblEmail, gbc);
        gbc.gridx = 1;
        mainPanel.add(txtEmail, gbc);

        JLabel lblStrasse = new JLabel("Straße:");
        txtStrasse = new JTextField(strasse, 15);
        txtStrasse.setEditable(true);
        gbc.gridx = 0;
        gbc.gridy = 7;
        mainPanel.add(lblStrasse, gbc);
        gbc.gridx = 1;
        mainPanel.add(txtStrasse, gbc);

        JLabel lblNr = new JLabel("Nr.:");
        txtNr = new JTextField(nr, 5);
        txtNr.setEditable(true);
        gbc.gridx = 2;
        mainPanel.add(lblNr, gbc);
        gbc.gridx = 3;
        mainPanel.add(txtNr, gbc);

        JLabel lblOrt = new JLabel("Ort:");
        txtOrt = new JTextField(ort, 15);
        txtOrt.setEditable(true);
        gbc.gridx = 0;
        gbc.gridy = 8;
        mainPanel.add(lblOrt, gbc);
        gbc.gridx = 1;
        mainPanel.add(txtOrt, gbc);

        JLabel lblPLZ = new JLabel("PLZ:");
        txtPLZ = new JTextField(plz, 5);
        txtPLZ.setEditable(true);
        gbc.gridx = 2;
        mainPanel.add(lblPLZ, gbc);
        gbc.gridx = 3;
        mainPanel.add(txtPLZ, gbc);

        JLabel lblKundenkarte = new JLabel("Kundenkarte:");
        txtKundenkarte = new JTextField(kundenkarte, 15);
        txtKundenkarte.setEditable(true);
        gbc.gridx = 0;
        gbc.gridy = 9;
        mainPanel.add(lblKundenkarte, gbc);
        gbc.gridx = 1;
        mainPanel.add(txtKundenkarte, gbc);

        JLabel lblFuehrerscheinzeit = new JLabel("Führerscheinzeit:");
        txtFuehrerscheinzeit = new JTextField(fuehrerscheinzeit, 15);
        txtFuehrerscheinzeit.setEditable(true);
        gbc.gridx = 0;
        gbc.gridy = 10;
        mainPanel.add(lblFuehrerscheinzeit, gbc);
        gbc.gridx = 1;
        mainPanel.add(txtFuehrerscheinzeit, gbc);

        JLabel lblFuehrerscheinklasse = new JLabel("Führerscheinklasse:");
        txtFuehrerscheinklasse = new JTextField(fuehrerscheinklasse, 15);
        txtFuehrerscheinklasse.setEditable(true);
        gbc.gridx = 0;
        gbc.gridy = 11;
        mainPanel.add(lblFuehrerscheinklasse, gbc);
        gbc.gridx = 1;
        mainPanel.add(txtFuehrerscheinklasse, gbc);

        JLabel lblPasswort = new JLabel("Passwort:");
        txtPasswort = new JTextField(passwort, 15);
        txtPasswort.setEditable(true);
        gbc.gridx = 0;
        gbc.gridy = 12;
        mainPanel.add(lblPasswort, gbc);
        gbc.gridx = 1;
        mainPanel.add(txtPasswort, gbc);

        // Buttons
        JButton btnZurueck = new JButton("Zurück");
        JButton btnSpeichern = new JButton("Speichern");
        gbc.gridx = 0;
        gbc.gridy = 14;
        mainPanel.add(btnZurueck, gbc);
        gbc.gridx = 1;
        mainPanel.add(btnSpeichern, gbc);
        gbc.gridx = 2;

        // Add action listener for the Back button
        btnZurueck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(mainPanel);
                parentFrame.getContentPane().removeAll();
                parentFrame.getContentPane().add(new RegistrierenPage().getMainPanel());
                parentFrame.revalidate();
                parentFrame.repaint();
            }
        });

        // Add action listener for the Save button
        btnSpeichern.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Kunde kunde = new Kunde(
                        txtVorname.getText(),
                        txtName.getText(),
                        txtGeburtsdatum.getText(),
                        Integer.parseInt(txtAlter.getText()),
                        0, // Assuming kundennummer is auto-generated or you can set a default value
                        Integer.parseInt(txtTelefonnummer.getText()),
                        txtFuehrerscheinklasse.getText(),
                        txtEmail.getText(),
                        "", // zahlungsmittel, not provided in UI
                        "", // historie, not provided in UI
                        txtStrasse.getText(),
                        Integer.parseInt(txtNr.getText()),
                        Integer.parseInt(txtPLZ.getText()),
                        txtOrt.getText(),
                        Boolean.parseBoolean(txtKundenkarte.getText()), // Assuming kundenkarte is a boolean
                        Integer.parseInt(txtFuehrerscheinzeit.getText()),
                        txtVorname.getText(), // anmeldename, using Vorname as placeholder
                        txtPasswort.getText()  // passwort
                    );
        
                    kundenverwaltung.neuenKundenErstellen(kunde); // Correct method to add a new customer
        
                    JOptionPane.showMessageDialog(mainPanel, "Daten erfolgreich gespeichert!");
        
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(mainPanel, "Fehler beim Speichern der Daten: " + ex.getMessage(), "Fehler", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        this.setLayout(new BorderLayout());
        this.add(mainPanel, BorderLayout.CENTER);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
