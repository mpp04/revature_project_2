package com.ex.web.services;

import com.ex.web.dao.ArtistDao;
import com.ex.web.models.Artists;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class ArtistService implements ArtistDao {


    private SessionFactory sessionFactory;

    public ArtistService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<Artists> getAllArtists() {
        Session session = sessionFactory.openSession();
        String hql = "FROM Artists";
        Query query = session.createQuery(hql);
        List<Artists> foundArtists = query.list();
        return foundArtists;
    }

    @Override
    public int getArtistIdByArtist(String Artist_Name) {
        Artists foundArtist;
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria cr = session.createCriteria(Artists.class);
        cr.add(Restrictions.eq("Artist_Name", Artist_Name));
        foundArtist = (Artists) cr.uniqueResult();
        session.getTransaction().commit();
        return foundArtist.getArtist_Id();
    }

    @Override
    public String getArtistById(int Artist_Id) {
        Artists foundArtist;
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria cr = session.createCriteria(Artists.class);
        cr.add(Restrictions.eq("Artist_Id", Artist_Id));
        foundArtist = (Artists) cr.uniqueResult();
        session.getTransaction().commit();
        return foundArtist.getArtist_Name();
    }

}
