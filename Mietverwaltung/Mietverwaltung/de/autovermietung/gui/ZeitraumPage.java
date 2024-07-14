package Gui;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ZeitraumPage {
    private JFrame frame;
    private JPanel panel;
    private JLabel label;
    private JSpinner vonSpinner;
    private JSpinner bisSpinner;

    public ZeitraumPage(JFrame frame) {
    	         this.frame = frame;
    	         initialize();
        }

    private void initialize() {
    	frame.getContentPane().removeAll();
        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        label = new JLabel("Wähle einen Zeitraum aus");
        label.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(label, BorderLayout.NORTH);

        vonSpinner = new JSpinner(new SpinnerDateModel());
        vonSpinner.setEditor(new JSpinner.DateEditor(vonSpinner, "dd.MM.yyyy"));
        vonSpinner.setValue(LocalDate.now());

        bisSpinner = new JSpinner(new SpinnerDateModel());
        bisSpinner.setEditor(new JSpinner.DateEditor(bisSpinner, "dd.MM.yyyy"));
        bisSpinner.setValue(LocalDate.now());

        JPanel datePanel = new JPanel();
        datePanel.setLayout(new GridLayout(1, 2));
        datePanel.add(new JLabel("Von:"));
        datePanel.add(vonSpinner);
        datePanel.add(new JLabel("Bis:"));
        datePanel.add(bisSpinner);

        panel.add(datePanel, BorderLayout.CENTER);

        frame.getContentPane().add(panel);
        frame.revalidate();
        frame.repaint();
    }

    public LocalDate getVonDate() {
        return ((SpinnerDateModel) vonSpinner.getModel()).getDate().toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
    }

    public LocalDate getBisDate() {
        return ((SpinnerDateModel) bisSpinner.getModel()).getDate().toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
    }

	public JFrame getFrame() {
       return frame;
   }

	public Component getPanel() {

		return panel;
	}}
