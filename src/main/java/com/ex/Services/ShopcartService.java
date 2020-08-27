package com.ex.Services;

import com.ex.Daos.ShopcartDao;
import com.ex.Frames.*;
import org.hibernate.SessionFactory;

import org.hibernate.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


public class ShopcartService implements ShopcartDao {


    private SessionFactory sessionFactory;

    public ShopcartService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

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

    @Override
    public Shopcarts addShopcartByUserId(int User_Id) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            Shopcarts newShopCart = new Shopcarts();
            newShopCart.setUser_Id(User_Id);
            session.save(newShopCart);
            session.getTransaction().commit();
            return newShopCart;

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
}
