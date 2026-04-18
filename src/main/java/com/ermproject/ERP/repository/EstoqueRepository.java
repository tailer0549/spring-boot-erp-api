package com.ermproject.ERP.repository;

import com.ermproject.ERP.entities.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {
}
