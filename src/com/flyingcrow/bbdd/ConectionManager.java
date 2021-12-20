package com.flyingcrow.bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConectionManager {
	
	private Connection connection;
	private Statement statement;
	
	public ConectionManager(String url) throws SQLException {
		connection = DriverManager.getConnection(url);
		statement = connection.createStatement();
		CreateTables();
	}
	
	public void CreateTables() throws SQLException {
		statement.execute("CREATE DATABASE IF NOT EXISTS BDInstituto;");
		statement.execute("USE BDInstituto;");
		statement.execute("CREATE TABLE IF NOT EXISTS `Profesor` (\n"
				+ "  `dni` varchar(30) NOT NULL,\n"
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
				+ "  `dni` varchar(30) NOT NULL,\r\n"
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
	
	
	
}
