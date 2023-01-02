package com.example.ordersapiappexample.controller;

import com.example.ordersapiappexample.modal.dao.client.IDaoClient;
import com.example.ordersapiappexample.modal.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/client") //префикс
public class ClientController {
    @Autowired
    private IDaoClient obj;

    //получение всех объектов
    @GetMapping("/all")
    public List<Client> all(){
        return  obj.findAll();
    }

    @GetMapping("/get")
    public Optional<Client> findById(@RequestParam(defaultValue = "2") Integer id){

        return obj.findById(id);
    }

    @PostMapping("/save")
    public Client save(@RequestParam String name){
        return obj.save(new Client(name));
    }

    @PostMapping("/update")
    public Client update(@RequestParam Integer id, @RequestParam(required = false) String name){
        return  obj.update(new Client(id,name));
    }

    @DeleteMapping("/del")
    public Client delete(@RequestParam Integer id){
        return obj.delete(id);
    }

    @GetMapping("/ping")
    public String ping(){
        return "Client" +
                " pong";
    }

}
