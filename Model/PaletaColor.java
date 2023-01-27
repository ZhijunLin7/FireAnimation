package Model;

import java.awt.Color;

public class PaletaColor {

    // Atributos
    private Color[] colores;

    // Constructor
    public PaletaColor() {
        this.colores = new Color[256];
    }

    // Metodos
    public void rellenarPaleta(int temp1, int temp2, Color colorComienzo, Color colorFinal) {
        int pasos = temp2 - temp1;

        int[] rgbaComienzo = { colorComienzo.getRed(), colorComienzo.getGreen(), colorComienzo.getBlue(),
                colorComienzo.getAlpha() };

        int[] rgbaFinal = { colorFinal.getRed(), colorFinal.getGreen(), colorFinal.getBlue(), colorFinal.getAlpha() };

        float[] colorInterpolado = new float[4];

        for (int i = 0; i <= pasos; i++) {
            for (int j = 0; j < colorInterpolado.length; j++) {
                colorInterpolado[j] = rgbaComienzo[j] + (rgbaFinal[j] - rgbaComienzo[j]) * (i / (float) pasos);
            }
            this.colores[(i + temp1)] = new Color((int) colorInterpolado[0], (int) colorInterpolado[1],
                    (int) colorInterpolado[2],
                    (int) colorInterpolado[3]);
        }

    }

    // Getter y Setter
    public Color[] getColores() {
        return colores;
    }

    public void setColores(Color[] colores) {
        this.colores = colores;
    }

}
