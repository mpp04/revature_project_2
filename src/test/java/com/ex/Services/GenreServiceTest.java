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

public class GenreServiceTest extends TestCase {

    private static SessionFactory sessionFactory;
    private static GenreService genreService;


    @BeforeClass
    public void setUp() throws Exception {
        HibernateUtil.connect();
        sessionFactory = HibernateUtil.getSessionFactory();
        genreService = new GenreService(sessionFactory);
    }

    @Test
    public void testGetAllGenres() {
        assertEquals("It works", genreService.getAllGenres().get(0).getGenre_Id(),4);
    }

    @Test
    public void testGetGenreIdByGenre() {
        assertEquals("It works", genreService.getGenreIdByGenre("Rap"), 3);
    }

    @Test
    public void testGetGenreById() {
        assertEquals("It works", genreService.getGenreById(3), "Rap");
    }

}