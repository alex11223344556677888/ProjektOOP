package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ZusammenfassungPage extends JPanel {
    private static final long serialVersionUID = 1L;

    private JPanel mainPanel;
    private JTextField txtVorname, txtName, txtGeburtsdatum, txtAlter, txtTelefonnummer, txtEmail, txtStrasse, txtNr, txtOrt, txtPLZ, txtFuehrerscheinzeit;
    private JRadioButton rdbJa, rdbNein;
    private JComboBox<String> cmbFuehrerscheinklasse;
    private JPasswordField txtPasswort, txtPasswortWdh;

    public ZusammenfassungPage(String vorname, String name, String geburtsdatum, String alter,
                               String telefonnummer, String email, String strasse, String nr,
                               String ort, String plz, String kundenkarte, String fuehrerscheinzeit,
                               String fuehrerscheinklasse, String passwort) {
    	mainPanel = new BackgroundPanel("bilder/DFF4179E-6663-4C59-9991-ACE68B2C9392.jpeg"); // Update with the correct path to your image
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        // Header label
        JLabel lblHeader = new RoundedLabel(" Zusammenfassung deiner Eingaben ");
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
        txtVorname = new JTextField(vorname, 15);
        txtVorname.setEditable(true);
        gbc.gridx = 0;
        gbc.gridy = 1;
        lblHeader.setBackground(Color.WHITE);
        lblHeader.setForeground(Color.BLACK);
        mainPanel.add(lblVorname, gbc);
        gbc.gridx = 1;
        mainPanel.add(txtVorname, gbc);

        JLabel lblName = new RoundedLabel(" Name: ");
        txtName = new JTextField(name, 15);
        txtName.setEditable(true);
        gbc.gridx = 0;
        gbc.gridy = 2;
        lblHeader.setBackground(Color.WHITE);
        lblHeader.setForeground(Color.BLACK);
        mainPanel.add(lblName, gbc);
        gbc.gridx = 1;
        mainPanel.add(txtName, gbc);

        JLabel lblGeburtsdatum = new RoundedLabel(" Geburtsdatum: ");
        txtGeburtsdatum = new JTextField(geburtsdatum, 15);
        txtGeburtsdatum.setEditable(true);
        gbc.gridx = 0;
        gbc.gridy = 3;
        lblHeader.setBackground(Color.WHITE);
        lblHeader.setForeground(Color.BLACK);
        mainPanel.add(lblGeburtsdatum, gbc);
        gbc.gridx = 1;
        mainPanel.add(txtGeburtsdatum, gbc);

        JLabel lblAlter = new RoundedLabel(" Alter: ");
        txtAlter = new JTextField(alter, 15);
        txtAlter.setEditable(true);
        gbc.gridx = 0;
        gbc.gridy = 4;
        lblHeader.setBackground(Color.WHITE);
        lblHeader.setForeground(Color.BLACK);
        mainPanel.add(lblAlter, gbc);
        gbc.gridx = 1;
        mainPanel.add(txtAlter, gbc);

        JLabel lblTelefonnummer = new RoundedLabel(" Telefonnummer: ");
        txtTelefonnummer = new JTextField(telefonnummer, 15);
        txtTelefonnummer.setEditable(true);
        gbc.gridx = 0;
        gbc.gridy = 5;
        lblHeader.setBackground(Color.WHITE);
        lblHeader.setForeground(Color.BLACK);
        mainPanel.add(lblTelefonnummer, gbc);
        gbc.gridx = 1;
        mainPanel.add(txtTelefonnummer, gbc);

        JLabel lblEmail = new RoundedLabel(" Email: ");
        txtEmail = new JTextField(email, 15);
        txtEmail.setEditable(true);
        gbc.gridx = 0;
        gbc.gridy = 6;
        lblHeader.setBackground(Color.WHITE);
        lblHeader.setForeground(Color.BLACK);
        mainPanel.add(lblEmail, gbc);
        gbc.gridx = 1;
        mainPanel.add(txtEmail, gbc);

        JLabel lblStrasse = new RoundedLabel(" Straße: ");
        txtStrasse = new JTextField(strasse, 15);
        txtStrasse.setEditable(true);
        gbc.gridx = 0;
        gbc.gridy = 7;
        lblHeader.setBackground(Color.WHITE);
        lblHeader.setForeground(Color.BLACK);
        mainPanel.add(lblStrasse, gbc);
        gbc.gridx = 1;
        mainPanel.add(txtStrasse, gbc);

        JLabel lblNr = new RoundedLabel(" Nr.: ");
        txtNr = new JTextField(nr, 5);
        txtNr.setEditable(true);
        gbc.gridx = 2;
        lblHeader.setBackground(Color.WHITE);
        lblHeader.setForeground(Color.BLACK);
        mainPanel.add(lblNr, gbc);
        gbc.gridx = 3;
        mainPanel.add(txtNr, gbc);

        JLabel lblOrt = new RoundedLabel(" Ort: ");
        txtOrt = new JTextField(ort, 15);
        txtOrt.setEditable(true);
        gbc.gridx = 0;
        gbc.gridy = 8;
        lblHeader.setBackground(Color.WHITE);
        lblHeader.setForeground(Color.BLACK);
        mainPanel.add(lblOrt, gbc);
        gbc.gridx = 1;
        mainPanel.add(txtOrt, gbc);

        JLabel lblPLZ = new RoundedLabel(" PLZ: ");
        txtPLZ = new JTextField(plz, 5);
        txtPLZ.setEditable(true);
        gbc.gridx = 2;
        lblHeader.setBackground(Color.WHITE);
        lblHeader.setForeground(Color.BLACK);
        mainPanel.add(lblPLZ, gbc);
        gbc.gridx = 3;
        mainPanel.add(txtPLZ, gbc);

        JLabel lblKundenkarte = new RoundedLabel(" Kundenkarte: ");
        JTextField txtKundenkarte = new JTextField(kundenkarte, 15);
        txtKundenkarte.setEditable(true);
        gbc.gridx = 0;
        gbc.gridy = 9;
        lblHeader.setBackground(Color.WHITE);
        lblHeader.setForeground(Color.BLACK);
        mainPanel.add(lblKundenkarte, gbc);
        gbc.gridx = 1;
        mainPanel.add(txtKundenkarte, gbc);

        JLabel lblFuehrerscheinzeit = new RoundedLabel(" Führerscheinzeit: ");
        txtFuehrerscheinzeit = new JTextField(fuehrerscheinzeit, 15);
        txtFuehrerscheinzeit.setEditable(true);
        gbc.gridx = 0;
        gbc.gridy = 10;
        lblHeader.setBackground(Color.WHITE);
        lblHeader.setForeground(Color.BLACK);
        mainPanel.add(lblFuehrerscheinzeit, gbc);
        gbc.gridx = 1;
        mainPanel.add(txtFuehrerscheinzeit, gbc);

        JLabel lblFuehrerscheinklasse = new RoundedLabel(" Führerscheinklasse: ");
        JTextField txtFuehrerscheinklasse = new JTextField(fuehrerscheinklasse, 15);
        txtFuehrerscheinklasse.setEditable(true);
        gbc.gridx = 0;
        gbc.gridy = 11;
        lblHeader.setBackground(Color.WHITE);
        lblHeader.setForeground(Color.BLACK);
        mainPanel.add(lblFuehrerscheinklasse, gbc);
        gbc.gridx = 1;
        mainPanel.add(txtFuehrerscheinklasse, gbc);

        JLabel lblPasswort = new RoundedLabel(" Passwort: ");
        JTextField txtPasswort = new JTextField(passwort, 15);
        txtPasswort.setEditable(true);
        gbc.gridx = 0;
        gbc.gridy = 12;
        lblHeader.setBackground(Color.WHITE);
        lblHeader.setForeground(Color.BLACK);
        mainPanel.add(lblPasswort, gbc);
        gbc.gridx = 1;
        mainPanel.add(txtPasswort, gbc);

        // Buttons
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
                parentFrame.getContentPane().add(new RegistrierenPage().getMainPanel());
                parentFrame.revalidate();
                parentFrame.repaint();
            }
        });
        /*btnSpeichern.addActionListener(e -> {
            JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(mainPanel);
            parentFrame.getContentPane().removeAll();
            //parentFrame.getContentPane().add(new KalenderPage(this).getMainPanel());
            KalenderPage kalenderPage = new KalenderPage(this);
            parentFrame.revalidate();
            parentFrame.repaint();
        });*/
     // In ZusammenfassenPage class
        //JButton btnKalender = new JButton("Kalender");
     // Add action listener for the Save button
        btnSpeichern.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(mainPanel);
                parentFrame.getContentPane().removeAll();
                parentFrame.getContentPane().add(new KalenderPage().getMainPanel());
                parentFrame.revalidate();
                parentFrame.repaint();
            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}





