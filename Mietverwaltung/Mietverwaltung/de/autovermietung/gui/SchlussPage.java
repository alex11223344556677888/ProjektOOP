package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SchlussPage extends JPanel {
    private static final long serialVersionUID = 1L;
    private JPanel mainPanel;

    public SchlussPage() {
        mainPanel = new BackgroundPanel("bilder/DFF4179E-6663-4C59-9991-ACE68B2C9392.jpeg");
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.CENTER;

        // Label for the thank you message
        JLabel lblThankYou = new RoundedLabel(" Vielen Dank für Ihre Bestellung ");
        lblThankYou.setFont(new Font("Arial", Font.BOLD, 24));
        lblThankYou.setBackground(Color.WHITE);
        lblThankYou.setForeground(Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        mainPanel.add(lblThankYou, gbc);

        // Button to close the application
        JButton btnBeenden = new JButton("Beenden");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        mainPanel.add(btnBeenden, gbc);

        // Set layout and add main panel to this panel
        setLayout(new BorderLayout());
        add(mainPanel, BorderLayout.CENTER);

        // Add action listener for the Beenden button
        btnBeenden.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(mainPanel);
                parentFrame.getContentPane().removeAll();
                parentFrame.getContentPane().add(new WelcomePage().getMainPanel());
                parentFrame.revalidate();
                parentFrame.repaint();
            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
