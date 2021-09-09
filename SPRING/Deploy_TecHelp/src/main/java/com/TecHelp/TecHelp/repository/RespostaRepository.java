package com.TecHelp.TecHelp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TecHelp.TecHelp.model.Resposta;

public interface RespostaRepository extends JpaRepository<Resposta, Long> {
	
	public List<Resposta> findAllByComentarioContainingIgnoreCase(String comentario);
	
	public List<Resposta> findAllByImagemContainingIgnoreCase(String imagem);

}
