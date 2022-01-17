package com.flyingcrow.modelo;

public class Ternaria {

	private Profesor profesor;
	private Alumno alumno;
	private Asignatura asignatura;
	
	public Ternaria(Profesor profesor, Alumno alumno, Asignatura asignatura) {
		super();
		this.profesor = profesor;
		this.alumno = alumno;
		this.asignatura = asignatura;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
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
	
}
