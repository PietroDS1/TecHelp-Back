package com.TecHelp.TecHelp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TecHelp.TecHelp.model.Tema;

public interface TemaRepository extends JpaRepository<Tema, Long> {

	public List<Tema> findAllByTipoContainingIgnoreCase(String tipo);

}
