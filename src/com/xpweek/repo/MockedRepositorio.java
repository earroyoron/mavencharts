package com.xpweek.repo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.xpweek.entities.Usuario;

public class MockedRepositorio implements Repositorio {

	private List<Usuario> usuariosCamionerosEspañoles = new ArrayList<Usuario>();
	
	public MockedRepositorio() {
		Usuario user1 = new Usuario();
		user1.setEmail("ear@com.net");
		usuariosCamionerosEspañoles.add(user1);
	}
	
	@Override
	public List<Usuario> getUsersByCountry(String criterio, String idioma) {
		if ("camion".equals(criterio) && ("ES".equals(idioma))) {
			return usuariosCamionerosEspañoles;
		}
		return Collections.emptyList();
	}

}
