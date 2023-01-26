import Controller.FuegoController;
import Model.FuegoModel;
import View.FuegoView;

public class MyTask {
    public static void main(String[] args) {
        FuegoController fuegoController = new FuegoController();
        FuegoModel fuegoModel = new FuegoModel(fuegoController);
        FuegoView fuegoView = new FuegoView(fuegoController);

        fuegoController.setFuegoModel(fuegoModel);
        fuegoController.setFuegoView(fuegoView);

    }
}
