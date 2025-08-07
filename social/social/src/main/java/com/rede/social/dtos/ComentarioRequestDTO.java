package com.rede.social.dtos;

public class ComentarioRequestDTO {

    private String texto;
    private Integer idUser;
    private Integer idPostagem;

    public String getTexto() {
        return texto;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public Integer getIdPostagem() {
        return idPostagem;
    }
}
