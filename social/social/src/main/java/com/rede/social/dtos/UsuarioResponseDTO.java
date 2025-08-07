package com.rede.social.dtos;

import com.rede.social.entity.Usuario;

import java.time.LocalDate;

public class UsuarioResponseDTO {

    private String nome;
    private String email;
    private LocalDate dataCadastro;

    public UsuarioResponseDTO(Usuario user) {
        this.nome = user.getNome();
        this.email = user.getEmail();
        this.dataCadastro = user.getDataCadastro();
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }
}
