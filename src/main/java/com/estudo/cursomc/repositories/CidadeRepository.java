package com.estudo.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudo.cursomc.domain.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

}
