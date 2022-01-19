package com.flyingcrow.consultas;

import java.util.ArrayList;
import java.util.Scanner;

import com.flyingcrow.bbdd.ConectionManager;
import com.flyingcrow.modelo.Alumno;
import com.flyingcrow.modelo.Asignatura;
import com.flyingcrow.modelo.Nota;
import com.flyingcrow.modelo.Profesor;

public class ConsultasManager {
	
	private ConectionManager connection;
	
	public ConsultasManager(ConectionManager connection) {
		this.connection = connection;
	}
	
	public void ConsultasMenu(Scanner scan) {
		String opcion;
		do {
			System.out.print("\n1.- Listado de un Profesor"
					+ "\n2.- Listado de un Alumno"
					+ "\n3.- Listado de una Asignatura"
					+ "\n4.- Volver"
					+ "\n\nSelecciona una opcion: ");
			
			opcion = scan.nextLine();
			
			System.out.println();
			
			switch (opcion) {
			case "1":
				System.out.println("Iniciando Consulta de un profesor...");
				Profesor p = ConsultaProfesor.ConsultaDeProfesor(scan, connection);
				if (p!=null) {
					ArrayList<Asignatura> asignaturas = connection.ReadAsignaturaProfesor(p);
					System.out.println("\nAsignaturas impartidas por " + p +":");
					asignaturas.forEach(a->System.out.println(a));
					System.out.println();
				}
				break;
			case "2":
				System.out.println("Iniciando Consulta de un alumno...");
				Alumno alumno = ConsultaAlumno.ConsultaDeAlumno(scan, connection);
				if (alumno!=null) {
					ArrayList<Nota> notas = connection.ReadNotasAlumno(alumno);
					System.out.println("\nNotas de " + alumno +":");
					notas.forEach(a->System.out.println(a));
					System.out.println();
				}
				break;
			case "3":
				System.out.println("Iniciando Consulta de una asignatura...");
				Asignatura asignatura = ConsultaAsignatura.ConsultaDeAsignatura(scan, connection);
				if (asignatura!=null) {
					ArrayList<Profesor> profesores = connection.ReadAsignaturasDeProfesores(asignatura);
					System.out.println("\nProfesores que imparten " + asignatura +":");
					profesores.forEach(a->System.out.println(a));
					System.out.println();
				}
				break;
			case "4":
				System.out.println("Volviendo...");
				return;
			default:
				System.out.println(opcion + " no es un valor aceptado, vuelve a intentarlo!\n\n");
			}
		} while (true);
	}
}
