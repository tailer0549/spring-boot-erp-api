package com.ermproject.ERP.DTO.pedidos;

import jakarta.validation.constraints.NotNull;

public class PedidoItemDTO {


    private Long produtoId;
    private Integer quantity;

    public PedidoItemDTO() {
    }

    public PedidoItemDTO(Long produtoId, Integer quantity) {
        this.produtoId = produtoId;
        this.quantity = quantity;
    }

    public Long getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
