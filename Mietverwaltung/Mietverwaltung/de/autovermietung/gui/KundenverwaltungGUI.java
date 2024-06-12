import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KundenverwaltungGUI {
    private Kundenverwaltung kv;
    private JFrame frame;
    private JTextField vornameField;
    private JTextField nameField;
    private JTextField geburtsdatumField;
    private JTextField alterField;
    private JTextField telefonnummerField;
    private JComboBox<String> fuehrerscheinklasseComboBox;
    private JTextField emailField;
    private JTextField zahlungsmittelField;
    private JTextField historieField;
    private JTextField strasseField;
    private JTextField hausnummerField;
    private JTextField postleitzahlField;
    private JTextField ortField;
    private JCheckBox kundenkarteCheckBox;
    private JTextField fuehrerscheinzeitraumField;

    public KundenverwaltungGUI(Kundenverwaltung kv) {
        this.kv = kv;
        createGUI();
    }

    private void createGUI() {
        frame = new JFrame("Kundenverwaltung");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2));

        panel.add(new JLabel("Vorname:"));
        vornameField = new JTextField();
        panel.add(vornameField);

        panel.add(new JLabel("Name:"));
        nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("Geburtsdatum (DD.MM.YYYY):"));
        geburtsdatumField = new JTextField();
        panel.add(geburtsdatumField);

        panel.add(new JLabel("Alter:"));
        alterField = new JTextField();
        panel.add(alterField);

        panel.add(new JLabel("Telefonnummer:"));
        telefonnummerField = new JTextField();
        panel.add(telefonnummerField);

        panel.add(new JLabel("Führerscheinklasse:"));
        String[] fuehrerscheinklassen = {"B", "BF17", "BE"};
        fuehrerscheinklasseComboBox = new JComboBox<>(fuehrerscheinklassen);
        panel.add(fuehrerscheinklasseComboBox);

        panel.add(new JLabel("E-Mail:"));
        emailField = new JTextField();
        panel.add(emailField);

        panel.add(new JLabel("Zahlungsmittel:"));
        zahlungsmittelField = new JTextField();
        panel.add(zahlungsmittelField);

        panel.add(new JLabel("Historie:"));
        historieField = new JTextField();
        panel.add(historieField);

        panel.add(new JLabel("Strasse:"));
        strasseField = new JTextField();
        panel.add(strasseField);

        panel.add(new JLabel("Hausnummer:"));
        hausnummerField = new JTextField();
        panel.add(hausnummerField);

        panel.add(new JLabel("Postleitzahl:"));
        postleitzahlField = new JTextField();
        panel.add(postleitzahlField);

        panel.add(new JLabel("Ort:"));
        ortField = new JTextField();
        panel.add(ortField);

        panel.add(new JLabel("Kundenkarte:"));
        kundenkarteCheckBox = new JCheckBox();
        panel.add(kundenkarteCheckBox);

        panel.add(new JLabel("Führerscheinzeitraum (in Jahren):"));
        fuehrerscheinzeitraumField = new JTextField();
        panel.add(fuehrerscheinzeitraumField);

        JButton addButton = new JButton("Kunden hinzufügen");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addKunde();
            }
        });
        panel.add(addButton);

        frame.add(panel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }

    private void addKunde() {
        String vorname = vornameField.getText();
        String name = nameField.getText();
        String geburtsdatum = geburtsdatumField.getText();
        int alter = Integer.parseInt(alterField.getText());
        int telefonnummer = Integer.parseInt(telefonnummerField.getText());
        String fuehrerscheinklasse = (String) fuehrerscheinklasseComboBox.getSelectedItem();
        String email = emailField.getText();
        String zahlungsmittel = zahlungsmittelField.getText();
        String historie = historieField.getText();
        String strasse = strasseField.getText();
        int hausnummer = Integer.parseInt(hausnummerField.getText());
        int postleitzahl = Integer.parseInt(postleitzahlField.getText());
        String ort = ortField.getText();
        boolean kundenkarte = kundenkarteCheckBox.isSelected();
        int fuehrerscheinzeitraum = Integer.parseInt(fuehrerscheinzeitraumField.getText());
    }
}
