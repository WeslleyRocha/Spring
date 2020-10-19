package org.generation.blogPessoal.seguranca;
import java.util.Optional;

import org.generation.blogPessoal.model.Usuario;
import org.generation.blogPessoal.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service

public class UserDetailsServiceImpl implements UserDetailsService  {

	@Autowired
	private UsuarioRepository userRepository;
	
	@Override
	public UserDetails  loadUserByUsername(String userName)
	
	{
		Optional<Usuario> user = userRepository.findByUsuario(userName);
		user.orElseThrow(()-> new  UsernameNotFoundException(userName + " Not Found."));
		
		return user.map(UserDetailsImpl::new).get();
 	}
	
	
}
