package com.ex.Services;

import com.ex.Frames.Albums;
import com.ex.Frames.ArtistDao;
import com.ex.Frames.Artists;

import java.sql.Timestamp;

import com.ex.Frames.Genres;
import org.hibernate.SessionFactory;

import org.hibernate.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.*;
import org.hibernate.engine.internal.StatefulPersistenceContext;
import org.hibernate.engine.spi.PersistenceContext;
import org.hibernate.engine.spi.SessionImplementor;

import java.util.List;

public class ArtistService implements ArtistDao {


    private SessionFactory sessionFactory;

    public ArtistService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public int getArtistIdByArtist(String Artist_Name) {
        Session session = null;
        Artists foundArtists = null;
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            Criteria cr = session.createCriteria(Artists.class);
            cr.add(Restrictions.eq("Artist_Name", Artist_Name));
            foundArtists = (Artists) cr.uniqueResult();
            session.getTransaction().commit();

        } catch (HibernateException hex) {
            hex.printStackTrace();
            if(session != null && session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
        }finally {
            if(session != null) {
                session.close();
            }
        }

        return foundArtists.getArtist_Id();
    }

    @Override
    public String getArtistById(int Artist_Id) {
        Session session = null;
        Artists foundArtists = null;
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            Criteria cr = session.createCriteria(Artists.class);
            cr.add(Restrictions.eq("Artist_Id", Artist_Id));
            foundArtists = (Artists) cr.uniqueResult();
            session.getTransaction().commit();

        } catch (HibernateException hex) {
            hex.printStackTrace();
            if(session != null && session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
        }finally {
            if(session != null) {
                session.close();
            }
        }

        return foundArtists.getArtist_Name();
    }

    @Override
    public Timestamp getArtistYearById(int Artist_Id) {
        return null;
    }
}
