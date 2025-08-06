package com.rede.social.controller;

import com.rede.social.entity.Usuario;
import com.rede.social.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public Usuario cadastrarUsuario(@RequestBody Usuario usuario) {
        this.userRepository.save(usuario);
        return usuario;
    }

    @GetMapping
    public List<Usuario> listarUsuarios() {
        return this.userRepository.findAll();
    }

    @GetMapping("/{idUsuario}")
    public Usuario buscarUsuario(@PathVariable Integer idUsuario) {
        return this.userRepository.findById(idUsuario).get();
    }

    @PutMapping("/{idUsuario}")
    public Usuario alterarUsuario(@PathVariable Integer idUsuario, @RequestBody Usuario usuario) {
        Usuario alterar = this.userRepository.findById(idUsuario).get();

        alterar.setNome(usuario.getNome());
        alterar.setEmail(usuario.getEmail());

        this.userRepository.save(alterar);
        return alterar;
    }

    @DeleteMapping("/{idUsuario}")
    public Usuario deletarUsuario(@PathVariable Integer idUsuario) {
        Usuario usuario = this.userRepository.findById(idUsuario).get();

        this.userRepository.deleteById(idUsuario);
        return usuario;
    }
}
