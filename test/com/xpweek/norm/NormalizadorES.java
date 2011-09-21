package com.xpweek.norm;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.xpweek.norm.Normalizer;

public class NormalizadorES {
	
	Normalizer normalizadorEspanyol;
	
	@Before
	public void setUp(){
		normalizadorEspanyol = Normalizer.getInstance("ES");
		
	}
	
	@Test
	public void wordWithoutUpperCase() {
		assertEquals("camion", normalizadorEspanyol.normalize("CAMION"));
		assertEquals("camion", normalizadorEspanyol.normalize("Camion"));
		
	}
	
	@Test
	public void wordWithoutAccent() {
		assertEquals("camion", normalizadorEspanyol.normalize("camión"));
		assertEquals("caiman", normalizadorEspanyol.normalize("caimán"));
	}
	
	@Test
	public void wordWithoutPlurals() {
		assertEquals("libro", normalizadorEspanyol.normalize("libros"));
		assertEquals("caiman", normalizadorEspanyol.normalize("caimanes"));
		assertEquals("bailarin", normalizadorEspanyol.normalize("bailarinas"));
	}
	
	@Test
	public void wordWithoutAstherisk() {
		assertEquals("camion", normalizadorEspanyol.normalize("camion*"));
	}	

}
