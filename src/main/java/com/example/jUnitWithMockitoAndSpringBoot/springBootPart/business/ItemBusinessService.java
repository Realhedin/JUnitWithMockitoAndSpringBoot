package com.example.jUnitWithMockitoAndSpringBoot.springBootPart.business;

import com.example.jUnitWithMockitoAndSpringBoot.springBootPart.model.Item;
import org.springframework.stereotype.Component;

/**
 * @author dkorolev
 *         Date: 4/12/2019
 *         Time: 4:42 PM
 */
@Component
public class ItemBusinessService {

    public Item retrieveHardcodedItem() {
        return new Item(1, "Ball", 10, 100);
    }
}