package com.ex.Frames;

import javax.persistence.*;

@Entity
@Table(name = "shopcarts", schema = "project2")
public class Shopcarts {


    //Fields for Shopcarts Class
    @Id
    @Column(name="shopcart_id", columnDefinition = "SERIAL NOT NULL")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Shopcart_Id;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="users", referencedColumnName = "user_id",columnDefinition = "INT")
    private Users User_Id;


    //Constructor for Shopcarts Class
    public Shopcarts() {
    }


    //Getters and Setters for Shopcarts Class
    public int getShopcart_Id() {
        return Shopcart_Id;
    }

    public void setShopcart_Id(int shopcart_Id) {
        Shopcart_Id = shopcart_Id;
    }

    public Users getUser_Id() {
        return User_Id;
    }

    public void setUser_Id(Users user_Id) {
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
