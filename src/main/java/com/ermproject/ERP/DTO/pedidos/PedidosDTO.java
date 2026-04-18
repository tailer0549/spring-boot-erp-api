package com.ermproject.ERP.DTO.pedidos;
import com.ermproject.ERP.entities.Pedidos;
import java.util.Set;
import java.util.stream.Collectors;

public class PedidosDTO {


    private Long id;
        private Long usuarioId;
        private Set<PedidoItemDTO> itens;
        private Double total;
        private Integer status;

        public PedidosDTO() {
        }

    public PedidosDTO(Pedidos entity) {
        this.id = entity.getId();
        this.usuarioId = entity.getUsuario().getId();

        this.itens = entity.getItems()
                .stream()
                .map(item -> new PedidoItemDTO(
                        item.getId().getProduto().getId(),
                        item.getQuantity()
                ))
                .collect(Collectors.toSet());

        this.total = entity.getTotal();
        this.status = entity.getStatus();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Set<PedidoItemDTO> getItens() {
        return itens;
    }

    public void setItens(Set<PedidoItemDTO> itens) {
        this.itens = itens;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}




