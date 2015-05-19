package com.knowroaming.rfonseca.dao;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;

import com.knowroaming.rfonseca.pojo.User;
import com.knowroaming.rfonseca.utils.DBUtilities;

public class UserDAOImpl implements UserDAO {

	@Override
	public void saveUser(User user) throws Exception {
	    DBUtilities dbUtilities = new DBUtilities();
		
        String sql_stmt = "INSERT INTO user_tb (name,email,country,phone_number) VALUES ('" + user.getName() + "','" + user.getEmail() + "','" + user.getCountry() + "','" + user.getPhoneNumber() + "')";
        
        dbUtilities.ExecuteSQLStatement(sql_stmt);
	}

	@Override
	public User getUserByName(String name) throws Exception {
		// TODO Auto-generated method stub

		User returnUser = new User();
		try {
            DBUtilities dbUtilities = new DBUtilities();
 
            String sql_stmt = "SELECT user_id FROM user_tb where name = '"+name+"'";
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
	public User getUserByEmail(String email) throws Exception {

		User returnUser = new User();
		try {
            DBUtilities dbUtilities = new DBUtilities();
 
            String sql_stmt = "SELECT user_id FROM user_tb where email = '"+email+"'";
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
	public User getUserById(int userId) throws Exception {

		User returnUser = new User();
		try {
            DBUtilities dbUtilities = new DBUtilities();
 
            String sql_stmt = "SELECT user_id FROM user_tb where user_id = "+userId;
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
	public String getUserNameById(int userId) throws Exception {
		String userName = "";
		try {
            DBUtilities dbUtilities = new DBUtilities();
 
            String sql_stmt = "SELECT name FROM user_tb where user_id = "+userId;
            ResultSet resultSet = dbUtilities.ReadRecords(sql_stmt);
 
            if (resultSet.next()) {
            	 
                ResultSetMetaData metaData = resultSet.getMetaData();
                int numberOfColumns = metaData.getColumnCount();
                do {
                    for (int i = 1; i <= numberOfColumns; i++) {
                    	userName = resultSet.getObject(i).toString();
                    }
                } while (resultSet.next());
                
 
            }       
            //close db connection
            dbUtilities.DisconnectFromDB();            
 
        } catch (SQLException ex) {
            System.out.println("The following error has occured: " + ex.getMessage());
        }

		return userName;
	}
	
	@Override
	public List<User> getAllUsers() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUser(User student) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}



}