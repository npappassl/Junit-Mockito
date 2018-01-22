package com.something.to.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class SimpleSolverTest {
    private String input;
    private int expectedStart;
    private int expectedLength;
    private Solver s;

    public SimpleSolverTest(String input, int expectedStart, int expectedLength){
        this.input = input;
        this.expectedStart = expectedStart;
        this.expectedLength = expectedLength;

        s = new SimpleSolver();
    }
    @Parameters
    public static Collection<Object[]> arguments(){
        return Arrays.asList(new Object[][]{
                {"aaabbbb", 3 , 4},
                {"",       -1 , 0},
                {"a",       0 , 1},
                {"aa",      0 , 2},
                {"ab",      0 , 1},
                {"acvsasvasdddddbasbsaasddbabdbbbbadbadb", 9, 5}
        });
    }

    @Test
    public void findUniformStringTestSimple() {
        ToTest t = new ToTest(input, s);
        Pair expected = new Pair(expectedStart, expectedLength);
        Pair actual = t.findUniformString();

        assertEquals(expected, actual);
    }
}
