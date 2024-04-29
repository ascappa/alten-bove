package com.alten.shape;

import javax.swing.*;
import java.awt.*;

public class Rectangle extends JComponent {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g.drawRect(30, 50, 70, 90);
    }
}
