
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

public class ShopcartServiceTest extends TestCase {

    private static SessionFactory sessionFactory;
    private static ShopcartService shopcartService;
    //private static UserService userService;

    @BeforeClass
    public void setUp() throws Exception {
        HibernateUtil.connect();
        sessionFactory = HibernateUtil.getSessionFactory();
        shopcartService = new ShopcartService(sessionFactory);
        //userService = new UserService(sessionFactory);
    }

/*    @Test
    public void testGetShopcartIdByUserId() {
        assertEquals("It works", shopcartService.getShopcartIdByUserId(3), 2);
    }*/

    @Test
    public void testGetUserIdByShopcartId() {
        assertEquals("It works", shopcartService.getUserIdByShopcartId(2), 3);
    }

    @Test
    public

}



