package com.rede.social.controller;

import com.rede.social.entity.Comentario;
import com.rede.social.entity.Postagem;
import com.rede.social.repository.ComentarioRepository;
import com.rede.social.repository.PostagemRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {

    private final ComentarioRepository comentarioRepository;
    private final PostagemRepository postagemRepository;

    public ComentarioController(ComentarioRepository comentarioRepository, PostagemRepository postagemRepository) {
        this.comentarioRepository = comentarioRepository;
        this.postagemRepository = postagemRepository;
    }

    @PostMapping("/{idPostagem}/comentar")
    public Comentario comentar(@PathVariable Integer idPostagem, @RequestBody Comentario comentario) {
        Postagem postagem = this.postagemRepository.findById(idPostagem).get();
        List<Comentario> comentarios = postagem.getComentarios();

        comentario.setDataCriacao(LocalDateTime.now());

        comentarios.add(comentario);

        postagem.setComentarios(comentarios);
        return comentario;
    }

    @GetMapping("/postagens/{idPostagem}/comentarios")
    public List<Comentario> buscarComentarios(@PathVariable Integer idPostagem) {
        return this.comentarioRepository.findByPostagemId(idPostagem);
    }
}
