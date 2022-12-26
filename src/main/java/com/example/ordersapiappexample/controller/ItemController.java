package com.example.ordersapiappexample.controller;

import com.example.ordersapiappexample.modal.dao.item.IDaoItem;
import com.example.ordersapiappexample.modal.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/item") //префикс
public class ItemController {

    @Autowired
    private IDaoItem daoItem;
    //получение всех объектов
    @GetMapping("/all")
    public List<Item> all(){
        return  daoItem.findAll();
    }

    @GetMapping("/get")
        public Optional<Item> findById(@RequestParam Integer id){
            return daoItem.findById(id);
        }

    @GetMapping("/save")
    public Item save(@RequestParam String itemName, @RequestParam Long itemArticle){
        Item item = new Item(itemName,itemArticle);
        return daoItem.save(item);
    }
    @PatchMapping("/update")
    public Item update(@RequestParam Integer id, @RequestParam(required = false) String itemName,
                       @RequestParam(required = false) Long itemArticle ){
        return  daoItem.update(new Item(id,itemName,itemArticle));
    }

    @GetMapping("/ping")
    public String ping(){
       return "item pong";
    }
}
