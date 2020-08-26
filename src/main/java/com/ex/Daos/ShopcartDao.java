package com.ex.Daos;

import com.ex.Frames.Shopcarts;

public interface ShopcartDao {

    //int getShopcartIdByUserId(int User_Id); (OLD METHOD, IGNORE IT)

    int getUserIdByShopcartId(int Shopcart_Id); //Return the user id by the shopping cart (most likely more useful)

    Shopcarts addShopcartByUserId(int User_Id); //Returns the shopping cart of the user

}
