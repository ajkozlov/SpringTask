package ru.av.service;

import ru.av.entities.Item;

import java.util.List;

public interface BasketService {
    public Double getSum();
    public List<String> getPositions();
    public void addItem(Item item);
    public void buy();
}
