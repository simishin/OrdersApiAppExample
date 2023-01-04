package com.example.ordersapiappexample.modal.dao.order;

import com.example.ordersapiappexample.modal.dao.IdaoBase;
import com.example.ordersapiappexample.modal.entity.Order;

public interface IdaoOrder extends IdaoBase<Order> {
    Order save(Order item, Integer idClient);
    Order update(Order item, Integer idClient);
}

