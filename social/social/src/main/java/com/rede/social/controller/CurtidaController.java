package com.rede.social.controller;

import com.rede.social.entity.Curtida;
import com.rede.social.entity.Postagem;
import com.rede.social.entity.Usuario;
import com.rede.social.repository.CurtidaRepository;
import com.rede.social.repository.PostagemRepository;
import com.rede.social.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curtidas")
public class CurtidaController {

    private final CurtidaRepository curtidaRepository;
    private final PostagemRepository postagemRepository;
    private final UserRepository userRepository;

    public CurtidaController(CurtidaRepository curtidaRepository, PostagemRepository postagemRepository, UserRepository userRepository) {
        this.curtidaRepository = curtidaRepository;
        this.postagemRepository = postagemRepository;
        this.userRepository = userRepository;
    }

    @PostMapping("/usuario/{idUsuario}/curtir/postagens/{idPostagem}")
    public Curtida curtirPostagem(@PathVariable Integer idUsuario, @PathVariable Integer idPostagem) {
        Curtida curtida = new Curtida();

        Usuario usuario = this.userRepository.findById(idUsuario).get();
        Postagem postagem = this.postagemRepository.findById(idPostagem).get();

        curtida.setUser(usuario);
        curtida.setPostagem(postagem);

        this.curtidaRepository.save(curtida);
        return curtida;
    }

    @GetMapping("/postagens/{idPostagem}/curtidas")
    public List<Curtida> verCurtidas(@PathVariable Integer idPostagem) {
        return this.curtidaRepository.findByPostagemId(idPostagem);
    }
}
