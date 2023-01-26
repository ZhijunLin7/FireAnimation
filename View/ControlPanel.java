package View;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class ControlPanel extends JPanel {

    // Atributos
    private JButton play,stop,pause,setcolor;
    private JSpinner perCentPugna, temIni, tempFinal;

    // Constructor
    public ControlPanel(){
        this.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        //Crear los botones
        this.play=new JButton("Play");
        this.stop=new JButton("Stop");
        this.pause=new JButton("Pause");
        this.setcolor=new JButton("Setcolor");

        constraints.gridx = 0;
        constraints.gridy = 0;

        this.add(this.play, constraints);

        constraints.gridx = 1;
        this.add(this.stop, constraints);
        constraints.gridx = 2;
        this.add(this.pause, constraints);

    }



    // Metodos

    // Getter y Setter
    public JButton getPlay() {
        return play;
    }

    public void setPlay(JButton play) {
        this.play = play;
    }
}