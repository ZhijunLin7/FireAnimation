package Model;

import java.util.Random;

import Enums.FuegoStatus;

public class Fuego implements Runnable {

    // Atributos
    private int[][] matrizFuego;
    private int pocentageChispa;
    private FuegoModel fuegoModel;

    // Constructor
    public Fuego() {

    }

    public Fuego(FuegoModel fuegoModel) {
        this.matrizFuego = new int[200][200];
        this.pocentageChispa = 50;
        this.fuegoModel = fuegoModel;
    }

    // Metodos
    @Override
    public void run() {
        while (this.fuegoModel.getStatus() != FuegoStatus.stopped) {
            try {
                this.generarChispa(pocentageChispa);
                this.propagar();
                Thread.sleep(50);
            } catch (Exception e) {
                // TODO: handle exception
            }
        }

    }

    // Genera Chispa en el base de array.
    public void generarChispa(int pocentageChispa) {
        Random ran = new Random();
        for (int j = 0; j < matrizFuego[matrizFuego.length-1].length; j++) {
            int numRan = ran.nextInt(100) + 1;
            if (numRan <= pocentageChispa) {
                this.matrizFuego[matrizFuego.length-1][j] = 255;
            } else {
                this.matrizFuego[matrizFuego.length-1][j] = 0;
            }
        }
    }

    // Propaga el chispa.
    public void propagar() {
        for (int i = 0; i < (matrizFuego.length - 1); i++) {
            for (int j = 0; j < matrizFuego[i].length; j++) {
                int temperatura = 0;
                int tempAbaIzq = 0;
                int tempAbajo = 0;
                int tempAbaDerecha = 0;

                // Calcular la tempreatura basando en los de abajo, izquierda, derecha.
                tempAbaIzq = matrizFuego[i + 1][positiveMod(j - 1, matrizFuego.length)];
                tempAbajo = matrizFuego[i + 1][j];
                tempAbaDerecha = matrizFuego[i + 1][positiveMod(j + 1, matrizFuego.length)];

                // La tempratura sedivide en 3 y le quita un porcentaje de refrigeracion.
                temperatura = (tempAbaIzq + tempAbajo + tempAbaDerecha) / 3;
                matrizFuego[i][j] = (int) (temperatura * 0.99);
            }
        }
    }

    // Saca el resto de la divicion entre dos numero
    public static int positiveMod(int value, int mod) {
        return ((value % mod + mod) % mod);
    }

    // Getter y Setter
    public int[][] getMatrizFuego() {
        return matrizFuego;
    }

    public void setMatrizFuego(int[][] matrizFuego) {
        this.matrizFuego = matrizFuego;
    }

    public int getPocentageChispa() {
        return pocentageChispa;
    }

    public void setPocentageChispa(int pocentageChispa) {
        this.pocentageChispa = pocentageChispa;
    }

    public FuegoModel getFuegoModel() {
        return fuegoModel;
    }

    public void setFuegoModel(FuegoModel fuegoModel) {
        this.fuegoModel = fuegoModel;
    }

}
