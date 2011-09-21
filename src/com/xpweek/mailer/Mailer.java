package com.xpweek.mailer;

import java.security.InvalidParameterException;

public class Mailer {
	
	public static void Check (String email) {
		if ((email == null) || ("".equals(email)))
				throw new InvalidParameterException();
	}

}
