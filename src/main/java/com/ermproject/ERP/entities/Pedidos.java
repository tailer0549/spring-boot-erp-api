package com.ermproject.ERP.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_pedidos")
public class Pedidos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant moment;
    private Integer status;



    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToMany(mappedBy = "id.pedido")
    private Set<PedidoItem> items = new HashSet<>();

    @OneToOne(mappedBy = "pedido")
    private Pagamento pagamento;

    public Set<PedidoItem> getItems() {
        return items;
    }

    public Pedidos() {
    }

    public Pedidos(Long id, Instant moment, Integer status, Usuario cliente) {
        this.id = id;
        this.moment = moment;
        this.status = status;
        this.usuario = cliente;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Double getTotal() {
        Double total = 0.0;

        for (PedidoItem p : items) {
            total += p.getSubTotal();
        }

        return total;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pedidos pedidos = (Pedidos) o;
        return Objects.equals(getId(), pedidos.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
