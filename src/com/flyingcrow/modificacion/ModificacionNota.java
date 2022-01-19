package com.flyingcrow.modificacion;

import java.util.ArrayList;
import java.util.Scanner;

import com.flyingcrow.bbdd.ConectionManager;
import com.flyingcrow.modelo.Alumno;

public class ModificacionNota {
	public static Alumno ModificacionDeAlumno(Scanner scan, ConectionManager connection) {
		System.out.println("\nSelecciona un Alumno de la base de datos...");
		ArrayList<Alumno> alumnos = connection.ReadAllAlumnos();
		if (alumnos.size() == 0) {
			System.out.println("No hay Alumno en la base de datos...");
			return null;
		}
		
		alumnos.forEach(p->System.out.println(p));

		System.out.print("Marca el id del alumno que quieras cambiar la nota: ");
		Alumno alumno = connection.ReadAlumno(scan.nextLine());
		
		if (alumno == null) {
			System.out.println("Alumno no encontrada...");
			return null;
		}
		
		return alumno;
	}
}
