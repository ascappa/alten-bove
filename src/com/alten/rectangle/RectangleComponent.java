package com.alten.rectangle;

import javax.swing.*;
import java.awt.*;

public class RectangleComponent extends JComponent {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        Rectangle box = new Rectangle(45, 56, 50, 50);
        g2.draw(box);
    }
}
