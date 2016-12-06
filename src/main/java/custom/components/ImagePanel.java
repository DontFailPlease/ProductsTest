package custom.components;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by di on 06.12.16.
 */
public class ImagePanel extends JPanel {

    public File getImage() {
        return image;
    }

    public void setImage(File image) {
        this.image = image;
    }

    File image;

    public ImagePanel() { }

    public ImagePanel(File image)
    {
        this.image = image;
    }

    private BufferedImage convertFileToImage()
    {
        BufferedImage img = null;
        try {
            img = ImageIO.read(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally
        {
            return img;
        }
    }

    @Override
    public void paintComponent(Graphics g)
    {
        BufferedImage img = convertFileToImage();
        g.drawImage(img, 0, 0 , this.getWidth(), this.getHeight(), this);
    }
}
