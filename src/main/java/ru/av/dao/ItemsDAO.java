package ru.av.dao;


import ru.av.entities.Item;

import java.util.Collection;

public interface ItemsDAO {
    public Item get(Long id);

    public Collection<Item> getList();

    public void set(Item item);

    public void update(Item item);

    public Collection<Item> getFinishedItems();

    public Collection<Item> getCategoryList(Long catID);
}
