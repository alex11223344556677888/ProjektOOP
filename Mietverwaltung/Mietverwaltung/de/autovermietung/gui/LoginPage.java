package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Verwaltungsklassen.Kundenverwaltung;
import fachklassen.Kunde;

public class LoginPage extends JPanel {
    private static final long serialVersionUID = 1L;
    private JPanel mainPanel;
    private Kundenverwaltung kundenverwaltung;

    public LoginPage(Kundenverwaltung kundenverwaltung) {
        if (kundenverwaltung == null) {
            throw new IllegalArgumentException("Kundenverwaltung darf nicht null sein.");
        }
        this.kundenverwaltung = kundenverwaltung;

        mainPanel = new BackgroundPanel("bilder/DFF4179E-6663-4C59-9991-ACE68B2C9392.jpeg"); // Update with the correct path to your image
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Header label
        JLabel lblHeader = new RoundedLabel(" Gib deine Anmeldedaten hier bitte ein ");
        lblHeader.setFont(new Font("Arial", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        lblHeader.setBackground(Color.WHITE);
        lblHeader.setForeground(Color.BLACK);
        mainPanel.add(lblHeader, gbc);
        
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;

        // Email label and text field
        JLabel lblEmail = new RoundedLabel(" E-Mail: ");
        JTextField txtEmail = new JTextField(15);
        lblEmail.setBackground(Color.WHITE);
        lblEmail.setForeground(Color.BLACK);

        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(lblEmail, gbc);
        
        gbc.gridx = 1;
        mainPanel.add(txtEmail, gbc);

        // Password label and text field
        JLabel lblPassword = new RoundedLabel(" Passwort: ");
        JPasswordField txtPassword = new JPasswordField(15);

        gbc.gridx = 0;
        gbc.gridy = 2;
        lblPassword.setBackground(Color.WHITE);
        lblPassword.setForeground(Color.BLACK);
        mainPanel.add(lblPassword, gbc);
        
        gbc.gridx = 1;
        mainPanel.add(txtPassword, gbc);

        // Buttons
        JButton btnBack = new JButton("Zurück");
        JButton btnLogin = new JButton("Anmelden");

        Dimension buttonSize = new Dimension(100, 30);
        btnBack.setPreferredSize(buttonSize);
        btnLogin.setPreferredSize(buttonSize);

        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.setOpaque(false);
        GridBagConstraints buttonGbc = new GridBagConstraints();
        buttonGbc.insets = new Insets(10, 10, 10, 10);
        
        buttonGbc.gridx = 0;
        buttonGbc.gridy = 0;
        buttonPanel.add(btnBack, buttonGbc);

        buttonGbc.gridx = 1;
        buttonPanel.add(btnLogin, buttonGbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(buttonPanel, gbc);

        // Add action listener for the Back button
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(mainPanel);
                parentFrame.getContentPane().removeAll();
                parentFrame.getContentPane().add(new WelcomePage(kundenverwaltung).getMainPanel());
                parentFrame.revalidate();
                parentFrame.repaint();
            }
        });

        // Add action listener for the Save button
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = txtEmail.getText();
                String password = new String(txtPassword.getPassword());

                // Check credentials
                Kunde kunde = kundenverwaltung.getKundeByEmail(email);
                if (kunde != null && kunde.getPasswort().equals(password)) {
                    // Credentials are correct, switch to Auftraguebersicht
                    JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(mainPanel);
                    parentFrame.getContentPane().removeAll();
                    parentFrame.getContentPane().add(new Auftraguebersicht(kundenverwaltung).getMainPanel());
                    parentFrame.revalidate();
                    parentFrame.repaint();
                } else {
                    JOptionPane.showMessageDialog(mainPanel, "E-Mail oder Passwort ist falsch.", "Fehler", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
