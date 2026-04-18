package com.ermproject.ERP.entities;

import com.ermproject.ERP.entities.PK.PedidoItemPK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_pedido_item")
public class PedidoItem {

    @EmbeddedId
    private PedidoItemPK id = new PedidoItemPK();
    private Integer quantity;
    private Double price;

    public PedidoItem() {
    }

    public PedidoItem(Pedidos pedido, Produto produto, Integer quantity, Double price) {
        id.setPedido(pedido);
        id.setProduto(produto);
        this.quantity = quantity;
        this.price = price;
    }

    public Produto getProduto() {
        return id.getProduto();
    }

    public void setProduto(Produto p) {
        id.setProduto(p);
    }

    public Pedidos getPedido() {
        return id.getPedido();
    }

    public void setPedido(Pedidos a) {
        id.setPedido(a);
    }

    public PedidoItemPK getId() {
        return id;
    }

    public void setId(PedidoItemPK id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getSubTotal() {
        Double subTotal = quantity * price;
        return subTotal;
    }
}
