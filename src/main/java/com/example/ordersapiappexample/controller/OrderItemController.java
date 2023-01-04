package com.example.ordersapiappexample.controller;

import com.example.ordersapiappexample.modal.dao.orderitem.IdaoOrderItem;
import com.example.ordersapiappexample.modal.entity.OrderItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/orderItems") //префикс
public class OrderItemController {
    @Autowired
    private IdaoOrderItem obj;
    @GetMapping("/all")
    public List<OrderItems> all(){
//        System.out.println("List<OrderItems> all()");
//        if (obj.findAll()==null) return null;
        return  obj.findAll();
    }

    @GetMapping("/get")
    public Optional<OrderItems> findById(@RequestParam(defaultValue = "1") Integer id){
        return obj.findById(id);
    }

    @PostMapping("/save")
    public OrderItems save(@RequestParam(defaultValue = "1") Integer quantity,
                           @RequestParam(required = false) Integer itemId,
                           @RequestParam(required = false) Integer orderId){
        return obj.update(new OrderItems(-1,quantity,null,null),orderId, itemId);
//        return obj.save(new OrderItems(-1,quantity,null,null),orderId, itemId);
    }
    @PostMapping("/update")
    public OrderItems update(@RequestParam(defaultValue = "-1") Integer id,
                             @RequestParam(defaultValue = "0") Integer quantity,
                             @RequestParam(defaultValue = "-1") Integer itemId,
                             @RequestParam(defaultValue = "-1") Integer orderId){
        System.out.println("PostMapping(\"/update\")=>"+id);
        return  obj.update(new OrderItems(id,quantity,null, null),orderId, itemId);
    }

    @PostMapping("/del")
    public OrderItems delete(@RequestParam(required = false) Integer id){
        return obj.delete(id);
    }

    @GetMapping("/ping")
    public String ping(){
        return "OrderItems pong";
    }

}
