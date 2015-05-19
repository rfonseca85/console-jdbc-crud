package com.knowroaming.rfonseca.view;

import java.sql.SQLException;
import java.util.Scanner;

import com.knowroaming.rfonseca.dao.UsageInformationDAO;
import com.knowroaming.rfonseca.dao.UsageInformationDAOImpl;
import com.knowroaming.rfonseca.dao.UserDAO;
import com.knowroaming.rfonseca.dao.UserDAOImpl;
import com.knowroaming.rfonseca.pojo.UsageInformation;
import com.knowroaming.rfonseca.pojo.User;
import com.knowroaming.rfonseca.utils.DisplayUtils;
import com.knowroaming.rfonseca.utils.ValidationsUtils;

public class UsageInformationView {

	UserDAO userDAO = new UserDAOImpl();

	public UsageInformationView() throws SQLException {

		System.out.println();
		System.out.println("              *****************************************                  ");
		System.out.println("              |            Usage Information          |                  ");
		System.out.println("              *****************************************                  ");
		System.out.println();

		// Getting User id
        System.out.println("Enter user id: ");
		String userId_temp = new Scanner(System.in).next();
        while(!validateUserIdExists(userId_temp))
        {
        	System.out.println("User id not found \n");
            System.out.println("Enter user Id again: ");
            userId_temp = new Scanner(System.in).next();
        }
		
        // Getting Type of Usage    
        System.out.print("Type of usage: (1)DATA (2)VOICE SMS");
        String typeOfUsage_temp = new Scanner(System.in).next();
        while(!(typeOfUsage_temp.equals("1") || typeOfUsage_temp.equals("2")))
        {
        	 System.out.print("Invalid selection \n");
        	 System.out.print("Type of usage: (1)DATA (2)VOICE SMS");
        	 typeOfUsage_temp = new Scanner(System.in).next();
        }	        
      
		// Getting DataOfUsage      
		System.out.println("Enter date of usage (yyyy-mm-dd): ");
		String dateOfUsage_temp = new Scanner(System.in).next();
        while(!ValidationsUtils.validateDateMask(dateOfUsage_temp))
        {
            System.out.println("Enter date of usage again (yyyy-mm-dddd): ");
            dateOfUsage_temp = new Scanner(System.in).next();
        }		
 
       
		//Saving usage informations
		try {
			UsageInformation usageInformation = new UsageInformation(Integer.parseInt(typeOfUsage_temp), dateOfUsage_temp, Integer.parseInt(userId_temp));
			UsageInformationDAO usageInformationDAO = new UsageInformationDAOImpl();
			usageInformationDAO.saveUsageInformation(usageInformation);
			DisplayUtils.displayMessage("Usage information saved");
		} catch (Exception e) {
			System.out.println("Impossible save user, error: " + e.getMessage());
		}

		HomeView.DisplayMenu();
	}

	private boolean validateUserIdExists(String userId_temp){

		try {
			User user = userDAO.getUserById(Integer.parseInt(userId_temp));
			if(user.getUserId()!=0){
				return true;
			}		
		} catch (Exception e) {
			System.out.println("Impossible get User informations, error: " + e.getMessage());
		} 
		return false;
	}
	
}