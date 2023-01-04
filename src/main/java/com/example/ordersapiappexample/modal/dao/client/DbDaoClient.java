package com.example.ordersapiappexample.modal.dao.client;

import com.example.ordersapiappexample.modal.entity.Client;
import com.example.ordersapiappexample.modal.entity.Order;
import com.example.ordersapiappexample.modal.repository.ClientRepository;
//import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class DbDaoClient implements IDaoClient {
    private final ClientRepository repository;
    public  static ClientRepository xxx;
    public DbDaoClient(ClientRepository repository) {
        this.repository = repository;
        xxx = repository;
    }

    @Override
    public List<Client> findAll() {
        return (List<Client>) repository.findAll();
    }
    @Override
    public Optional<Client> findById(Integer id) {
        System.out.println("+++++++ "+id);
        return repository.findById(id);
    }
    @Override
    public Client save(Client item) {
//        if ( repository.findById(item.getId()).isPresent()) return null;
        return repository.save(item);
    }
    @Override
    public Client update(Client item) {
        if (! repository.findById(item.getId()).isPresent()){
            return repository.save(item);
        }
//        Optional<Client> x = repository.findById(item.getId());
//        Set<Order> y = x.get().orders();
        item.setOrders(repository.findById(item.getId()).get().orders());
        return repository.save(item);
    }
    @Override
    public Client delete(Integer id) {
        Optional<Client> item =  repository.findById(id);
        if (! item.isPresent()) {
            System.out.println("Client delete NOT fined");
            return null;}
        if (item.get().getSize() >0 ) return null; //запрет на удаление
        repository.deleteById(id);
        Client z = item.get();
        z.setOrders( new HashSet<Order>());
        return z;
    }
}//class DbDaoClient
