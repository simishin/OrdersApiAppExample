package com.example.ordersapiappexample.controller;
import com.example.ordersapiappexample.modal.dao.order.IdaoOrder;
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
    public Optional<Order> findById(@RequestParam(defaultValue = "2") Integer id){
        return obj.findById(id);
    }

    @PostMapping("/save")
    public Order save(@RequestParam(defaultValue = "Заказ ***") String descript,
                      @RequestParam(required = false) Integer idClient){
        return obj.save(new Order(descript), idClient);
    }
    @PostMapping("/update")
    public Order update(@RequestParam(defaultValue = "-1") Integer id,
                        @RequestParam(defaultValue = "") String descript,
                       @RequestParam(defaultValue = "-1") Integer idClient ){
        return  obj.update(new Order(id,descript),idClient);
    }

    @DeleteMapping("/del")
    public Order delete(@RequestParam(required = false) Integer id){
        return obj.delete(id);
    }

    @GetMapping("/ping")
    public String ping(){
        return "Order pong";
    }

}
