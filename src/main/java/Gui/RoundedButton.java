package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RoundedButton extends JButton {

    private int cornerRadius;
    private boolean mouseOver = false;
    private boolean mousePressed = false;

    public RoundedButton(String text, int radius) {
        super(text);
        this.cornerRadius = radius;
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setOpaque(false);
        setBackground(new Color(186, 186, 186)); // Change font color to red
        setForeground(new Color(57, 62, 69));
        setPreferredSize(new Dimension(180, 120));
        setFont(new Font("Arial", Font.PLAIN, 48)); // Using bold font with size 36

        // Add mouse listeners to change state on hover and press
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                mouseOver = true;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                mouseOver = false;
                repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                mousePressed = true;
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                mousePressed = false;
                repaint();
            }
        });
    }

    public void styleCheckButton() {
        this.setForeground(new Color(52, 24, 73));
        this.setFont(new Font("Arial", Font.BOLD, 36));
    }

    public void setFontSize(int fontSize) {
        this.setFont(new Font("Arial", Font.BOLD, fontSize));
    }


    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Background color based on state
        if (mousePressed) {
            g2.setColor(new Color(150, 150, 150));
        } else if (mouseOver) {
            g2.setColor(new Color(200, 200, 200));
        } else {
            g2.setColor(new Color(186, 186, 186));
        }

        g2.fillRoundRect(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);
        super.paintComponent(g2);
        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(2));
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, cornerRadius, cornerRadius);
        g2.dispose();
    }

    @Override
    public Insets getInsets() {
        return new Insets(cornerRadius / 2, cornerRadius / 2, cornerRadius / 2, cornerRadius / 2);
    }
}
