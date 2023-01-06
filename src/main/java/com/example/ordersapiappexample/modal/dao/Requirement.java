package com.example.ordersapiappexample.modal.dao;

import com.example.ordersapiappexample.modal.dao.client.DbDaoClient;
import com.example.ordersapiappexample.modal.dao.order.DbDaoOrder;
import com.example.ordersapiappexample.modal.dao.orderitem.DbDaoOrderItem;
import com.example.ordersapiappexample.modal.entity.Order;
import com.example.ordersapiappexample.modal.entity.OrderItems;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class Requirement {//Требования
    public static String receipt(Integer id){
        ObjectMapper objectMapper = new ObjectMapper();
        String json = null;
        if (id < 0){//Вывод списка заказов {имя-номер}
            record OrdeM(int id, String descript){}
            List<OrdeM> y = new ArrayList<>();
            for (Order x: DbDaoOrder.xxx.findAll() )
                y.add(new OrdeM(x.getId(), x.getDescript()));
            try {
                json = objectMapper.writeValueAsString(y);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
            return json;
        }
        if ( DbDaoOrder.isEmpt(id)) { //НЕТ такого
            return "НЕТ такого заказа "+id;
        }
        record Ware(String itemName, Long itemArticle, Integer quantity, Float price, Float total){}

        float amount=0F;
        float locsum;
        List<Ware> elm = new ArrayList<>();
        for (OrderItems x: DbDaoOrderItem.xxx.findAll() ){
            if (x.getOrder().getId() != id) continue;
            locsum = x.getItem().getPrice() * x.getQuantity();
            amount += locsum;
            elm.add(new Ware(x.getItem().getItemName(), x.getItem().getItemArticle(),
                    x.getQuantity(), x.getItem().getPrice(), locsum ));
        }
        record Check(List<Ware> elm, Float amount){}
        try {
            json = objectMapper.writeValueAsString(new Check(elm,amount));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return json;
    }

    public static String delOrder(Integer id){

        if ( DbDaoOrder.isEmpt(id)) { //НЕТ такого
            return "НЕТ такого заказа "+id;
        }
        System.out.println("************** delOrder "+ id);
        Order elm = DbDaoOrder.xxx.findById(id).get();

//        int[] ordIt =  elm.getOrderItem();
//        DbDaoOrderItem.xxx.deleteAllById(elm.orderItem());

//        for (OrderItems x : elm.orderItem()){
//            System.out.println(" ***** "+x.getId());
//            DbDaoOrderItem.xxx.delete(x);
//        }

        for (int i : elm.getOrderItem() ) {
            System.out.println(" ***** "+i);
//            elm.orderItem().toArray().
//
            DbDaoOrderItem.deleteQ(i); }
//        if (elm.getSize() != 0 ) return "Не все удалилось в Расшивке";
//        int cientId = elm.getClient().getId();
        //проверяю сколько заказов на клиенте
//        if( elm.getClient().getSize() == 1 )
//            DbDaoClient.xxx.deleteById(elm.getClient().getId());
//        DbDaoOrder.xxx.deleteById(id);
        return "Цепочка удалена";
    }
}//class Requirement
