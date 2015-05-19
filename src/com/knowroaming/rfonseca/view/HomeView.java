package com.knowroaming.rfonseca.view;

import java.sql.SQLException;
import java.util.Scanner;

import com.knowroaming.rfonseca.utils.DisplayUtils;
 
public class HomeView {
 
    public static void main(String[] args) throws SQLException {
        DisplayUtils.DisplayLogoAscII();
    	DisplayMenu();
    }
 
    public static void DisplayMenu() throws SQLException {
      
        // Display menu graphics
        System.out.println();			        
        System.out.println("              *****************************************                  ");
        System.out.println("              |            Command Menu               |                  ");
        System.out.println("              *****************************************                  ");
        System.out.println("              | Options:                              |                  ");
        System.out.println("              |        1. User Data Entry             |                  ");
        System.out.println("              |        2. Usage Information           |                  ");
        System.out.println("              |        3. Fetching Information        |                  ");
        System.out.println("              |        4. Exit                        |                  ");
        System.out.println("              *****************************************                  ");	
        System.out.println();		
    	
        System.out.print("Select option: ");

        String MENU = new Scanner(System.in).next();
        while(!(MENU.equals("1") || MENU.equals("2") || MENU.equals("3") || MENU.equals("4")))
        {
        	 System.out.print("Invalid selection \n");
        	 System.out.print("Select option again:");
        	 MENU = new Scanner(System.in).next();
        }		
        
        switch (MENU) {
            case "1":
            	new UserDataEntryView();
                break;
            case "2":
                new UsageInformationView();
                break;
            case "3":
                new FetchingInformationView();
                break;
            case "4":
                System.exit(0);
                break;
            default:
                DisplayUtils.displayMessage("Invalid selection");    
            	DisplayMenu();
                break; 
        }
    }
}