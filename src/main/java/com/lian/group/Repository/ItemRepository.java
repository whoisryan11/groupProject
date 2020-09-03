package com.lian.group.Repository;

import com.lian.group.Entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
    Item findItemById(Integer id);
}
