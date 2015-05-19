package com.knowroaming.rfonseca.view;

import java.sql.SQLException;
import java.util.Scanner;

import com.knowroaming.rfonseca.dao.UserDAO;
import com.knowroaming.rfonseca.dao.UserDAOImpl;
import com.knowroaming.rfonseca.pojo.User;
import com.knowroaming.rfonseca.utils.DisplayUtils;
import com.knowroaming.rfonseca.utils.ValidationsUtils;

public class UserDataEntryView {

	UserDAO userDAO = new UserDAOImpl();

	public UserDataEntryView() throws SQLException {

		System.out.println();
		System.out.println("              *****************************************                  ");
		System.out.println("              |            User Data Entry            |                  ");
		System.out.println("              *****************************************                  ");
		System.out.println();

		// Getting Name
		System.out.println("Enter name: ");
		String name_temp = new Scanner(System.in).next();
		warningValidateDublicatedName(name_temp);
		while(!ValidationsUtils.validateOnlyString(name_temp))
        {
            System.out.println("Enter name again: ");
            name_temp = new Scanner(System.in).next();
        }
     
		// Getting Email
        System.out.println("Enter email: ");
		String email_temp = new Scanner(System.in).next();
        while(!ValidationsUtils.validateEmail(email_temp) || !validateDublicatedEmail(email_temp))
        {
            System.out.println("Enter email again: ");
            email_temp = new Scanner(System.in).next();
        }
		
		// Getting Country      
		System.out.println("Enter country: ");
		String country_temp = new Scanner(System.in).next();
        while(!ValidationsUtils.validateOnlyString(country_temp))
        {
            System.out.println("Enter country again: ");
            country_temp = new Scanner(System.in).next();
        }		
		
		// Getting phoneNumber     
		System.out.println("Enter phone number (10 numeric digits): ");
		String phoneNumber_temp = new Scanner(System.in).next();
        while(!ValidationsUtils.validatePhoneNumber(phoneNumber_temp))
        {
            System.out.println("Enter phone number again: ");
            phoneNumber_temp = new Scanner(System.in).next();
        }			
		
		//Saving user
		try {
			userDAO.saveUser(new User(name_temp,email_temp,country_temp, phoneNumber_temp));
			User user = userDAO.getUserByEmail(email_temp);
			DisplayUtils.displayMessage("User ID (" + user.getUserId() + ") saved");
		} catch (Exception e) {
			System.out.println("Impossible save user, error: " + e.getMessage());
		}
		
		
		//back to menu
		HomeView.DisplayMenu();

	}

	private void warningValidateDublicatedName(String name_temp){

		try {
			User user = userDAO.getUserByName(name_temp);
			if(user.getUserId()!=0){
				System.out.println("Warnig - Duplicated Name");
			}		
		} catch (Exception e) {
			System.out.println("Impossible get User informations, error: " + e.getMessage());
		} 
	}
	
	private boolean validateDublicatedEmail(String email_temp){

		try {
			User user = userDAO.getUserByEmail(email_temp);
			if(user.getUserId()!=0){
				System.out.println("Duplicated Email");
				return false;
			}		
		} catch (Exception e) {
			System.out.println("Impossible get User informations, error: " + e.getMessage());
		} 
		return true;
	}
	
}