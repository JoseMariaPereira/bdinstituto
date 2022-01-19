package com.flyingcrow.consultas;

import java.util.ArrayList;
import java.util.Scanner;

import com.flyingcrow.bbdd.ConectionManager;
import com.flyingcrow.modelo.Asignatura;

public class ConsultaAsignatura {

	public static Asignatura ConsultaDeAsignatura(Scanner scan, ConectionManager connection) {
		System.out.println("\nSelecciona una Asignatura de la base de datos...");
		ArrayList<Asignatura> alumnos = connection.ReadAllAsignaturas();
		if (alumnos.size() == 0) {
			System.out.println("No hay Asignaturas en la base de datos...");
			return null;
		}
		
		alumnos.forEach(p->System.out.println(p));

		System.out.print("Marca el id de la asignatura que quieras consultar: ");
		Asignatura profesor = connection.ReadAsignatura(scan.nextLine());
		
		if (profesor == null) {
			System.out.println("asignatura no encontrada...");
			return null;
		}
		
		return profesor;
	}
	
}
