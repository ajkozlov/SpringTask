package ru.av.service;

import org.springframework.stereotype.Component;
import ru.av.entities.Item;

import java.util.Collection;

public interface ItemsService {
    public Collection<Item> getList();
    public Item findById(long id);
    public Collection<Item> getFinishedItems();
    public void save(Item item);
    public Collection<Item> getCategoryList(Long catID);
}
