package com.flyingcrow.consultas;

import java.util.ArrayList;
import java.util.Scanner;

import com.flyingcrow.bbdd.ConectionManager;
import com.flyingcrow.modelo.Profesor;

public class ConsultaProfesor {

	public static Profesor ConsultaDeProfesor(Scanner scan, ConectionManager connection) {
		System.out.println("\nSelecciona un profesor de la base de datos...");
		ArrayList<Profesor> profesores = connection.ReadAllProfesores();
		if (profesores.size() == 0) {
			System.out.println("No hay Profesores en la base de datos...");
			return null;
		}
		
		profesores.forEach(p->System.out.println(p));

		System.out.print("Marca el dni del profesor que quieras consultar: ");
		Profesor profesor = connection.ReadProfesor(scan.nextLine());
		
		if (profesor == null) {
			System.out.println("Profesor no encontrada...");
			return null;
		}
		
		return profesor;
	}
	
	
}
