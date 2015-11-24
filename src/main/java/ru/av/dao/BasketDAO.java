package ru.av.dao;


import ru.av.entities.BasketItem;
import ru.av.entities.Item;

import java.util.Collection;
import java.util.List;

public interface BasketDAO {
    public Double getSum();
    public List<String> getPositions();
    public void addItem(Item item);
    public List<BasketItem> getList();
    public void clear();
}
