package com.example.finalprojectspringboot.Item;

import com.example.finalprojectspringboot.Item.Item;

import java.util.List;
import java.util.Optional;

public interface ItemService {
    List<Item> getItems();
    Optional<Item> get(Long id);
    void add(Item item);
    void delete(Long id);
    void update(Item item);
    List<Item> getItemsByUserId(Long userId);


}


