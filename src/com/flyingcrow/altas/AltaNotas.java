package com.flyingcrow.altas;

import java.util.ArrayList;
import java.util.Scanner;

import com.flyingcrow.bbdd.ConectionManager;
import com.flyingcrow.modelo.Alumno;
import com.flyingcrow.modelo.Asignatura;
import com.flyingcrow.modelo.Nota;

public class AltaNotas {

	public static Nota AltaDeNotas (Scanner scan, ConectionManager connection) {

		ArrayList<Alumno> alumnos = connection.ReadAllAlumnos();
		
		if (alumnos.size() == 0) {
			System.out.println("No hay alumnos en la base de datos...");
			return null;
		}
		
		System.out.println("Selecciona un alumno de la base de datos...\n");
		
		alumnos.forEach(a->System.out.println(a));

		System.out.print("\nMarca el id del alumno: ");
		Alumno alumno = connection.ReadAlumno(scan.nextLine());
		
		if (alumno == null) {
			System.out.println("Alumno no encontrado...");
			return null;
		}
		
		System.out.println("Alumno: " + alumno + " seleccionado!");
		
		ArrayList<Asignatura> asignaturas = connection.ReadAllAsignaturas();
		
		if (asignaturas.size() == 0) {
			System.out.println("No hay asignaturas en la base de datos...");
			return null;
		}
		
		System.out.println("\nSeleccinoa una asignatura...");
		
		asignaturas.forEach(a->System.out.println(a));
		
		System.out.print("Selecciona una asignatura: ");
		Asignatura asignatura = connection.ReadAsignatura(scan.nextLine());
		
		if (asignatura == null) {
			System.out.println("Asignatura no encontrada...");
			return null;
		}
		
		int numnota = -1;
		while (numnota < 0 || numnota > 10) {
			try {
				System.out.print("Introduce una nota del 0 al 10: ");
				numnota = scan.nextInt();
			} catch (NumberFormatException e) {
				System.out.println("Introduce un numero entero del 0 al 10...");
			}
		}
		
		return new Nota(alumno, asignatura, numnota);		
	}
	
}
