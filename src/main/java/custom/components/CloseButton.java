package custom.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by di on 07.12.16.
 */
public class CloseButton extends JComponent implements MouseListener {
    public CloseButton(int x, int y, int width, int height)
    {
        super();
        this.setLocation(x, y);
        this.setSize(width, height);
        this.addMouseListener(this);
    }

    @Override
    public Dimension getPreferredSize()
    {
        return this.getSize();
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("u don't see me, but I'm here");
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
