package com.xpweek.norm;

public abstract class IdiomaGenerico implements Idioma {

	@Override
	public String replaceAccents(String word) {
		word = word.replaceAll("á", "a");
		word = word.replaceAll("é", "e");
		word = word.replaceAll("í", "i");
		word = word.replaceAll("ó", "o");
		word = word.replaceAll("ú", "u");
		return word;
	}

	@Override
	public String replacePlurals(String word) {
		// TODO Auto-generated method stub
		return null;
	}

}
