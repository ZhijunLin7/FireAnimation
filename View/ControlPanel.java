package View;

import java.awt.GridLayout;
import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class ControlPanel extends JPanel {

    // Atributos
    private JButton play, stop, pause, setcolor, colorInicial, colorFinal;
    private JSpinner perCentChispa, temIni, tempFinal;

    // Constructor
    public ControlPanel() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        // Crear los botones
        this.play = new JButton("Play");
        this.stop = new JButton("Stop");
        this.pause = new JButton("Pause");
        this.setcolor = new JButton("Setcolor");
        this.colorInicial = new JButton("Color Inicial");
        this.colorFinal = new JButton("Color Final");

        // Crear lo spinners
        SpinnerModel value = new SpinnerNumberModel(50, 1, 100, 1);
        this.perCentChispa = new JSpinner(value);
        value = new SpinnerNumberModel(1, 1, 255, 1);
        this.temIni = new JSpinner(value);
        value = new SpinnerNumberModel(100, 1, 255, 1);
        this.tempFinal = new JSpinner(value);

        // Añadir los botones al panel
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1;
        constraints.weighty = 1;
        this.add(this.play, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        this.add(this.pause, constraints);

        constraints.gridx = 2;
        constraints.gridy = 0;
        this.add(this.stop, constraints);

        constraints.gridx = 2;
        constraints.gridy = 1;
        this.add(this.setcolor, constraints);

        // Añadir los botones que tiene el elegidor de color al panel total

        constraints.gridx = 0;
        constraints.gridy = 1;
        this.add(this.colorInicial, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        this.add(this.colorFinal, constraints);

        // Añadir los spinner al panel
        /*
         * Aqui creo un panel y meto el descripcion y el jspinner al final meto el panel
         * al panel totoal
         */

        JPanel pTempInicial = new JPanel();
        pTempInicial.setLayout(new GridLayout(2, 1));
        JLabel lTempInicial = new JLabel("Temperatura inicial");
        pTempInicial.add(lTempInicial);
        pTempInicial.add(this.temIni);

        constraints.gridx = 0;
        constraints.gridy = 2;
        this.add(pTempInicial, constraints);

        JPanel pTempFinal = new JPanel();
        pTempFinal.setLayout(new GridLayout(2, 1));
        JLabel lTempFinal = new JLabel("Temperatura final");
        pTempFinal.add(lTempFinal);
        pTempFinal.add(this.tempFinal);

        constraints.gridx = 1;
        constraints.gridy = 2;
        this.add(pTempFinal, constraints);

        JPanel pChispa = new JPanel();
        pChispa.setLayout(new GridLayout(2, 1));
        JLabel lChispa = new JLabel("% de Chispa");
        pChispa.add(lChispa);
        pChispa.add(this.perCentChispa);

        constraints.gridx = 2;
        constraints.gridy = 2;
        this.add(pChispa, constraints);

    }

    // Metodos

    // Getter y Setter
    public JButton getPlay() {
        return play;
    }

    public void setPlay(JButton play) {
        this.play = play;
    }

    public JButton getStop() {
        return stop;
    }

    public void setStop(JButton stop) {
        this.stop = stop;
    }

    public JButton getPause() {
        return pause;
    }

    public void setPause(JButton pause) {
        this.pause = pause;
    }

    public JButton getSetcolor() {
        return setcolor;
    }

    public void setSetcolor(JButton setcolor) {
        this.setcolor = setcolor;
    }

    public JButton getColorInicial() {
        return colorInicial;
    }

    public void setColorInicial(JButton colorInicial) {
        this.colorInicial = colorInicial;
    }

    public JButton getColorFinal() {
        return colorFinal;
    }

    public void setColorFinal(JButton colorFinal) {
        this.colorFinal = colorFinal;
    }

    public JSpinner getPerCentChispa() {
        return perCentChispa;
    }

    public void setPerCentChispa(JSpinner perCentChispa) {
        this.perCentChispa = perCentChispa;
    }

    public JSpinner getTemIni() {
        return temIni;
    }

    public void setTemIni(JSpinner temIni) {
        this.temIni = temIni;
    }

    public JSpinner getTempFinal() {
        return tempFinal;
    }

    public void setTempFinal(JSpinner tempFinal) {
        this.tempFinal = tempFinal;
    }

    
}