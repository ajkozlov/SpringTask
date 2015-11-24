package ru.av.tests;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.av.entities.Item;
import ru.av.service.BasketService;
import ru.av.service.ItemsService;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class BasketTest {
    @Autowired
    BasketService basketService;

    @Autowired
    ItemsService itemsService;

    @Test
    public void basketTest() {
        Item item1 = itemsService.findById(1);
        assertNotNull(item1);
        Item item2 = itemsService.findById(2);
        assertNotNull(item2);
        double sum = item1.getPrice() + item2.getPrice();
        basketService.addItem(item1);
        assertEquals(basketService.getSum(), item1.getPrice());
        basketService.addItem(item2);
        assertEquals(basketService.getSum(), (Double)(item1.getPrice() + item2.getPrice()));
        assertEquals(basketService.getPositions().size(), 2);
        basketService.buy();
        assertEquals(basketService.getSum(), Double.valueOf("0"));
    }
}
