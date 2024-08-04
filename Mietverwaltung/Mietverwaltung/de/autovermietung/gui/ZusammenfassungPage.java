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
    private Kundenverwaltung kundenverwaltung;

    public ZusammenfassungPage(String vorname, String name, String geburtsdatum, String alter,
                               String telefonnummer, String email, String strasse, String nr,
                               String ort, String plz, String kundenkarte, String fuehrerscheinzeit,
                               String fuehrerscheinklasse, String passwort, Kundenverwaltung kundenverwaltung) {
        
        if (kundenverwaltung == null) {
            throw new IllegalArgumentException("Kundenverwaltung darf nicht null sein.");
        }
        this.kundenverwaltung = kundenverwaltung;

       // Layout und Constraints für das Hauptpanel festlegen
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        // Header-Label erstellen und hinzufügen
        JLabel lblHeader = new RoundedLabel(" Sind deine Eingaben korrekt? ");
        lblHeader.setFont(new Font("Arial", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        lblHeader.setBackground(Color.WHITE);
        lblHeader.setForeground(Color.BLACK);
        mainPanel.add(lblHeader, gbc);

        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;

        // Vorname-Label und Textfeld erstellen und hinzufügen
        JLabel lblVorname = new RoundedLabel(" Vorname: ");
        txtVorname = new JTextField(vorname, 15);
        txtVorname.setEditable(true);
        gbc.gridx = 0;
        gbc.gridy = 1;
        lblVorname.setBackground(Color.WHITE);
        lblVorname.setForeground(Color.BLACK);
        mainPanel.add(lblVorname, gbc);
        gbc.gridx = 1;
        mainPanel.add(txtVorname, gbc);

        // Name-Label und Textfeld erstellen und hinzufügen
        JLabel lblName = new RoundedLabel(" Name: ");
        txtName = new JTextField(name, 15);
        txtName.setEditable(true);
        gbc.gridx = 0;
        gbc.gridy = 2;
        lblName.setBackground(Color.WHITE);
        lblName.setForeground(Color.BLACK);
        mainPanel.add(lblName, gbc);
        gbc.gridx = 1;
        mainPanel.add(txtName, gbc);

        // Geburtsdatum-Label und Textfeld erstellen und hinzufügen
        JLabel lblGeburtsdatum = new RoundedLabel(" Geburtsdatum: ");
        txtGeburtsdatum = new JTextField(geburtsdatum, 15);
        txtGeburtsdatum.setEditable(true);
        gbc.gridx = 0;
        gbc.gridy = 3;
        lblGeburtsdatum.setBackground(Color.WHITE);
        lblGeburtsdatum.setForeground(Color.BLACK);
        mainPanel.add(lblGeburtsdatum, gbc);
        gbc.gridx = 1;
        mainPanel.add(txtGeburtsdatum, gbc);

        // Alter-Label und Textfeld erstellen und hinzufügen
        JLabel lblAlter = new RoundedLabel(" Alter: ");
        txtAlter = new JTextField(alter, 15);
        txtAlter.setEditable(true);
        gbc.gridx = 0;
        gbc.gridy = 4;
        lblAlter.setBackground(Color.WHITE);
        lblAlter.setForeground(Color.BLACK);
        mainPanel.add(lblAlter, gbc);
        gbc.gridx = 1;
        mainPanel.add(txtAlter, gbc);

        // Define a DocumentFilter to allow only numeric input and limit the length for txtAlter
        ((AbstractDocument) txtAlter.getDocument()).setDocumentFilter(new DocumentFilter() {
            private final int MAX_LENGTH = 2;

            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (string == null) {
                    return;
                }

                if ((fb.getDocument().getLength() + string.length()) <= MAX_LENGTH && string.matches("\\d*")) {
                    super.insertString(fb, offset, string, attr);
                } else {
                    JOptionPane.showMessageDialog(null, "Falsche Eingabe");
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (text == null) {
                    return;
                }

                if ((fb.getDocument().getLength() - length + text.length()) <= MAX_LENGTH && text.matches("\\d*")) {
                    super.replace(fb, offset, length, text, attrs);
                } else {
                    JOptionPane.showMessageDialog(null, "Falsche Eingabe");
                }
            }

            @Override
            public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
                super.remove(fb, offset, length);
            }
        });

        // Telefonnummer-Label und Textfeld erstellen und hinzufügen
        JLabel lblTelefonnummer = new RoundedLabel(" Telefonnummer: ");
        txtTelefonnummer = new JTextField(telefonnummer, 15);
        txtTelefonnummer.setEditable(true);
        gbc.gridx = 0;
        gbc.gridy = 5;
        lblTelefonnummer.setBackground(Color.WHITE);
        lblTelefonnummer.setForeground(Color.BLACK);
        mainPanel.add(lblTelefonnummer, gbc);
        gbc.gridx = 1;
        mainPanel.add(txtTelefonnummer, gbc);

        // DocumentFilter für Telefonnummer, um nur numerische Eingaben zu erlauben
        ((AbstractDocument) txtTelefonnummer.getDocument()).setDocumentFilter(new DocumentFilter() {
            private final int MAX_LENGTH = 13;

            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (string == null) {
                    return;
                }

                if ((fb.getDocument().getLength() + string.length()) <= MAX_LENGTH && string.matches("\\d*")) {
                    super.insertString(fb, offset, string, attr);
                } else {
                    JOptionPane.showMessageDialog(null, "Falsche Eingabe");
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (text == null) {
                    return;
                }

                if ((fb.getDocument().getLength() - length + text.length()) <= MAX_LENGTH && text.matches("\\d*")) {
                    super.replace(fb, offset, length, text, attrs);
                } else {
                    JOptionPane.showMessageDialog(null, "Falsche Eingabe");
                }
            }

            @Override
            public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
                super.remove(fb, offset, length);
            }
        });

        // Email-Label und Textfeld erstellen und hinzufügen
        JLabel lblEmail = new RoundedLabel(" Email: ");
        txtEmail = new JTextField(email, 15);
        txtEmail.setEditable(true);
        gbc.gridx = 0;
        gbc.gridy = 6;
        lblEmail.setBackground(Color.WHITE);
        lblEmail.setForeground(Color.BLACK);
        mainPanel.add(lblEmail, gbc);
        gbc.gridx = 1;
        mainPanel.add(txtEmail, gbc);

        // Formatiert txtEmail
        txtEmail.setInputVerifier(new InputVerifier() {
            private final Pattern emailPattern = Pattern.compile(
                "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$"
            );

            @Override
            public boolean verify(JComponent input) {
                JTextField textField = (JTextField) input;
                String text = textField.getText().trim();
                
                // Erlaubt leere Eingaben ohne Fehlermeldung
                if (text.isEmpty()) {
                    return true;
                }
                
                boolean isValid = emailPattern.matcher(text).matches();
                if (!isValid) {
                    JOptionPane.showMessageDialog(input, "Bitte geben Sie eine gültige E-Mail-Adresse ein.", "Ungültige E-Mail", JOptionPane.ERROR_MESSAGE);
                }
                return isValid;
            }
        });

        // Setzt die Schriftart von txtTelefonnummer auf die gleiche wie txtEmail
        Font emailFont = txtEmail.getFont();
        txtTelefonnummer.setFont(emailFont);

        // Straße-Label und Textfeld erstellen und hinzufügen
        JLabel lblStrasse = new RoundedLabel(" Straße: ");
        txtStrasse = new JTextField(strasse, 15);
        txtStrasse.setEditable(true);
        gbc.gridx = 0;
        gbc.gridy = 7;
        lblStrasse.setBackground(Color.WHITE);
        lblStrasse.setForeground(Color.BLACK);
        mainPanel.add(lblStrasse, gbc);
        gbc.gridx = 1;
        mainPanel.add(txtStrasse, gbc);

        // Nr.-Label und Textfeld erstellen und hinzufügen
        JLabel lblNr = new RoundedLabel(" Nr.: ");
        txtNr = new JTextField(nr, 5);
        txtNr.setEditable(true);
        gbc.gridx = 2;
        lblNr.setBackground(Color.WHITE);
        lblNr.setForeground(Color.BLACK);
        mainPanel.add(lblNr, gbc);
        gbc.gridx = 3;
        mainPanel.add(txtNr, gbc);

        // Ort-Label und Textfeld erstellen und hinzufügen
        JLabel lblOrt = new RoundedLabel(" Ort: ");
        txtOrt = new JTextField(ort, 15);
        txtOrt.setEditable(true);
        gbc.gridx = 0;
        gbc.gridy = 8;
        lblOrt.setBackground(Color.WHITE);
        lblOrt.setForeground(Color.BLACK);
        mainPanel.add(lblOrt, gbc);
        gbc.gridx = 1;
        mainPanel.add(txtOrt, gbc);

        // DocumentFilter für Ort, um numerische Eingaben zu verbieten
        ((AbstractDocument) txtOrt.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (string == null) {
                    return;
                }

                if (string.matches("[^\\d]*")) {
                    super.insertString(fb, offset, string, attr);
                } else {
                    JOptionPane.showMessageDialog(null, "Falsche Eingabe");
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (text == null) {
                    return;
                }

                if (text.matches("[^\\d]*")) {
                    super.replace(fb, offset, length, text, attrs);
                } else {
                    JOptionPane.showMessageDialog(null, "Falsche Eingabe");
                }
            }

            @Override
            public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
                super.remove(fb, offset, length);
            }
        });

        // PLZ-Label und Textfeld erstellen und hinzufügen
        JLabel lblPLZ = new RoundedLabel(" PLZ: ");
        txtPLZ = new JTextField(plz, 5);
        txtPLZ.setEditable(true);
        gbc.gridx = 2;
        lblPLZ.setBackground(Color.WHITE);
        lblPLZ.setForeground(Color.BLACK);
        mainPanel.add(lblPLZ, gbc);
        gbc.gridx = 3;
        mainPanel.add(txtPLZ, gbc);

        // DocumentFilter für PLZ, um nur numerische Eingaben zu erlauben und die Länge zu begrenzen
        ((AbstractDocument) txtPLZ.getDocument()).setDocumentFilter(new DocumentFilter() {
            private final int MAX_LENGTH = 5;

            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (string == null) {
                    return;
                }

                if ((fb.getDocument().getLength() + string.length()) <= MAX_LENGTH && string.matches("\\d*")) {
                    super.insertString(fb, offset, string, attr);
                } else {
                    JOptionPane.showMessageDialog(null, "Falsche Eingabe");
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (text == null) {
                    return;
                }

                if ((fb.getDocument().getLength() - length + text.length()) <= MAX_LENGTH && text.matches("\\d*")) {
                    super.replace(fb, offset, length, text, attrs);
                } else {
                    JOptionPane.showMessageDialog(null, "Falsche Eingabe");
                }
            }

            @Override
            public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
                super.remove(fb, offset, length);
            }
        });

        // Kundenkarte-Label und Textfeld erstellen und hinzufügen
        JLabel lblKundenkarte = new RoundedLabel(" Kundenkarte: ");
        JTextField txtKundenkarte = new JTextField(kundenkarte, 15);
        txtKundenkarte.setEditable(true);
        gbc.gridx = 0;
        gbc.gridy = 9;
        lblKundenkarte.setBackground(Color.WHITE);
        lblKundenkarte.setForeground(Color.BLACK);
        mainPanel.add(lblKundenkarte, gbc);
        gbc.gridx = 1;
        mainPanel.add(txtKundenkarte, gbc);

        // Führerscheinzeit-Label und Textfeld erstellen und hinzufügen
        JLabel lblFuehrerscheinzeit = new RoundedLabel(" Führerscheinzeit: ");
        txtFuehrerscheinzeit = new JTextField(fuehrerscheinzeit, 15);
        txtFuehrerscheinzeit.setEditable(true);
        gbc.gridx = 0;
        gbc.gridy = 10;
        lblFuehrerscheinzeit.setBackground(Color.WHITE);
        lblFuehrerscheinzeit.setForeground(Color.BLACK);
        mainPanel.add(lblFuehrerscheinzeit, gbc);
        gbc.gridx = 1;
        mainPanel.add(txtFuehrerscheinzeit, gbc);

        // Führerscheinklasse-Label und Textfeld erstellen und hinzufügen
        JLabel lblFuehrerscheinklasse = new RoundedLabel(" Führerscheinklasse: ");
        JTextField txtFuehrerscheinklasse = new JTextField(fuehrerscheinklasse, 15);
        txtFuehrerscheinklasse.setEditable(true);
        gbc.gridx = 0;
        gbc.gridy = 11;
        lblFuehrerscheinklasse.setBackground(Color.WHITE);
        lblFuehrerscheinklasse.setForeground(Color.BLACK);
        mainPanel.add(lblFuehrerscheinklasse, gbc);
        gbc.gridx = 1;
        mainPanel.add(txtFuehrerscheinklasse, gbc);

        // Passwort-Label und Textfeld erstellen und hinzufügen
        JLabel lblPasswort = new RoundedLabel(" Passwort: ");
        JTextField txtPasswort = new JTextField(passwort, 15);
        txtPasswort.setEditable(true);
        gbc.gridx = 0;
        gbc.gridy = 12;
        lblPasswort.setBackground(Color.WHITE);
        lblPasswort.setForeground(Color.BLACK);
        mainPanel.add(lblPasswort, gbc);
        gbc.gridx = 1;
        mainPanel.add(txtPasswort, gbc);

        // Zurück- und Speichern-Buttons erstellen und hinzufügen
        JButton btnZurueck = new JButton("Zurück");
        JButton btnSpeichern = new JButton("Speichern");
        gbc.gridx = 0;
        gbc.gridy = 14;
        lblHeader.setBackground(Color.WHITE);
        lblHeader.setForeground(Color.BLACK);
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
                parentFrame.getContentPane().add(new RegistrierenPage(kundenverwaltung).getMainPanel());
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

                    // Switch to the Login page
                    JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(mainPanel);
                    parentFrame.getContentPane().removeAll();
                    parentFrame.getContentPane().add(new LoginPage(kundenverwaltung).getMainPanel());
                    parentFrame.revalidate();
                    parentFrame.repaint();

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(mainPanel, "Fehler beim Speichern der Daten: " + ex.getMessage(), "Fehler", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace(); // Print stack trace for debugging
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
