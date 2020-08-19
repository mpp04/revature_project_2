package com.ex.Frames;

import java.util.List;

public interface CartContentDao {

    int getItemsByCartId(int Cart_Id);
    List<CartContents> getCartIdsByShopcartId(int Shopcart_Id); //Cart Ids are in a list


}
