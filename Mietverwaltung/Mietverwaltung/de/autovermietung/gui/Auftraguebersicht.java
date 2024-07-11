package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Auftraguebersicht extends JPanel {
    private static final long serialVersionUID = 1L;

    private JPanel mainPanel;
    private JList<String> list;
    private DefaultListModel<String> listModel;
    private JButton btnZurueck, btnNeuesAutoMieten;

    public Auftraguebersicht() {
        mainPanel = new BackgroundPanel("bilder/DFF4179E-6663-4C59-9991-ACE68B2C9392.jpeg"); // Update with the correct path to your image
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.CENTER;

        // Header label
        JLabel lblHeader = new JLabel("Buchungsverlauf");
        lblHeader.setFont(new Font("Arial", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        mainPanel.add(lblHeader, gbc);

        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;

        // Create the list model and populate it
        listModel = new DefaultListModel<>();
        listModel.addElement("<html> ---Modell---- <br/> ---Buchungszeitraum---- <br/> ----Abgeschlossen---- <br/>------</html>");
        listModel.addElement("<html>----Modell---- <br/>----Buchungszeitraum---- <br/> ----Offen---- <br/>------</html>");
        listModel.addElement("Element 3");
        listModel.addElement("Element 4");

        // Create the JList with the list model
        list = new JList<>(listModel);
        list.setCellRenderer(new CustomListCellRenderer());
        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setPreferredSize(new Dimension(300, 200));

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        mainPanel.add(scrollPane, gbc);

        // Create buttons
        btnZurueck = new JButton("Zurück");
        btnNeuesAutoMieten = new JButton("Neues Auto mieten");

        // Add buttons to the panel
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(btnZurueck, gbc);

        gbc.gridx = 1;
        mainPanel.add(btnNeuesAutoMieten, gbc);

        // Set layout and add main panel to this panel
        setLayout(new BorderLayout());
        add(mainPanel, BorderLayout.CENTER);

        // Add action listeners for buttons
        btnZurueck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement the action for the Zurück button
                JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(mainPanel);
                parentFrame.getContentPane().removeAll();
                parentFrame.getContentPane().add(new LoginPage().getMainPanel());
                parentFrame.revalidate();
                parentFrame.repaint();
            }
        });
    }

    static class CustomListCellRenderer extends DefaultListCellRenderer {
        private static final long serialVersionUID = 1L;

        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            Component component = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

            String text = value.toString();
            if (text.contains("Abgeschlossen")) {
                component.setBackground(Color.RED);
            } else if (text.contains("Offen")) {
                component.setBackground(Color.GREEN);
            } else {
                component.setBackground(Color.WHITE);
            }

            if (isSelected) {
                component.setBackground(component.getBackground().darker());
            }

            return component;
        }
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    // Assuming BackgroundPanel is a custom class extending JPanel and handling background image
    /*static class BackgroundPanel extends JPanel {
        private static final long serialVersionUID = 1L;
		private Image backgroundImage;

        public BackgroundPanel(String fileName) {
            try {
                backgroundImage = new ImageIcon(fileName).getImage();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (backgroundImage != null) {
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }*/
}


