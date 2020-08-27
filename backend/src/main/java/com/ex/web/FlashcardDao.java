package com.ex.web;

import com.ex.web.models.Flashcard;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

@Repository
@Transactional
public class FlashcardDao {
    SessionFactory sessionFactory;

    protected void initFlashcard() {
        Flashcard f = new Flashcard();
        f.setQuestion("How many beans are required to integrate Spring and Hibernate with Transaction Management");
        f.setAnswer("3");

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(f);
        tx.commit();
    }

    @Autowired
    public FlashcardDao(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED, readOnly=true)
    public List<Flashcard> findAll() {
        Session session = sessionFactory.getCurrentSession(); // CONTEXTUAL SESSION. IS USED IN TX MANAGEMENT.
        String hql = "From Flashcard";
        Query query = session.createQuery(hql);
        List<Flashcard> cards = query.list();
        return cards;
    }
}
