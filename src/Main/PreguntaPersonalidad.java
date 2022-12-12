package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;

public class PreguntaPersonalidad extends JFrame {
    private JTextField textoRespuesta;
    private JPanel respuestaPersonalidad;
    private JButton enviarButton;
    private JProgressBar barraPalabras;

    public Boolean responsabilidad, neuroticismo, amabilidad, sociabilidad, apertura;


    public PreguntaPersonalidad() {
        setBackground(Color.cyan);
        setLocation(420,210);
        setContentPane(respuestaPersonalidad);
        setBounds(300,200,550,300);
        setTitle("¡Queremos conocerte!");
        setVisible(true);
        enviarButton.setEnabled(false);
        textoRespuesta.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                String trim = textoRespuesta.getText().trim();
                int palabras = trim.split("\\s+").length;
                barraPalabras.setValue(palabras);
                if (palabras <= 30){
                    enviarButton.setEnabled(false);
                } else {
                    enviarButton.setEnabled(true);
                }
            }
        });
        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            String texto = textoRespuesta.getText();
            if(Objects.equals(App.prediccion("neuroticismo", texto), "Si")){
                neuroticismo = true;
            } else neuroticismo = false;
            if(Objects.equals(App.prediccion("amabilidad", texto), "Si")){
                amabilidad = true;
            } else amabilidad = false;
            if(Objects.equals(App.prediccion("sociabilidad", texto), "Si")){
                sociabilidad = true;
            } else sociabilidad = false;
            if(Objects.equals(App.prediccion("apertura", texto), "Si")){
                apertura = true;
            } else apertura = false;
            if(Objects.equals(App.prediccion("responsabilidad", texto), "Si")){
                responsabilidad = true;
            } else responsabilidad = false;
            System.out.println("Responsabilidad: " + responsabilidad);
            System.out.println("Amabilidad :" + amabilidad);
            System.out.println("Apertura: " + apertura);
            System.out.println("Sociabilidad: " + sociabilidad);
            System.out.println("Neuroticismo: " + neuroticismo);
            Main.inicio.setVisible(true);
            setVisible(false);
            }
        });
        barraPalabras.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                barraPalabras.setStringPainted(true);
            }
        });

        barraPalabras.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                barraPalabras.setStringPainted(false);
            }
        });
    }
}
