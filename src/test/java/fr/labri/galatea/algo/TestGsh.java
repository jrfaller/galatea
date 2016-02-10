package fr.labri.galatea.algo;

import fr.labri.galatea.ConceptOrder;
import fr.labri.galatea.Context;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestGsh {

    @Ignore
    @Test
    public void testCeres() {
        Context c = Samples.sampleContext1();
        Algorithm a = new Ceres(c);
        a.compute();
        ConceptOrder o = a.getConceptOrder();
        assertEquals(Samples.sampleGsh1(), Samples.conceptOrderHash(o));
    }

    @Test
    public void testSimpleGSH() {
        Context c = Samples.sampleContext1();
        Algorithm a = new SimpleGSH(c);
        a.compute();
        ConceptOrder o = a.getConceptOrder();
        assertEquals(Samples.sampleGsh1(), Samples.conceptOrderHash(o));
    }

}
