package com.xpweek.norm;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.xpweek.norm.Normalizer;

public class NormalizadorPO {
	
	Normalizer normalizadorPolaco;
	
	@Before
	public void setUp(){
		normalizadorPolaco = Normalizer.getInstance("PO");
	}
	
	@Test
	public void wordWithoutUpperCase() {
		
		assertEquals("camion", normalizadorPolaco.normalize("CAMION"));
		assertEquals("camion", normalizadorPolaco.normalize("Camion"));
	}
	
	@Test
	public void wordWithoutPluralsInOtherLanguages() {
		assertEquals("moto", normalizadorPolaco.normalize("motozj"));
	}
	

}
