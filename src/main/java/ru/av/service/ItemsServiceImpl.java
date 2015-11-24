package ru.av.service;

import org.springframework.stereotype.Service;
import ru.av.dao.ItemsDAO;
import ru.av.entities.Item;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.Collection;


@Service("itemsService")
public class ItemsServiceImpl implements ItemsService {

    @Resource(name = "itemsDAO")
    private ItemsDAO dao;

    public void setDao(ItemsDAO dao) {
        this.dao = dao;
    }

    @Transactional
    public Collection<Item> getList() {
        return dao.getList();
    }

    public Item findById(long id) {
        return dao.get(id);
    }

    @Transactional
    public Collection<Item> getFinishedItems() {
        return dao.getFinishedItems();
    }

    @Transactional
    public void save(Item item) {
        dao.update(item);
    }

    @Transactional
    public Collection<Item> getCategoryList(Long catID) {
        return dao.getCategoryList(catID);
    }
}
