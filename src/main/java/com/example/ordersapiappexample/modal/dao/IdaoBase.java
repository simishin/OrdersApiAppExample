package com.example.ordersapiappexample.modal.dao;

import com.example.ordersapiappexample.modal.entity.Item;

import java.util.List;
import java.util.Optional;

public interface IdaoBase<E> {
    public List<E> findAll();
    Optional<E> findById(Integer id) ;
    E save(E item);
    E update(E item);
    E delete(Integer id);
}
