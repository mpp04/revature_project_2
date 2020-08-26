package com.ex.Daos;

import com.ex.Frames.Artists;
import java.util.List;

public interface ArtistDao {

    List<Artists> getAllArtists(); //Return a list of all the artists

    int getArtistIdByArtist(String Artist_Name); //Returns the artist id by the artist name provided

    String getArtistById(int Artist_Id); //Returns the artist name by the artist id provided


}
