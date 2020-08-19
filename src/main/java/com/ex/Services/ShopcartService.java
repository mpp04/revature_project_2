package com.ex.Services;

import com.ex.Frames.Genres;
import com.ex.Frames.ShopcartDao;
import com.ex.Frames.Shopcarts;
import org.hibernate.SessionFactory;

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

public class ShopcartService implements ShopcartDao {


    private SessionFactory sessionFactory;

    public ShopcartService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public int getShopcartIdByUserId(int User_Id) {
        Session session = null;
        Shopcarts foundShopcarts = null;
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            Criteria cr = session.createCriteria(Shopcarts.class);
            cr.add(Restrictions.eq("User_Id", User_Id));
            foundShopcarts = (Shopcarts) cr.uniqueResult();
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

        return foundShopcarts.getShopcart_Id();
    }


    @Override
    public int getUserIdByShopcartId(int Shopcart_Id) {
        Session session = null;
        Shopcarts foundShopcarts = null;
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            Criteria cr = session.createCriteria(Shopcarts.class);
            cr.add(Restrictions.eq("Shopcart_Id", Shopcart_Id));
            foundShopcarts = (Shopcarts) cr.uniqueResult();
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

        return foundShopcarts.getUser_Id().getUser_Id();
    }
}
