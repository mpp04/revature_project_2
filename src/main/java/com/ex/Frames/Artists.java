package com.ex.Frames;

import java.sql.Timestamp;
import javax.persistence.*;


@Entity
@Table(name = "artists",schema = "project2")
public class Artists {


    //Fields for Artists Class
    @Id
    @Column(name="artist_id", columnDefinition = "SERIAL NOT NULL")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Artist_Id;

    @Column(name="artist_name")
    private String Artist_Name;

    @Column(name="artist_year")
    private Timestamp Artist_Year;


    //Constructors for Artist Class
    public Artists(int Artist_Id, String Artist_Name,Timestamp Artist_Year) {
        this.Artist_Id = Artist_Id;
        this.Artist_Name = Artist_Name;
        this.Artist_Year = Artist_Year;
    }

    public Artists(String Artist_Name,Timestamp Artist_Year) {
        this.Artist_Name = Artist_Name;
        this.Artist_Year = Artist_Year;
    }

    public Artists(){

    }


    //Getters and Setters for Artists Class
    public int getArtist_Id() {
        return Artist_Id;
    }

    public void setArtist_Id(int artist_Id) {
        Artist_Id = artist_Id;
    }

    public String getArtist_Name() {
        return Artist_Name;
    }

    public void setArtist_Name(String artist_Name) {
        Artist_Name = artist_Name;
    }

    public Timestamp getArtist_Year() {
        return Artist_Year;
    }

    public void setArtist_Year(Timestamp artist_Year) {
        Artist_Year = artist_Year;
    }


    //To String Method for Artists Class
    @Override
    public String toString() {
        return "Artists{" +
                "Artist_Id=" + Artist_Id +
                ", Artist_Name='" + Artist_Name + '\'' +
                ", Artist_Year=" + Artist_Year +
                '}';
    }


}
