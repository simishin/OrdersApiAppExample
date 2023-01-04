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
        if (id<0) return null;
        return repository.findById(id);
    }
    public static boolean isPres(Integer id){
        return xxx.findById(id).isPresent();
    }

    @Override
    public Item save(Item item) {
        return repository.save(item);
    }

    @Override
    public Item update(Item elm) {
        if (repository.findById(elm.getId()).isPresent()){
           if (elm.getItemName().isBlank())
               elm.setItemName(repository.findById(elm.getId()).get().getItemName());
           if (elm.getItemArticle()==0)
               elm.setItemArticle(repository.findById(elm.getId()).get().getItemArticle());
           if (elm.getPrice()==0)
               elm.setPrice(repository.findById(elm.getId()).get().getPrice());
        }
        return repository.save(elm);
    }

    @Override
    public Item delete(Integer id) {
        Optional<Item> z = repository.findById(id);
        if (z.isEmpty()) return null;

        repository.deleteById(id);
        return z.get();
    }

}
