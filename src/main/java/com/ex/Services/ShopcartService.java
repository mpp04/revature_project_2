package com.ex.Services;

import com.ex.Frames.Albums;
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

/*

    @Override
    public int getShopcartIdByUserId(int User_Id) {
        Session session = null;
        Shopcarts foundShopcart = null;
        try{
            session = sessionFactory.openSession();
            foundShopcart = (Shopcarts) session.get(Shopcarts.class, User_Id);
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
        System.out.println(foundShopcart);
        return foundShopcart.getShopcart_Id();
    }
*/


    @Override
    public int getUserIdByShopcartId(int Shopcart_Id) {
        Session session = null;
        Shopcarts foundShopcart = null;
        try{
            session = sessionFactory.openSession();
            foundShopcart = (Shopcarts) session.get(Shopcarts.class, Shopcart_Id);
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

        return foundShopcart.getUser_Id();
    }
}
