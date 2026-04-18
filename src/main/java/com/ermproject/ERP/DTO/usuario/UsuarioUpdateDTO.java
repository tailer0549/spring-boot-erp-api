package com.ermproject.ERP.DTO.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UsuarioUpdateDTO {

    @NotBlank(message = "Nome é obrigatório")
    private String name;

    @Email(message = "Email inválido")
    private String email;

    public UsuarioUpdateDTO() {
    }

    public UsuarioUpdateDTO(String name, String email) {
        this.name = name;
        this.email = email;
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
