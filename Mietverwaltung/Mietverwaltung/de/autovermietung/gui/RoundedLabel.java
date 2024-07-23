package Gui;

import javax.swing.*;
import java.awt.*;

public class RoundedLabel extends JLabel {
    private static final long serialVersionUID = 1L;
    private Color backgroundColor;
    private int cornerRadius = 10;

    public RoundedLabel(String text) {
        super(text);
        setOpaque(false);
        this.backgroundColor = Color.WHITE;
    }

    public RoundedLabel(String text, int radius) {
        super(text);
        setOpaque(false);
        this.backgroundColor = Color.WHITE;
        this.cornerRadius = radius;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(backgroundColor);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);
        g2.setColor(getForeground());
        super.paintComponent(g2);
        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getForeground());
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, cornerRadius, cornerRadius);
        g2.dispose();
    }

    @Override
    public void setBackground(Color bg) {
        this.backgroundColor = bg;
    }
} 
    
  

