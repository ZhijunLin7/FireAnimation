import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
public class Interpolation {
    public static Color interpolateColor(Color color1, Color color2, int steps, int step) {
        float[] color1Components = color1.getRGBColorComponents(null);
        float[] color2Components = color2.getRGBColorComponents(null);
        
        float[] interpolatedColor = new float[3];
        for (int i = 0; i < 3; i++) {
            interpolatedColor[i] = color1Components[i] + (color2Components[i] - color1Components[i]) * (step / (float) steps);
        }
        return new Color(interpolatedColor[0], interpolatedColor[1], interpolatedColor[2]);
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Drawing with Alpha");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints dBagConstraints = new GridBagConstraints();
        
        Color color1 = new Color(255,0,0,255);
        Color color2 = new Color(255,0,0,0);;
        int steps = 100;
        for (int i = 0; i <= steps; i++) {
            dBagConstraints.gridx=i;
            dBagConstraints.gridwidth=1;
            dBagConstraints.gridheight=1;
            dBagConstraints.fill=GridBagConstraints.BOTH;
            System.out.println(interpolateColor(color1, color2, steps, i));
            JPanel p = new JPanel();
            p.setBackground(interpolateColor(color1, color2, steps, i));
            frame.add(p);
        }
        frame.setSize(400,400);
        frame.setVisible(true);  
        
        

    }
}