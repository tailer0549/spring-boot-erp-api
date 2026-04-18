package com.ermproject.ERP.entities.PK;

import com.ermproject.ERP.entities.PedidoItem;
import com.ermproject.ERP.entities.Pedidos;
import com.ermproject.ERP.entities.Produto;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Objects;

@Embeddable
public class PedidoItemPK {


    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedidos pedido;

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Pedidos getPedido() {
        return pedido;
    }

    public void setPedido(Pedidos pedido) {
        this.pedido = pedido;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PedidoItemPK that = (PedidoItemPK) o;
        return Objects.equals(getProduto(), that.getProduto()) && Objects.equals(getPedido(), that.getPedido());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProduto(), getPedido());
    }
}
