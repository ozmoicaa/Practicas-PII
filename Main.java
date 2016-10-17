package pii.main;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		String docEntrada = args[0];
		String docSalida = args[1];
		Scanner entradaTeclado = new Scanner(System.in);
		ArrayList<Linea> lineas = new ArrayList<Linea>();
		ArrayList<Linea> lineasAñadidas = new ArrayList<Linea>();
		lineas = OpFicheros.leerFichero(docEntrada, lineas);
		do {
		
			OperacionesLineas.menuLineas();
			// entradaTeclado.nextLine();
			String opcion = entradaTeclado.nextLine();
			switch (Integer.valueOf(opcion)) {
			case 1: {
				lineas = OperacionesLineas.añadirLinea(entradaTeclado, docEntrada, lineas, lineasAñadidas);
				break;
			}
			case 2: {
				/* Ordenar por hora de salida */
				OperacionesLineas.ordenarHoraSalida(lineas);
				break;
			}
			case 3: {
				OperacionesLineas.ordenarLugarSalida(lineas);
				break;
			}
			case 4: {
				System.out.println("Por favor, introduzca el número de la línea deseada");
				String numLinea = entradaTeclado.nextLine();
				OperacionesLineas.buscarNumeroLinea(numLinea, lineas);
				break;
			}
			case 5: {
				System.out.println("Por favor, introduzca la hora de llegada de la línea deseada");
				String horaSalida = entradaTeclado.nextLine();
				OperacionesLineas.buscarHoraLinea(horaSalida, lineas);
				break;
			}
			case 6: {
				//ArrayList<Linea> lineasFinales = new ArrayList<Linea>();
			//	lineasFinales= OpFicheros.leerFichero(docEntrada, lineas);
				OpFicheros.escribirFichero2(docSalida, lineas);
				//OpFicheros.escribirFichero2(docSalida, lineasFinales);
				//OpFicheros.escribirFichero2(docSalida, lineasAñadidas);
				entradaTeclado.close();
				System.exit(0);
			}
			default: System.out.println("Opción no válida, vuelva a introducir");
			break;
			}
		} while (true);

	}

	

}
