package com.ermproject.ERP.service;

import com.ermproject.ERP.DTO.estoque.EstoqueInsertDTO;
import com.ermproject.ERP.DTO.estoque.EstoqueUpdateDTO;
import com.ermproject.ERP.entities.Estoque;
import com.ermproject.ERP.entities.Produto;
import com.ermproject.ERP.repository.EstoqueRepository;
import com.ermproject.ERP.service.exceptions.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstoqueService {

    @Autowired
    private EstoqueRepository repository;

    @Autowired
    private ProdutoService produtoService;

    public Estoque findById(Long id) {
        Optional<Estoque> obj = repository.findById(id);
        return obj.orElseThrow(() -> new RuntimeException("Error"));
    }

    @Transactional
    public Estoque insert(EstoqueInsertDTO dto) {
        Estoque entity = fromInsertDTO(dto);
        return repository.save(entity);
    }

    @Transactional
    public Estoque update(Long id, EstoqueUpdateDTO dto) {
        Estoque entity = repository.getReferenceById(id);
        fromUpdateDTO(entity, dto);
        return repository.save(entity);
    }

    public List<Estoque> findAll() {
        List<Estoque> estoque = repository.findAll();
        return estoque;
    }

    @Transactional
    public void decrementarEstoque(Long produtoId, Integer quantity) {

        Estoque estoque = repository.findByProdutoId(produtoId).orElseThrow(() -> new ResourceNotFoundException(produtoId));

        if (estoque.getQuantity() < quantity) {
            throw new IllegalArgumentException("Estoque insuficiente");
        }

            estoque.setQuantity(estoque.getQuantity() - quantity);

        repository.save(estoque);
    }

    private Estoque fromInsertDTO(EstoqueInsertDTO dto) {
        Produto produto = produtoService.findById(dto.getProdutoId());
        return new Estoque(null, produto, dto.getQuantity());
    }

    private void fromUpdateDTO(Estoque entity, EstoqueUpdateDTO dto) {
        Estoque obj = entity;

        if (dto != null) {
            obj.setQuantity(dto.getQuantity());
        }
    }
}
