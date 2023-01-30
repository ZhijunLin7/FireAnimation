package View;

import javax.swing.JFrame;

import Controller.FuegoController;
import Enums.FuegoStatus;
import Model.Fuego;
import java.awt.image.BufferedImage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagLayout;
import java.awt.Color;
import java.awt.Dimension;

import java.awt.GridBagConstraints;

public class FuegoView extends JFrame implements Runnable, ActionListener {

    // Atributos
    private FuegoController fuegoController;
    private ControlPanel controlPanel;
    private Viewer viewer;

    // Constructor
    public FuegoView(FuegoController fuegoController) {
        this.fuegoController = fuegoController;
        this.controlPanel = new ControlPanel();
        this.viewer = new Viewer();

        this.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 0.5;
        constraints.weighty = 0.5;
        this.add(controlPanel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 0.5;
        constraints.weighty = 0.5;
        this.add(viewer, constraints);

        this.controlPanel.getPlay().addActionListener(this);

        this.setPreferredSize(new Dimension(1480, 650));
        this.setTitle("Fuego");
        this.setDefaultCloseOperation(3);
        this.pack();
        this.setVisible(true);

        Thread t = new Thread(this);
        t.start();
    }

    // Metodos
    @Override
    public void run() {
        BufferedImage bufferedImage = new BufferedImage(400, 400, BufferedImage.TYPE_INT_ARGB);
        while (this.fuegoController.getFuegoModel().getStatus() != FuegoStatus.stopped) {
            try {
                this.pintar(bufferedImage);
                viewer.setFuegoImage(bufferedImage);
                this.repaint();
                Thread.sleep(50);
            } catch (Exception e) {
                // TODO: handle exception
            }
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Play":
                System.out.println("Play");
                this.fuegoController.play();
                break;
            case "Pause":
                System.out.println("Pause");
                break;
            case "Stop":
                System.out.println("Stop");
                break;
        }
    }

    public void pintar(BufferedImage bufferedImage) {
        Fuego fuego = fuegoController.getFuegoModel().getFuego();
        for (int i = 0; i < fuego.getMatrizFuego().length; i++) {
            for (int j = 0; j < fuego.getMatrizFuego()[i].length; j++) {
                int temp = fuego.getMatrizFuego()[i][j];
                Color c = fuegoController.getFuegoModel().getPaletaColor().getColores()[temp];
                int color = c.getRGB();
                bufferedImage.setRGB(j, i, color);
            }
        }
    }

    // Getter y Setter
    public FuegoController getFuegoController() {
        return fuegoController;
    }

    public void setFuegoController(FuegoController fuegoController) {
        this.fuegoController = fuegoController;
    }

    public ControlPanel getControlPanel() {
        return controlPanel;
    }

    public void setControlPanel(ControlPanel controlPanel) {
        this.controlPanel = controlPanel;
    }

    public Viewer getViewer() {
        return viewer;
    }

    public void setViewer(Viewer viewer) {
        this.viewer = viewer;
    }

}
