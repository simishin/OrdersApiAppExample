package com.example.ordersapiappexample.modal.entity;

public class Item {//продукт
    private Integer id;
    private String itemName;
    private Long    itemArticle;

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
}
