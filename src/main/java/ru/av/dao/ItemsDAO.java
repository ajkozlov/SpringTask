package ru.av.dao;


import ru.av.entities.Item;

import java.util.Collection;

public interface ItemsDAO {
    public Item get(Long id);

    public Collection<Item> getList();

    public void set(Item item);
}
