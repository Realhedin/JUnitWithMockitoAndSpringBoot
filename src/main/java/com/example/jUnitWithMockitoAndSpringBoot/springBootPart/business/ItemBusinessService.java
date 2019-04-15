package com.example.jUnitWithMockitoAndSpringBoot.springBootPart.business;

import java.util.List;

import com.example.jUnitWithMockitoAndSpringBoot.springBootPart.data.ItemRepository;
import com.example.jUnitWithMockitoAndSpringBoot.springBootPart.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author dkorolev
 *         Date: 4/12/2019
 *         Time: 4:42 PM
 */
@Component
public class ItemBusinessService {

    @Autowired
    private ItemRepository itemRepository;

    public Item retrieveHardcodedItem() {
        return new Item(1, "Ball", 10, 100);
    }


    public List<Item> retrieveAllItems() {
        List<Item> all = itemRepository.findAll();
        //calculate value
        all.stream().forEach(i->i.setValue(i.getPrice()*i.getQuantity()));
        return all;
    }
}