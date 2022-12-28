package com.example.ordersapiappexample.modal.dao.item;

import com.example.ordersapiappexample.modal.entity.Item;
import com.example.ordersapiappexample.modal.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//имплементация Dao для сущнисти
@Service
public class DbDaoItem implements IDaoItem{

    @Autowired
    private ItemRepository repository;

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
        if (! repository.findById(item.getId()).isPresent()){
            System.out.println("DbDaoItem=>isPresent()");
            return null;
        }
        System.out.println("DbDaoItem=>save");
        return repository.save(item);
    }

    @Override
    public Item delete(Integer id) {
        Optional<Item> item =  repository.findById(id);
        if (item.isPresent()) return null;
        repository.deleteById(id);
        return item.get();
    }

}
