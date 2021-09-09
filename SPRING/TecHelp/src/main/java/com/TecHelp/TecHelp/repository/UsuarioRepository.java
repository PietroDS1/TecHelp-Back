package com.TecHelp.TecHelp.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.TecHelp.TecHelp.model.Usuario;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	//@Query(value = "SELECT * FROM db_techelp.tb_usuario WHERE email = :email", nativeQuery = true)
	//public Optional<Usuario> pegarPorEmail(@Param("email") String email);

	public Optional<Usuario> findByEmailIgnoreCase(String email);
}
