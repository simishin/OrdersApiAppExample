package com.example.ordersapiappexample.modal.dao.client;

import com.example.ordersapiappexample.modal.entity.Client;
import com.example.ordersapiappexample.modal.entity.Order;
import com.example.ordersapiappexample.modal.repository.ClientRepository;
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
        return repository.findById(id);
    }
    public static boolean isPres(Integer id){
        return xxx.findById(id).isPresent();
    }
    @Override
    public Client save(Client item) {
        return repository.save(item);
    }
    @Override
    public Client update(Client item) {
        if (repository.findById(item.getId()).isEmpty()){
            return repository.save(item);
        }
        item.setOrders(repository.findById(item.getId()).get().orders());
        return repository.save(item);
    }
    @Override
    public Client delete(Integer id) {
        Optional<Client> item =  repository.findById(id);
        if (item.isEmpty()) {
            System.out.println("Client delete NOT fined");
            return null;}
        if (item.get().getSize() >0 ) return null; //запрет на удаление
        repository.deleteById(id);
        Client z = item.get();
        z.setOrders( new HashSet<Order>());
        return z;
    }
}//class DbDaoClient
