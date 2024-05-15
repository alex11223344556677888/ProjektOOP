import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;

public class GUI_Autoauswahl.java {
    public static void main(String[] args) {
        // JFrame erstellen
        JFrame frame = new JFrame("My GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Allgemeine Größe des JFrames
        frame.setSize(1920, 1080);

        // JPanel 
        JPanel panel = new JPanel();
        panel.setLayout(null); // Standart Layout

        // Combobox Einstellungen
        String[] carTypes = {"Alle","Kleinwagen", "SUV", "Coupe", "Cabrio", "Limousine", "Kombi"};
        JComboBox<String> carFilter = new JComboBox<>(carTypes);
        carFilter.setLocation(100, 100); 
        carFilter.setSize(300, 60); 
        carFilter.setBackground(Color.black);
        carFilter.setForeground(Color.white);
        carFilter.setSelectedItem("Wähle einen Autotyp aus");
        carFilter.setFont(new Font(null, 0, 18));
        
        
        JLabel initialTextLabel = new JLabel("Wähle einen Autotyp aus");
        initialTextLabel.setLocation(100, 50); 
        initialTextLabel.setSize(300, 60); 
        initialTextLabel.setVisible(true); 
        initialTextLabel.setFont( new Font(null, Font.BOLD, 20));
        panel.add(initialTextLabel);
        

        // Combobox zum Panel hinzufügen
        panel.add(carFilter);

        //Combobox für den Sortierfilter

        String[] carSort = {"Preis niedrig - hoch" , "Preis hoch - niedrig"};
        JComboBox<String> carSortFilter = new JComboBox<>(carSort);
        carSortFilter.setLocation(600, 100); 
        carSortFilter.setSize(300, 60); 
        carSortFilter.setBackground(Color.black);
        carSortFilter.setForeground(Color.white);
        carSortFilter.setSelectedItem("Wähle einen Autotyp aus");
        carSortFilter.setFont(new Font(null, 0, 18));
        

        JLabel inTextLableSort = new JLabel("Sortierfilter");
        inTextLableSort.setLocation(600, 50); 
        inTextLableSort.setSize(300, 60); 
        inTextLableSort.setVisible(true); 
        inTextLableSort.setFont( new Font(null, Font.BOLD, 20));
        panel.add( inTextLableSort);

        panel.add(carSortFilter);

        // Hintergrundbild einfügen
        ImageIcon backgroundImage = new ImageIcon("oop_background_vermietung.png");
        JLabel backgroundImageLabel = new JLabel(backgroundImage);
        backgroundImageLabel.setBounds(0, 0, 1920, 1080); 
        panel.add(backgroundImageLabel); 

        // Frame zum Panel hinzufpgen
        frame.getContentPane().add(panel);

        // Listener (gibt die Auswahl in Konsole aus)
        carFilter.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                String selectedCarType = (String) e.getItem();
                System.out.println("Selected car type: " + selectedCarType);
                // Add your logic here
            }
        });

        // Fenster mittig 
        frame.setLocationRelativeTo(null);

        // Fenster sichrbar
        frame.setVisible(true);
    }
}
