package fr.labri.galatea.algo.tests;

import java.io.IOException;

import org.junit.Test;

import fr.labri.galatea.ConceptOrder;
import fr.labri.galatea.algo.AddExtent;
import fr.labri.galatea.algo.Algorithm;
import fr.labri.galatea.algo.Ceres;
import fr.labri.galatea.algo.SimpleGSH;
import fr.labri.galatea.io.ParseCSVContext;

import static junit.framework.Assert.*;

public class TestAlgos {

	@Test
	public void testSimpleGSH() throws IOException {
		ParseCSVContext p = new ParseCSVContext("target/test-classes/gsh.csv");
		p.parse();
		Algorithm a = new SimpleGSH(p.getContext());
		a.compute();
		ConceptOrder o = a.getConceptOrder();
		assertTrue(o.getConcepts().size() == 10);

	}
	@Test
	public void testCeres() throws IOException {
		ParseCSVContext p = new ParseCSVContext("target/test-classes/gsh.csv");
		p.parse();
		Algorithm a = new Ceres(p.getContext());
		a.compute();
		ConceptOrder o = a.getConceptOrder();
		assertTrue(o.getConcepts().size() == 10);	
	}

	@Test
	public void testAddExtent() throws IOException {
		ParseCSVContext p = new ParseCSVContext("target/test-classes/gsh.csv");
		p.parse();
		Algorithm a = new AddExtent(p.getContext());
		a.compute();
		ConceptOrder o = a.getConceptOrder();
		assertTrue(o.getConcepts().size() == 13);	
	}

}
