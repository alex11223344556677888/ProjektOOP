package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomePage extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel mainPanel;

    public WelcomePage() {
        //setTitle("Herzlich Willkommen bei der Autovermietung");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;

        // Header label
        JLabel lblWelcome = new JLabel("Herzlich Willkommen bei der Autovermietung");
        lblWelcome.setFont(new Font("Arial", Font.BOLD, 36));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        mainPanel.add(lblWelcome, gbc);

        // Sub-header label
        JLabel lblPrompt = new JLabel("Möchten sie sich anmelden oder registrieren?");
        lblPrompt.setFont(new Font("Arial", Font.PLAIN, 24));
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        mainPanel.add(lblPrompt, gbc);

        // Login button
        JButton btnLogin = new JButton("Anmelden");
        btnLogin.setFont(new Font("Arial", Font.PLAIN, 18));
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        mainPanel.add(btnLogin, gbc);

        // Register button
        JButton btnRegister = new JButton("Registrieren");
        btnRegister.setFont(new Font("Arial", Font.PLAIN, 18));
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        mainPanel.add(btnRegister, gbc);
        
        // ActionListener für anmeldeButton
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().removeAll();
                getContentPane().add(new LoginPage().getMainPanel());
                revalidate();
                repaint();
            }
        });

        // ActionListener for the Register button
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().removeAll();
                getContentPane().add(new RegistrierenPage().getMainPanel());
                revalidate();
                repaint();
            }
        });

        add(mainPanel);
        setVisible(true);
    }

    public  JPanel getMainPanel() {
        return mainPanel;
    }
}



