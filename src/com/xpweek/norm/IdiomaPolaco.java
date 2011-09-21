package com.xpweek.norm;
public class IdiomaPolaco extends IdiomaGenerico implements Idioma {

	

	public String replacePlurals(String word) {
		String[] sufixes = { "zj"};
		for (String sufix : sufixes) {
			if (word.endsWith(sufix)) {
				return word.substring(0, word.length() - sufix.length());
			}
		}
		return word;
	}

}
