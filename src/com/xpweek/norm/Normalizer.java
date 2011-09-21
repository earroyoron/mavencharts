package com.xpweek.norm;

public class Normalizer {
	
	private Idioma idiomaEspecializado;
	private String[] plurales;

	public static Normalizer getInstance (String idioma) {
		//TODO:pendiente de revisar la funcion plurales de cada implementación
		Normalizer normalizador = new Normalizer();  
		if ("ES".equals(idioma)) {
			String[] plurales = new String[] {"es","s"};
			normalizador.setIdiomaEspecializado(new IdiomaEspanhol());
			normalizador.setPlurales(plurales);
		}
		if ("PO".equals(idioma)) {
			String[] plurales = new String[] {"zk"};
			normalizador.setIdiomaEspecializado(new IdiomaPolaco());
			normalizador.setPlurales(plurales);
		}
		return normalizador;
	}
	
	public String[] getPlurales() {
		return plurales;
	}

	public void setPlurales(String[] plurales) {
		this.plurales = plurales;
	}

	public Idioma getIdiomaEspecializado() {
		return idiomaEspecializado;
	}

	public void setIdiomaEspecializado(Idioma idiomaEspecializado) {
		this.idiomaEspecializado = idiomaEspecializado;
	}

	public String normalize(String word) {
		word = word.toLowerCase();
		word = idiomaEspecializado.replaceAccents(word);
		word = idiomaEspecializado.replacePlurals(word);
		word = word.replaceAll("\\*", "");
		return word;
	}
}
