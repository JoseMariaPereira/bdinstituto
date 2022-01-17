package com.flyingcrow.main;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MainClass {

	public static void main(String[] args) {

		System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
		MainMenu mainMenu;
		try {
			mainMenu = new MainMenu();
			mainMenu.MenuStartUp();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
