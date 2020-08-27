package com.ex.web.services;

import com.ex.web.dao.UserDao;
import com.ex.web.models.Users;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;


public class UserService implements UserDao {

    private SessionFactory sessionFactory;


    public UserService(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    /**
     * @param Username -User's entered email
     * @param Password -User's entered password
     * @return Users object which includes email, password, first name, and last name
     */
    @Override
    public Users login(String Username, String Password) {
        Session session = sessionFactory.openSession();
        Criteria cr = session.createCriteria(Users.class);
        Criterion usernameCr = Restrictions.eq("Username", Username);
        Criterion passwordCr = Restrictions.eq("Password", Password);
        LogicalExpression andExp = Restrictions.and(usernameCr, passwordCr);
        cr.add(andExp);
        Users loggedInUser = (Users) cr.uniqueResult();
        return loggedInUser;
    }

    /**
     * @param User_Id -User Id that is going to be used to parse the database
     * @return Users object based on the User Id provided
     */
    @Override
    public Users getById(int User_Id) {
        Session session = null;
        Users foundUser = null;
        try {
            session = sessionFactory.openSession();
            foundUser = (Users) session.get(Users.class, User_Id);
        } catch (HibernateException hex) {
            hex.printStackTrace();
            if (session != null && session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return foundUser;
    }

    /**
     * @param Username User username that is going to be used to parse the database
     * @return Users object based on the username provided
     */
    @Override
    public Users getByUsername(String Username) {
        Session session = null;
        Users foundUser = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            Criteria cr = session.createCriteria(Users.class);
            cr.add(Restrictions.eq("Username", Username));
            foundUser = (Users) cr.uniqueResult();
            session.getTransaction().commit();

        } catch (HibernateException hex) {
            hex.printStackTrace();
            if (session != null && session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return foundUser;
    }

    /**
     * @param Username User username that is going to be used to parse the database
     * @return User Id based on the username provided
     */
    @Override
    public int getUserIdByUsername(String Username) {
        Session session = null;
        Users foundUsers = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            Criteria cr = session.createCriteria(Users.class);
            cr.add(Restrictions.eq("Username", Username));
            foundUsers = (Users) cr.uniqueResult();
            session.getTransaction().commit();

        } catch (HibernateException hex) {
            hex.printStackTrace();
            if (session != null && session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return foundUsers.getUser_Id();
    }

    /**
     * @param User_Id User id that is going to be used to parse the database
     * @return Username based on the user id provided
     */
    @Override
    public String getUsernameByUserId(int User_Id) {
        Session session = null;
        Users foundUsers = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            Criteria cr = session.createCriteria(Users.class);
            cr.add(Restrictions.eq("User_Id", User_Id));
            foundUsers = (Users) cr.uniqueResult();
            session.getTransaction().commit();

        } catch (HibernateException hex) {
            hex.printStackTrace();
            if (session != null && session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return foundUsers.getUsername();
    }

    /**
     * @param User_Id userID that is going to be used to parse the database
     * @param Email   New User email
     * @return int of 0 if email is successfully changed or a 1 if it does not change
     */
    @Override
    public int updateEmail(int User_Id, String Email) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            Users foundUser = (Users) session.get(Users.class, User_Id);
            if (foundUser != null) {
                foundUser.setEmail(Email);
                session.update(foundUser);
                session.getTransaction().commit();
                return 0;
            }

        } catch (HibernateException hex) {
            hex.printStackTrace();
            if (session != null && session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return 1;
    }

    /**
     * @param Email      New User's email
     * @param Password   New User's password
     * @param Username   New Usre's username
     * @param First_Name New User's first name
     * @param Last_Name  New User's last name
     * @return User object of the newly created user
     */
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
            if (session != null && session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

}