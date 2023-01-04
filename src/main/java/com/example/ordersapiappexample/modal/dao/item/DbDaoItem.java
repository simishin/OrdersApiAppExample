package com.example.ordersapiappexample.modal.dao.item;

import com.example.ordersapiappexample.modal.entity.Item;
import com.example.ordersapiappexample.modal.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//имплементация Dao для сущнисти
@Service
public class DbDaoItem implements IDaoItem{

    private final ItemRepository repository;
    public static ItemRepository xxx;
    public DbDaoItem(ItemRepository repository) {
        this.repository = repository;
        xxx = repository;
    }

    @Override
    public List<Item> findAll() {
        return (List<Item>) repository.findAll();
    }

    @Override
    public Optional<Item> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Item save(Item item) {
        return repository.save(item);
    }

    @Override
    public Item update(Item item) {
        if (repository.findById(item.getId()).isEmpty()){
            System.out.println("DbDaoItem=>isPresent()");
            return null;
        }
        System.out.println("DbDaoItem=>save");
        return repository.save(item);
    }

    @Override
    public Item delete(Integer id) {
        Optional<Item> z = repository.findById(id);
        if (z.isEmpty()) return null;

        repository.deleteById(id);
        return z.get();
    }

}
