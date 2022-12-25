package com.example.ordersapiappexample.modal.dao.item;

import com.example.ordersapiappexample.modal.entity.Item;

import java.util.List;

//

public interface IDaoItem {
  public List<Item> findAll();
  Item findById(Integer id) throws Exception;
  Item save(Item item);
  Item update(Item item);
  Item delete(Integer id);
}
