package com.flyingcrow.altas;

import java.util.Scanner;

import com.flyingcrow.bbdd.ConectionManager;
import com.flyingcrow.modelo.Nota;
import com.flyingcrow.modelo.Ternaria;

public class AltasManager {
	
	private ConectionManager connection;
	
	public AltasManager(ConectionManager connection) {
		this.connection = connection;
	}
	
	public void AltasMenu(Scanner scan) {
		String opcion;
		do {
			System.out.print("\n1.- Alta Profesor"
					+ "\n2.- Alta Alumno"
					+ "\n3.- Alta Asignatura"
					+ "\n4.- Alta Nota"
					+ "\n5.- Alta Relacion Profesor/Alumno/Asignatura"
					+ "\n6.- Volver"
					+ "\n\nSelecciona una opcion: ");
			
			opcion = scan.nextLine();
			
			System.out.println();
			
			switch (opcion) {
			case "1":
				System.out.println("Creando nueva entrada para Profesores...");
				connection.InsertProfesor(AltaProfesor.AltaDeProfesor(scan));
				break;
			case "2":
				System.out.println("Creando nueva entrada para Alumnos...");
				connection.InsertAlumno(AltaAlumno.AltaDeAlumno(scan));
				break;
			case "3":
				System.out.println("Creando nueva entrada para Asignatura...");
				connection.InsertAsignatura(AltaAsignatura.AltaDeAsignaturas(scan));
				break;
			case "4":
				System.out.println("Creando nueva nota...");
				Nota n = AltaNotas.AltaDeNotas(scan, connection);
				if (n != null) {
					connection.InsertNota(n);
				}
				break;
			case "5": 
				System.out.println("Creando nueva relacion...");
				Ternaria t = AltaTernaria.AltaDeTernaria(scan, connection);
				if (t != null) {
					
				}
				break;
			case "6":
				System.out.println("Volviendo...");
				break;
			default:
				System.out.println(opcion + " no es un valor aceptado, vuelve a intentarlo!\n\n");
				opcion = "";
			}
		} while (opcion.equals(""));
	}
	
}
