package Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartScreen extends JFrame{
    private JButton iniciarButton;
    private JButton aprenderButton;
    private JPanel startPanel;
    //FondoPanel fondo = new FondoPanel();
    public boolean pressedi, presseda, act1, act2;
    public static boolean nuevo;

    public StartScreen(){
        setLocation(420,210);
        setContentPane(startPanel);
        setTitle("Bienvenido");
        setSize(550,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(false);
        iniciarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Main.pregunta.neuroticismo || Main.pregunta.responsabilidad) {
                    act1 = false;
                    act2 = true;
                }
                else {
                    act1 = true;
                    act2 = false;
                }
                pressedi = true;
                setVisible(false);
            }
        });
        aprenderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                presseda = true;
                Main.trigger = true;
                Main.aprender.setVisible(true);
                setVisible(false);
            }
        });
    }
}

