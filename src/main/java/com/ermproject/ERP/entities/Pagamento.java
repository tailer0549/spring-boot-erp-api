package com.ermproject.ERP.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_pagamento")
public class Pagamento {
    // Id é a mesma do pedido

    @Id
    private Long id;
    private Instant moment;

    @JsonIgnore
    @OneToOne
    @MapsId
    @JoinColumn(name = "pedido_id")
    private Pedidos pedido;

    public Pagamento() {
    }

    public Pagamento(Long id, Instant moment) {
        this.id = id;
        this.moment = moment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pagamento pagamento = (Pagamento) o;
        return Objects.equals(getId(), pagamento.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
