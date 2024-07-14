package Gui;

import javax.swing.*;
import Verwaltungsklassen.Kundenverwaltung;

public class MainApplication {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Kundenverwaltung kundenverwaltung = new Kundenverwaltung();
            JFrame frame = new JFrame("Welcome Page");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame.getContentPane().add(new WelcomePage(kundenverwaltung).getMainPanel()); // Pass kundenverwaltung
            frame.pack();
            frame.setVisible(true);
        });
    }
}


/**
public class MainApplication {
	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(() -> new WelcomePage());
	    }
	} */

