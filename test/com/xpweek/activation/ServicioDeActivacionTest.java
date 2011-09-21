package com.xpweek.activation;

import static org.junit.Assert.*;
import org.junit.Test;
import com.xpweek.entities.Usuario;
import static org.mockito.Mockito.*;

public class ServicioDeActivacionTest {
	
	private Usuario user;
	private HashGenerator hasher; 
	private HashDAO hashdao;
	private Emailer emailer;

	@Test public void
	envia_un_correo_a_nuevo_usuario() {
		preparaUsuarioARegistrar();
		preparaMocks();
		ActivationService service = new ActivationServiceImpl(hasher,hashdao,emailer);
		service.registerUser(user);
		verify(hasher).generate();
		verify(hashdao).save();
		verify(emailer).send();
		};
		

	private void preparaUsuarioARegistrar() {
		user = new Usuario();
		user.setEmail("ear@com.net");
		user.setPerfil("fontanero");
	}

	private void preparaMocks() {
		 hasher = mock(HashGenerator.class);
		 hashdao = mock(HashDAO.class);
		 emailer = mock(Emailer.class);
	}

}
