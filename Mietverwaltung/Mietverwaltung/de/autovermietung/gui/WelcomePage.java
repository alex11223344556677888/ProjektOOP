package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomePage extends JPanel {
    private static final long serialVersionUID = 1L;
    private JPanel mainPanel;

    public WelcomePage() {
    	 mainPanel = new BackgroundPanel( "bilder/DFF4179E-6663-4C59-9991-ACE68B2C9392.jpeg"); // Update with your image path
         mainPanel.setLayout(new GridBagLayout());
        //mainPanel = new JPanel(new GridBagLayout());
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

        // Sub-header label
        JLabel lblPrompt = new RoundedLabel(" Möchten sie sich anmelden oder registrieren? ");
        lblPrompt.setFont(new Font("Arial", Font.PLAIN, 24));
        lblPrompt.setBackground(Color.WHITE);
        lblPrompt.setForeground(Color.BLACK);
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
                JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(mainPanel);
                parentFrame.getContentPane().removeAll();
                parentFrame.getContentPane().add(new LoginPage().getMainPanel());
                parentFrame.revalidate();
                parentFrame.repaint();
            }
        });

        // ActionListener for the Register button
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
        JFrame frame = new JFrame("Welcome Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.getContentPane().add(new WelcomePage().getMainPanel());
        frame.pack();
        frame.setVisible(true);
    }
}




