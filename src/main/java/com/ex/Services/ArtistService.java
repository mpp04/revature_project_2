package com.ex.Services;

import com.ex.Daos.ArtistDao;
import com.ex.Frames.Artists;

import java.util.List;

import org.hibernate.SessionFactory;

import org.hibernate.*;

import org.hibernate.criterion.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ArtistService implements ArtistDao {


    private SessionFactory sessionFactory;
    @Autowired
    public ArtistService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    @Transactional
    public List<Artists> getAllArtists() {
        Session session = sessionFactory.openSession();
        String hql = "FROM Artists";
        Query query = session.createQuery(hql);
        List<Artists> foundArtists = query.list();
        return foundArtists;
    }

    @Override
    @Transactional
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
    @Transactional
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
