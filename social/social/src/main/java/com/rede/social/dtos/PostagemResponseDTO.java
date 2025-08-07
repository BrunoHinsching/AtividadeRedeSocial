package com.rede.social.dtos;

import com.rede.social.entity.Postagem;

import java.time.LocalDateTime;
import java.util.List;

public class PostagemResponseDTO {

    private String conteudo;
    private LocalDateTime dataCriacao;
    private UsuarioResponseDTO user;
    private List<ComentarioResponseDTO> comentario;
    private CurtidaResponseDTO curtida;

    public PostagemResponseDTO(Postagem postagem) {
        this.conteudo = postagem.getConteudo();
        this.dataCriacao = postagem.getDataCriacao();
        this.user = new UsuarioResponseDTO(postagem.getUser());
        this.comentario = new ComentarioResponseDTO(postagem.getComentarios());
        this.curtida = new CurtidaResponseDTO(postagem.getCurtidas());
    }

    public String getConteudo() {
        return conteudo;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public UsuarioResponseDTO getUser() {
        return user;
    }

    public List<ComentarioResponseDTO> getComentario() {
        return comentario;
    }

    public CurtidaResponseDTO getCurtida() {
        return curtida;
    }
}
