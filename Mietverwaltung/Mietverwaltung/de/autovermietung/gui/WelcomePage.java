package Gui;

import Verwaltungsklassen.Kundenverwaltung;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomePage extends JPanel {
    private static final long serialVersionUID = 1L;
    private JPanel mainPanel;
    private Kundenverwaltung kundenverwaltung;

    public WelcomePage(Kundenverwaltung kundenverwaltung) {
        if (kundenverwaltung == null) {
            throw new IllegalArgumentException("Kundenverwaltung darf nicht null sein.");
        }
        this.kundenverwaltung = kundenverwaltung;

        mainPanel = new BackgroundPanel("bilder/DFF4179E-6663-4C59-9991-ACE68B2C9392.jpeg");
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;

        // Header label
        JLabel lblWelcome = new RoundedLabel(" Herzlich Willkommen bei der Autovermietung ");
        lblWelcome.setFont(new Font("Arial", Font.BOLD, 36));
        lblWelcome.setBackground(Color.WHITE);
        lblWelcome.setForeground(Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(lblWelcome, gbc);

        // Beispiel: Anzeigen des Namens eines Kunden aus der Kundenverwaltung
        JLabel lblKundenName = new JLabel("Kundenname: " + kundenverwaltung.getKundenName(123456789)); // replace with the actual customer ID
        lblKundenName.setFont(new Font("Arial", Font.PLAIN, 18));
        gbc.gridy = 1;
        mainPanel.add(lblKundenName, gbc);

        // Sub-header label
        JLabel lblPrompt = new RoundedLabel(" Möchten Sie sich anmelden oder registrieren? ");
        lblPrompt.setFont(new Font("Arial", Font.PLAIN, 24));
        lblPrompt.setBackground(Color.WHITE);
        lblPrompt.setForeground(Color.BLACK);
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        mainPanel.add(lblPrompt, gbc);

        // Login button
        JButton btnLogin = new JButton("Anmelden");
        btnLogin.setFont(new Font("Arial", Font.PLAIN, 18));
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        mainPanel.add(btnLogin, gbc);

        // Register button
        JButton btnRegister = new JButton("Registrieren");
        btnRegister.setFont(new Font("Arial", Font.PLAIN, 18));
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        mainPanel.add(btnRegister, gbc);

        // ActionListener für Anmeldebutton
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(mainPanel);
                parentFrame.getContentPane().removeAll();
                parentFrame.getContentPane().add(new LoginPage(kundenverwaltung).getMainPanel());
                parentFrame.revalidate();
                parentFrame.repaint();
            }
        });

        // ActionListener für den Registrierungsbutton
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(mainPanel);
                parentFrame.getContentPane().removeAll();
                parentFrame.getContentPane().add(new RegistrierenPage().getMainPanel());
                parentFrame.revalidate();
                parentFrame.repaint();
            }
        });

        setLayout(new BorderLayout());
        add(mainPanel, BorderLayout.CENTER);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public static void main(String[] args) {
        // Beispiel für die Initialisierung der Kundenverwaltung
        Kundenverwaltung kundenverwaltung = new Kundenverwaltung();
        kundenverwaltung.setKundenName("Max Mustermann"); // Beispielname
    
        JFrame frame = new JFrame("Welcome Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.getContentPane().add(new WelcomePage(kundenverwaltung).getMainPanel());
        frame.pack();
        frame.setVisible(true);
    }
}
