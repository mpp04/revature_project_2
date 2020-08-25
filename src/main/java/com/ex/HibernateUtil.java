package com.ex;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {

  private static SessionFactory sessionFactory;


  public static HibernateUtil connect() {
    HibernateUtil m = new HibernateUtil();
    HibernateUtil.configure();
    return m;
  }

  private static void configure() {
    // find and load hibernate.cfg.xml

    Configuration config = new Configuration().configure("hibernate.cfg.xml");
    StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(config.getProperties());
    sessionFactory = config.buildSessionFactory(builder.build());
  }

  public static SessionFactory getSessionFactory() {
    return sessionFactory;
  }

  public static void shutdown() {
    // Close caches and connection pools
    if(sessionFactory!=null){
      sessionFactory.close();
    }
  }
}

