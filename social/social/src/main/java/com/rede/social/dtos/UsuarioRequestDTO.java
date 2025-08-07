package com.rede.social.dtos;

import java.time.LocalDate;

public class UsuarioRequestDTO {

    private String nome;
    private String email;
    private LocalDate dataCadastro;

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
