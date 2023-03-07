package Model;

import java.awt.Color;

import Controller.FuegoController;
import Enums.FuegoStatus;

public class FuegoModel {

    // Atributos
    private FuegoStatus status;
    private Fuego fuego;
    private PaletaColor paletaColor;
    private FuegoController fuegoController;

    // Constructor
    public FuegoModel(FuegoController fuegoController) {
        this.status = FuegoStatus.stopped;
        this.paletaColor = new PaletaColor();
        this.paletaColor.getColores()[0] = new Color(0, 0, 0, 0);
        this.paletaColor.anadirColor(1, 30, new Color(128, 128, 128, 10), new Color(115, 75, 0, 255));
        this.paletaColor.anadirColor(31, 255, new Color(255, 255, 0, 255), new Color(255, 0, 0, 255));
        this.fuegoController = fuegoController;
    }

    // Metodos
    private void start() {
        this.status = FuegoStatus.running;
        this.fuego = new Fuego(this);
        Thread t = new Thread(this.fuego);
        t.start();
    }

    public synchronized void play() {
        if (this.status.equals(FuegoStatus.paused)) {
            this.status = FuegoStatus.running;
            notifyAll();
        } else if (this.status.equals(FuegoStatus.stopped)) {
            this.start();
            this.fuegoController.getFuegoView().comenzar();
        }
    }

    public synchronized void stop() {
        this.status = FuegoStatus.stopped;
    }

    public synchronized void pause() {
        if (this.status.equals(FuegoStatus.running)) {
            this.status = FuegoStatus.paused;
        }
    }

    public synchronized FuegoStatus getStatus() {
        if (this.status.equals(FuegoStatus.paused)) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread Interrupted");
            }
        }
        return status;
    }

    public synchronized void setStatus(FuegoStatus status) {
        this.status = status;
    }

    // Getter y Setter
    public Fuego getFuego() {
        return fuego;
    }

    public void setFuego(Fuego fuego) {
        this.fuego = fuego;
    }

    public PaletaColor getPaletaColor() {
        return paletaColor;
    }

    public void setPaletaColor(PaletaColor paletaColor) {
        this.paletaColor = paletaColor;
    }

    public FuegoController getFuegoController() {
        return fuegoController;
    }

    public void setFuegoController(FuegoController fuegoController) {
        this.fuegoController = fuegoController;
    }

}
