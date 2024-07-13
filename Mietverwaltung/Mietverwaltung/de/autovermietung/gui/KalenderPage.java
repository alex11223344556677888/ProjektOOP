package Gui;

import de.autovermietung.verwaltungsklassen.TerminVerwaltung;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class KalenderPage extends JPanel {
    private static final long serialVersionUID = 1L;

    private JPanel mainPanel;
    private JSpinner spinnerVonDatum, spinnerBisDatum;
    private TerminVerwaltung terminVerwaltung;

    public KalenderPage() {
        this.terminVerwaltung = new TerminVerwaltung(); // Backend-Instanz erstellen
        mainPanel = new BackgroundPanel("DFF4179E-6663-4C59-9991-ACE68B2C9392.jpeg"); // Update with the correct path to your image
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        // Header label
        JLabel lblHeader = new RoundedLabel(" Gib das Von- und Bis-Datum ein ");
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

        // Labels and spinners for the form
        JLabel lblVonDatum = new RoundedLabel(" Von Datum: ");
        spinnerVonDatum = createSpinner();
        gbc.gridx = 0;
        gbc.gridy = 1;
        lblHeader.setBackground(Color.WHITE);
        lblHeader.setForeground(Color.BLACK);
        mainPanel.add(lblVonDatum, gbc);
        gbc.gridx = 1;
        mainPanel.add(spinnerVonDatum, gbc);

        JLabel lblBisDatum = new RoundedLabel(" Bis Datum: ");
        spinnerBisDatum = createSpinner();
        gbc.gridx = 0;
        gbc.gridy = 2;
        lblHeader.setBackground(Color.WHITE);
        lblHeader.setForeground(Color.BLACK);
        mainPanel.add(lblBisDatum, gbc);
        gbc.gridx = 1;
        mainPanel.add(spinnerBisDatum, gbc);

        // Buttons
        JButton btnZurueck = new JButton("Zurück");
        JButton btnSpeichern = new JButton("Speichern");
        gbc.gridx = 0;
        gbc.gridy = 14;
        mainPanel.add(btnZurueck, gbc);
        gbc.gridx = 1;
        mainPanel.add(btnSpeichern, gbc);
        gbc.gridx = 2;

        // Add action listener for the Save button
        btnSpeichern.addActionListener(e -> speichereDatumUndPruefeVerfuegbarkeit());
        
        // Add action listener for the Back button
        btnZurueck.addActionListener(e -> {
            JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(mainPanel);
            parentFrame.getContentPane().removeAll();
            parentFrame.getContentPane().add(new RegistrierenPage().getMainPanel());
            parentFrame.revalidate();
            parentFrame.repaint();
        });
    }

    private JSpinner createSpinner() {
        JSpinner spinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor editor = new JSpinner.DateEditor(spinner, "dd.MM.yyyy");
        spinner.setEditor(editor);
        return spinner;
    }

    private void speichereDatumUndPruefeVerfuegbarkeit() {
        // Get the dates from the spinners
        Date vonDatum = (Date) spinnerVonDatum.getValue();
        Date bisDatum = (Date) spinnerBisDatum.getValue();
        LocalDate vonLocalDate = vonDatum.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate bisLocalDate = bisDatum.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        // Extract day, month, and year
        int startTag = vonLocalDate.getDayOfMonth();
        int startMonat = vonLocalDate.getMonthValue();
        int startJahr = vonLocalDate.getYear();
        int endeTag = bisLocalDate.getDayOfMonth();
        int endeMonat = bisLocalDate.getMonthValue();
        int endeJahr = bisLocalDate.getYear();

        // Call the method from TerminVerwaltung
        terminVerwaltung.pruefeBuchungsZeitraumPKWListe(startTag, startMonat, startJahr, endeTag, endeMonat, endeJahr);

        // Refresh the GUI or show a confirmation
        JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(mainPanel);
        parentFrame.getContentPane().removeAll();
        parentFrame.getContentPane().add(new FilterPage(startTag, startMonat, startJahr, endeTag, endeMonat, endeJahr).getMainPanel());
        parentFrame.revalidate();
        parentFrame.repaint();
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}


