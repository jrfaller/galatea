package fr.labri.galatea.algo;

import fr.labri.galatea.ConceptOrder;
import fr.labri.galatea.Context;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestLattice {

    @Test
    public void testAddExtent() {
        Context c = Samples.sampleContext1();
        Algorithm a = new AddExtent(c);
        a.compute();
        ConceptOrder o = a.getConceptOrder();
        assertEquals(Samples.sampleLattice1(), Samples.conceptOrderHash(o));
    }

}
