package com.ermproject.ERP.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_estoque")
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer quantity;


    @OneToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    public Estoque() {
    }

    public Estoque(Long estoqueId, Produto produto, Integer quantity) {
        this.id = estoqueId;
        this.produto = produto;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Produto getProduct() {
        return produto;
    }

    public void setProduct(Produto produto) {
        this.produto = produto;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Estoque estoque = (Estoque) o;
        return Objects.equals(getId(), estoque.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
