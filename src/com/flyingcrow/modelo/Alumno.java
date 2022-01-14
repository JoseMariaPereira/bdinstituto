package com.flyingcrow.modelo;

public class Alumno {
	private String idal;
	private String nombre;
	private String codigoAlumno;
	
	public Alumno(String nombre, String codigoAlumno) {
		this("No asignado aun", nombre, codigoAlumno);
	}
	
	public Alumno(String idal, String nombre, String codigoAlumno) {
		this.idal = idal;
		this.nombre = nombre;
		this.codigoAlumno = codigoAlumno;
	}

	public String getIdal() {
		return idal;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigoAlumno() {
		return codigoAlumno;
	}
	
	
	@Override
	public String toString() {
		return "Nombre: " + getNombre()
				+ "\nID: " + getIdal()
				+ "\nCodigo Alumno: " + getCodigoAlumno();
	}
}
