package com.example.ordersapiappexample.modal.dao.orderitem;

import com.example.ordersapiappexample.modal.dao.IdaoBase;
import com.example.ordersapiappexample.modal.entity.OrderItems;

public interface IdaoOrderItem extends IdaoBase<OrderItems> {
    OrderItems save(OrderItems orderItems, Integer orderId, Integer itemId);
    OrderItems update(OrderItems orderItems, Integer orderId, Integer itemId);
}

