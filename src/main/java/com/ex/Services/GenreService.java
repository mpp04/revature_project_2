package com.ex.Services;

import com.ex.Frames.*;

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

public class GenreService implements GenreDao {


    private SessionFactory sessionFactory;

    public GenreService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<Genres> getAllGenres() {
        Session session = null;
        List<Genres> foundGenres = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            String hql = "FROM Genres";
            Query query = session.createQuery(hql);
            for(Object o : query.list()){
                foundGenres.add((Genres) o);
            }
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
        return foundGenres;
    }

    @Override
    public int getGenreIdByGenre(String Genre_Name) {
        Session session = null;
        Genres foundGenres = null;
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            Criteria cr = session.createCriteria(Genres.class);
            cr.add(Restrictions.eq("Genre_Name", Genre_Name));
            foundGenres = (Genres) cr.uniqueResult();
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

        return foundGenres.getGenre_Id();
    }

    @Override
    public String getGenreById(int Genre_Id) {
        Session session = null;
        Genres foundGenres = null;
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            Criteria cr = session.createCriteria(Genres.class);
            cr.add(Restrictions.eq("Genre_Id", Genre_Id));
            foundGenres = (Genres) cr.uniqueResult();
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

        return foundGenres.getGenre_Name();
    }


}
