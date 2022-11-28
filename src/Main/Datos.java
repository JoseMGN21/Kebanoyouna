package Main;
import java.util.ArrayList;
import java.util.List;

public class Datos {
    ArrayList<String> respuestas;
    static ArrayList<String> palabras;
    boolean vacio;
    public Datos(int dificultad) {
        respuestas = new ArrayList<>();
        palabras = new ArrayList<>();
        if (dificultad == 1) {
            respuestas.add("aoi");
            respuestas.add("iie");
            respuestas.add("namae");
            respuestas.add("doko");
            respuestas.add("fune");
            respuestas.add("hon");
            respuestas.add("umi");
            respuestas.add("momo");
            respuestas.add("tsume");
            respuestas.add("sono");
            palabras.add("あおい");
            palabras.add("いいえ");
            palabras.add("なまえ");
            palabras.add("どこ");
            palabras.add("ふね");
            palabras.add("ほん");
            palabras.add("うみ");
            palabras.add("もも");
            palabras.add("つめ");
            palabras.add("その");
            //vacio = false;
        } else if (dificultad == 2) {
            respuestas.add("kotoba");
            respuestas.add("tomodachi");
            respuestas.add("kakkoii");
            respuestas.add("arigatou");
            respuestas.add("terebi");
            respuestas.add("moa");
            respuestas.add("raigetsu");
            respuestas.add("getsuyoubi");
            respuestas.add("pasokon");
            respuestas.add("kamera");
            palabras.add("ことば");
            palabras.add("ともだち");
            palabras.add("かっこいい");
            palabras.add("ありがとう");
            palabras.add("テレビ");
            palabras.add("モア");
            palabras.add("らいげつ");
            palabras.add("げつようび");
            palabras.add("パソコン");
            palabras.add("カメラ");
            //vacio = false;
        } else {
            respuestas.add("hanbaagaa");
            respuestas.add("muzukashii");
            respuestas.add("chokoreeto");
            respuestas.add("makudonarudo");
            respuestas.add("benkyoushimasu");
            respuestas.add("gomennasai");
            respuestas.add("konnichiha");
            respuestas.add("jidouhanbaiki");
            respuestas.add("natsuyasumi");
            respuestas.add("sandoicchi");
            palabras.add("ハンバーガー");
            palabras.add("むずかしい");
            palabras.add("チョコレート");
            palabras.add("マクドナルド");
            palabras.add("べんきょうします");
            palabras.add("ごめんなさい");
            palabras.add("こんにちは");
            palabras.add("じどうはんばいき");
            palabras.add("なつやすみ");
            palabras.add("サンドイッチ");
            //vacio = false;
        }
    }
}
