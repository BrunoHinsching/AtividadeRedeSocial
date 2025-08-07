package com.rede.social.dtos;

import com.rede.social.entity.Curtida;

public class CurtidaResponseDTO {

    private UsuarioResponseDTO user;

    public CurtidaResponseDTO(Curtida curtida) {
        this.user = new UsuarioResponseDTO(curtida.getUser());
    }
}
