package com.ermproject.ERP.DTO.pedidos;

import jakarta.validation.constraints.NotNull;

import java.time.Instant;

public class PedidosUpdateDTO {

    @NotNull(message = "Instant inválido")
    private Instant instant;

    @NotNull(message = "Status inválido")
    private Integer status;

    @NotNull(message = "Usuário inválido")
    private Long usuarioId;

    public PedidosUpdateDTO() {
    }

    public PedidosUpdateDTO(Instant instant, Integer status, Long usuarioId) {
        this.instant = instant;
        this.status = status;
        this.usuarioId = usuarioId;
    }

    public Instant getInstant() {
        return instant;
    }

    public void setInstant(Instant instant) {
        this.instant = instant;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}
