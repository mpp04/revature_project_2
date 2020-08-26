package com.ex.Services;

import com.ex.Daos.ArtistDao;
import com.ex.Frames.Artists;

import java.sql.Timestamp;

import org.hibernate.SessionFactory;

import org.hibernate.*;

import org.hibernate.criterion.*;

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
