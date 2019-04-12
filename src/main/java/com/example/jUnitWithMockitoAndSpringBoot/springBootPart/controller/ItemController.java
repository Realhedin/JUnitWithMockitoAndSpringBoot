package com.example.jUnitWithMockitoAndSpringBoot.springBootPart.controller;

import com.example.jUnitWithMockitoAndSpringBoot.springBootPart.model.Item;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dkorolev
 *         Date: 4/11/2019
 *         Time: 2:10 PM
 */
@RestController
public class ItemController {

    @GetMapping("/dummyItem")
    public Item dummyItem() {
        return new Item(1, "Ball", 10, 100);
    }

}