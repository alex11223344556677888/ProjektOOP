package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class KalenderPage extends JPanel {
    private static final long serialVersionUID = 1L;

    private JPanel mainPanel;
    private JSpinner spinnerVonDatum, spinnerBisDatum;
    private JPanel previousPage;

    public KalenderPage() {
    	//this.previousPage = previousPage;
        mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        // Header label
        JLabel lblHeader = new JLabel("Gib das Von- und Bis-Datum ein");
        lblHeader.setFont(new Font("Arial", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(lblHeader, gbc);
        
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;

        // Labels and spinners for the form
        JLabel lblVonDatum = new JLabel("Von Datum:");
        spinnerVonDatum = createSpinner();
        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(lblVonDatum, gbc);
        gbc.gridx = 1;
        mainPanel.add(spinnerVonDatum, gbc);

        JLabel lblBisDatum = new JLabel("Bis Datum:");
        spinnerBisDatum = createSpinner();
        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(lblBisDatum, gbc);
        gbc.gridx = 1;
        mainPanel.add(spinnerBisDatum, gbc);

        // Buttons
        /*JButton btnweiter = new JButton("Weiter");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(btnweiter, gbc);*/
        
        JButton btnZurueck = new JButton("Zurück");
        JButton btnweiter1 = new JButton("Speichern");
        gbc.gridx = 0;
        gbc.gridy = 14;
        mainPanel.add(btnZurueck, gbc);
        gbc.gridx = 1;
        mainPanel.add(btnweiter1, gbc);
        gbc.gridx = 2;

        // Add action listener for the Save button
        btnweiter1.addActionListener(e -> {
            // Get the dates
            Date vonDatum = (Date) spinnerVonDatum.getValue();
            Date bisDatum = (Date) spinnerBisDatum.getValue();
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            System.out.println("Von Datum: " + sdf.format(vonDatum));
            System.out.println("Bis Datum: " + sdf.format(bisDatum));
            
            JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(mainPanel);
            parentFrame.getContentPane().removeAll();
            parentFrame.getContentPane().add(new FilterPage().getMainPanel());
            parentFrame.revalidate();
            parentFrame.repaint();
        });
        
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
        
        
    }

    

	private JSpinner createSpinner() {
        JSpinner spinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor editor = new JSpinner.DateEditor(spinner, "dd.MM.yyyy");
        spinner.setEditor(editor);
        return spinner;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}


