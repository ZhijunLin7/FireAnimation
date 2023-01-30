package test;


import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Model.Fuego;
import Model.FuegoModel;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.Color;
import java.awt.Graphics2D;
public class Testingo extends JPanel {

    // Atributos
    private BufferedImage image;
    private FuegoModel fuegoModel;

    // Constructor
    public Testingo() {
        try {
            this.image = ImageIO.read(new File("View\\bg.jpg"));
        } catch (Exception e) {
            // TODO: handle exception
        }
        this.fuegoModel=new FuegoModel(null);
    }

    // Metodos

    // Getter y Setter
    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public void test1() {
        BufferedImage bufferedImage = new BufferedImage(400, 400, BufferedImage.TYPE_INT_ARGB);
        JFrame jFrame = new JFrame();
        Testingo viewer = new Testingo();
        jFrame.add(viewer);

        for (int i = 0; i < 40; i++) {
            bufferedImage.setRGB(i, i, new Color(0, 0, 0, 255).getRGB());
        }
        viewer.getImage().getGraphics().drawImage(bufferedImage, 0, 0, null);

        for (int i = 0; i < 40; i++) {
            bufferedImage.setRGB(i, i, new Color(0, 0, 0, 0).getRGB());
        }
        viewer.getImage().getGraphics().drawImage(bufferedImage, 0, 0, null);

        jFrame.setDefaultCloseOperation(3);
        jFrame.setSize(650, 650);
        jFrame.setVisible(true);
    }    
    
    public void pintar(BufferedImage bufferedImage) {
        Fuego fuego = fuegoModel.getFuego();
        for (int i = 0; i < fuego.getMatrizFuego().length; i++) {
            for (int j = 0; j < fuego.getMatrizFuego()[i].length; j++) {
                int temp = fuego.getMatrizFuego()[i][j];
                Color c = fuegoModel.getPaletaColor().getColores()[temp];
                int color = c.getRGB();
                bufferedImage.setRGB(j, i, color);
            }
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);


        BufferedImage bufferedImage = new BufferedImage(400, 400, BufferedImage.TYPE_INT_ARGB);

            pintar(bufferedImage);

		
        g.drawImage(image, 0, 0, this);
		g.drawImage(bufferedImage, 0, 0, 400, 400, 0, 0, bufferedImage.getWidth(),
				bufferedImage.getHeight(), null);
        this.repaint();
        
    }


    public static void main(String[] args) {
        
        JFrame jFrame = new JFrame();
        Testingo viewer = new Testingo();
        jFrame.add(viewer);

        

        jFrame.setDefaultCloseOperation(3);
        jFrame.setSize(650, 650);
        jFrame.setVisible(true);

        

        
        
    }

}
