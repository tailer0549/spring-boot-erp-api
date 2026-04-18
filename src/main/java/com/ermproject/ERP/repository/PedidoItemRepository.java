package com.ermproject.ERP.repository;

import com.ermproject.ERP.entities.PedidoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoItemRepository extends JpaRepository<PedidoItem, Long> {
}
