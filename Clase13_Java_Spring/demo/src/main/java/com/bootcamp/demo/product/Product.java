package com.bootcamp.demo.product;

public class Product {
    private Long id;
    private String name;
    private Double price;
    private Integer stock;

    // porque esto lo necesita Jackson (libreria) - JSON <-> Java Objects
    public Product(){
    }

    public Product(Long id, String name, Double price, Integer stock) {
        setId(id);
        setName(name);
        setPrice(price);
        setStock(stock);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
