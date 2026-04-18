package com.ermproject.ERP.controller;

import com.ermproject.ERP.DTO.login.LoginDTO;
import com.ermproject.ERP.DTO.usuario.UsuarioDTO;
import com.ermproject.ERP.DTO.usuario.UsuarioInsertDTO;
import com.ermproject.ERP.service.JWTService;
import com.ermproject.ERP.service.LoginService;
import com.ermproject.ERP.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    LoginService service;

    @PostMapping(value = "/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO dto) {
        // Validando no banco
            String token = service.login(dto);
            return ResponseEntity.ok(token);
    }

    @PostMapping(value = "/{register}")
    public ResponseEntity<Void> register(@RequestBody UsuarioInsertDTO dto) {
        usuarioService.insert(dto);
        return ResponseEntity.ok().build();
    }
}

