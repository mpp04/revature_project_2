package com.ex.Services;

import com.ex.Daos.CartContentDao;
import com.ex.Frames.*;
import org.hibernate.*;

import java.util.List;

public class CartContentService implements CartContentDao {


    private SessionFactory sessionFactory;

    public CartContentService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public int getItemsByCartId(int Cart_Id) {
        Session session = null;
        CartContents foundItem = null;
        try{
            session = sessionFactory.openSession();
            foundItem = (CartContents) session.get(CartContents.class, Cart_Id);
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

        return foundItem.getProduct_Id();
    }

    @Override
    public List<CartContents> getCartIdsByShopcartId(int Shopcart_Id) {
        Session session = null;
        try{
            session = sessionFactory.openSession();
            String hql = "FROM CartContents WHERE shopcart_id = :s";
            Query query = session.createQuery(hql);
            query.setInteger("s", Shopcart_Id);

            List foundCartcontents = (List)query.list();
            System.out.println(foundCartcontents);
            return foundCartcontents;

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
    public int addItemToCart(int Product_Id, int Shopcart_Id) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            CartContents newItem = new CartContents();
            newItem.setProduct_Id(Product_Id);
            newItem.setShopcart_Id(Shopcart_Id);
            session.save(newItem);
            session.getTransaction().commit();
            return 0;

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
        return 1;
    }

    @Override
    public int removeItemFromCart(int Cart_Id) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            CartContents foundItems = (CartContents) session.get(CartContents.class, Cart_Id);
            if(foundItems!=null){
                session.delete(foundItems);
                session.getTransaction().commit();
                return 0;
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
        return 1;
    }
}
