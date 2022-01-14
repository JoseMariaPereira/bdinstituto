package com.flyingcrow.altas;

import java.util.Scanner;

import com.flyingcrow.modelo.Profesor;

public class AltaProfesor {

	public static Profesor AltaDeProfesor(Scanner scan) {
		String nombre, dni, titulacion;
		System.out.print("\nIndica el nombre del profesor: ");
		do {
			nombre = scan.nextLine();
		} while (nombre.isBlank());
		System.out.print("Indica el dni del profesor: ");
		do {
			dni = scan.nextLine();
		} while (dni.isBlank());
		System.out.print("Indica la titulacion del profesor: ");
		do {
			titulacion = scan.nextLine();
		} while (titulacion.isBlank());
		Profesor profesor = new Profesor(dni, nombre, titulacion);
		return profesor;
	}
	
}
