package com.knowroaming.rfonseca.dao;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.knowroaming.rfonseca.pojo.UsageInformation;
import com.knowroaming.rfonseca.utils.DBUtilities;

public class UsageInformationDAOImpl implements UsageInformationDAO {

	@Override
	public void saveUsageInformation(UsageInformation usageInformation) throws Exception {

	    DBUtilities dbUtilities = new DBUtilities();
		
        StringBuffer sql_stmt = new StringBuffer();
        sql_stmt.append("INSERT INTO `knowroaming_db`.`usage_information_tb` ");
       	sql_stmt.append("(`typeOfUsage`, ");
       	sql_stmt.append("`dateOfUsage`, ");
       	sql_stmt.append("`user_id`) ");
        sql_stmt.append("VALUES ");
        sql_stmt.append("(" + usageInformation.getTypeOfUsage() + ", ");
        sql_stmt.append("'" + usageInformation.getDateOfUsage() + "', ");
        sql_stmt.append(usageInformation.getUserId() + ") ");
       
        dbUtilities.ExecuteSQLStatement(sql_stmt.toString());
		
	}

	@Override
	public UsageInformation getUserInformationByUserId(int userId) throws Exception {

		UsageInformation returnUser = new UsageInformation();
		try {
            DBUtilities dbUtilities = new DBUtilities();
 
            String sql_stmt = "SELECT user_id FROM usage_information_tb where user_id = "+userId;
            ResultSet resultSet = dbUtilities.ReadRecords(sql_stmt);
 
            // process query results
            if (resultSet.next()) {
 
                ResultSetMetaData metaData = resultSet.getMetaData();
                int numberOfColumns = metaData.getColumnCount();
                do {
                    for (int i = 1; i <= numberOfColumns; i++) {
                    	returnUser.setUserId(Integer.parseInt(resultSet.getObject(i).toString()));
                    }
                } while (resultSet.next());
                
 
            } else {
            	returnUser.setUserId(0);
            }

            //close db connection
            dbUtilities.DisconnectFromDB();            
 
        } catch (SQLException ex) {
            System.out.println("The following error has occured: " + ex.getMessage());
        }

		return returnUser;
	}

	@Override
	public List<UsageInformation> fetchingUsageInformationsByDateRange(int userId, String startdate, String finalDate) throws Exception {
		
		List<UsageInformation> usageInformationList = new ArrayList<UsageInformation>(); 
		

		try {
            DBUtilities dbUtilities = new DBUtilities();
 
            StringBuffer sql_stmt = new StringBuffer();
            sql_stmt.append(" select usage_information_id, typeOfUsage, dateOfUsage, user_Id from usage_information_tb ");
            sql_stmt.append(" where user_id = "+userId);
            sql_stmt.append(" and dateOfUsage BETWEEN '" + startdate + "' AND '" + finalDate + "'");
         
            ResultSet resultSet = dbUtilities.ReadRecords(sql_stmt.toString());
 
            // process query results
            while (resultSet.next()) {
 
        		UsageInformation usageInformation = new UsageInformation();
            	
                usageInformation.setUsageInformationId(Integer.parseInt(resultSet.getObject(1).toString()));
                usageInformation.setTypeOfUsage(Integer.parseInt(resultSet.getObject(2).toString()));
                usageInformation.setDateOfUsage(resultSet.getObject(3).toString());
                usageInformation.setUserId(Integer.parseInt(resultSet.getObject(4).toString()));
                
                usageInformationList.add(usageInformation);
 
            } 
            //close db connection
            dbUtilities.DisconnectFromDB();            
 
        } catch (SQLException ex) {
            System.out.println("The following error has occured: " + ex.getMessage());
        }

		return usageInformationList;		
		
	}
	
}