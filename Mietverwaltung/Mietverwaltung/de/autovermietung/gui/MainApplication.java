package Gui;

import javax.swing.*;


public class MainApplication {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Welcome Page");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame.getContentPane().add(new WelcomePage().getMainPanel());
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

