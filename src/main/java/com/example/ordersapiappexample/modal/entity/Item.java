package com.example.ordersapiappexample.modal.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "item_t")
public class Item {//продукт
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String itemName;
    @Column
    private Long    itemArticle;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    private Set<OrderItems> orderItem;

    public Item() {
        this.id = -1;
        this.itemName ="undefine";
        itemArticle =-1L;
    }

    public Item(Integer id, String itemName, Long itemArticle) {
        this.id = id; //первичный ключ
        this.itemName = itemName;
        this.itemArticle = itemArticle;
    }
    public Item(String itemName, Long itemArticle) {
        this.id = -1; //первичный ключ
        this.itemName = itemName;
        this.itemArticle = itemArticle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Long getItemArticle() {
        return itemArticle;
    }

    public void setItemArticle(Long itemArticle) {
        this.itemArticle = itemArticle;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", itemArticle=" + itemArticle +
                '}';
    }

    public Set<OrderItems> getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(Set<OrderItems> orderItem) {
        this.orderItem = orderItem;
    }
}
