package com.example.jUnitWithMockitoAndSpringBoot.springBootPart.data;

import com.example.jUnitWithMockitoAndSpringBoot.springBootPart.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author dkorolev
 *         Date: 4/15/2019
 *         Time: 12:43 PM
 */
public interface ItemRepository extends JpaRepository<Item, Integer> {
}