package com.ermproject.ERP.service;

import com.ermproject.ERP.DTO.login.LoginDTO;
import com.ermproject.ERP.entities.Usuario;
import com.ermproject.ERP.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
     JWTService jwtService;

    public String login(LoginDTO dto) {

        Usuario usuario = usuarioRepository.findByEmail(dto.getEmail()).orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));

        if (!passwordEncoder.matches(dto.getPassword(), usuario.getPassword())) {
            throw new RuntimeException("Senha inválida");
        }

        return jwtService.generateToken(usuario.getEmail());
    }
}
