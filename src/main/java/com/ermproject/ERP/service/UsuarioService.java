package com.ermproject.ERP.service;

import com.ermproject.ERP.DTO.usuario.UsuarioInsertDTO;
import com.ermproject.ERP.DTO.usuario.UsuarioUpdateDTO;
import com.ermproject.ERP.entities.Usuario;
import com.ermproject.ERP.repository.UsuarioRepository;
import com.ermproject.ERP.service.exceptions.DatabaseException;
import com.ermproject.ERP.service.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    public List<Usuario> findAll() {
        List<Usuario> lista = repository.findAll();
        return lista;
    }

    public Usuario findById(Long id) {
        Optional<Usuario> us = repository.findById(id);
        return us.orElseThrow(() -> new ResourceNotFoundException(id));

    }

    @Transactional
    public Usuario insert(UsuarioInsertDTO dto) {
        Usuario user = fromInsertDTO(dto);
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        return repository.save(user);
    }

    @Transactional
    public void delete(Long id) {
        try {
        repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    @Transactional
    public Usuario update(Long id, UsuarioUpdateDTO usuario) {
        try {
        Usuario us = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        updateData(us, usuario);
        return repository.save(us);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Usuario entity, UsuarioUpdateDTO dto) {
        if (entity != null) {
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail()); }
    }

    // Transforma DTO em usuário
    private Usuario fromInsertDTO(UsuarioInsertDTO dto) {
        return new Usuario(null, dto.getName(), dto.getEmail(), dto.getPhone(), dto.getPassword());
    }

    // Desuso
    private void fromUpdateDTO(Usuario us, UsuarioUpdateDTO dto) {
        // Acho que esses ifs são redundantes, UsuarioUpdateDTO já tem valid no controller
        if (dto.getName() != null) {
            us.setName(dto.getName());
        }

        if (dto.getEmail() != null) {
            us.setEmail(dto.getEmail());
        }
    }

}
