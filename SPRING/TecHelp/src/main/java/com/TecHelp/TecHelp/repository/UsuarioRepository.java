package com.TecHelp.TecHelp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TecHelp.TecHelp.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
