package ru.av.tests;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Collection;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import ru.av.entities.Item;
import ru.av.service.ItemsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class ItemsTest {

    private static final Logger logger = LoggerFactory.getLogger(ItemsService.class);

    @Autowired
    ItemsService itemsService;

    @Test
    public void indexTest() {
        Collection<Item> allItems = itemsService.getList();
        logger.debug("{}", allItems);

    }

    @Test
    public void findItem() {
        Item item = itemsService.findById(1);
        assertNotNull(item);
        assertEquals((long)item.getId(), 1L);
    }

    @Test
    public void finishedItems() {
        Collection<Item> items = itemsService.getFinishedItems();
        assertNotNull(items);
        assertEquals(items.size(), 5);
    }

    @Test
    public void categoryItems() {
        Collection<Item> items = itemsService.getCategoryList(1L);
        assertNotNull(items);
        assertEquals(items.size(), 5);
    }
}
