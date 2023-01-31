package Controller;

import Model.FuegoModel;
import View.FuegoView;

public class FuegoController {

    // Atributos
    private FuegoModel fuegoModel;
    private FuegoView fuegoView;

    // Constructor
    public FuegoController() {

    }

    public FuegoController(FuegoModel fuegoModel, FuegoView fuegoView) {
        this.fuegoModel = fuegoModel;
        this.fuegoView = fuegoView;
    }

    // Metodos
    public void play() {
        fuegoModel.play();
    }

    public void pause() {
        this.fuegoModel.pause();
    }

    public void stop() {
        this.fuegoModel.stop();
    }

    // Getter y Setter
    public FuegoModel getFuegoModel() {
        return fuegoModel;
    }

    public void setFuegoModel(FuegoModel fuegoModel) {
        this.fuegoModel = fuegoModel;
    }

    public FuegoView getFuegoView() {
        return fuegoView;
    }

    public void setFuegoView(FuegoView fuegoView) {
        this.fuegoView = fuegoView;
    }

}