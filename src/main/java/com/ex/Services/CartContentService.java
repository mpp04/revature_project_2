package com.ex.Services;

import com.ex.Frames.CartContents;
import com.ex.Frames.CartContentDao;
import com.ex.Frames.Users;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
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

        return foundItem.getProduct_Id().getAlbum_Id();
    }

    @Override
    public List<CartContents> getCartIdsByShopcartId(int Shopcart_Id) {
        Session session = null;
        List<CartContents> foundItems = new ArrayList<>();
        try{
            session = sessionFactory.openSession();
            Criteria cr = session.createCriteria(CartContents.class);
            Criteria crUser = cr.createCriteria("Shopcart_Id");
            crUser.add(Restrictions.eq("Shopcart_Id", Shopcart_Id));

            for(Object o : cr.list()){
                foundItems.add((CartContents) o);
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

        return foundItems;
    }
}
