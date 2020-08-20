package com.ex.Frames;

import org.hibernate.*;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

public interface UserDao {

    Users login(String Username,String Password);
    Users getById(int User_Id);
    Users getByUsername(String Username);
    int getUserIdByUsername(String Username);
    String getUsernameByUserId(int User_Id);
    int updateEmail(int User_Id, String Email);
    Users createAccount(String Email, String Username, String Password, String First_Name, String Last_Name);
    //int deleteUserById(int User_Id);

}
