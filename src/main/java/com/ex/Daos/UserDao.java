package com.ex.Daos;

import com.ex.Frames.Users;

public interface UserDao {

    Users login(String Username, String Password); //Returns the User who just logged in

    Users getById(int User_Id); //Returns User by the user id

    Users getByUsername(String Username); //Returns User by username

    int getUserIdByUsername(String Username); //Returns user id as an int when you enter the username

    String getUsernameByUserId(int User_Id); //Returns the username as a string when you enter the user id

    int updateEmail(int User_Id, String Email); //Enter the current username and the NEW email that you want associated
                                                // with that username. Returns 0 if successful and 1 if it's not.

    Users createAccount(String Email, String Username, String Password, String First_Name, String Last_Name);// Returns the User that was created by this method

    //int deleteUserById(int User_Id); (OLD METHOD, IGNORE IT)

}
