package com.knowroaming.rfonseca.view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.knowroaming.rfonseca.dao.UsageInformationDAO;
import com.knowroaming.rfonseca.dao.UsageInformationDAOImpl;
import com.knowroaming.rfonseca.dao.UserDAO;
import com.knowroaming.rfonseca.dao.UserDAOImpl;
import com.knowroaming.rfonseca.pojo.UsageInformation;
import com.knowroaming.rfonseca.pojo.User;
import com.knowroaming.rfonseca.utils.DisplayUtils;
import com.knowroaming.rfonseca.utils.ValidationsUtils;

public class FetchingInformationView {

	UsageInformationDAO usageInformationDAO = new UsageInformationDAOImpl();
	UserDAO userDAO = new UserDAOImpl();
	
	public FetchingInformationView() throws SQLException {

		System.out.println();
		System.out.println("              *****************************************                  ");
		System.out.println("              |          Fetching Information         |                  ");
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
		
		// Getting StartDataOfUsage      
		System.out.println("Enter start date of usage (yyyy-mm-dd): ");
		String startDateOfUsage_temp = new Scanner(System.in).next();
        while(!ValidationsUtils.validateDateMask(startDateOfUsage_temp))
        {
            System.out.println("Enter start date of usage again (yyyy-mm-dddd): ");
            startDateOfUsage_temp = new Scanner(System.in).next();
        }		
 
		// Getting FinalDataOfUsage      
		System.out.println("Enter final date of usage (yyyy-mm-dd): ");
		String finalDateOfUsage_temp = new Scanner(System.in).next();
        while(!ValidationsUtils.validateDateMask(finalDateOfUsage_temp))
        {
            System.out.println("Enter final date of usage again (yyyy-mm-dddd): ");
            finalDateOfUsage_temp = new Scanner(System.in).next();
        }	
       

		//Getting all informations on database
		
		List<UsageInformation> usageInformationList = new ArrayList<UsageInformation>();
		User user = new User();
		try {
			user.setName(userDAO.getUserNameById(Integer.parseInt(userId_temp)));
			usageInformationList = usageInformationDAO.fetchingUsageInformationsByDateRange(Integer.parseInt(userId_temp),startDateOfUsage_temp,finalDateOfUsage_temp);
		} catch (Exception e) {
			System.out.println("Impossible fetching informations, error: " + e.getMessage());
		}		
		
		//Show all informations
		if(!usageInformationList.isEmpty()){
			DisplayUtils.displayGrid(user,usageInformationList);
		}else{
			System.out.println("No data found");
		}
		
		//Backing to menu
        System.out.print("Back to Menu: (y)Yes - (n)No");
        String backToMenu = new Scanner(System.in).next();
        while(!(backToMenu.equals("y") || backToMenu.equals("n")))
        {
        	 System.out.print("Invalid selection \n");
        	 System.out.print("Back to Menu: (y)Yes - (n)No");
        	 backToMenu = new Scanner(System.in).next();
        }			
		if(backToMenu.equals("y")){
			HomeView.DisplayMenu();
		}else{
			System.exit(0);
		}
	}

	private boolean validateUserIdExists(String userId_temp){
		try {
			UsageInformation usageInformation = usageInformationDAO.getUserInformationByUserId(Integer.parseInt(userId_temp));
			if(usageInformation.getUserId()!=0){
				return true;
			}		
		} catch (Exception e) {
			System.out.println("Impossible get Usage Information, error: " + e.getMessage());
		} 
		return false;
	}
	
}