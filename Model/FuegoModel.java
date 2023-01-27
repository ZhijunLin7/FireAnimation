package Model;

import java.awt.Color;

import Controller.FuegoController;
import Enums.FuegoStatus;

public class FuegoModel {

    // Atributos
    private FuegoStatus status = FuegoStatus.running;
    private Fuego fuego;
    private PaletaColor paletaColor;
    private FuegoController fuegoController;

    // Constructor
    public FuegoModel(FuegoController fuegoController) {
        this.fuego = new Fuego(this);
        this.paletaColor = new PaletaColor();
        this.paletaColor.getColores()[0]=new Color(0,0,0,0);
        this.paletaColor.rellenarPaleta(1,255,new Color(255,255,0,1),new Color(255,0,0,255));
        this.fuegoController = fuegoController;
        Thread t = new Thread(this.fuego);
        t.start();
    }

    // Metodos
    public void start() {
        this.status = FuegoStatus.running;
    }

    public void stop() {
        this.status = FuegoStatus.stopped;
    }

    public void play() {
        this.status = FuegoStatus.running;
        notifyAll();
    }

    public void pause() {
        this.status = FuegoStatus.paused;
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
