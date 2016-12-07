package custom.components;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by di on 06.12.16.
 */
public class ImagePanel extends JPanel implements MouseListener{

    private boolean isShowCloseIcon = false;

    public File getImage() {
        return image;
    }

    public void setImage(File image) {
        this.image = image;
        this.repaint();
    }

    File image;

    public ImagePanel() {
        this.setLayout(new BorderLayout());
        this.addMouseListener(this);
    }

    public ImagePanel(File image)
    {
        this.addMouseListener(this);
        this.image = image;
    }

    private BufferedImage convertFileToImage()
    {
        BufferedImage img = null;
        try {
            if(image != null && image.exists()) {
                img = ImageIO.read(image);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return img;
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        BufferedImage img = convertFileToImage();
        g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);

        if (isShowCloseIcon) {
            CloseButton closeButton = new CloseButton(this.getWidth() - 25, 5, 20, 20);
            this.add(closeButton, BorderLayout.CENTER);
        }
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
        isShowCloseIcon = true;
        repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        isShowCloseIcon = false;
        repaint();
    }
}
