package com.example.ordersapiappexample.modal.dao.order;


import com.example.ordersapiappexample.modal.dao.client.DbDaoClient;
import com.example.ordersapiappexample.modal.entity.Client;
import com.example.ordersapiappexample.modal.entity.Order;
import com.example.ordersapiappexample.modal.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DbDaoOrder implements IdaoOrder {
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
    public Order save(Order item, Integer idClient) {
        Optional<Client> cx = DbDaoClient.xxx.findById(idClient);
        System.out.println("************\n"+ cx);
        if (cx.isPresent()) { //есть такой
            item.setClient(cx.get());
            return repository.save(item);
        }
        return null;
    }

    @Override
    public Order update(Order item, Integer idClient) {
        System.out.println("Order update "+item+" **** "+idClient);
        return null;
    }

    @Override // НЕ используется
    public Order save(Order item) {  return repository.save(item);  }

    @Override // НЕ используется
    public Order update(Order item) {
        if (!repository.findById(item.getId()).isPresent()) {
            return null;
        }
        return repository.save(item);
    }

    @Override
    public Order delete(Integer id) {
        Optional<Order> item = repository.findById(id);
        if (! item.isPresent()) return null;
        repository.deleteById(id);
        return item.get();
    }

}
