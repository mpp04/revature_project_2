package com.ex.Services;

import com.ex.Frames.Shopcarts;
import com.ex.Frames.UserDao;
import com.ex.Frames.Users;
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

public class UserService implements UserDao{

    private SessionFactory sessionFactory;

    public UserService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Users login(String Username, String Password) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Criteria cr = session.createCriteria(Users.class);
            Criterion usernameCr = Restrictions.eq("Username", Username);
            Criterion passwordCr = Restrictions.eq("Password", Password);
            LogicalExpression andExp = Restrictions.and(usernameCr, passwordCr);
            cr.add(andExp);
            Users loggedInUser = (Users) cr.uniqueResult();
            return loggedInUser;

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
    public Users getById(int User_Id) {
        Session session = null;
        Users foundUser = null;
        try{
            session = sessionFactory.openSession();
            foundUser = (Users) session.get(Users.class, User_Id);
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

        return foundUser;
    }

    @Override
    public Users getByUsername(String Username) {
        Session session = null;
        Users foundUser = null;
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            Criteria cr = session.createCriteria(Users.class);
            cr.add(Restrictions.eq("Username", Username));
            foundUser = (Users) cr.uniqueResult();
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

        return foundUser;
    }

    @Override
    public int getUserIdByUsername(String Username) {
        Session session = null;
        Users foundUsers = null;
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            Criteria cr = session.createCriteria(Users.class);
            cr.add(Restrictions.eq("Username", Username));
            foundUsers = (Users) cr.uniqueResult();
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

        return foundUsers.getUser_Id();
    }

    @Override
    public String getUsernameByUserId(int User_Id) {
        Session session = null;
        Users foundUsers = null;
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            Criteria cr = session.createCriteria(Users.class);
            cr.add(Restrictions.eq("User_Id", User_Id));
            foundUsers = (Users) cr.uniqueResult();
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

        return foundUsers.getUsername();
    }

    @Override
    public int updateEmail(int User_Id, String Email) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            Users foundUser = (Users) session.get(Users.class, User_Id);
            if (foundUser != null){
                foundUser.setEmail(Email);
                session.update(foundUser);
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

    @Override
    public Users createAccount(String Email, String Username, String Password, String First_Name, String Last_Name) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            Users newUser = new Users();
            newUser.setEmail(Email);
            newUser.setPassword(Password);
            newUser.setUsername(Username);
            newUser.setFirst_Name(First_Name);
            newUser.setLast_Name(Last_Name);
            session.save(newUser);
            session.getTransaction().commit();
            return newUser;

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

/*    @Override
    public int deleteUserById(int User_Id) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            Users foundUser = (Users) session.get(Users.class, User_Id);
            if(foundUser!=null){
                session.delete(foundUser);
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
    }*/

}
