package com.rede.social.controller;

import com.rede.social.entity.Postagem;
import com.rede.social.entity.Usuario;
import com.rede.social.repository.PostagemRepository;
import com.rede.social.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/postagens")
public class PostagemController {

    private final PostagemRepository postagemRepository;
    private final UserRepository userRepository;

    public PostagemController(PostagemRepository postagemRepository, UserRepository userRepository) {
        this.postagemRepository = postagemRepository;
        this.userRepository = userRepository;
    }

    @PostMapping("/{idUsuario}/postar")
    public Postagem criarPost(@PathVariable Integer idUsuario, @RequestBody Postagem postagem) {
        Usuario autor = this.userRepository.findById(idUsuario).get();

        postagem.setUser(autor);
        postagem.setDataCriacao(LocalDateTime.now());

        this.postagemRepository.save(postagem);
        return postagem;
    }

    @GetMapping
    public List<Postagem> listarPostagens() {
        return this.postagemRepository.findAll();
    }

    @GetMapping("/{idPostagem}")
    public Postagem buscarPostagem(@PathVariable Integer idPostagem) {
        return this.postagemRepository.findById(idPostagem).get();
    }

    @GetMapping("/usuarios/{idUsuario}/postagens")
    public List<Postagem> filtrarPostagens(@PathVariable Integer idUsuario) {
        return this.postagemRepository.findByAutorId(idUsuario);
    }
}
