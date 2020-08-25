package com.ex.Frames;

import javax.persistence.*;

@Entity
@Table(name = "cartcontents",schema = "project2")
public class CartContents {


    //Fields for CartsContents Class
    @Id
    @Column(name="cart_id", columnDefinition = "SERIAL NOT NULL")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Cart_Id;

    @Column(name="product_id", columnDefinition = "INT")
    private int Product_Id; //Album_ID foreign key

    @Column(name="shopcart_id", columnDefinition = "INT")
    private int Shopcart_Id;


    //Constructors for CartsContents Class
    public CartContents(int Cart_Id, int Product_Id, int Shopcart_Id) {
        this.Cart_Id = Cart_Id;
        this.Product_Id = Product_Id;
        this.Shopcart_Id = Shopcart_Id;
    }

    public CartContents(int Product_Id, int Shopcart_Id){
        this.Product_Id = Product_Id;
        this.Shopcart_Id = Shopcart_Id;
    }

    public CartContents(int Product_Id){
        this.Product_Id = Product_Id;
    }

    public CartContents(){
    }


    //Getters and Setters for CartsContents Class
    public int getCart_Id() {
        return Cart_Id;
    }

    public void setCart_Id(int cart_Id) {
        Cart_Id = cart_Id;
    }

    public int getProduct_Id() {
        return Product_Id;
    }

    public void setProduct_Id(int product_Id) {
        Product_Id = product_Id;
    }

    public int getShopcart_Id() {
        return Shopcart_Id;
    }

    public void setShopcart_Id(int shopcart_Id) {
        Shopcart_Id = shopcart_Id;
    }


    //To String Method for CartsContents Class
    @Override
    public String toString() {
        return "CartContents{" +
                "Cart_Id=" + Cart_Id +
                ", Product_Id=" + Product_Id +
                ", Shopcart_Id=" + Shopcart_Id +
                '}';
    }


}
