package com.something.to.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SimpleSolverTest {
    Solver s;

    @BeforeEach
    public void setUp() {
        s = new SimpleSolver();
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
        Pair expected = new Pair(-1, 0);
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
