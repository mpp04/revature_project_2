package com.ex.Services;

import com.ex.Frames.AlbumDao;
import com.ex.Frames.Albums;
import org.hibernate.SessionFactory;

import org.hibernate.*;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.*;
import org.hibernate.engine.internal.StatefulPersistenceContext;
import org.hibernate.engine.spi.PersistenceContext;
import org.hibernate.engine.spi.SessionImplementor;

import java.util.List;

public class AlbumService implements AlbumDao {


    private SessionFactory sessionFactory;

    public AlbumService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<Albums> getAllAlbums() {
        Session session = null;
        List<Albums> foundAlbums = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            String hql = "FROM Albums";
            Query query = session.createQuery(hql);
            for(Object o : query.list()){
                foundAlbums.add((Albums) o);
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
        return foundAlbums;
    }

    @Override
    public List<Albums> getAlbumsByGenre(int Genre_Id) {
        Session session = null;
        //List<Albums> foundAlbums = new ArrayList<>();
        try{
            session = sessionFactory.openSession();
            String hql = "from Albums where genre_id = :g";
            Query query = session.createQuery(hql);
            query.setInteger("g", Genre_Id);

            List foundAlbums = (List)query.list();
            return foundAlbums;
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
        //System.out.println(foundAlbums);
        //return foundAlbums;
        return null;
    }

    @Override
    public List<Albums> getAlbumsByArtist(int Artist_Id) {
        Session session = null;
        //List<Albums> foundAlbums = new ArrayList<>();
        try{
            session = sessionFactory.openSession();
            String hql = "from Albums where artist_id = :g";
            Query query = session.createQuery(hql);
            query.setInteger("g", Artist_Id);

            List foundAlbums = (List)query.list();
            return foundAlbums;

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

        return null;
    }

    @Override
    public List<Albums> getAlbumsByTitle(String Album_Title) {
        Session session = null;
        //List<Albums> foundAlbums = new ArrayList<>();
        try{
            session = sessionFactory.openSession();
            String hql = "from Albums where album_title = :g";
            Query query = session.createQuery(hql);
            query.setString("g", Album_Title);

            List foundAlbums = (List)query.list();
            return foundAlbums;

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

        return null;
    }

    @Override
    public Albums getAlbumById(int Album_Id) {
        Session session = null;
        Albums foundAlbums = null;
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            Criteria cr = session.createCriteria(Albums.class);
            cr.add(Restrictions.eq("Album_Id", Album_Id));
            foundAlbums = (Albums) cr.uniqueResult();
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

        return foundAlbums;
    }

    @Override
    public String getAlbumDescription(int Album_Id) {
        Session session = null;
        Albums foundDescription = null;
        try{
            session = sessionFactory.openSession();
            foundDescription = (Albums) session.get(Albums.class, Album_Id);
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

        return foundDescription.getDescription();
    }

    @Override
    public float getPriceByAlbumId(int Album_Id){
        Session session = null;
        Albums foundPrice = null;
        try{
            session = sessionFactory.openSession();
            foundPrice = (Albums) session.get(Albums.class, Album_Id);
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

        return foundPrice.getPrice();
    }

}
