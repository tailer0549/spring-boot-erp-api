package com.ermproject.ERP.DTO.usuario;

import com.ermproject.ERP.entities.Usuario;

public class UsuarioDTO {
    // DTO de resposta

    private Long id;
    private String name;
    private String email;
    private String password;


    public UsuarioDTO() {
    }

    // Recebe as informações do usuário
    public UsuarioDTO(Usuario entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.email = entity.getEmail();
        this.password = entity.getPassword();
    }

    public String getPassword() {
        return password;
    }

    public void setPasswor(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
