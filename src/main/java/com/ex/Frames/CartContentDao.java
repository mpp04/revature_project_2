package com.ex.Frames;

import java.util.List;

public interface CartContentDao {

    int getItemsByCartId(int Cart_Id); // Returns the product id (album id) based on the cart id that you input

    List<CartContents> getCartIdsByShopcartId(int Shopcart_Id); //Returns a list of all cart information (to get item)
                                                                // based on the shopcart id that you input

    int addItemToCart(int Product_Id,int Shopcart_Id); //Returns 0 if you are able to successfully add to the cart
                                                       // and 1 if you cannot

    int removeItemFromCart(int Cart_Id); //Returns 0 if you can successfully remove from cart and 1 if you cannot

}
