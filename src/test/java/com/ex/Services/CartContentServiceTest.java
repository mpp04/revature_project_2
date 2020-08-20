
package com.ex.Services;

import com.ex.HibernateUtil;
import junit.framework.TestCase;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.ex.Frames.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class CartContentServiceTest extends TestCase {

    private static SessionFactory sessionFactory;
    private static CartContentService cartContentService;


    @BeforeClass
    public void setUp() throws Exception {
        HibernateUtil.connect();
        sessionFactory = HibernateUtil.getSessionFactory();
        cartContentService = new CartContentService(sessionFactory);

    }

    @Test
    public void testGetItemsByCartId() {
        assertEquals("It works", (cartContentService.getItemsByCartId(5)), 5);
    }

    @Test
    public void testGetCartIdsByShopcartId() {
        assertEquals("It works", cartContentService.getCartIdsByShopcartId(2).get(0).getCart_Id(), 3);
    }

    @Test
    public void testAddItemToCart(){
        assertEquals("It works",cartContentService.addItemToCart(1,2),0);
    }

    @Test
    public void testRemoveItemFromCart(){
        assertEquals("It works",cartContentService.removeItemFromCart(2),1);
    }
}


