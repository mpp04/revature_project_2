package com.ex.web.dao;

import com.ex.web.models.Genres;

import java.util.List;

public interface GenreDao {

    List<Genres> getAllGenres(); //Returns a list of all Genres (genre id's and corresponding names)

    int getGenreIdByGenre(String Genre_Name); //Returns the genre id based on the provided genre name

    String getGenreById(int Genre_Id); //Returns the genre name based on the provided genre id

}
