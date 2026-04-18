package com.ermproject.ERP.controller;

import com.ermproject.ERP.DTO.usuario.UsuarioDTO;
import com.ermproject.ERP.DTO.usuario.UsuarioInsertDTO;
import com.ermproject.ERP.DTO.usuario.UsuarioUpdateDTO;
import com.ermproject.ERP.entities.Usuario;
import com.ermproject.ERP.service.UsuarioService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService service;


    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> findAll() {
        List<Usuario> list = service.findAll();
        List<UsuarioDTO> listDTO = list.stream().map(UsuarioDTO::new).toList();
        return ResponseEntity.ok().body(listDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UsuarioDTO> findById(@PathVariable Long id) {
        Usuario us = service.findById(id);
        return ResponseEntity.ok().body(new UsuarioDTO(us));
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> insert(@Valid @RequestBody UsuarioInsertDTO dto) {
        Usuario entity = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(entity.getId()).toUri();
        return ResponseEntity.created(uri).body(new UsuarioDTO(entity));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build(); // Retorna 204
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UsuarioDTO> update(@PathVariable Long id, @Valid @RequestBody UsuarioUpdateDTO dto) {
        Usuario us = service.update(id, dto);
        return ResponseEntity.ok().body(new UsuarioDTO(us));
    }
}
