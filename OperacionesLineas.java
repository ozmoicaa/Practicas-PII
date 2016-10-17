package pii.main;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class OperacionesLineas {

	public static ArrayList<Linea> añadirLinea(Scanner entradaTeclado, String docEntrada, ArrayList<Linea> lineas, ArrayList<Linea> lineasEncontradas) {

		System.out.println("Por favor, introduzca el número de línea");
		String numero = entradaTeclado.nextLine();
		for (Linea linea : lineas) {
			if (numero.equals(linea.getNumero())) {
				System.out.println("\nLínea existente");
				return lineas;
			}
		}
		System.out.println("Por favor, introduzca el lugar de salida de la línea");
		String lugarSalida = entradaTeclado.nextLine();
		System.out.println("Por favor, introduzca la hora de salida de la línea en formato hh:mm");
		String horaSalida = entradaTeclado.nextLine();
		System.out.println("Por favor, introduzca el lugar de llegada de la línea");
		String lugarLlegada = entradaTeclado.nextLine();
		System.out.println("Por favor, introduza la hora de llegada de la línea");
		String horaLlegada = entradaTeclado.nextLine();
		lineas.add(new Linea(numero, lugarSalida, horaSalida, lugarLlegada, horaLlegada));
		//lineasEncontradas.add(new Linea(numero , lugarSalida, horaSalida, lugarLlegada, horaLlegada));
		return lineas;
	}

	public static void buscarHoraLinea(String horaLlegada, ArrayList<Linea> lineas) {

		ArrayList<Linea> lineasEncontradas = new ArrayList<Linea>();
		for (Linea linea : lineas) {
			if (horaLlegada.equals(linea.getHoraLlegada())) {
				lineasEncontradas.add(linea);
			}
		}
		if (lineasEncontradas.size() == 0) {
			System.out.println("\nLínea no existente");
			return;
		}
		System.out.printf("%-12s %-15s %-14s %-25s %-25s\n", "Nº Linea", "Lugar Salida", "Hora Salida", "Lugar Llegada",
				"Hora Llegada");
		for (Linea linea : lineasEncontradas) {
			System.out.printf("%-12s %-15s %-14s %-25s %-25s\n", linea.getNumero(), linea.getLugarSalida(),
					linea.getHoraSalida(), linea.getLugarLlegada(), linea.getHoraLlegada());
		}
		return;
	}

	public static void ordenarHoraSalida(ArrayList<Linea> lineass) {
		Collections.sort(lineass, new Comparator<Linea>() {
			@Override
			public int compare(Linea linea1, Linea linea2) {
				DecimalFormat df = new DecimalFormat("00");
				String[] partes = linea1.getHoraSalida().split(":");
				linea1.setHoraSalida(
						(df.format(Integer.parseInt(partes[0])) + ":" + df.format(Integer.parseInt(partes[1]))));
				String[] partesLinea = (linea2.getHoraSalida()).split(":");
				linea2.setHoraSalida(df.format(Integer.parseInt(partesLinea[0])) + ":"
						+ df.format(Integer.parseInt(partesLinea[1])));
				int last = linea1.getHoraSalida().compareTo(linea2.getHoraSalida());
				return last;
			}
		});
		System.out.printf("%-12s %-15s %-14s %-25s %-25s\n", "Nº Linea", "Lugar Salida", "Hora Salida", "Lugar Llegada",
				"Hora Llegada");
		for (Linea linea2 : lineass) {
			System.out.printf("%-12s %-15s %-14s %-25s %-25s\n", linea2.getNumero(), linea2.getLugarSalida(),
					linea2.getHoraSalida(), linea2.getLugarLlegada(), linea2.getHoraLlegada());
		}
		return;
	}

	public static void menuLineas() {
		System.out.println("\n1) Añadir una nueva línea.\n" + "2) Ordenar por hora de salida.\n"
				+ "3) Ordenar por lugar de salida\n" + "4) Buscar por número de línea.\n"
				+ "5) Buscar por hora de llegada.\n" + "6) Fin del programa.\n");
	}

	public static void ordenarLugarSalida(ArrayList<Linea> lineas) {
		Collections.sort(lineas, new Comparator<Linea>() {
			@Override
			public int compare(Linea l1, Linea l2) {
				int last = l1.getLugarSalida().compareTo(l2.getLugarSalida());
				return last;
			}
		});
		System.out.printf("%-12s %-15s %-14s %-25s %-25s\n", "Nº Linea", "Lugar Salida", "Hora Salida", "Lugar Llegada",
				"Hora Llegada");
		for (Linea linea : lineas) {
			System.out.printf("%-12s %-15s %-14s %-25s %-25s\n", linea.getNumero(), linea.getLugarSalida(),
					linea.getHoraSalida(), linea.getLugarLlegada(), linea.getHoraLlegada());
		}
		return;
	}

	public static void buscarNumeroLinea(String numLinea, ArrayList<Linea> lineas) {
		HashMap<String, Linea> hashLineas = new HashMap<String, Linea>();
		// creo el mapa
		for (Linea linea : lineas) {
			hashLineas.put(linea.getNumero(), linea);
		}
		try {
			Linea auxResultado = hashLineas.get(numLinea);
			auxResultado.getHoraLlegada();
			System.out.printf("%-12s %-15s %-14s %-25s %-25s\n", "Nº Linea", "Lugar Salida", "Hora Salida",
					"Lugar Llegada", "Hora Llegada");
			System.out.printf("%-12s %-15s %-14s %-25s %-25s\n", auxResultado.getNumero(),
					auxResultado.getLugarSalida(), auxResultado.getHoraSalida(), auxResultado.getLugarLlegada(),
					auxResultado.getHoraLlegada());
		} catch (Exception e) {
			System.out.println("\nLinea no existente");
			return;
		}
	}
}
