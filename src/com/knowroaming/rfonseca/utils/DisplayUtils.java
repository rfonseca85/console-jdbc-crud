package com.knowroaming.rfonseca.utils;

import java.util.List;

import com.knowroaming.rfonseca.pojo.UsageInformation;
import com.knowroaming.rfonseca.pojo.User;


public class DisplayUtils {

	public final static void DisplayLogoAscII(){
        System.out.println("    _  __                    _____                       _                 ");
        System.out.println("   | |/ /                   |  __ \\                     (_)                ");
        System.out.println("   | ' / _ __   _____      _| |__) |___   __ _ _ __ ___  _ _ __   __ _     ");
        System.out.println("   |  < | '_ \\ / _ \\ \\ /\\ / /  _  // _ \\ / _` | '_ ` _ \\| | '_ \\ / _` |    ");
        System.out.println("   | . \\| | | | (_) \\ V  V /| | \\ \\ (_) | (_| | | | | | | | | | | (_| |    ");
        System.out.println("   |_|\\_\\_| |_|\\___/ \\_/\\_/ |_|  \\_\\___/ \\__,_|_| |_| |_|_|_| |_|\\__, |    ");
        System.out.println("                                                                 |___/     ");      
        System.out.println();			        	        
	}

	public final static void displayMessage(String message){
	
        System.out.println();				
        System.out.println("*** ----  "+message);
        System.out.println("___________________________________________________                  ");
        System.out.println();		
        
	}
	
	public static void displayGrid(User user, List<UsageInformation> usageInformationList){

		System.out.println();
		System.out.println("     Usage Informations of "+user.getName());
		System.out.println("     ----------------------------------------------------------------------------------------------------------------");
		System.out.println("    |       Usage Information Id       |       Type of Usage       |       Date of Usage       |       User Id       |");
		System.out.println("     ----------------------------------------------------------------------------------------------------------------");		
		for (UsageInformation uCurrent : usageInformationList) {
			String typeOfUsage = (uCurrent.getTypeOfUsage()==1?"DATA     ":"VOICE SMS");
			System.out.println("    |       "+uCurrent.getUsageInformationId()+"       		       |       "+typeOfUsage+"           |       "+uCurrent.getDateOfUsage()+"          |       "+uCurrent.getUserId()+"             |");

		
		}
		System.out.println("     ----------------------------------------------------------------------------------------------------------------");	
		System.out.println();
	
	}	

}
