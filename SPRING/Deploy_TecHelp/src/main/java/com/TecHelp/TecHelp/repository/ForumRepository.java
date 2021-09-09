package com.TecHelp.TecHelp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TecHelp.TecHelp.model.Forum;

public interface ForumRepository extends JpaRepository<Forum, Long> {
	
	public List<Forum> findAllByPublicacaoContainingIgnoreCase (String publicacao);
	
	public List<Forum> findAllByTituloContainingIgnoreCase (String titulo);
	
	public List<Forum> findAllByImagemContainingIgnoreCase (String imagem);

}
