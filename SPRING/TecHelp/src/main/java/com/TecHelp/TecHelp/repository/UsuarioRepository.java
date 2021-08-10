package com.TecHelp.TecHelp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.TecHelp.TecHelp.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	@Query(value = "SELECT * FROM db_techelp.tb_usuario WHERE email = :email", nativeQuery = true)
	public Optional<Usuario> pegarPorEmail(@Param("email") String email);

}
