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
    public void rellenarPaleta() {
        for (int i = 0; i < colores.length; i++) {
            colores[i]=new Color(255,i,0,i);
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
