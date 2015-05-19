package com.knowroaming.rfonseca.dao;

import java.util.List;

import com.knowroaming.rfonseca.pojo.User;

public interface UserDAO {

       public List<User> getAllUsers() throws Exception;
       public User getUserById(int userId) throws Exception;
       public int updateUser(User user) throws Exception;
       public int deleteUser(User student) throws Exception;
       public void saveUser(User user) throws Exception;
       
       public User getUserByName(String name) throws Exception;
       public User getUserByEmail(String email) throws Exception;
       
       public String getUserNameById(int userId) throws Exception;
       
}