package com.something.to.test;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolverReturnsNullTest {
    Solver s;

    @Before
    public void setUp() {
        s = new SolverReturnsNull();
    }

    @Test
    public void findUniformStringTestSimple() {
        ToTest t = new ToTest("aaabbbb", s);
        Pair expected = new Pair(3, 4);
        Pair actual = t.findUniformString();

        assertEquals(expected, actual);
    }

    @Test
    public void findUniformStringTestEmpty() {
        ToTest t = new ToTest("", s);
        Pair expected = null;
        Pair actual = t.findUniformString();

        assertEquals(expected, actual);
    }

    @Test
    public void findUniformStringTestSingleChar() {
        ToTest t = new ToTest("a", s);
        Pair expected = new Pair(0, 1);
        Pair actual = t.findUniformString();

        assertEquals(expected, actual);
    }

    @Test
    public void findUniformStringTestTwoChar() {
        ToTest t = new ToTest("aa", s);
        Pair expected = new Pair(0, 2);
        Pair actual = t.findUniformString();

        assertEquals(expected, actual);
    }

    @Test
    public void findUniformStringTestTwoDistinctsChars() {
        ToTest t = new ToTest("ab", s);
        Pair expected = new Pair(0, 1);
        Pair actual = t.findUniformString();

        assertEquals(expected, actual);
    }

    @Test
    public void findUniformStringTestLong() {
        ToTest t = new ToTest("acvsasvasdddddbasbsaasddbabdbbbbadbadb", s);
        Pair expected = new Pair(9, 5);
        Pair actual = t.findUniformString();

        assertEquals(expected, actual);
    }

}
