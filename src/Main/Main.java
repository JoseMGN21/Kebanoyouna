package Main;
import java.util.Scanner;
import java.util.Random;

public class Main {
    static double elo = 0, nelo = 0;
    static double regulador = 0;
    static Datos datos;
    static Random r = new Random();
    static int pos;
    public static int n;
    public static int difficulty;
    static Actividad actividad;
    static StartScreen inicio;
    static PreguntaPersonalidad pregunta;
    static Ayuda aprender;
    static boolean trigger, lvlup, lvldwn;
    static boolean calculo;
    public static void main(String[] args) throws Exception {
        long[] respuestas;
        pregunta = new PreguntaPersonalidad();
        datos = new Datos(1);
        aprender = new Ayuda(trigger);
        inicio = new StartScreen();
        inicio.nuevo = true;
        while(!inicio.pressedi) {
            Thread.sleep(200);
        }
        while (inicio.pressedi){
            //for (n = 0 ; n<=9 ; n++) {
                if (inicio.nuevo)
                    actividad = new Actividad();
                if (elo <= 35) {
                    difficulty = 1;
                    if(lvldwn) {
                        datos = new Datos(difficulty);
                        lvldwn = false;
                    }
                    respuestas = Practica.practicafacil();
                    regulador = -1.5;
                } else {
                    if (elo <= 70) {
                        difficulty = 2;
                        if(lvlup || lvldwn) {
                            datos = new Datos(difficulty);
                            lvlup = false;
                            lvldwn = false;
                        }
                        respuestas = Practica.practicamedio(pos);
                        regulador = -5;
                    } else {
                        difficulty = 3;
                        if(lvlup || lvldwn) {
                            datos = new Datos(difficulty);
                            lvldwn = false;
                            lvlup = false;
                        }
                        respuestas = Practica.practicadificil(pos);
                        regulador = -8;
                    }
                }
                if (respuestas[1] < 5) {
                    System.out.println(respuestas[0]);
                    System.out.println(respuestas[1]);
                    System.out.println(respuestas[2] / 1000);
                    nelo = elo + (Fuzzy.fuzzify(respuestas[1], respuestas[0], respuestas[2] / 1000)) / 10 + regulador;
                    if ((nelo >= 35 && elo < 35 )||(nelo >= 70 && elo < 70))
                        lvlup = true;
                    //else lvlup = false;
                    if ((nelo < 35 && elo >= 35 )||(nelo < 70 && elo >= 70))
                        lvldwn = true;
                    //else lvldwn = false;
                    elo = nelo;
                } else
                    elo = elo - 15;
                if (elo >= 100)
                    elo = 100;
                if (elo <= 0)
                    elo = 0;
                calculo = true;
                System.out.println(elo);
            }
        }

}
