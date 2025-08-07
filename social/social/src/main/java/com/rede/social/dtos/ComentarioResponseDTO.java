package com.rede.social.dtos;

import com.rede.social.entity.Comentario;

public class ComentarioResponseDTO {

    private String texto;
    private UsuarioResponseDTO user;
    private PostagemResponseDTO postagem;

    public ComentarioResponseDTO(Comentario comentario) {
        this.texto = comentario.getTexto();
        this.user = new UsuarioResponseDTO(comentario.getUser());
        this.postagem = new PostagemResponseDTO(comentario.getPostagem());
    }

    public String getTexto() {
        return texto;
    }

    public UsuarioResponseDTO getUser() {
        return user;
    }

    public PostagemResponseDTO getPostagem() {
        return postagem;
    }
}
