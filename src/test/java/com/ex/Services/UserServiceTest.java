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

public class UserServiceTest extends TestCase {

    private static SessionFactory sessionFactory;
    private static UserService userService;


    @BeforeClass
    public void setUp() throws Exception {
        HibernateUtil.connect();
        sessionFactory = HibernateUtil.getSessionFactory();
        userService = new UserService(sessionFactory);
    }

    @Test
    public void testLogin() {
        assertEquals("It works",userService.login("NavPan","Navjot12345").getEmail(),"navpanchhi@gmail.com");
    }

    @Test
    public void testGetById() {
        assertEquals("It works", userService.getById(userService.getUserIdByUsername("NavPan")).getEmail() ,"navpanchhi@gmail.com" );
    }

    @Test
    public void testGetByUsername() {
        assertEquals("It works", userService.getByUsername("NavPan2").getEmail(), "navjot@gmail.com" );
    }

    @Test
    public void testGetUserIdByUsername() {
        assertEquals("It works", userService.getUserIdByUsername("NavPan"), userService.getByUsername("NavPan").getUser_Id());
    }

    @Test
    public void testGetUsernameByUserId() {
        assertEquals("It works", userService.getUsernameByUserId(userService.getByUsername("NavPan").getUser_Id()),"NavPan" );
    }

    @Test
    public void testUpdateEmail() {
        assertEquals("It works", userService.updateEmail(userService.getUserIdByUsername("NavPan2"),"navp@gmail.com"), 0);
        userService.updateEmail(userService.getUserIdByUsername("NavPan2"),"navjot@gmail.com");
    }

    @Test
    public void testCreateAccount() {
        if (userService.getByUsername("NavPan").getEmail() == "navpanchhi@gmail.com"){
            //userService.deleteUserById(userService.getUserIdByUsername("NavPan"));
            assertEquals("It works", userService.createAccount(
                    "navpanchhi@gmail.com",
                    "NavPan",
                    "Navjot12345",
                    "Navjot",
                    "Panchhi"
            ).getEmail(), "navpanchhi@gmail.com");
            //userService.deleteUserById(userService.getUserIdByUsername("NavPan"));
        }
    }

/*    @Test
    public void testDeleteUserById() {
        assertEquals("It works", userService.deleteUserById(userService.getUserIdByUsername("NavPan")), 0);
        userService.createAccount(
                "navpanchhi@gmail.com",
                "NavPan",
                "Navjot12345",
                "Navjot",
                "Panchhi"
        );
    }*/

}