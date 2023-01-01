package com.example.ordersapiappexample.modal.dao.order;

import com.example.ordersapiappexample.modal.entity.Order;
import com.example.ordersapiappexample.modal.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class DbDaoOrder  implements IdaoOrder {
    @Autowired
    private OrderRepository repository;

    @Override
    public List<Order> findAll() {
        return (List<Order>) repository.findAll();
    }

    @Override
    public Optional<Order> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Order save(Order item) {
        return repository.save(item);
    }

    @Override
    public Order update(Order item) {
        if (! repository.findById(item.getId()).isPresent()){
            return null;
        }
        return repository.save(item);
    }

    @Override
    public Order delete(Integer id) {
        Optional<Order> item =  repository.findById(id);
        if (item.isPresent()) return null;
        repository.deleteById(id);
        return item.get();
    }
}
