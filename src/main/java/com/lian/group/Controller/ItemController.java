package com.lian.group.Controller;

import com.lian.group.Entity.Item;
import com.lian.group.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ItemController {
    @Autowired
    private ItemRepository itemRepository;

    @PostMapping("/addItem")
    public String addItem(@RequestParam String name) {
        Item item = new Item();
        item.setName(name);
        itemRepository.save(item);
        return "Added new item to repo!";
    }

    @GetMapping("/item")
    public Iterable<Item> getItems(){
        return itemRepository.findAll();
    }

    @GetMapping("item/{id}")
    public Item findItemById (@PathVariable Integer id) {
        return itemRepository.findItemById(id);
    }
}
