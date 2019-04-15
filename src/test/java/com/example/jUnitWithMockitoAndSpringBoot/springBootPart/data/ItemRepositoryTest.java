package com.example.jUnitWithMockitoAndSpringBoot.springBootPart.data;

import java.util.List;

import com.example.jUnitWithMockitoAndSpringBoot.springBootPart.model.Item;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author dkorolev
 *         Date: 4/15/2019
 *         Time: 3:47 PM
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class ItemRepositoryTest {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void testFindAll() {
        List<Item> all = itemRepository.findAll();
        Assert.assertEquals(1, all.size());
    }

}