package com.flyingcrow.altas;

import java.util.Scanner;

import com.flyingcrow.modelo.Alumno;

public class AltaAlumno {

	
	public static Alumno AltaDeAlumno(Scanner scan) {
		String nombre, codigoAlumno;
		System.out.print("\nIndica el nombre del alumno: ");
		do {
			nombre = scan.nextLine();
		} while (nombre.isBlank());
		System.out.print("Indica el codigo del alumno: ");
		do {
			codigoAlumno = scan.nextLine();
		} while (codigoAlumno.isBlank());
		Alumno alumno = new Alumno(nombre, codigoAlumno);
		return alumno;
	}
}
