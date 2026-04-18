package com.ermproject.ERP.controller;

import com.ermproject.ERP.DTO.pedidos.PedidosDTO;
import com.ermproject.ERP.DTO.pedidos.PedidosInsertDTO;
import com.ermproject.ERP.DTO.pedidos.PedidosUpdateDTO;
import com.ermproject.ERP.entities.Pedidos;
import com.ermproject.ERP.service.PedidosService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidosController {

    @Autowired
    private PedidosService service;

    @GetMapping
    public ResponseEntity<List<PedidosDTO>> findAll() {
        List<Pedidos> list = service.findAll();
        List<PedidosDTO> listDTO = list.stream().map(PedidosDTO::new).toList();
        return ResponseEntity.ok().body(listDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PedidosDTO> findById(@PathVariable Long id) {
        Pedidos entity = service.findById(id);
        return ResponseEntity.ok().body(new PedidosDTO(entity));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PedidosDTO> update(@PathVariable Long id, @Valid @RequestBody PedidosUpdateDTO dto) {
        Pedidos entity = service.update(id, dto);
        return ResponseEntity.ok().body(new PedidosDTO(entity));
    }

    @PostMapping
    public ResponseEntity<PedidosDTO> insert(@Valid @RequestBody PedidosInsertDTO dto) {
        Pedidos entity  = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(entity.getId()).toUri();
        return ResponseEntity.created(uri).body(new PedidosDTO(entity));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
