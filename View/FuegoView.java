package View;

import javax.swing.JFrame;

import Controller.FuegoController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FuegoView extends JFrame implements Runnable, ActionListener {

    // Atributos
    private FuegoController fuegoController;
    private ControlPanel controlPanel;
    private Viewer viewer;

    // Constructor
    public FuegoView(FuegoController fuegoController) {
        this.fuegoController = fuegoController;
        this.controlPanel = new ControlPanel();
        this.viewer = new Viewer(null);
    }

    // Metodos
    @Override
    public void run() {
        // TODO Auto-generated method stub

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

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
