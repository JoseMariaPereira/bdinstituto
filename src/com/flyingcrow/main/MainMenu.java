package com.flyingcrow.main;

import java.io.*;
import java.sql.*;
import java.util.Scanner;

import com.flyingcrow.altas.AltasManager;
import com.flyingcrow.bbdd.ConectionManager;


public class MainMenu {
	
	private final String URL = "jdbc:mysql://localhost:3307/alumnos?user=root&password=usbw";
	

	private ConectionManager conectionManager;
	private AltasManager altas;
	
	public MainMenu() throws SQLException {
		conectionManager = new ConectionManager(URL);
		altas = new AltasManager(conectionManager);
	}
	
	public void MenuStartUp() {
		String opcion;
		Scanner scan = new Scanner(System.in);
		System.out.println("Bienvenido al gestor de notas!\n");
		do {
			System.out.print("Menu:"
					+ "\n\t1.- Crear Base de datos"
					+ "\n\t2.- Altas."
					+ "\n\t3.- Crear Base de datos"
					+ "\n\t4.- Crear Base de datos"
					+ "\n\t5.- Crear Base de datos"
					+ "\n\t6.- Salir"
					+ "\n\nSelecciona una opcion: ");
			
			opcion = scan.nextLine();
			
			switch (opcion) {
			case "1":
				System.out.println("Creando base de datos...");
				try {
					conectionManager.CreateTables();
				} catch (SQLException e) {
					System.out.println("Ha ocurrido un error de conexion!");
				}
				break;
			case "2":
				System.out.println("Iniciando módulo de altas");
				break;
			case "3": 
				break;
			case "4": 
				break;
			case "5": 
				break;
			case "6":
				System.out.println("Hasta luego!");
				scan.close();
				return;
			default:
				System.out.println(opcion + " no es un valor aceptado, vuelve a intentarlo!\n\n");
			}
			
		} while (true);
	}
	
}
