package com.ex.Frames;

import sun.security.krb5.internal.crypto.Des;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table
public class Albums {


    //Fields for Albums Class
    @Id
    @Column(name="album_id", columnDefinition = "SERIAL NOT NULL")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Album_Id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="Artists", referencedColumnName = "artist_id",columnDefinition = "INT")
    private int Artist_Id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="Genres", referencedColumnName = "genre_id",columnDefinition = "INT")
    private int Genre_Id;

    @Column(name="album_title")
    private String Album_Title;

    @Column(name="description")
    private String Description;

    @Column(name="album_art")
    private String Album_Art;

    @Column(name="year_released")
    private Timestamp Year_Released;


    //Constructors for Albums Class
    public Albums(int Album_Id, int Artist_Id, int Genre_Id, String Album_Title, String Description, String Album_Art, Timestamp Year_Released){
        this.Album_Id = Album_Id;
        this.Artist_Id = Artist_Id;
        this.Genre_Id = Genre_Id;
        this.Album_Title = Album_Title;
        this.Description = Description;
        this.Album_Art = Album_Art;
        this.Year_Released = Year_Released;
    }

    public Albums(String Album_Title, String Description, String Album_Art, Timestamp Year_Released){
        this.Album_Title = Album_Title;
        this.Description = Description;
        this.Album_Art = Album_Art;
        this.Year_Released = Year_Released;
    }

    public Albums() {
    }


    //Getters and Setters for  Albums class
    public int getAlbum_Id() {
        return Album_Id;
    }

    public void setAlbum_Id(int album_Id) {
        Album_Id = album_Id;
    }

    public int getArtist_Id() {
        return Artist_Id;
    }

    public void setArtist_Id(int artist_Id) {
        Artist_Id = artist_Id;
    }

    public int getGenre_Id() {
        return Genre_Id;
    }

    public void setGenre_Id(int genre_Id) {
        Genre_Id = genre_Id;
    }

    public String getAlbum_Title() {
        return Album_Title;
    }

    public void setAlbum_Title(String album_Title) {
        Album_Title = album_Title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getAlbum_Art() {
        return Album_Art;
    }

    public void setAlbum_Art(String album_Art) {
        Album_Art = album_Art;
    }

    public Timestamp getYear_Released() {
        return Year_Released;
    }

    public void setYear_Released(Timestamp year_Released) {
        Year_Released = year_Released;
    }


    //To String Method for Albums class
    @Override
    public String toString() {
        return "Albums{" +
                "Album_Id=" + Album_Id +
                ", Artist_Id=" + Artist_Id +
                ", Genre_Id=" + Genre_Id +
                ", Album_Title='" + Album_Title + '\'' +
                ", Description='" + Description + '\'' +
                ", Album_Art='" + Album_Art + '\'' +
                ", Year_Released=" + Year_Released +
                '}';
    }


}
