package Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ComparacionKanas extends JFrame {
    private JPanel comparacionKanas;
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JProgressBar eloBar;
    JLabel palabra;
    JLabel tipoKana;
    private JButton ayudaButton;
    Random r1 = new Random();
    Random r2 = new Random();
    public int pos, pos2, errores = 0;
    boolean pressedr, correct;
    public static boolean trigger;

    String kana, tipo;


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
    public ComparacionKanas(){
        setLocation(300,200);
        setContentPane(comparacionKanas);
        eloBar.setMaximum(35);
        setTitle("Kebanoyona");
        setSize(800,350);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        StartScreen.nuevo = false;
        setVisible(true);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Practica.pos2 == 0){
                    Practica.errores = errores;
                    correct = true;
                    button1.setEnabled(true);
                    button2.setEnabled(true);
                    button3.setEnabled(true);
                    button4.setEnabled(true);
                } else {
                    correct = false;
                    errores += 1;
                    button1.setEnabled(false);
                }
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Practica.pos2 == 1){
                    Practica.errores = errores;
                    correct = true;
                    button1.setEnabled(true);
                    button2.setEnabled(true);
                    button3.setEnabled(true);
                    button4.setEnabled(true);
                } else {
                    correct = false;
                    errores += 1;
                    button2.setEnabled(false);
                }
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Practica.pos2 == 2){
                    Practica.errores = errores;
                    correct = true;
                    button1.setEnabled(true);
                    button2.setEnabled(true);
                    button3.setEnabled(true);
                    button4.setEnabled(true);
                } else {
                    correct = false;
                    errores += 1;
                    button3.setEnabled(false);
                }
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Practica.pos2 == 3){
                    Practica.errores = errores;
                    correct = true;
                    button1.setEnabled(true);
                    button2.setEnabled(true);
                    button3.setEnabled(true);
                    button4.setEnabled(true);
                } else {
                    correct = false;
                    errores += 1;
                    button4.setEnabled(false);
                }
            }
        });
        ayudaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.trigger = false;
                Actividad.trigger = false;
                trigger = true;
                //Main.aprender = new Ayuda(Main.trigger);
                Main.aprender.setVisible(true);
                Main.comparacion.setVisible(false);
                Practica.startTimeA = System.currentTimeMillis();
            }
        });
    }
}
