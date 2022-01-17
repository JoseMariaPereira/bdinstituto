package com.flyingcrow.bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.flyingcrow.modelo.Alumno;
import com.flyingcrow.modelo.Asignatura;
import com.flyingcrow.modelo.Nota;
import com.flyingcrow.modelo.Profesor;
import com.mysql.cj.protocol.Resultset;

public class ConectionManager {
	
	private static ConectionManager conectionManager;
	
	private Connection connection;
	private Statement statement;
	
	private ConectionManager(String url, boolean create) throws SQLException {
		if (conectionManager == null) {
			conectionManager = this;
			connection = DriverManager.getConnection(url);
			statement = connection.createStatement();
			if (create) {
				CreateTables();
			}
		}
	}
	
	public static ConectionManager GetConectionManager(String url, boolean create) throws SQLException {
		if (conectionManager == null) {
			conectionManager = new ConectionManager(url, create);
		}
		return conectionManager;
	}
	/**
	 * Crea la base de datos si no existe, no la sobreescribe
	 * 
	 * @throws SQLException
	 */
	public void CreateTables() throws SQLException {
		statement.execute("CREATE DATABASE IF NOT EXISTS BDInstituto;");
		statement.execute("USE BDInstituto;");
		statement.execute("CREATE TABLE IF NOT EXISTS `Profesor` (\n"
				+ "  `dni` varchar(30) unique NOT NULL,\n"
				+ "  `nombre` varchar(30) NOT NULL,\n"
				+ "  `titulacion` varchar(30) NOT NULL,\n"
				+ "  PRIMARY KEY (`dni`)\n"
				+ ") ENGINE=InnoDB");
		statement.execute("CREATE table IF NOT EXISTS `alumno` (\r\n"
				+ "  `idal` int(4) unsigned zerofill auto_increment not null,\r\n"
				+ "  `codigoalumno` varchar(5) unique NOT NULL,\r\n"
				+ "  `nombre` varchar(30) NOT NULL,\r\n"
				+ "  PRIMARY KEY (`idal`)\r\n"
				+ ") ENGINE=InnoDB");
		statement.execute("CREATE table IF NOT EXISTS `asignatura` (\r\n"
				+ "  `idas` int(4) unsigned zerofill auto_increment not null,\r\n"
				+ "  `codigoasignatura` varchar(5) unique NOT NULL,\r\n"
				+ "  `nombreciclo` varchar(30) NOT NULL,\r\n"
				+ "  PRIMARY KEY (`idas`)\r\n"
				+ ") ENGINE=InnoDB\r\n"
				+ "");
		statement.execute("CREATE table IF NOT EXISTS `profesoralumnosasignatura` (\r\n"
				+ "  `dni` varchar(30) unique NOT NULL,\r\n"
				+ "  `idal` int(4) unsigned zerofill not null,\r\n"
				+ "  `idas` int(4) unsigned zerofill not null,\r\n"
				+ "  PRIMARY KEY (`idas`, `idal`),\r\n"
				+ "  foreign key(dni) references profesor(dni),\r\n"
				+ "  foreign key(idal) references alumno(idal) on delete cascade,\r\n"
				+ "  foreign key(idas) references asignatura(idas)\r\n"
				+ ") ENGINE=InnoDB");
		statement.execute("CREATE table IF NOT EXISTS `notas` (\r\n"
				+ "  `fecha` date NOT NULL,\r\n"
				+ "  `idal` int(4) unsigned zerofill not null,\r\n"
				+ "  `idas` int(4) unsigned zerofill not null,\r\n"
				+ "  nota int not null,\r\n"
				+ "  PRIMARY KEY (`idas`, `idal`, fecha),\r\n"
				+ "  foreign key(idal) references alumno(idal) on delete cascade,\r\n"
				+ "  foreign key(idas) references asignatura(idas)\r\n"
				+ ") ENGINE=InnoDB");
	}
	
	/**
	 * Inserta un profesor
	 * 
	 * @param profesor el profesor a insertar
	 * @return devuelve true si se ha insertado y false si ha ocurrido algun error
	 */
	public boolean InsertProfesor(Profesor profesor) {
		boolean returnValue = true;
		try {
			statement.executeUpdate("insert into profesor values('" + profesor.getDni() +"', '" + profesor.getNombre() + "', '" + profesor.getTitulacion() + "')");
			System.out.println("Profesor:\n" + profesor + "\n Insertado correctamente");
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error...");
			System.out.println("\n" + e.getMessage());
			returnValue = false;
		}
		return returnValue;
	}
	
	/**
	 * @return devuelve un lista de profesores de la bbdd
	 */
	public ArrayList<Profesor> ReadAllProfesores() {
		ArrayList<Profesor> profesores = new ArrayList<>();
		try {
			ResultSet result = statement.executeQuery("SELECT * FROM profesor");
			while(result.next()) {
				profesores.add(new Profesor(result.getString(1), result.getString(2), result.getString(3)));
			}			
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error...");
			System.out.println("\n" + e.getMessage());
		}
		return profesores;
	}
	
