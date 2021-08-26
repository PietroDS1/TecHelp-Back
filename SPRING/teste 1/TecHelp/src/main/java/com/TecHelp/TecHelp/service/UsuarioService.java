package com.TecHelp.TecHelp.service;

import java.nio.charset.Charset;
import org.apache.commons.codec.binary.Base64;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.TecHelp.TecHelp.model.UserLogin;
import com.TecHelp.TecHelp.model.Usuario;
import com.TecHelp.TecHelp.repository.UsuarioRepository;

@Service
public class UsuarioService{
	@Autowired
	private UsuarioRepository repositoty;

	public Usuario CadastrarUsuario(Usuario usuario) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		String senhaEncoder = encoder.encode(usuario.getSenha());
		usuario.setSenha(senhaEncoder);

		return repositoty.save(usuario);
	}

	public Optional<UserLogin> Logar(Optional<UserLogin> user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<Usuario> nomeCompleto = repositoty.findByUsuario(user.get().getUsuario());
		if (nomeCompleto.isPresent()) {
			if (encoder.matches(user.get().getSenha(), nomeCompleto.get().getSenha())) {
				String auth = user.get().getUsuario() + ":" + user.get().getSenha();
				byte[] encodeAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encodeAuth);
				user.get().setToken(authHeader);
				user.get().setNome(nomeCompleto.get().getNome());
				return user;
			}
		}
		return null;
	}
}
