package com.flyingcrow.modelo;

import java.time.LocalDate;

public class Nota {
	
	private Alumno alumno;
	private Asignatura asignatura;
	private LocalDate fecha;
	private int nota;
	
	public Nota(Alumno alumno, Asignatura asignatura, int nota) {
		this(alumno, asignatura, LocalDate.now(), nota);
	}

	public Nota(Alumno alumno, Asignatura asignatura, LocalDate fecha, int nota) {
		super();
		this.alumno = alumno;
		this.asignatura = asignatura;
		this.fecha = fecha;
		this.nota = nota;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Asignatura getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	@Override
	public String toString() {
		return "Nota [alumno=" + alumno + ", asignatura=" + asignatura + ", fecha=" + fecha + ", nota=" + nota + "]";
	}
	
	
}
