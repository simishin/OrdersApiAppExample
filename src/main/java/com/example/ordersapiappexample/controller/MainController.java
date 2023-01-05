package com.example.ordersapiappexample.controller;

import com.example.ordersapiappexample.modal.dao.Requirement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class MainController {
    @GetMapping("/ping")
    public String toString(){
        return  "pong";
    }
    @GetMapping("/receipt/{id:\\d+}")
    public String receipt(@PathVariable Integer id){
        return Requirement.receipt(id);}

    @GetMapping("/receipt")
    public String receiptq(@RequestParam(defaultValue = "-1") Integer id){
        return Requirement.receipt(id);}
}
