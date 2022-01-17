package com.flyingcrow.altas;

import java.util.ArrayList;
import java.util.Scanner;

import com.flyingcrow.bbdd.ConectionManager;
import com.flyingcrow.modelo.Alumno;
import com.flyingcrow.modelo.Asignatura;
import com.flyingcrow.modelo.Profesor;
import com.flyingcrow.modelo.Ternaria;

public class AltaTernaria {
	
	public static Ternaria AltaDeTernaria (Scanner scan, ConectionManager connection) {
		
		Ternaria ternaria = null;
		
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
		
		System.out.println("Selecciona un Profesor...");
		ArrayList<Profesor> profesores = connection.ReadAllProfesores();
		if (profesores.size() == 0) {
			System.out.println("No hay Profesores en la base de datos...");
			return null;
		}
		System.out.println("Selecciona un profesor de la base de datos...\n");
		
		profesores.forEach(p->System.out.println(p));

		System.out.print("\nMarca el dni del profesor: ");
		Profesor profesor = connection.ReadProfesor(scan.nextLine());
		
		if (profesor == null) {
			System.out.println("Profesor no encontrada...");
			return null;
		}
		
		return new Ternaria(profesor, alumno, asignatura);
	}
}
