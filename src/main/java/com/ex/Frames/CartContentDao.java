package com.ex.Frames;

import java.util.List;

public interface CartContentDao {

    int getItemsByCartId(int Cart_Id);
    List<CartContents> getCartIdsByShopcartId(int Shopcart_Id); //Cart Ids are in a list
    int addItemToCart(int Product_Id,int Shopcart_Id);
    int removeItemFromCart(int Cart_Id);
}
