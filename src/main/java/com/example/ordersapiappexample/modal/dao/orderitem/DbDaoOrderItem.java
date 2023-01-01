package com.example.ordersapiappexample.modal.dao.orderitem;

import com.example.ordersapiappexample.modal.entity.OrderItems;
import com.example.ordersapiappexample.modal.repository.OrderItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class DbDaoOrderItem implements IdaoOrderItem {
    @Autowired
    private OrderItemsRepository repository;

    @Override
    public List<OrderItems> findAll() {
        return (List<OrderItems>) repository.findAll();
    }

    @Override
    public Optional<OrderItems> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public OrderItems save(OrderItems item) {
        return repository.save(item);
    }

    @Override
    public OrderItems update(OrderItems item) {
        if (! repository.findById(item.getId()).isPresent()){
            return null;
        }
        return repository.save(item);
    }

    @Override
    public OrderItems delete(Integer id) {
        Optional<OrderItems> item =  repository.findById(id);
        if (item.isPresent()) return null;
        repository.deleteById(id);
        return item.get();
    }
}
