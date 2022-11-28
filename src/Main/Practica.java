
package Main;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Practica {
    static Random r = new Random();
    static Scanner entrada = new Scanner(System.in);
    static String respuesta;
    static long[] resultados ={0,0,0};
    static int errores = 0;
    static int n = 0;
    static long startTime, startTimeA, tiempoAyudas;
    static List respuestas;
    static List palabras;
    static boolean correcto;
    public static long[] practicafacil() throws InterruptedException {
        palabras = Main.datos.palabras;
        respuestas = Main.datos.respuestas;
        startTime = System.currentTimeMillis();
        while(!Main.actividad.pressedc) {
           while (!Main.actividad.pressedr) {
                Thread.sleep(200);
            }
            if(Main.actividad.correct) {
                System.out.println("Regresando resultados...");
                Main.actividad.pressedr = false;
                Main.actividad.pressedc = false;
                resultados[0] = tiempoAyudas/1000;
                resultados[1] = errores;
                return resultados;
            }
        }resultados[0] = tiempoAyudas/1000;
        resultados[1] = errores;
        return resultados;
    }
    public static long[] practicamedio(int pos) throws InterruptedException {
        palabras = Main.datos.palabras;
        respuestas = Main.datos.respuestas;
        startTime = System.currentTimeMillis();
        while(!Main.actividad.pressedc) {
            while (!Main.actividad.pressedr) {
                Thread.sleep(200);
            }
            if(Main.actividad.correct) {
                System.out.println("Regresando resultados...");
                Main.actividad.pressedr = false;
                Main.actividad.pressedc = false;
                resultados[0] = tiempoAyudas/1000;
                resultados[1] = errores;
                return resultados;
            }
        }
        resultados[0] = tiempoAyudas/1000;
        resultados[1] = errores;
        return resultados;
        }
    public static long[] practicadificil(int pos) throws InterruptedException {
        palabras = Main.datos.palabras;
        respuestas = Main.datos.respuestas;
        startTime = System.currentTimeMillis();
        while(!Main.actividad.pressedc) {
            while (!Main.actividad.pressedr) {
                Thread.sleep(200);
            }
            if(Main.actividad.correct) {
                System.out.println("Regresando resultados...");
                Main.actividad.pressedr = false;
                Main.actividad.pressedc = false;
                resultados[0] = tiempoAyudas/1000;
                resultados[1] = errores;
                return resultados;
            }
        }
        return resultados;
}
    public static boolean revision(int pos){
        while (errores < 5) {
            respuesta = Actividad.resp;
            System.out.println(respuesta);
            System.out.println(respuestas.get(pos));
                if (respuesta.equals(respuestas.get(pos))) {
                    resultados[2] = System.currentTimeMillis() - startTime;
                    resultados[1] = errores;
                    System.out.println("Correcto");
                    palabras.remove(pos);
                    respuestas.remove(pos);
                    correcto = true;
                    return correcto;
                } else {
                    System.out.println("Incorrecto");
                    errores += 1;
                    resultados[1] = errores;
                    correcto = false;
                    if (errores == 5){
                        palabras.remove(pos);
                        respuestas.remove(pos);
                    }
                    return correcto;
                }
            }
        System.out.println("5 errores");
        resultados[2] = System.currentTimeMillis() - startTime;
        palabras.remove(pos);
        respuestas.remove(pos);
        Main.actividad.pressedr = false;
        return correcto;
    }
}