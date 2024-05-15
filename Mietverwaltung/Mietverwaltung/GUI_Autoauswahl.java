import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class GUI_Autoauswahl {
    private JFrame frame;
    private JLabel imageLabel;

    public testgui2() {
        // Create a new JFrame (window)
        frame = new JFrame("My GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the size of the window
        frame.setSize(1920, 1080);

        // Create a JPanel to hold the content
        JPanel panel = new JPanel();
        panel.setLayout(null); // Use null layout to set the coordinates manually

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
         panel.add(inTextLableSort);
 
         panel.add(carSortFilter);
 ;

        // Load the image
        File imageFile = new File("OOP_AutoImg.jpg"); // Replace with the path to your image file
        Image image = null;
        try {
            image = ImageIO.read(imageFile);
        } catch (IOException e) {
            System.out.println("Error reading image file: " + e.getMessage());
        }

        // Create a JLabel with the image
        imageLabel = new JLabel(new ImageIcon(image));
        imageLabel.setLocation(50, 360); // Set the x and y coordinates
        imageLabel.setSize(250, 250); // Set the width and height
        panel.add(imageLabel);

        // Add a background image
        ImageIcon backgroundImage = new ImageIcon("oop_background_vermietung.png");
        JLabel backgroundImageLabel = new JLabel(backgroundImage);
        backgroundImageLabel.setBounds(0, 0, 1920, 1080); // Set the bounds of the label to cover the entire frame
        panel.add(backgroundImageLabel); // Add the label to the panel

        // Add the panel to the frame
        frame.getContentPane().add(panel);

        // Add a listener to the JComboBox
        carFilter.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                String selectedCarType = (String) e.getItem();
                System.out.println("Selected car type: " + selectedCarType);
                // Add your logic here

                // Hide the initial text label when an item is selected
                initialTextLabel.setVisible(false);
            }
        });

        // Center the window on the screen
        frame.setLocationRelativeTo(null);

        // Make the window visible
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        testgui2 gui = new testgui2();
    }
}
