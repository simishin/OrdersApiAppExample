package com.example.ordersapiappexample.modal.dao.orderitem;

import com.example.ordersapiappexample.modal.dao.item.DbDaoItem;
import com.example.ordersapiappexample.modal.dao.order.DbDaoOrder;
import com.example.ordersapiappexample.modal.entity.Item;
import com.example.ordersapiappexample.modal.entity.Order;
import com.example.ordersapiappexample.modal.entity.OrderItems;
import com.example.ordersapiappexample.modal.repository.OrderItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DbDaoOrderItem implements IdaoOrderItem {
    @Autowired
    private OrderItemsRepository repository;

    @Override
    public List<OrderItems> findAll() {
        return (List<OrderItems>) repository.findAll();
    }

    @Override
    public Optional<OrderItems> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public OrderItems save(OrderItems orderItems, Integer orderId, Integer itemId) {
        Optional<Order> ax = DbDaoOrder.xxx.findById(orderId);
        Optional<Item> bx = DbDaoItem.xxx.findById(itemId);
        if (ax.isPresent() && bx.isPresent()){
            orderItems.setOrder(ax.get());
            orderItems.setItem(bx.get());
            return repository.save(orderItems);
        }
        return null;
    }

    @Override
    public OrderItems update(OrderItems elm, Integer orderId, Integer itemId) {
        if (orderId > -1)
            if (DbDaoOrder.xxx.findById(orderId).isPresent())
                elm.setOrder(DbDaoOrder.xxx.findById(orderId).get());
        if (itemId > -1)
            if (DbDaoItem.xxx.findById(itemId).isPresent())
                elm.setItem(DbDaoItem.xxx.findById(itemId).get());
        if (repository.findById(elm.getId()).isPresent()) //есть такой элемент
            if (elm.getQuantity() < 1 )
                elm.setQuantity(repository.findById(elm.getId()).get().getQuantity());
            else return null;
        System.out.println("************* OrderItems update "+elm+"\t"+orderId+"\t"+itemId);
        return repository.save(elm);
    }

    @Override // НЕ используется
    public OrderItems save(OrderItems item) {
        return repository.save(item);
    }

    @Override // НЕ используется
    public OrderItems update(OrderItems item) {
        if (! repository.findById(item.getId()).isPresent()){
            return null;
        }
        return repository.save(item);
    }

    @Override
    public OrderItems delete(Integer id) {
        Optional<OrderItems> item =  repository.findById(id);
        if (! item.isPresent()) return null;
        repository.deleteById(id);
        return item.get();
    }

}
