package com.ermproject.ERP.repository;

import com.ermproject.ERP.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
