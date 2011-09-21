package com.xpweek.busc;

import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import com.xpweek.entities.Usuario;
import com.xpweek.repo.MockedRepositorio;
import com.xpweek.repo.Repositorio;

import static org.mockito.Mockito.*;

public class BuscadorESTest {

	// TODO si recibo una cadena vacía devuelvo una lista vacia
	// TODO si busco un idioma que no existe devuelvo lista vacia
	// TODO si busco camiones,ES obtengo usuarios con perfil camion =
	// ear@com.net

	private BuscadorUsuarios buscadorUsuarios;
	private static final String IDIOMA_UTILIZADO = "ES";
	private Usuario usuarioQueDeboEncontrar;
	private Repositorio repository;
	private List<Usuario> usuariosCamionerosEspañoles = new ArrayList<Usuario>();

	@Before
	public void setUp() {
		buscadorUsuarios = new BuscadorUsuarios();		
		prepararEInyectarRepo();
		prepararRespuesta_listaCamionerosEspañoles();
	}

	
	public void setRepository(Repositorio repository) {
		this.repository = repository;
	}


	private void prepararEInyectarRepo() {
		repository = mock(Repositorio.class);
		buscadorUsuarios.setRepositorio(repository);
	}
	
	private void prepararRespuesta_listaCamionerosEspañoles() {
		usuarioQueDeboEncontrar = new Usuario();
		usuarioQueDeboEncontrar.setEmail("ear@com.net");
		Usuario user1 = new Usuario();
		user1.setEmail("ear@com.net");
		usuariosCamionerosEspañoles.add(user1);
	}

	
	@Test
	public void busca_cadena_vacia_españoles() {
		String textoAEncontrar = "";
		List<Usuario> usuariosCoincidentes = buscadorUsuarios
				.buscarCoincidencias(textoAEncontrar, IDIOMA_UTILIZADO);
		assertTrue(usuariosCoincidentes.isEmpty());
	}

	@Test
	public void buscarCamionerosEspañoles() {	
		assertThat_encuentroCamionerosEspañoles("camion");
		assertThat_encuentroCamionerosEspañoles("camión");
		assertThat_encuentroCamionerosEspañoles("Camión");
		assertThat_encuentroCamionerosEspañoles("Camiones");
		assertThat_encuentroCamionerosEspañoles("CAMION");
	}

	@Test
	public void buscarCamionerosEspañolesPlurales() {
		String textoAEncontrar = "camiones";
		when(repository.getUsersByCountry("camion", "ES")).thenReturn(
				usuariosCamionerosEspañoles);
		List<Usuario> usuariosCoincidentes = buscadorUsuarios
				.buscarCoincidencias(textoAEncontrar, IDIOMA_UTILIZADO);
		assertEquals("ear@com.net", usuariosCoincidentes.get(0).getEmail());
	}

	private void assertThat_encuentroCamionerosEspañoles(String textoAEncontrar) {
		when(repository.getUsersByCountry("camion", "ES")).thenReturn(
				usuariosCamionerosEspañoles);
		List<Usuario> usuariosCoincidentes = buscadorUsuarios
				.buscarCoincidencias(textoAEncontrar, IDIOMA_UTILIZADO);
		assertThat(usuariosCoincidentes, hasItem(usuarioQueDeboEncontrar));
	}

	

	
}
