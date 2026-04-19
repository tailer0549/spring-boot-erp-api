package com.ermproject.ERP.controller;

import com.ermproject.ERP.DTO.estoque.EstoqueDTO;
import com.ermproject.ERP.DTO.estoque.EstoqueInsertDTO;
import com.ermproject.ERP.DTO.estoque.EstoqueUpdateDTO;
import com.ermproject.ERP.entities.Estoque;
import com.ermproject.ERP.service.EstoqueService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/estoque")
public class EstoqueController {

    @Autowired
    private EstoqueService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<EstoqueDTO> findById(@PathVariable Long id) {
        Estoque entity = service.findById(id);
        return ResponseEntity.ok().body(new EstoqueDTO(entity));
    }

    @PostMapping
    public ResponseEntity<EstoqueDTO> insert(@RequestBody EstoqueInsertDTO dto) {
        Estoque entity = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(entity.getId()).toUri();
        return ResponseEntity.created(uri).body(new EstoqueDTO(entity));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<EstoqueDTO> update(@PathVariable Long id, @Valid @RequestBody EstoqueUpdateDTO dto) {
        Estoque entity = service.update(id, dto);
        return ResponseEntity.ok().body(new EstoqueDTO(entity));
    }

    @GetMapping
    public ResponseEntity<List<EstoqueDTO>> findAll() {
        List<Estoque> estoque = service.findAll();
        List<EstoqueDTO> estoqueDTO = estoque.stream().map(EstoqueDTO::new).toList();
        return ResponseEntity.ok().body(estoqueDTO);
    }
}
