package ru.av.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.av.dao.BasketDAO;
import ru.av.entities.BasketItem;
import ru.av.entities.Item;

import java.util.List;

@Service
public class BasketServiceImpl implements BasketService {

    @Autowired
    BasketDAO basketDAO;

    @Autowired
    ItemsService itemsService;

    public Double getSum() {
        return basketDAO.getSum();
    }

    public List<String> getPositions() {
        return basketDAO.getPositions();
    }

    public void addItem(Item item) {
        basketDAO.addItem(item);
    }

    public void buy() {
        List<BasketItem> basketList = basketDAO.getList();
        for(BasketItem basketItem : basketList){
            Item item = basketItem.getItem();
            item.setQuantity(basketItem.getItem().getQuantity() - basketItem.getCount());
            itemsService.save(item);
            basketDAO.clear();
        }
    }
}
