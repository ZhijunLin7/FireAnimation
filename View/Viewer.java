package View;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

public class Viewer extends JPanel {

    // Atributos
    private BufferedImage image;

    // Constructor
    public Viewer(BufferedImage image) {
        try {
            this.image = ImageIO.read(new File("View\\bg.jpg"));
        } catch (Exception e) {
            // TODO: handle exception
        }
        
    }

    // Metodos
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }



    // Getter y Setter
    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public void add(BufferedImage bufferedImage) {
    }

}
