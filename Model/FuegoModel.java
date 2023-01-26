package Model;

import Enums.FuegoStatus;

public class FuegoModel {

    // Atributos
    private FuegoStatus status = FuegoStatus.stopped;
    private Fuego fuego;
    private PaletaColor paletaColor;

    // Constructor
    public FuegoModel() {
        this.fuego = new Fuego(this);
        this.paletaColor = new PaletaColor();
        this.paletaColor.rellenarPaleta();
    }

    public FuegoModel(FuegoStatus status, Fuego fuego) {
        this.status = status;
        this.fuego = fuego;
    }

    // Metodos
    private void start() {

    }

    public void stop() {

    }

    public void play() {

    }

    public void pause() {

    }

    public synchronized FuegoStatus getStatus() {
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

}