	/**
	 * @return devuelve un profesor especifico de la bbdd
	 */
	public Profesor ReadProfesor(String dni) {
		Profesor profesor = null;
		try {
			ResultSet result = statement.executeQuery("SELECT * FROM profesor WHERE dni = " + dni);
			if (result.next()) {
				profesor = new Profesor(result.getString(1), result.getString(2), result.getString(3));
			}
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error...");
			System.out.println("\n" + e.getMessage());
		}
		return profesor;
	}
	
	/**
	 * Inserta un alumno
	 * 
	 * @param alumno el alumno a insertar
	 * @return devuelve true si se ha insertado y false si ha ocurrido algun error
	 */
	public boolean InsertAlumno(Alumno alumno) {
		boolean returnValue = true;
		try {
			statement.executeUpdate("insert into alumno (codigoalumno, nombre) values('" + alumno.getCodigoAlumno() + "', '" + alumno.getNombre() + "')");
			System.out.println("Alumno:\n" + alumno + "\n Insertado correctamente");
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error...");
			System.out.println("\n" + e.getMessage());
			returnValue = false;
		}
		return returnValue;
	}
	
	/**
	 * @return devuelve un lista de alumnos de la bbdd
	 */
	public ArrayList<Alumno> ReadAllAlumnos() {
		ArrayList<Alumno> alumnos = new ArrayList<>();
		try {
			ResultSet result = statement.executeQuery("SELECT * FROM alumno");
			while(result.next()) {
				alumnos.add(new Alumno(result.getString(1), result.getString(3), result.getString(2)));
			}			
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error...");
			System.out.println("\n" + e.getMessage());
		}
		return alumnos;
	}
	
	/**
	 * @return devuelve un alumno especifico de la bbdd
	 */
	public Alumno ReadAlumno(String idal) {
		Alumno alumno = null;
		try {
			ResultSet result = statement.executeQuery("SELECT * FROM alumno WHERE idal = " + idal);
			if (result.next()) {
				alumno = new Alumno(result.getString(1), result.getString(3), result.getString(2));
			}
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error...");
			System.out.println("\n" + e.getMessage());
		}
		return alumno;
	}
	
	/**
	 * Inserta una asignatura
	 * 
	 * @param asignatura el asignatura a insertar
	 * @return devuelve true si se ha insertado y false si ha ocurrido algun error
	 */
	public boolean InsertAsignatura(Asignatura asignatura) {
		boolean returnValue = true;
		try {
			statement.executeUpdate("insert into asignatura (codigoasignatura, nombreciclo) values('" + asignatura.getCodigoAsugnatura() + "', '" + asignatura.getNombre() + "')");
			System.out.println("Asignatura:\n" + asignatura + "\n Insertado correctamente");
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error...");
			System.out.println("\n" + e.getMessage());
			returnValue = false;
		}
		return returnValue;
	}
	
	/**
	 * @return devuelve un lista de asignaturas de la bbdd
	 */
	public ArrayList<Asignatura> ReadAllAsignaturas() {
		ArrayList<Asignatura> asignaturas = new ArrayList<>();
		try {
			ResultSet result = statement.executeQuery("SELECT * FROM asignatura");
			while(result.next()) {
				asignaturas.add(new Asignatura(result.getString(1), result.getString(3), result.getString(2)));
			}			
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error...");
			System.out.println("\n" + e.getMessage());
		}
		return asignaturas;
	}
	
	/**
	 * @return devuelve un lista de asignaturas de la bbdd
	 */
	public Asignatura ReadAsignatura(String idas) {
		Asignatura asignatura = null;
		try {
			ResultSet result = statement.executeQuery("SELECT * FROM asignatura * WHERE idas = " + idas);
			if(result.next()) {
				asignatura = new Asignatura(result.getString(1), result.getString(3), result.getString(2));
			}			
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error...");
			System.out.println("\n" + e.getMessage());
		}
		return asignatura;
	}
	
	/**
	 * Inserta una nota
	 * 
	 * @param nota el nota a insertar
	 * @return devuelve true si se ha insertado y false si ha ocurrido algun error
	 */
	public boolean InsertNota(Nota nota) {
		boolean returnValue = true;
		try {
			statement.executeUpdate("insert into notas values('" + nota.getFecha().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + "', '" + nota.getAlumno().getIdal() + "', '" + nota.getAsignatura().getIdas() + "', '" + nota.getNota() + "')");
			System.out.println("Nota:\n" + nota + "\n Insertado correctamente");
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error...");
			System.out.println("\n" + e.getMessage());
			returnValue = false;
		}
		return returnValue;
	}
	
	
}
