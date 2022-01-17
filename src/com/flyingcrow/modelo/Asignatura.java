package com.flyingcrow.modelo;

public class Asignatura {
	private String idas;
	private String nombreCiclo;
	private String codigoAsignatura;
	
	public Asignatura(String nombreCiclo, String codigoAsignatura) {
		this("No asignado aun", nombreCiclo, codigoAsignatura);
	}
	
	public Asignatura(String idas, String nombreCiclo, String codigoAsignatura) {
		this.idas = idas;
		this.nombreCiclo = nombreCiclo;
		this.codigoAsignatura = codigoAsignatura;
	}

	public String getIdas() {
		return idas;
	}

	public String getNombre() {
		return nombreCiclo;
	}

	public void setNombre(String nombre) {
		this.nombreCiclo = nombre;
	}

	public String getCodigoAsugnatura() {
		return codigoAsignatura;
	}

	@Override
	public String toString() {
		return "Asignatura [idas=" + idas + ", nombreCiclo=" + nombreCiclo + ", codigoAsignatura=" + codigoAsignatura
				+ "]";
	}

	
}
