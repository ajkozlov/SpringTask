package ru.av.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import ru.av.entities.Category;
import ru.av.entities.Item;

import java.util.Collection;

public class ItemsDAOImpl extends HibernateDaoSupport implements ItemsDAO {

    private Boolean showAll = true;

    public void setShowAll(Boolean showAll) {
        this.showAll = showAll;
    }

    public Item get(Long id) {
        return getHibernateTemplate().get(Item.class, id);
    }

    public Collection<Item> getList() {
        Criteria criteria = currentSession().createCriteria(Item.class);
        if(!this.showAll) {
            criteria.add(Restrictions.gt("quantity", 0));
        }
        return criteria.list();
    }

    public void set(Item item) {
        getHibernateTemplate().save(item);
    }

    public void update(Item item) {
        getHibernateTemplate().update(item);
    }

    public Collection<Item> getFinishedItems() {
        return currentSession().createCriteria(Item.class).add(Restrictions.eq("quantity", 0)).list();
    }

    public Collection<Item> getCategoryList(Long catID) {
        return currentSession().createCriteria(Item.class).add(Restrictions.eq("category", getHibernateTemplate().get(Category.class, catID))).list();
    }

}
