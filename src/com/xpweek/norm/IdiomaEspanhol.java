package com.xpweek.norm;

public class IdiomaEspanhol extends IdiomaGenerico implements Idioma{
	
	public String replacePlurals(String word) {
		String[] sufixes = {"es","as","s"};
		for (String sufix : sufixes)
		{
			if (word.endsWith(sufix))
			{
				return word.substring(0, word.length() - sufix.length());
			}
		}
		return word;
	}

}
