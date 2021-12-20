package com.flyingcrow.main;

import java.sql.SQLException;

public class MainClass {

	public static void main(String[] args) {
		
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
