package Model;

import java.awt.Color;
import java.util.ArrayList;

public class PaletaColor {

    // Atributos
    private Color[] colores;
    private ArrayList<Integer> arrayTemp;
    private ArrayList<Color> arrayColor;

    // Constructor
    public PaletaColor() {
        this.colores = new Color[256];
        this.arrayTemp = new ArrayList<>();
        this.arrayColor = new ArrayList<>();
    }

    // Metodos
    public void anadirColor(int temp1, int temp2, Color colorComienzo, Color colorFinal) {
        this.arrayTemp.add(temp1);
        this.arrayColor.add(colorComienzo);
        this.arrayTemp.add(temp2);
        this.arrayColor.add(colorFinal);

        // pintar
        for (int i = 0; i < arrayTemp.size() - 1; i++) {
            rellenarPaleta(arrayTemp.get(i), arrayTemp.get(i + 1), arrayColor.get(i), arrayColor.get(i + 1));
        }

    }

    public void anadirNuevoColor(int temp1, int temp2, Color colorComienzo, Color colorFinal) {
        ArrayList<Integer> newArrayTemp = new ArrayList<>();
        ArrayList<Color> newArrayColor = new ArrayList<>();
        for (int i = 0; i < arrayTemp.size(); i++) {
            if (arrayTemp.get(i)<temp1 || arrayTemp.get(i)>temp2) {
                newArrayTemp.add(arrayTemp.get(i));
                newArrayColor.add(arrayColor.get(i));
            }
        }

        newArrayTemp.add(temp1);
        newArrayTemp.add(temp2);
        newArrayColor.add(colorComienzo);
        newArrayColor.add(colorFinal);

        for (int i = 0; i < newArrayTemp.size(); i++) {
            for (int j = i + 1; j < newArrayTemp.size(); j++) {
                if (newArrayTemp.get(i) > newArrayTemp.get(j)) {
                    int tmp = newArrayTemp.get(i);
                    newArrayTemp.set(i, newArrayTemp.get(j));
                    newArrayTemp.set(j, tmp);
                    Color color = newArrayColor.get(i);
                    newArrayColor.set(i, newArrayColor.get(j));
                    newArrayColor.set(j, color);
                }
            }
        }
        
        this.arrayTemp= newArrayTemp;
        this.arrayColor= newArrayColor;
        // pintar
        for (int i = 0; i < arrayTemp.size() - 1; i++) {
            rellenarPaleta(arrayTemp.get(i), arrayTemp.get(i + 1), arrayColor.get(i), arrayColor.get(i + 1));
        }

        System.out.println(arrayTemp.toString());
        
    }

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

    public ArrayList<Integer> getArrayTemp() {
        return arrayTemp;
    }

    public void setArrayTemp(ArrayList<Integer> arrayTemp) {
        this.arrayTemp = arrayTemp;
    }

    public ArrayList<Color> getArrayColor() {
        return arrayColor;
    }

    public void setArrayColor(ArrayList<Color> arrayColor) {
        this.arrayColor = arrayColor;
    }

}
