package com.flyingcrow.main;

import java.sql.*;
import java.util.Scanner;

import com.flyingcrow.altas.AltasManager;
import com.flyingcrow.bbdd.ConectionManager;


public class MainMenu {

	private final String URL = "jdbc:mysql://localhost:3307/alumnos?user=root&password=usbw";
	private final String URLREAL = "jdbc:mysql://localhost:3307/bdinstituto?user=root&password=usbw";

	private ConectionManager conectionManager;
	private AltasManager altas;
	
	public MainMenu() throws SQLException  {
		try {
			conectionManager = ConectionManager.GetConectionManager(URLREAL, false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			conectionManager = ConectionManager.GetConectionManager(URL, true);
		}
		altas = new AltasManager(conectionManager);
	}
	
	public void MenuStartUp() {
		String opcion;
		Scanner scan = new Scanner(System.in);
		System.out.println("Bienvenido al gestor de notas!\n");
		do {
			System.out.print("Menu:"
					+ "\n\t1.- Altas."
					+ "\n\t2.- Crear Base de datos"
					+ "\n\t3.- Crear Base de datos"
					+ "\n\t4.- Crear Base de datos"
					+ "\n\t5.- Salir"
					+ "\n\nSelecciona una opcion: ");
			
			opcion = scan.nextLine();
			
			System.out.println();
			
			switch (opcion) {
			case "1":
				System.out.println("Iniciando módulo de altas...");
				altas.AltasMenu(scan);
				break;
			case "2":
				break;
			case "3": 
				break;
			case "4": 
				break;
			case "5": 
				System.out.println("Hasta luego!");
				scan.close();
				return;
			default:
				System.out.println(opcion + " no es un valor aceptado, vuelve a intentarlo!\n\n");
			}
			
		} while (true);
	}
	
}
