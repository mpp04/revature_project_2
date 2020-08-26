package com.ex.Daos;

import java.sql.Timestamp;

public interface ArtistDao {

    int getArtistIdByArtist(String Artist_Name); //Returns the artist id by the artist name provided

    String getArtistById(int Artist_Id); //Returns the artist name by the artist id provided

    Timestamp getArtistYearById(int Artist_Id); // Returns the TimeStamp by the artist id provided

}
