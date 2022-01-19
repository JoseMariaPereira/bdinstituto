package com.flyingcrow.bajas;

import java.util.Scanner;

import com.flyingcrow.bbdd.ConectionManager;
import com.flyingcrow.modelo.Alumno;
import com.flyingcrow.modelo.Profesor;

public class BajasManager {
	
	private ConectionManager connection;
	
	public BajasManager(ConectionManager connection) {
		this.connection = connection;
	}
	
	public void BajasMenu(Scanner scan) {
		String opcion;
		do {
			System.out.print("\n1.- Baja Profesor"
					+ "\n2.- Baja Alumno"
					+ "\n3.- Volver"
					+ "\n\nSelecciona una opcion: ");
			
			opcion = scan.nextLine();
			
			System.out.println();
			
			switch (opcion) {
			case "1":
				System.out.println("Iniciando Baja de un profesor...");
				Profesor p = BajaProfesor.BajaDeProfesor(scan, connection);
				if (p!=null) {
					connection.DeleteProfesor(p);
				}
				break;
			case "2":
				System.out.println("Creando nueva entrada para Alumnos...");
				Alumno a = BajaAlumno.BajaDeAlumno(scan, connection);
				if (a != null) {
					connection.DeleteAlumno(a);		
				}
				break;
			case "3":
				System.out.println("Volviendo...");
				return;
			default:
				System.out.println(opcion + " no es un valor aceptado, vuelve a intentarlo!\n\n");
			}
		} while (true);
	}
}
