package com.ex.Daos;

import java.util.List;
import com.ex.Frames.*;


public interface AlbumDao {


    List<Albums> getAllAlbums(); //Returns a list of all the Albums

    List<Albums> getAlbumsByGenre(int Genre_Id); //Returns a list of all the Albums for a specific genre

    List<Albums> getAlbumsByArtist(int Artist_Id); //Returns a list of all the Albums by a specific artist

    List<Albums> getAlbumsByTitle(String Album_Title); //Returns a list of all the Albums by a specific album name

    Albums getAlbumById(int Album_Id); //Returns the Album by a specific album id

    String getAlbumDescription(int Album_Id); //Returns the description of the album by the album id

    float getPriceByAlbumId(int Album_Id); // Returns the album's price by the album id


}
