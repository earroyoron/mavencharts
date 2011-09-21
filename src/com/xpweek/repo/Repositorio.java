package com.xpweek.repo;

import java.util.List;

import com.xpweek.entities.Usuario;

public interface Repositorio {

	List<Usuario> getUsersByCountry (String criterio,String idioma);	
	
}
