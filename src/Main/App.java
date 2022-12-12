package Main;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

class App {
	public static String prediccion(String rasgo, String texto) {
		String url = "http://127.0.0.1:5000/persontext/" + rasgo +"/" + URLEncoder.encode(texto);
		System.out.println(url);
		String respuesta = "";
		try {
			respuesta = peticionHttpGet(url);
		} catch (Exception e) {
			// Manejar excepción
			e.printStackTrace();
		}

		JSONObject jsonObject = null;

		try {
			jsonObject = new JSONObject(respuesta);
			System.out.println("Respuesta : " +jsonObject.toString());
		} catch (Exception err){
			System.out.println("Exeption : " +err.toString());
		}

		String regreso = (String) jsonObject.getString("presenta_"+rasgo);
		System.out.println(regreso);
		return regreso;
	}
	public static String peticionHttpGet(String urlParaVisitar) throws Exception {
		// Esto es lo que vamos a devolver
		StringBuilder resultado = new StringBuilder();
		// Crear un objeto de tipo URL
		URL url = new URL(urlParaVisitar);

		// Abrir la conexión e indicar que será de tipo GET
		HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
		conexion.setRequestMethod("GET");
		// Búferes para leer
		BufferedReader rd = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
		String linea;
		// Mientras el BufferedReader se pueda leer, agregar contenido a resultado
		while ((linea = rd.readLine()) != null) {
			resultado.append(linea);
		}
		// Cerrar el BufferedReader
		rd.close();
		// Regresar resultado, pero como cadena, no como StringBuilder
		return resultado.toString();
	}
}

