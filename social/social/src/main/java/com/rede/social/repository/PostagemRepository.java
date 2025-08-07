package com.rede.social.repository;

import com.rede.social.entity.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostagemRepository extends JpaRepository<Postagem, Integer> {
    List<Postagem> findByAutorId(Integer autorId);
}