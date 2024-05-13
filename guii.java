import javax.swing.*; //jshdkdakdjpo
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//jsdjdnsjndksand
public class guii extends JFrame {

    public guii() {
        // Fenstertitel setzen
        super("GUI Beispiel");

        // Größe des Fensters festlegen
        setSize(300, 200);

        // Layout-Manager für das Fenster festlegen
        setLayout(new FlowLayout());

        // Button erstellen
        JButton button = new JButton("Klick mich!");
        JButton button2 = new JButton("wähle aus");

        JTextField textfield = new JTextField(20);
        add(textfield);
        

        // ActionListener für den Button hinzufügen
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aktion ausführen, wenn der Button geklickt wird
                //System.out.println("Hallo");
                JButton button2 = new JButton("wähle aus");
                add(button2);
                remove(button);
                revalidate();
                
                

            }
        });
         

        
           
        

        
        

    




        // Button zum Fenster hinzufügen
        add(button);

        // Fenster sichtbar machen
        setVisible(true);

        // Programm beenden, wenn das Fenster geschlossen wird
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        guii gui = new guii();
    }
}

