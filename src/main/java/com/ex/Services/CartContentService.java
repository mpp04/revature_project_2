package com.ex.Services;

import com.ex.Frames.CartContents;
import com.ex.Frames.CartContentDao;
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
    public int[] getItemsByCartId(int Cart_Id) {
        Session session = null;
        CartContents foundItem = null;
        CartContents foundQuantity = null;
        int ItemInfo[] = new int[2];
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            Criteria cr1 = session.createCriteria(CartContents.class);
            cr1.add(Restrictions.eq("Cart_Id", Cart_Id));
            Criteria cr2 = session.createCriteria(CartContents.class);
            cr2.add(Restrictions.eq("Cart_Id", Cart_Id));
            foundItem = (CartContents) cr1.uniqueResult();
            foundQuantity = (CartContents) cr2.uniqueResult();
            int productElement = foundItem.getProduct_Id().getAlbum_Id();
            int quantityElement = foundQuantity.getQuantity();
            session.getTransaction().commit();
            ItemInfo[0] = productElement;
            ItemInfo[1] = quantityElement;

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

        return ItemInfo;
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
