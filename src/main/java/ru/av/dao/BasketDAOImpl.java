package ru.av.dao;


import ru.av.entities.BasketItem;
import ru.av.entities.Item;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BasketDAOImpl implements BasketDAO {

    private Collection<BasketItem> basketItems = new ArrayList<BasketItem>();

    public Double getSum() {
        Double sum = 0d;
        for(BasketItem item : basketItems){
            sum += item.getSum();
        }
        return Math.round(sum*100d)/100d;
    }

    public List<String> getPositions() {
        List<String> res = new ArrayList<String>();
        for(BasketItem basketItem : basketItems){
            res.add(basketItem.getItemTitle() + "  |  " + basketItem.getCount() + "  |  " + basketItem.getSum());
        }
        return res;
    }

    public void addItem(Item item) {
        for(BasketItem basketItem : basketItems){
            if(basketItem.itemEquals(item)){
                basketItem.addCount();
                return;
            }
        }
        if(item.getQuantity() > 0) {
            basketItems.add(new BasketItem(item));
        }
    }

    public List<BasketItem> getList() {
        return (List<BasketItem>) this.basketItems;
    }

    public void clear() {
        this.basketItems = new ArrayList<BasketItem>();
    }
}
