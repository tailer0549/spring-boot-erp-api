package com.ermproject.ERP.controller;

import com.ermproject.ERP.DTO.produto.ProdutoDTO;
import com.ermproject.ERP.DTO.produto.ProdutoInsertDTO;
import com.ermproject.ERP.DTO.produto.ProdutoUpdateDTO;
import com.ermproject.ERP.entities.Produto;
import com.ermproject.ERP.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;


    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> findAll() {
        List<Produto> list = service.findAll();
        List<ProdutoDTO> listDTO = list.stream().map(ProdutoDTO::new).toList();
        return ResponseEntity.ok().body(listDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProdutoDTO> findById(@PathVariable Long id) {
        Produto p = service.findById(id);
        return ResponseEntity.ok().body(new ProdutoDTO(p));
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> insert(@RequestBody ProdutoInsertDTO dto) {
        Produto entity = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(entity.getId()).toUri();
        return ResponseEntity.created(uri).body(new ProdutoDTO(entity));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ProdutoDTO> update(@PathVariable Long id, @Valid @RequestBody ProdutoUpdateDTO dto) {
        Produto p = service.update(id, dto);
        return ResponseEntity.ok().body(new ProdutoDTO(p));
    }
}
