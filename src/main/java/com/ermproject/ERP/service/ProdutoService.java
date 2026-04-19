package com.ermproject.ERP.service;

import com.ermproject.ERP.DTO.produto.ProdutoInsertDTO;
import com.ermproject.ERP.DTO.produto.ProdutoUpdateDTO;
import com.ermproject.ERP.entities.Produto;
import com.ermproject.ERP.repository.ProdutoRepository;
import com.ermproject.ERP.service.exceptions.DatabaseException;
import com.ermproject.ERP.service.exceptions.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;


    public List<Produto> findAll() {
        List<Produto> list = repository.findAll();
        return list;
    }

    public Produto findById(Long id) {
        Optional<Produto> p = repository.findById(id);
        return p.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Transactional
    public Produto insert(ProdutoInsertDTO dto) {
        Produto p = fromInsertDTO(dto);
        return repository.save(p);
    }

    @Transactional
    public void delete(Long id) {
        try {
        repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    @Transactional
    public Produto update(Long id, ProdutoUpdateDTO dto) {
        try {
        Produto entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        fromUpdateDTO(entity, dto);
        return repository.save(entity);
        } catch (ObjectNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private Produto fromInsertDTO(ProdutoInsertDTO dto) {
        return new Produto(null, dto.getName(),dto.getDescription(),dto.getPreco());
    }

    private void fromUpdateDTO(Produto entity, ProdutoUpdateDTO dto) {
        if (dto.getName() != null) {
            entity.setName(dto.getName());
        }

        if (dto.getDescription() != null) {
            entity.setDescription(dto.getDescription());
        }

        if (dto.getPrice() >= 0) {
            entity.setPrice(dto.getPrice());
        }
    }
}
