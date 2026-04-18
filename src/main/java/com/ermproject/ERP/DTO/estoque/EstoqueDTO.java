package com.ermproject.ERP.DTO.estoque;

import com.ermproject.ERP.entities.Estoque;
import com.ermproject.ERP.entities.Produto;

public class EstoqueDTO {

    private Long id;
    private Long produtoId;
    private Integer quantity;

    public EstoqueDTO() {
    }

    public EstoqueDTO(Estoque entity) {
        this.id = entity.getId();
        this.produtoId = entity.getProduct().getId();
        this.quantity = entity.getQuantity();
    }

    public Long getProduto() {
        return produtoId;
    }

    public void setProduto(Long produto) {
        this.produtoId = produto;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
