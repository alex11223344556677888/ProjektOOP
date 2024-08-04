package Gui;

import Verwaltungsklassen.Kundenverwaltung;
import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.regex.Pattern;

public class RegistrierenPage extends JPanel {
    private static final long serialVersionUID = 1L;

    private BackgroundPanel mainPanel;
    private JTextField txtVorname, txtName, txtGeburtsdatum, txtAlter, txtTelefonnummer, txtEmail, txtStrasse, txtNr, txtOrt, txtPLZ, txtFuehrerscheinzeit;
    private JRadioButton rdbJa, rdbNein;
    private JComboBox<String> cmbFuehrerscheinklasse;
    private JPasswordField txtPasswort, txtPasswortWdh;
    private Kundenverwaltung kundenverwaltung;

    public RegistrierenPage(Kundenverwaltung kundenverwaltung) {
        if (kundenverwaltung == null) {
            throw new IllegalArgumentException("Kundenverwaltung darf nicht null sein.");
        }
        this.kundenverwaltung = kundenverwaltung;

        mainPanel = new BackgroundPanel("bilder/DFF4179E-6663-4C59-9991-ACE68B2C9392.jpeg");
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        // Header label
        JLabel lblHeader = new RoundedLabel(" Gib deine Persönliche Daten ein ");
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

        // Labels and text fields for the form
        JLabel lblVorname = new RoundedLabel(" Vorname: ");
        txtVorname = new JTextField(15);
        gbc.gridx = 0;
        gbc.gridy = 1;
        lblVorname.setBackground(Color.WHITE);
        lblVorname.setForeground(Color.BLACK);
        mainPanel.add(lblVorname, gbc);
        gbc.gridx = 1;
        mainPanel.add(txtVorname, gbc);

        JLabel lblName = new RoundedLabel(" Name: ");
        txtName = new JTextField(15);
        gbc.gridx = 0;
        gbc.gridy = 2;
        lblName.setBackground(Color.WHITE);
        lblName.setForeground(Color.BLACK);
        mainPanel.add(lblName, gbc);
        gbc.gridx = 1;
        mainPanel.add(txtName, gbc);

        JLabel lblGeburtsdatum = new RoundedLabel(" Geburtsdatum: ");
        JFormattedTextField txtGeburtsdatum = createFormattedDateField();
        gbc.gridx = 0;
        gbc.gridy = 3;
        lblGeburtsdatum.setBackground(Color.WHITE);
        lblGeburtsdatum.setForeground(Color.BLACK);
        mainPanel.add(lblGeburtsdatum, gbc);
        gbc.gridx = 1;
        mainPanel.add(txtGeburtsdatum, gbc);

// Alter Textfeld + nur Zahlen sind erlaubt 
        JLabel lblAlter = new RoundedLabel(" Alter: ");
        txtAlter = new JTextField(15);
        lblAlter.setBackground(Color.WHITE);
        lblAlter.setForeground(Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 4;
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

// Telefonnummer Textfeld + das nur Zahlen erlaubt sind und eine beschränkte länge haben 
        JLabel lblTelefonnummer = new RoundedLabel(" Telefonnummer: ");
        JTextField txtTelefonnummer = new JTextField(15);
        lblTelefonnummer.setBackground(Color.WHITE);
        lblTelefonnummer.setForeground(Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 5;
        mainPanel.add(lblTelefonnummer, gbc);
        gbc.gridx = 1;
        mainPanel.add(txtTelefonnummer, gbc);
        // Define a DocumentFilter to allow only numeric input and limit the length for txtTelefonnummer
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

        JLabel lblEmail = new RoundedLabel(" Email: ");
        txtEmail = new JTextField(15);
        lblEmail.setBackground(Color.WHITE);
        lblEmail.setForeground(Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 6;
        mainPanel.add(lblEmail, gbc);
        gbc.gridx = 1;
        mainPanel.add(txtEmail, gbc);

        // Define an InputVerifier to allow only valid email addresses
        txtEmail.setInputVerifier(new InputVerifier() {
            private final Pattern emailPattern = Pattern.compile(
                "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$"
            );

            @Override
            public boolean verify(JComponent input) {
                JTextField textField = (JTextField) input;
                String text = textField.getText().trim();

                // Allow empty input without showing the message box
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

        // Set the font of txtTelefonnummer to be the same as txtEmail
        Font emailFont = txtEmail.getFont();
        txtTelefonnummer.setFont(emailFont);

        JLabel lblStrasse = new RoundedLabel(" Straße: ");
        txtStrasse = new JTextField(15);
        lblStrasse.setBackground(Color.WHITE);
        lblStrasse.setForeground(Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 7;
        mainPanel.add(lblStrasse, gbc);
        gbc.gridx = 1;
        mainPanel.add(txtStrasse, gbc);

        JLabel lblNr = new RoundedLabel(" Nr.: ");
        txtNr = new JTextField(5);
        lblNr.setBackground(Color.WHITE);
        lblNr.setForeground(Color.BLACK);
        gbc.gridx = 2;
        mainPanel.add(lblNr, gbc);
        gbc.gridx = 3;
        mainPanel.add(txtNr, gbc);

// Ort Textfeld + keine Zahlen sind erlaubt 
        JLabel lblOrt = new RoundedLabel(" Ort: ");
        txtOrt = new JTextField(15);
        lblOrt.setBackground(Color.WHITE);
        lblOrt.setForeground(Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 8;
        mainPanel.add(lblOrt, gbc);
        gbc.gridx = 1;
        mainPanel.add(txtOrt, gbc);
        // Define a DocumentFilter to disallow numeric input for txtOrt
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

// PLZ Textfeld + das nur Zahlen erlaubt sind 
        JLabel lblPLZ = new RoundedLabel(" PLZ: ");
        txtPLZ = new JTextField(5);
        lblPLZ.setBackground(Color.WHITE);
        lblPLZ.setForeground(Color.BLACK);
        gbc.gridx = 2;
        mainPanel.add(lblPLZ, gbc);
        gbc.gridx = 3;
        mainPanel.add(txtPLZ, gbc);
        // Define a DocumentFilter to allow only numeric input for txtPLZ
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

        // Kundenkarte section
        JLabel lblKundenkarte = new RoundedLabel(" Kundenkarte: ");
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

        JLabel lblFuehrerscheinzeit = new RoundedLabel(" Führerscheinzeit: ");
        txtFuehrerscheinzeit = new JTextField(15);
        gbc.gridx = 0;
        gbc.gridy = 10;
        mainPanel.add(lblFuehrerscheinzeit, gbc);
        gbc.gridx = 1;
        mainPanel.add(txtFuehrerscheinzeit, gbc);

        JLabel lblFuehrerscheinklasse = new RoundedLabel(" Führerscheinklasse: ");
        String[] fuehrerscheinklassen = {" ", "B", "C"};
        cmbFuehrerscheinklasse = new JComboBox<>(fuehrerscheinklassen);
        gbc.gridx = 0;
        gbc.gridy = 11;
        mainPanel.add(lblFuehrerscheinklasse, gbc);
        gbc.gridx = 1;
        mainPanel.add(cmbFuehrerscheinklasse, gbc);

        JLabel lblPasswort = new RoundedLabel(" Passwort: ");
        txtPasswort = new JPasswordField(15);
        gbc.gridx = 0;
        gbc.gridy = 12;
        mainPanel.add(lblPasswort, gbc);
        gbc.gridx = 1;
        mainPanel.add(txtPasswort, gbc);

        JLabel lblPasswortWdh = new RoundedLabel(" Passwort wiederholen: ");
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
                parentFrame.getContentPane().removeAll();
                parentFrame.getContentPane().add(new WelcomePage(kundenverwaltung).getMainPanel());
                parentFrame.revalidate();
                parentFrame.repaint();
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
                    new String(txtPasswort.getPassword()),
                    kundenverwaltung // Pass the Kundenverwaltung instance
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
}
