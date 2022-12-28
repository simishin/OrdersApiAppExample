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
    private IDaoItem obj;
    //получение всех объектов
    @GetMapping("/all")
    public List<Item> all(){
        return  obj.findAll();
    }

    @GetMapping("/get")
        public Optional<Item> findById(@RequestParam(defaultValue = "2") Integer id){
            return obj.findById(id);
        }

    @PostMapping ("/save")
    public Item save(@RequestParam String itemName, @RequestParam Long itemArticle){
        Item item = new Item(itemName,itemArticle);
        return obj.save(item);
    }
    @PostMapping("/update")
    public Item update(@RequestParam Integer id, @RequestParam(required = false) String itemName,
                       @RequestParam(required = false) Long itemArticle ){
        System.out.println("PostMapping(\"/update\")=>"+id);
        return  obj.update(new Item(id,itemName,itemArticle));
    }

    @PostMapping("/del")
    public Item delete(@RequestParam Integer id){
        return obj.delete(id);
    }

    @GetMapping("/ping")
    public String ping(){
       return "item pong";
    }
}
