package com.example.ordersapiappexample.modal.dao.item;

import com.example.ordersapiappexample.modal.entity.Item;

import java.util.List;
import java.util.Optional;

//

public interface IDaoItem {
  public List<Item> findAll();
  Optional<Item> findById(Integer id) ;
  Item save(Item item);
  Item update(Item item);
  Item delete(Integer id);
}
