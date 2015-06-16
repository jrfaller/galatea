package fr.labri.galatea.algo.tests;

import fr.labri.galatea.Attribute;
import fr.labri.galatea.BinaryAttribute;
import fr.labri.galatea.Context;
import fr.labri.galatea.Entity;

/**
 * Created by falleri on 16/06/15.
 */
public class SampleContexts {

    private SampleContexts() {}

    public static Context createSampleContext1() {
        Context c = new Context();
        Attribute aa = new BinaryAttribute("a");
        Attribute ab = new BinaryAttribute("b");
        Attribute ac = new BinaryAttribute("c");
        Attribute ad = new BinaryAttribute("d");
        Attribute ae = new BinaryAttribute("e");
        Attribute af = new BinaryAttribute("f");
        Attribute ag = new BinaryAttribute("g");
        Attribute ah = new BinaryAttribute("h");
        Entity e1 = new Entity("1");
        Entity e2 = new Entity("2");
        Entity e3 = new Entity("3");
        Entity e4 = new Entity("4");
        Entity e5 = new Entity("5");
        Entity e6 = new Entity("6");
        c.addAttribute(aa);
        c.addAttribute(ab);
        c.addAttribute(ac);
        c.addAttribute(ad);
        c.addAttribute(ae);
        c.addAttribute(af);
        c.addAttribute(ag);
        c.addAttribute(ah);
        c.addEntity(e1);
        c.addEntity(e2);
        c.addEntity(e3);
        c.addEntity(e4);
        c.addEntity(e5);
        c.addEntity(e6);
        c.addPair(e1, ab);
        c.addPair(e1, ac);
        c.addPair(e1, ad);
        c.addPair(e1, ae);
        c.addPair(e2, aa);
        c.addPair(e2, ab);
        c.addPair(e2, ac);
        c.addPair(e2, ag);
        c.addPair(e2, ah);
        c.addPair(e3, aa);
        c.addPair(e3, ab);
        c.addPair(e3, af);
        c.addPair(e3, ag);
        c.addPair(e3, ah);
        c.addPair(e4, ad);
        c.addPair(e4, ae);
        c.addPair(e5, ac);
        c.addPair(e5, ad);
        c.addPair(e6, aa);
        c.addPair(e5, ah);
        return c;
    }

}
