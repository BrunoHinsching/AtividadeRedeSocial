package com.rede.social.repository;

import com.rede.social.entity.Curtida;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CurtidaRepository extends JpaRepository<Curtida, Integer> {
    List<Curtida> findByPostagemId(Integer postagemId);
}
