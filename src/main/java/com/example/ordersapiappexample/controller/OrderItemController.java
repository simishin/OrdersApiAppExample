package com.example.ordersapiappexample.controller;

import com.example.ordersapiappexample.modal.dao.item.IDaoItem;
import com.example.ordersapiappexample.modal.dao.orderitem.IdaoOrderItem;
import com.example.ordersapiappexample.modal.entity.Item;
import com.example.ordersapiappexample.modal.entity.OrderItems;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/orderItems") //префикс
public class OrderItemController {

    private IdaoOrderItem obj;
    @GetMapping("/all")
    public List<OrderItems> all(){
        return  obj.findAll();
    }

    @GetMapping("/get")
    public Optional<OrderItems> findById(@RequestParam(defaultValue = "1") Integer id){
        return obj.findById(id);
    }

    @PostMapping("/save")
    public OrderItems save(@RequestParam Integer quantity){
        return obj.save(new OrderItems(-1,quantity,null,null));
    }
    @PostMapping("/update")
    public OrderItems update(@RequestParam Integer id, @RequestParam(required = false) Integer quantity){
        System.out.println("PostMapping(\"/update\")=>"+id);
        return  obj.update(new OrderItems(id,quantity,null, null));
    }

    @PostMapping("/del")
    public OrderItems delete(@RequestParam Integer id){
        return obj.delete(id);
    }

    @GetMapping("/ping")
    public String ping(){
        return "item pong";
    }

}
