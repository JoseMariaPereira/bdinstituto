package com.flyingcrow.bajas;

import java.util.ArrayList;
import java.util.Scanner;

import com.flyingcrow.bbdd.ConectionManager;
import com.flyingcrow.modelo.Profesor;

public class BajaProfesor {

	public static Profesor BajaDeProfesor(Scanner scan, ConectionManager connection) {
		
		System.out.println("\nSelecciona un profesor de la base de datos...");
		ArrayList<Profesor> profesores = connection.ReadAllProfesores();
		if (profesores.size() == 0) {
			System.out.println("No hay Profesores en la base de datos...");
			return null;
		}
		
		profesores.forEach(p->System.out.println(p));

		System.out.print("Marca el dni del profesor que quieras dar de baja: ");
		Profesor profesor = connection.ReadProfesor(scan.nextLine());
		
		if (profesor == null) {
			System.out.println("Profesor no encontrada...");
			return null;
		}
		
		return profesor;
	}
	
}
