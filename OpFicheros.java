package pii.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class OpFicheros {

	public static ArrayList<Linea> leerFichero(String pathFich, ArrayList<Linea> lineas) {

		try {
			FileReader fileReader = new FileReader(pathFich);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line = "";
			while ((line = bufferedReader.readLine()) != null) {
				String[] partes = line.split("\\s*\\*\\s*");
				Linea linea = new Linea(partes[0], partes[1], partes[2], partes[3],
						partes[4]);
				lineas.add(linea);
				 //System.out.println(line);

			}
			bufferedReader.close();
			fileReader.close();
		} catch (Exception IOException) {
			System.out.println("Fichero inexistente <" + pathFich + ">");
		}
		return lineas;
	}

	public static void escribirFichero2(String docSalida, ArrayList<Linea> linea) {

		try {
			FileWriter fileWriter = new FileWriter(docSalida);
			for (int i = 0; i < linea.size(); i++) {
				fileWriter.write((linea.get(i)).toString() + "\n");
			}
			fileWriter.close();

		} catch (Exception IOException) { // trata cualquier tipo de expcepcion
			System.out.println("Error al generar el fichero");
		}
	}
}
