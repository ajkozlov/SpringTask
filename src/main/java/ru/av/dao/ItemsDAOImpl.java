package ru.av.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.av.entities.Item;

import javax.annotation.Resource;
import java.util.Collection;

public class ItemsDAOImpl implements ItemsDAO {
    private SessionFactory sessionFactory;

    private Boolean showAll = true;

    public ItemsDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void setShowAll(Boolean showAll) {
        this.showAll = showAll;
    }

    public Item get(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return (Item) session.get(Item.class, id);
    }

    public Collection<Item> getList() {
        Session session = sessionFactory.getCurrentSession();
        Query query;
        if(this.showAll) {
            query = session.createQuery("from Items i");
        } else {
            query = session.createQuery("from Items i where i.quontity > 0");
        }
        return query.list();
    }

    public void set(Item item) {
        Session session = sessionFactory.getCurrentSession();
        session.save(item);
    }
}
