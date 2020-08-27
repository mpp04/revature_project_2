package com.ex.web.models;

import javax.persistence.*;

@Entity
@Table(name = "shopcarts", schema = "project2")
public class Shopcarts {


    //Fields for Shopcarts Class
    @Id
    @Column(name="shopcart_id", columnDefinition = "SERIAL NOT NULL")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Shopcart_Id;

    @Column(name="user_id", columnDefinition = "INT")
    private int User_Id;


    //Constructor for Shopcarts Class
    public Shopcarts(int Shopcart_Id, int User_Id){
        this.Shopcart_Id = Shopcart_Id;
        this.User_Id = User_Id;
    }

    public Shopcarts( int Shopcart_Id){
        this.Shopcart_Id = Shopcart_Id;
    }

    public Shopcarts() {
    }


    //Getters and Setters for Shopcarts Class
    public int getShopcart_Id() {
        return Shopcart_Id;
    }

    public void setShopcart_Id(int shopcart_Id) {
        Shopcart_Id = shopcart_Id;
    }

    public int getUser_Id() {
        return User_Id;
    }

    public void setUser_Id(int user_Id) {
        User_Id = user_Id;
    }


    //To String Method for Shopcarts Class
    @Override
    public String toString() {
        return "Shopcarts{" +
                "Shopcart_Id=" + Shopcart_Id +
                ", User_Id=" + User_Id +
                '}';
    }


}
