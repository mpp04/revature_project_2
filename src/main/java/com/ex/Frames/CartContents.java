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

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="Albums", referencedColumnName = "album_id",columnDefinition = "INT NOT NULL")
    private Albums Product_Id; //Album_ID foreign key

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="Shopcarts", referencedColumnName = "shopcart_id",columnDefinition = "INT NOT NULL")
    private Shopcarts Shopcart_Id;


    //Constructors for CartsContents Class
    public CartContents(int Cart_Id, Albums Product_Id, Shopcarts Shopcart_Id) {
        this.Cart_Id = Cart_Id;
        this.Product_Id = Product_Id;
        this.Shopcart_Id = Shopcart_Id;
    }

    public CartContents(Albums Product_Id, Shopcarts Shopcart_Id){
        this.Product_Id = Product_Id;
        this.Shopcart_Id = Shopcart_Id;
    }

    public CartContents(Albums Product_Id){
        this.Product_Id = Product_Id;
    }

    public CartContents(int Cart_Id) {
        this.Cart_Id = Cart_Id;
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

    public Albums getProduct_Id() {
        return Product_Id;
    }

    public void setProduct_Id(Albums product_Id) {
        Product_Id = product_Id;
    }


    public Shopcarts getShopcart_Id() {
        return Shopcart_Id;
    }

    public void setShopcart_Id(Shopcarts shopcart_Id) {
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
