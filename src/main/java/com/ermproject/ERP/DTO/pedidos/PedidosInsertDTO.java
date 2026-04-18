package com.ermproject.ERP.DTO.pedidos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class PedidosInsertDTO {

    @NotNull(message = "Usuário é obrigatório")
    private Long usuarioId;

    @NotEmpty(message = "Pedido deve ter pelo menos 1 item")
    private List<PedidoItemDTO> items;

    public PedidosInsertDTO() {
    }

    public PedidosInsertDTO(Long usuarioId, List<PedidoItemDTO> items) {
        this.usuarioId = usuarioId;
        this.items = items;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public List<PedidoItemDTO> getItems() {
        return items;
    }

    public void setItems(List<PedidoItemDTO> items) {
        this.items = items;
    }
}
