package com.ermproject.ERP.DTO.produto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class ProdutoInsertDTO {

    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    private String name;

    @NotBlank(message = "Descrição é obrigatória")
    private String description;

    @NotNull(message = "Preço é obrigatório")
    @Positive(message = "Preço precisa ser positivo")
    private Double preco;

    public ProdutoInsertDTO() {
    }

    public ProdutoInsertDTO(Long id, String name, String description, Double preco) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.preco = preco;
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

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
