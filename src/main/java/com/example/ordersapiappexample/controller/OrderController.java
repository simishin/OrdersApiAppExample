package com.example.ordersapiappexample.controller;

import com.example.ordersapiappexample.modal.dao.item.IDaoItem;
import com.example.ordersapiappexample.modal.dao.order.IdaoOrder;
import com.example.ordersapiappexample.modal.entity.Item;
import com.example.ordersapiappexample.modal.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/order") //префикс
public class OrderController {
    @Autowired
    private IdaoOrder obj;
    @GetMapping("/all")
    public List<Order> all(){
        return  obj.findAll();
    }

    @GetMapping("/get")
    public Optional<Order> findById(@RequestParam Integer id){
        return obj.findById(id);
    }

    @PostMapping("/save")
    public Order save(@RequestParam String descript){
        return obj.save(new Order(descript));
    }
    @PostMapping("/update")
    public Order update(@RequestParam Integer id, @RequestParam(required = false) String descript,
                       @RequestParam(required = false) Long itemArticle ){
        System.out.println("PostMapping(\"/update\")=>"+id);
        return  obj.update(new Order(id,descript));
    }

    @DeleteMapping("/del")
    public Order delete(@RequestParam Integer id){
        return obj.delete(id);
    }

    @GetMapping("/ping")
    public String ping(){
        return "item pong";
    }

}
