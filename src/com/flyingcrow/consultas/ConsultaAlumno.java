package com.flyingcrow.consultas;

import java.util.ArrayList;
import java.util.Scanner;

import com.flyingcrow.bbdd.ConectionManager;
import com.flyingcrow.modelo.Alumno;

public class ConsultaAlumno {

	public static Alumno ConsultaDeAlumno(Scanner scan, ConectionManager connection) {
		System.out.println("\nSelecciona un Alumno de la base de datos...");
		ArrayList<Alumno> alumnos = connection.ReadAllAlumnos();
		if (alumnos.size() == 0) {
			System.out.println("No hay Alumno en la base de datos...");
			return null;
		}
		
		alumnos.forEach(p->System.out.println(p));

		System.out.print("Marca el id del alumno que quieras consultar: ");
		Alumno profesor = connection.ReadAlumno(scan.nextLine());
		
		if (profesor == null) {
			System.out.println("Alumno no encontrada...");
			return null;
		}
		
		return profesor;
	}
	
}
