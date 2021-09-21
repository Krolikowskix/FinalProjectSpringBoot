package com.example.finalprojectspringboot.Item;

import com.example.finalprojectspringboot.Item.Item;
import com.example.finalprojectspringboot.Item.ItemService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Primary
@Service
public class JpaItemService implements ItemService {

    private final ItemRepository itemRepository;

    public JpaItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public List<Item> getItems() {
        return itemRepository.findAll();
    }

    @Override
    public Optional<Item> get(Long id) {
        return itemRepository.findById(id);
    }

    @Override
    public void add(Item item) {
        itemRepository.save(item);
    }

    @Override
    public void delete(Long id) {
        itemRepository.deleteById(id);
    }

    @Override
    public void update(Item item) {
        itemRepository.save(item);
    }

    @Override
    public List<Item> getItemsByUserId(Long userId) {
        return itemRepository.findAllByUserId(userId);
    }


}





