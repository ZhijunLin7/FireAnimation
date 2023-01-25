import java.awt.*;
import javax.swing.*;

public class MyFrame extends JFrame {
    public MyFrame() {
        super("My Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the layout manager to GridBagLayout
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        // Create the panel with buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 2));
        buttonPanel.add(new JButton("Button 1"));
        buttonPanel.add(new JButton("Button 2"));
        buttonPanel.add(new JButton("Button 3"));
        buttonPanel.add(new JButton("Button 4"));

        // Add the button panel to the top-left corner of the grid
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 0.5;
        constraints.weighty = 0.5;
        add(buttonPanel, constraints);

        // Create the panel with the picture
        JPanel picturePanel = new JPanel();
        ImageIcon image = new ImageIcon("View\\bg.jpg");
        JLabel label = new JLabel("", image, JLabel.CENTER);
        picturePanel.add(label);

        // Add the picture panel to the top-right corner of the grid
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 0.5;
        constraints.weighty = 0.5;
        add(picturePanel, constraints);
        
        // Pack and display the frame
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new MyFrame();
    }
}