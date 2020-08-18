package com.ex.Frames;

import java.sql.Timestamp;

public interface ArtistDao {

    int getArtistIdByArtist(String Artist_Name);
    Artists getArtistById(int Artist_Id);
    Timestamp getArtistYearById(int Artist_Id);

}
