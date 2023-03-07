package View;

import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Controller.FuegoController;
import Enums.FuegoStatus;
import Model.Fuego;

import java.awt.image.BufferedImage;
import java.awt.image.BufferStrategy;
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

        // Añadir el control panel al frame
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 0.2;
        constraints.weighty = 0.2;
        this.add(controlPanel, constraints);

        // Añadir el viewer panel al frame
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 0.8;
        constraints.weighty = 0.8;
        this.add(viewer, constraints);

        /*
         * El metodo que sirve para anadir listener a
         * todo los componentes de control panel
         */
        this.anadirListener();

        this.setPreferredSize(new Dimension(1100, 650));
        this.setTitle("Fuego");
        this.setDefaultCloseOperation(3);
        this.pack();
        this.setVisible(true);

    }

    // Metodos
    @Override
    public void run() {
        BufferedImage bufferedImage = new BufferedImage(400, 400, BufferedImage.TYPE_INT_ARGB);
        this.createBufferStrategy(2);
        BufferStrategy bs = this.getBufferStrategy();
        while (this.fuegoController.getFuegoModel().getStatus() != FuegoStatus.stopped) {
            try {
                this.pintar(bufferedImage);
                viewer.setFuegoImage(bufferedImage);
                paintComponents(bs.getDrawGraphics());
                bs.show();
                Thread.sleep(50);
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Color c;
        switch (e.getActionCommand()) {
            case "Play":
                this.fuegoController.play();
                break;

            case "Pause":
                this.fuegoController.pause();
                break;

            case "Stop":
                this.fuegoController.stop();
                break;

            case "Setcolor":
                // Coge el colo de los dos botones y dos tempratura para rellenar paleta de
                // color
                String temIni = this.controlPanel.getTemIni().getValue().toString();
                String temFinal = this.controlPanel.getTempFinal().getValue().toString();
                Color coloIni = this.controlPanel.getColorInicial().getBackground();
                Color coloFinal = this.controlPanel.getColorFinal().getBackground();
                this.fuegoController.getFuegoModel().getPaletaColor().anadirNuevoColor(Integer.valueOf(temIni),
                        Integer.valueOf(temFinal), coloIni, coloFinal);

                break;
            case "Color Inicial":
                // Elige el colo y pinta al fondo de boton
                c = JColorChooser.showDialog(null, "Elige el colo inicial", Color.BLACK);
                this.controlPanel.getColorInicial().setBackground(c);
                break;

            case "Color Final":
                c = JColorChooser.showDialog(null, "Elige el colo inicial", Color.BLACK);
                this.controlPanel.getColorFinal().setBackground(c);
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

    public void comenzar() {
        Thread t = new Thread(this);
        t.start();
    }

    public void anadirListener() {
        // Añadir el listener al botones
        this.controlPanel.getPlay().addActionListener(this);
        this.controlPanel.getStop().addActionListener(this);
        this.controlPanel.getPause().addActionListener(this);
        this.controlPanel.getSetcolor().addActionListener(this);
        this.controlPanel.getColorInicial().addActionListener(this);
        this.controlPanel.getColorFinal().addActionListener(this);

        // Cada vez que cambai el % de chispa lo pconfigura al fuego
        JSpinner perCentChispa = this.controlPanel.getPerCentChispa();
        perCentChispa.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                // TODO Auto-generated method stub
                int chispa = (int) perCentChispa.getValue();
                fuegoController.getFuegoModel().getFuego().setPocentageChispa(chispa);
            }

        });
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
