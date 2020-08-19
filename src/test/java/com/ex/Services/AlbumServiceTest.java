package com.ex.Services;

import com.ex.HibernateUtil;
import junit.framework.TestCase;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.ex.Frames.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class AlbumServiceTest extends TestCase {


    private static SessionFactory sessionFactory;
    private static AlbumService albumService;


    @BeforeClass
    public void setUp() throws Exception {
        HibernateUtil.connect();
        sessionFactory = HibernateUtil.getSessionFactory();
        albumService = new AlbumService(sessionFactory);
    }


    @Test
    public void testGetAllAlbums() {
        assertEquals("It works", albumService.getAllAlbums().get(0).getAlbum_Title(), "Bowie pop");
    }

    @Test
    public void testGetAlbumsByGenre() {
        assertEquals("It works", albumService.getAlbumsByGenre(1).get(0).getAlbum_Title(),"Bowie pop" );
    }

    @Test
    public void testGetAlbumsByArtist() {
        assertEquals("It works", albumService.getAlbumsByArtist(2).get(0).getAlbum_Title(), "Elvis rock");
    }

    @Test
    public void testGetAlbumsByTitle() {
        assertEquals("It works", albumService.getAlbumsByTitle("Bowie pop").get(0).getAlbum_Title(), "Bowie pop");
    }

    @Test
    public void testGetAlbumById() {
        assertEquals("It works", albumService.getAlbumById(3).getAlbum_Title(), "Eminem rap");
    }

    @Test
    public void testGetAlbumDescription() {
        assertEquals("It works", albumService.getAlbumDescription(4), "rock songs by bowie");
    }
}