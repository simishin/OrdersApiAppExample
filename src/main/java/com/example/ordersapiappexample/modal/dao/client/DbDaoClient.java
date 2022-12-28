package com.example.ordersapiappexample.modal.dao.client;

import com.example.ordersapiappexample.modal.entity.Client;
import com.example.ordersapiappexample.modal.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class DbDaoClient implements IdaoClient{

    @Autowired
    private ClientRepository repository;

    @Override
    public List<Client> findAll() {
        return (List<Client>) repository.findAll();
    }

    @Override
    public Optional<Client> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Client save(Client item) {
        return repository.save(item);
    }

    @Override
    public Client update(Client item) {
        if (! repository.findById(item.getId()).isPresent()){
            return null;
        }
        return repository.save(item);
    }

    @Override
    public Client delete(Integer id) {
        Optional<Client> item =  repository.findById(id);
        if (! item.isPresent()) return null;
        repository.deleteById(id);
        return item.get();
    }
}
