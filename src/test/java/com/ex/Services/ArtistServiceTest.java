package com.ex.Services;

import com.ex.HibernateUtil;
import junit.framework.TestCase;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.ex.Frames.*;

import java.sql.Timestamp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class ArtistServiceTest extends TestCase {

    private static SessionFactory sessionFactory;
    private static ArtistService artistService;


    @BeforeClass
    public void setUp() throws Exception {
        HibernateUtil.connect();
        sessionFactory = HibernateUtil.getSessionFactory();
        artistService = new ArtistService(sessionFactory);
    }


    @Test
    public void testGetAllArtists(){
        assertEquals("It works",artistService.getAllArtists().get(0).getArtist_Name(),"David Bowie");
    }

    @Test
    public void testGetArtistIdByArtist() {
        assertEquals("It works", artistService.getArtistIdByArtist("David Bowie"), 1);
    }

    @Test
    public void testGetArtistById() {
        assertEquals("It works", artistService.getArtistById(2), "Elvis Pretzel");
    }


}