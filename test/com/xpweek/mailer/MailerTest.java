package com.xpweek.mailer;

import java.security.InvalidParameterException;

import org.junit.Test;

public class MailerTest {

	//@SuppressWarnings
	@Test (expected=InvalidParameterException.class) public void 
	avisa_de_un_correo_vacio() {
		Mailer.Check ("");
	}

}
