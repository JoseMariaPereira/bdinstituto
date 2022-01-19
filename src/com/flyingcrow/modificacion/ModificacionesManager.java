package com.flyingcrow.modificacion;

import java.util.ArrayList;
import java.util.Scanner;

import com.flyingcrow.bbdd.ConectionManager;
import com.flyingcrow.consultas.ConsultaAlumno;
import com.flyingcrow.consultas.ConsultaAsignatura;
import com.flyingcrow.consultas.ConsultaProfesor;
import com.flyingcrow.modelo.Alumno;
import com.flyingcrow.modelo.Asignatura;
import com.flyingcrow.modelo.Nota;
import com.flyingcrow.modelo.Profesor;

public class ModificacionesManager {
	
	private ConectionManager connection;
	
	public ModificacionesManager(ConectionManager connection) {
		this.connection = connection;
	}
	
	public void ConsultasMenu(Scanner scan) {
		String opcion;
		do {
			System.out.print("\n1.- Modificar una Nota"
					+ "\n2.- Volver"
					+ "\n\nSelecciona una opcion: ");
			
			opcion = scan.nextLine();
			
			System.out.println();
			
			switch (opcion) {
			case "1":
				System.out.println("Iniciando Consulta de un profesor...");
				Alumno a = ModificacionNota.ModificacionDeAlumno(scan, connection);
				if (a!=null) {
					/*ArrayList<Asignatura> asignaturas = connection.ReadAsignaturaProfesor(a);
					System.out.println("\nAsignaturas impartidas por " + a +":");
					asignaturas.forEach(s->System.out.println(s));
					System.out.println();*/
				}
				break;
			case "2":
				System.out.println("Volviendo...");
				return;
			default:
				System.out.println(opcion + " no es un valor aceptado, vuelve a intentarlo!\n\n");
			}
		} while (true);
	}
	
}
