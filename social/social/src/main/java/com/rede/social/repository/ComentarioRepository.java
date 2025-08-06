package com.rede.social.repository;

import com.rede.social.entity.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComentarioRepository extends JpaRepository<Comentario, Integer> {
    List<Comentario> findByPostagemId(Integer postagemId);
}
