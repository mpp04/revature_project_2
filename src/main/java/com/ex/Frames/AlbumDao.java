package com.ex.Frames;

import java.math.BigDecimal;
import java.util.List;
import com.ex.Frames.*;

public interface AlbumDao {

    List<Albums> getAllAlbums();
    List<Albums> getAlbumsByGenre(int Genre_Id);
    List<Albums> getAlbumsByArtist(int Artist_Id);
    List<Albums> getAlbumsByTitle(String Album_Title);
    Albums getAlbumById(int Album_Id);
    String getAlbumDescription(int Album_Id);
    float getPriceByAlbumId(int Album_Id);

}
