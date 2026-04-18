package com.ermproject.ERP.DTO.produto;

import com.ermproject.ERP.entities.Produto;

public class ProdutoDTO {

    private Long id;
    private String name;
    private String description;
    private Double price;

    public ProdutoDTO() {
    }

    public ProdutoDTO(Produto entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.price = entity.getPrice();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
