package com.ermproject.ERP.DTO.estoque;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class EstoqueInsertDTO {

    @NotNull(message = "Produto é obrigatório")
    private Long produtoId;

    @NotNull(message = "Quandidade é obrigatória")
    @Positive(message = "Quandidade precisa ser positiva")
    private Integer quantity;

    public EstoqueInsertDTO() {
    }

    public EstoqueInsertDTO(Long produtoId, Integer quantity) {
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
