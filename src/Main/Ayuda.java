package Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Ayuda extends JFrame {
    private JButton button1;
    private JPanel ayudaPanel;
    private JLabel imagenAyuda;
    private JLabel tituloLabel;
    boolean change;
    ImageIcon hiragana = new ImageIcon(getClass().getResource("/Main/Hiragana.png"));
    ImageIcon katakana = new ImageIcon(getClass().getResource("/Main/Katakana.png"));


    public Ayuda(boolean trigger) {
        //setLocationRelativeTo(null);
        setLocation(300,50);
        setContentPane(ayudaPanel);
        setTitle("Hiragana");
        setSize(800,600);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(false);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Main.trigger){
                Main.inicio.presseda = false;
                Main.inicio.setVisible(true);
                setVisible(false);}
                else if (Actividad.trigger){
                    Practica.tiempoAyudas = Practica.tiempoAyudas + (System.currentTimeMillis() - Practica.startTimeA);
                    Main.actividad.ayudas.setText("Ayudas: " + Practica.tiempoAyudas/1000 + " s.");
                    if (Practica.tiempoAyudas > 60000)
                        Practica.tiempoAyudas = 60000;
                    Main.actividad.setVisible(true);
                    setVisible(false);
                } else if (ComparacionKanas.trigger){
                    Practica.tiempoAyudas = Practica.tiempoAyudas + (System.currentTimeMillis() - Practica.startTimeA);
                    //Main.comparacion.ayudas.setText("Ayudas: " + Practica.tiempoAyudas/1000 + " s.");
                    if (Practica.tiempoAyudas > 60000)
                        Practica.tiempoAyudas = 60000;
                    Main.comparacion.setVisible(true);
                    setVisible(false);
                } else {
                    Practica.tiempoAyudas = Practica.tiempoAyudas + (System.currentTimeMillis() - Practica.startTimeA);
                    Main.actividad.ayudas.setText("Ayudas: " + Practica.tiempoAyudas/1000 + " s.");
                    if (Practica.tiempoAyudas > 60000)
                        Practica.tiempoAyudas = 60000;
                    Main.actividad.setVisible(true);
                    setVisible(false);
                }
            }
        });
        imagenAyuda.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (change) {
                    setTitle("Hiragana");
                    tituloLabel.setText("Click en la imagen para cambiar a Katakana");
                    imagenAyuda.setIcon(hiragana);
                } else {
                    setTitle("Katakana");
                    tituloLabel.setText("Click en la imagen para cambiar a Hiragana");
                    imagenAyuda.setIcon(katakana);
                }
                change ^= true;
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
