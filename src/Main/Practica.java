
package Main;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Practica {
    static Random r1 = new Random();
    static Random r2 = new Random();
    static int pos, pos2;
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

    public static long[] comparacionfacil() throws InterruptedException{
        if (Main.datos.palabrasComparacion.size() == 0) {
            Main.datos = new Datos(Main.difficulty);
        }
        palabras = Main.datos.palabrasComparacion;
        respuestas = Main.datos.respuestasComparacion;
        startTime = System.currentTimeMillis();
        errores = 0;
        tiempoAyudas = 0;
        pos = r1.nextInt(0,palabras.size());
        pos2 = r2.nextInt(0,3);
        int bound = Main.datos.respuestasComparacion.get(pos)[pos2].indexOf("-");
        Main.comparacion.palabra.setText(Main.datos.respuestasComparacion.get(pos)[pos2].substring(0,bound));
        Main.comparacion.tipoKana.setText(Main.datos.respuestasComparacion.get(pos)[pos2].substring(bound+2,Main.datos.respuestasComparacion.get(pos)[pos2].length()));
        Main.comparacion.button1.setText(Main.datos.palabrasComparacion.get(pos)[0]);
        Main.comparacion.button2.setText(Main.datos.palabrasComparacion.get(pos)[1]);
        Main.comparacion.button3.setText(Main.datos.palabrasComparacion.get(pos)[2]);
        Main.comparacion.button4.setText(Main.datos.palabrasComparacion.get(pos)[3]);
        Main.datos.palabrasComparacion.remove(pos);
        Main.datos.respuestasComparacion.remove(pos);
        while(!Main.comparacion.correct ){
            Thread.sleep(200);
        } if(Main.comparacion.correct){
            System.out.println("Regresando resultados...");
            Main.comparacion.pressedr = false;
            resultados[0] = tiempoAyudas/1000;
            resultados[1] = errores;
            resultados[2] = System.currentTimeMillis() - startTime;
            return resultados;
        }
        return resultados;
    }
    public static long[] comparacionmedio() throws InterruptedException{
        if (Main.datos.palabrasComparacion.size() == 0) {
            Main.datos = new Datos(Main.difficulty);
        }
        palabras = Main.datos.palabrasComparacion;
        respuestas = Main.datos.respuestasComparacion;
        startTime = System.currentTimeMillis();
        errores = 0;
        tiempoAyudas = 0;
        pos = r1.nextInt(0,palabras.size());
        pos2 = r2.nextInt(0,3);
        int bound = Main.datos.respuestasComparacion.get(pos)[pos2].indexOf("-");
        Main.comparacion.palabra.setText(Main.datos.respuestasComparacion.get(pos)[pos2].substring(0,bound));
        Main.comparacion.tipoKana.setText(Main.datos.respuestasComparacion.get(pos)[pos2].substring(bound+2,Main.datos.respuestasComparacion.get(pos)[pos2].length()));
        Main.comparacion.button1.setText(Main.datos.palabrasComparacion.get(pos)[0]);
        Main.comparacion.button2.setText(Main.datos.palabrasComparacion.get(pos)[1]);
        Main.comparacion.button3.setText(Main.datos.palabrasComparacion.get(pos)[2]);
        Main.comparacion.button4.setText(Main.datos.palabrasComparacion.get(pos)[3]);
        Main.datos.palabrasComparacion.remove(pos);
        Main.datos.respuestasComparacion.remove(pos);
        while(!Main.comparacion.correct){
            Thread.sleep(200);
        } if(Main.comparacion.correct){
            System.out.println("Regresando resultados...");
            Main.comparacion.pressedr = false;
            resultados[0] = tiempoAyudas/1000;
            resultados[1] = errores;
            return resultados;
        }
        return resultados;
    }
    public static long[] comparaciondificil() throws InterruptedException{
        if (Main.datos.palabrasComparacion.size() == 0) {
            Main.datos = new Datos(Main.difficulty);
        }
        palabras = Main.datos.palabrasComparacion;
        respuestas = Main.datos.respuestasComparacion;
        startTime = System.currentTimeMillis();
        errores = 0;
        tiempoAyudas = 0;
        pos = r1.nextInt(0,palabras.size());
        pos2 = r2.nextInt(0,3);
        int bound = Main.datos.respuestasComparacion.get(pos)[pos2].indexOf("-");
        Main.comparacion.palabra.setText(Main.datos.respuestasComparacion.get(pos)[pos2].substring(0,bound));
        Main.comparacion.tipoKana.setText(Main.datos.respuestasComparacion.get(pos)[pos2].substring(bound+2,Main.datos.respuestasComparacion.get(pos)[pos2].length()));
        Main.comparacion.button1.setText(Main.datos.palabrasComparacion.get(pos)[0]);
        Main.comparacion.button2.setText(Main.datos.palabrasComparacion.get(pos)[1]);
        Main.comparacion.button3.setText(Main.datos.palabrasComparacion.get(pos)[2]);
        Main.comparacion.button4.setText(Main.datos.palabrasComparacion.get(pos)[3]);
        Main.datos.palabrasComparacion.remove(pos);
        Main.datos.respuestasComparacion.remove(pos);
        while(!Main.comparacion.correct){
            Thread.sleep(200);
        } if(Main.comparacion.correct){
            System.out.println("Regresando resultados...");
            Main.comparacion.pressedr = false;
            resultados[0] = tiempoAyudas/1000;
            resultados[1] = errores;
            return resultados;
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