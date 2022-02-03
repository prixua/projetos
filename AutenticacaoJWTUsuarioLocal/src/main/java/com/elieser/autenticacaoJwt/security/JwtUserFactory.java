package com.elieser.autenticacaoJwt.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

public class JwtUserFactory {

	private JwtUserFactory() {
	}

	/**
	 * Converte e gera um JwtUser com base nos dados de um funcionário.
	 * 
	 * @param user
	 * @return JwtUser
	 */
	/*public static JwtUser create(Funcionario funcionario) {
		return new JwtUser(funcionario.getId(), funcionario.getEmail(), funcionario.getSenha(),
				mapToGrantedAuthorities(funcionario.getPerfil()));
	}*/
	public static JwtUser create(User user) {
		return new JwtUser(1l,user.getUsername(), user.getSenha(),
				mapToGrantedAuthorities("GERAL"));
	}

	/**
	 * Converte o perfil do usuário para o formato utilizado pelo Spring Security.
	 * 
	 * @param perfil
	 * @return List<GrantedAuthority>
//	 */
//	private static List<GrantedAuthority> mapToGrantedAuthorities(PerfilEnum perfilEnum) {
//		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//		authorities.add(new SimpleGrantedAuthority(perfilEnum.toString()));
//		return authorities;
//	}
	private static List<GrantedAuthority> mapToGrantedAuthorities(String perfil) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(perfil));
		return authorities;
	}

}
