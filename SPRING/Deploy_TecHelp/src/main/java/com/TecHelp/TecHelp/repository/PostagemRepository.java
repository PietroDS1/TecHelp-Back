package com.TecHelp.TecHelp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TecHelp.TecHelp.model.Postagem;

public interface PostagemRepository extends JpaRepository<Postagem, Long>{

public List<Postagem> findAllByCursoContainingIgnoreCase(String curso);
	
public List<Postagem> findAllByNivelContainingIgnoreCase(String nivel);
}
