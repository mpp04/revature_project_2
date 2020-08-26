package com.ex.Frames;

import javax.persistence.*;

@Entity
@Table(name = "genres",schema = "project2")
public class Genres {


    //Fields for Genres Class
    @Id
    @Column(name="genre_id", columnDefinition = "SERIAL NOT NULL")
    private int Genre_Id;

    @Column(name="genre_name")
    private String Genre_Name;


    //Constructors for Genres Class
    public Genres(int Genre_Id,String Genre_Name) {
        this.Genre_Id = Genre_Id;
        this.Genre_Name = Genre_Name;
    }

    public Genres(String Genre_Name) {
        this.Genre_Name = Genre_Name;
    }

    public Genres() {
    }


    //Getters and Setters for Genres Class
    public int getGenre_Id() {
        return Genre_Id;
    }

    public void setGenre_Id(int genre_Id) {
        Genre_Id = genre_Id;
    }

    public String getGenre_Name() {
        return Genre_Name;
    }

    public void setGenre_Name(String genre_Name) {
        Genre_Name = genre_Name;
    }


    //To String Method for Genres Class
    @Override
    public String toString() {
        return "Genres{" +
                "Genre_Id=" + Genre_Id +
                ", Genre_Name='" + Genre_Name + '\'' +
                '}';
    }


}
