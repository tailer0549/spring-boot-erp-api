package com.ermproject.ERP.DTO.estoque;

import com.ermproject.ERP.entities.Produto;
import jakarta.validation.constraints.NotNull;

public class EstoqueUpdateDTO {

    @NotNull(message = "Produto é obrigatório")
    private Produto produto;

    @NotNull(message = "Quantidade é obrigatório")
    private Integer quantity;

    public EstoqueUpdateDTO() {
    }

    public EstoqueUpdateDTO(Produto produto, Integer quantity) {
        this.produto = produto;
        this.quantity = quantity;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
