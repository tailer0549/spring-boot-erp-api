package com.ermproject.ERP.service;

import com.ermproject.ERP.DTO.pedidos.PedidosInsertDTO;
import com.ermproject.ERP.DTO.pedidos.PedidosUpdateDTO;
import com.ermproject.ERP.entities.Pedidos;
import com.ermproject.ERP.entities.Usuario;
import com.ermproject.ERP.repository.PedidosRepository;
import com.ermproject.ERP.repository.UsuarioRepository;
import com.ermproject.ERP.service.exceptions.DatabaseException;
import com.ermproject.ERP.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class PedidosService {

    @Autowired
    private PedidosRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;


    public List<Pedidos> findAll() {
        List<Pedidos> list = repository.findAll();
        return list;
    }

    public Pedidos findById(Long id) {
        Optional<Pedidos> pedido = repository.findById(id);
        return pedido.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Pedidos insert(PedidosInsertDTO dto) {
        Pedidos p = fromInsertDTO(dto);
        return repository.save(p);
    }

    public Pedidos update(Long id, PedidosUpdateDTO dto) {
        Pedidos entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));

        if (entity.getStatus() == 1 || entity.getStatus() == 2) {
        fromUpdateDTO(entity, dto);
        return repository.save(entity); }
        throw new IllegalStateException("Pedido não pode ser alterado.");
    }

    public void delete (Long id) {

        try {
        repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private Pedidos fromInsertDTO(PedidosInsertDTO dto) {

        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Pedidos pedido = new Pedidos();
        pedido.setUsuario(usuario);
        pedido.setMoment(Instant.now());
        pedido.setStatus(1);
        return pedido;
    }

    private void fromUpdateDTO(Pedidos p, PedidosUpdateDTO dto) {
        if (p != null && dto != null) {
        Pedidos entity = p;
        entity.setStatus(dto.getStatus());
        entity.setMoment(dto.getInstant());
        entity.getUsuario().setId(dto.getUsuarioId());
        }
    }


}
