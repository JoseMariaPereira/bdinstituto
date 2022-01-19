package com.flyingcrow.main;

import java.sql.*;
import java.util.Scanner;

import com.flyingcrow.altas.AltasManager;
import com.flyingcrow.bajas.BajasManager;
import com.flyingcrow.bbdd.ConectionManager;
import com.flyingcrow.consultas.ConsultasManager;


public class MainMenu {

	private final String URL = "jdbc:mysql://localhost:3307/alumnos?user=root&password=usbw";
	private final String URLREAL = "jdbc:mysql://localhost:3307/bdinstituto?user=root&password=usbw";

	private ConectionManager conectionManager;
	private AltasManager altas;
	private BajasManager bajas;
	
	private ConsultasManager consultas;
	
	public MainMenu() throws SQLException  {
		try {
			conectionManager = ConectionManager.GetConectionManager(URLREAL, false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			conectionManager = ConectionManager.GetConectionManager(URL, true);
		}
		altas = new AltasManager(conectionManager);
		bajas = new BajasManager(conectionManager);
		consultas = new ConsultasManager(conectionManager);
	}
	
	public void MenuStartUp() {
		String opcion;
		Scanner scan = new Scanner(System.in);
		System.out.println("Bienvenido al gestor de notas!\n");
		do {
			System.out.print("Menu:"
					+ "\n\t1.- Altas."
					+ "\n\t2.- Bajas."
					+ "\n\t3.- Crear Base de datos"
					+ "\n\t4.- Consultas."
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
				System.out.println("Iniciando módulo de bajas...");
				bajas.BajasMenu(scan);
				break;
			case "3": 
				break;
			case "4":
				System.out.println("Iniciando módulo de consultas...");
				consultas.ConsultasMenu(scan);
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
