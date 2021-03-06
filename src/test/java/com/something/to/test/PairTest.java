package com.something.to.test;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class PairTest {
    @Test
    public void equalsTestEquals(){
        Pair p1 = new Pair(1,4);
        Pair p2 = new Pair(1,4);
        assertEquals(p1,p2);
    }
    @Test
    public void equalsTestEqualsMethod(){
        Pair p1 = new Pair(1,4);
        Pair p2 = new Pair(1,4);
        assertTrue(p1.equals(p2));
    }
    @Test
    public void equalsTestNotEqualLength(){
        Pair p1 = new Pair(1,4);
        Pair p2 = new Pair(1,2);
        assertFalse(p1.equals(p2));
    }
    @Test
    public void equalsTestNotEqualStart(){
        Pair p1 = new Pair(2,4);
        Pair p2 = new Pair(1,4);
        assertFalse(p1.equals(p2));
    }

}
