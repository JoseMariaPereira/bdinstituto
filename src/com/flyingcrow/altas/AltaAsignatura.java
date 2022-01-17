package com.flyingcrow.altas;

import java.util.Scanner;

import com.flyingcrow.modelo.Asignatura;

public class AltaAsignatura {
	public static Asignatura AltaDeAsignaturas(Scanner scan) {
		String nombre, codigoAsignatura;
		System.out.print("\nIndica el nombre del ciclo: ");
		do {
			nombre = scan.nextLine();
		} while (nombre.isBlank());
		System.out.print("Indica el codigo de la asignatura: ");
		do {
			codigoAsignatura = scan.nextLine();
		} while (codigoAsignatura.isBlank());
		Asignatura asignatura = new Asignatura(nombre, codigoAsignatura);
		return asignatura;
	}
}
