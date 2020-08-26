package com.ex.Frames;

import javax.persistence.*;

@Entity
@Table(name = "users",schema = "project2")
public class Users {


    //Fields for Users Class
    @Id
    @Column(name="user_id", columnDefinition = "SERIAL NOT NULL")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int User_Id;

    @Column(name="email",columnDefinition = "UNIQUE NOT NULL")
    private String Email;

    @Column(name="username",columnDefinition = "UNIQUE NOT NULL")
    private String Username;

    @Column(name="password",columnDefinition = "VARCHAR NOT NULL")
    private String Password;

    @Column(name="first_name",columnDefinition = "VARCHAR")// NOT NULL")
    private String First_Name;

    @Column(name="last_name",columnDefinition = "VARCHAR")// NOT NULL")
    private String Last_Name;


    //Constructors For Users class
    public Users(int User_Id, String Email, String Username,String Password, String First_Name, String Last_Name) {
        this.User_Id = User_Id;
        this.Email = Email;
        this.Username = Username;
        this.Password = Password;
        this.First_Name = First_Name;
        this.Last_Name = Last_Name;
    }

    public Users(String Email, String Username, String Password, String First_Name, String Last_Name){
        this.Email = Email;
        this.Username = Username;
        this.Password = Password;
        this.First_Name = First_Name;
        this.Last_Name = Last_Name;
    }

    public Users() {
    }


    //Getters and Setters for Users Class
    public int getUser_Id() {
        return User_Id;
    }

    public void setUser_Id(int user_Id) {
        User_Id = user_Id;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getFirst_Name() {
        return First_Name;
    }

    public void setFirst_Name(String first_Name) {
        First_Name = first_Name;
    }

    public String getLast_Name() {
        return Last_Name;
    }

    public void setLast_Name(String last_Name) {
        Last_Name = last_Name;
    }


    //To String Method for the Users Class
    @Override
    public String toString() {
        return "Users{" +
                "User_Id=" + User_Id +
                ", Email='" + Email + '\'' +
                ", Username='" + Username + '\'' +
                ", Password='" + Password + '\'' +
                ", First_Name='" + First_Name + '\'' +
                ", Last_Name='" + Last_Name + '\'' +
                '}';
    }
}
