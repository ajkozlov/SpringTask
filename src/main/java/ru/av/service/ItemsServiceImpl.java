package ru.av.service;

import org.springframework.stereotype.Service;
import ru.av.dao.ItemsDAO;
import ru.av.entities.Item;

import javax.annotation.Resource;
import java.util.Collection;


@Service("items")
public class ItemsServiceImpl implements ItemsService {

    //@Resource(name = "itemsDAO")
    private ItemsDAO dao;

    public ItemsServiceImpl(ItemsDAO dao) {
        this.dao = dao;
    }

    public Collection<Item> getList() {
        return dao.getList();
    }

    public Item findById(long id) {
        return dao.get(id);
    }
}
