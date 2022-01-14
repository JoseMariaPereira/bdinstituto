package com.flyingcrow.bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.flyingcrow.modelo.Alumno;
import com.flyingcrow.modelo.Profesor;

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
	 * Inserta un profesor
	 * 
	 * @param profesor el profesor a insertar
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
	
	
}
