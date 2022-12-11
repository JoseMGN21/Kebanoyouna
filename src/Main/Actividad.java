package Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Actividad extends JFrame {

    private JTextField respuesta;
    public JLabel palabra;
    private JPanel actividadPanel;
    public JLabel ayudas;
    private JLabel errores;
    public JButton revisarButton;
    private JButton continuarButton;
    private JButton ayudaButton;
    public JProgressBar eloBar;
    public boolean pressedr, pressedc;
    public static String resp;
    public static boolean correct;
    public int pos;
    public static boolean maxerr;
    Random r = new Random();
    //FondoPanel fondo = new FondoPanel();

    public Actividad(){
        //setLocationRelativeTo(null);
        setLocation(300,200);
        setContentPane(actividadPanel);
        eloBar.setMaximum(35);
        setTitle("Kebanoyona");
        setSize(800,350);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //this.setContentPane(fondo);
        pos = r.nextInt(0,9 - Main.n);
        palabra.setText(Main.datos.palabras.get(pos));
        StartScreen.nuevo = false;
        setVisible(true);
        continuarButton.setEnabled(false);

        revisarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Ejecutando...");
                resp = respuesta.getText();
                pressedr = true;
                correct = false;
                if (Practica.revision(pos)) {
                    correct = true;
                    //palabra.setText(Datos.palabras.get(pos));
                    System.out.println("Respuesta correcta");
                    revisarButton.setEnabled(false);
                    continuarButton.setEnabled(true);
                    return;
                } else {
                    System.out.println("Respuesta incorrecta");
                    System.out.println(Practica.errores);
                    errores.setText("Errores: " + Practica.errores);
                    if (Practica.errores == 5){
                        Main.elo = Main.elo - 15;
                        if(Main.elo < 0)
                            Main.elo = 0;
                        continuarButton.setEnabled(true);
                        revisarButton.setEnabled(false);
                    }
                }
                pressedr = false;
            }
        });
        continuarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pressedc = true;
                if (Main.datos.palabras.size() == 0) {
                    Main.datos = new Datos(Main.difficulty);
                    Practica.palabras = Main.datos.palabras;
                    Practica.respuestas = Main.datos.respuestas;
                }
                pos = r.nextInt(0,Main.datos.palabras.size());
                palabra.setText(Main.datos.palabras.get(pos));
                respuesta.setText("");
                Practica.tiempoAyudas = 0;
                Main.actividad.ayudas.setText("Ayudas: " + Practica.tiempoAyudas/1000 + " s.");
                Practica.errores = 0;
                errores.setText("Errores: 0");
                revisarButton.setEnabled(true);
                continuarButton.setEnabled(false);
                if(Main.difficulty == 1) {
                    eloBar.setString("Nivel fácil.");
                    eloBar.setValue((int) Main.elo);
                }else if(Main.difficulty == 2) {
                    eloBar.setString("Nivel medio.");
                    eloBar.setValue((int) Main.elo - 35);
                }else if(Main.difficulty == 3) {
                    eloBar.setString("Nivel difícil.");
                    eloBar.setValue((int) Main.elo - 70);
                }
                pressedc = false;
                }
        });
        ayudaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.trigger = false;
                //Main.aprender = new Ayuda(Main.trigger);
                Main.aprender.setVisible(true);
                Main.actividad.setVisible(false);
                Practica.startTimeA = System.currentTimeMillis();
            }
        });
    }
}

