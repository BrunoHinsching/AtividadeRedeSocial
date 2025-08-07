package com.rede.social.dtos;

import java.time.LocalDateTime;

public class PostagemRequestDTO {

    private String conteudo;
    private LocalDateTime dataCriacao;
    private Integer idUsuario;
    private Integer idComentario;
    private Integer idCurtida;

    public String getConteudo() {
        return conteudo;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public Integer getIdComentario() {
        return idComentario;
    }

    public Integer getIdCurtida() {
        return idCurtida;
    }
}
