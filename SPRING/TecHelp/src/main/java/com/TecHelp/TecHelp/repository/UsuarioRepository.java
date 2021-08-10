package com.TecHelp.TecHelp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TecHelp.TecHelp.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	public Optional<Usuario> findByEmail(String email);

}
