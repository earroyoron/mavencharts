package com.xpweek.busc;

import java.util.Collections;
import java.util.List;

import com.xpweek.entities.Usuario;
import com.xpweek.norm.Normalizer;
import com.xpweek.repo.MockedRepositorio;
import com.xpweek.repo.Repositorio;

public class BuscadorUsuarios {

	private Repositorio repositorio;
	

	
	public List<Usuario> buscarCoincidencias
		(String textoAEncontrar,String idiomaUtilizado) {
			Normalizer normalizador = Normalizer.getInstance(idiomaUtilizado);
			String textoNormalizado = normalizador.normalize(textoAEncontrar);
			return repositorio.getUsersByCountry(textoNormalizado,idiomaUtilizado);
	}

	public void setRepositorio(Repositorio repo) {
		this.repositorio = repo;
		
	}

}
