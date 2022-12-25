package com.example.ordersapiappexample.controller;

import com.example.ordersapiappexample.modal.dao.item.IDaoItem;
import com.example.ordersapiappexample.modal.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping("/ping")
    public String ping(){
       return "item pong";
    }
}
