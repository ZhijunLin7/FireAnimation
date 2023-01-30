package View;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.image.BufferStrategy;

public class Viewer extends JPanel {

    // Atributos
    private BufferedImage image;
    private BufferedImage fuegoImage;
    private BufferStrategy bf;
    
    // Constructor
    public Viewer() {
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
        g.drawImage(fuegoImage, 279, 406, this);
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

    public BufferedImage getFuegoImage() {
        return fuegoImage;
    }

    public void setFuegoImage(BufferedImage fuegoImage) {
        this.fuegoImage = fuegoImage;
    }
    

}
