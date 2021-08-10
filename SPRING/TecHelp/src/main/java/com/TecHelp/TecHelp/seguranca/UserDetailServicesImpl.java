package com.TecHelp.TecHelp.seguranca;

import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.TecHelp.TecHelp.model.Usuario;
import com.TecHelp.TecHelp.repository.UsuarioRepository;

@Service
public class UserDetailServicesImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository userRepositoty;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> user = userRepositoty.findByEmail(username);
		user.orElseThrow(() -> new UsernameNotFoundException(username + " not found!"));
		return user.map(UserDetailsImpl::new).get();
	}
}
