package com.something.to.test;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolverReturnsNullTest {
    @TestFactory
    public Stream<DynamicTest> uniformStringDynamicTests() {
        List<String> inPhrases = new ArrayList<>(Arrays.asList(
                "aaabbbb", "", "a",
                "aa", "ab", "acvsasvasdddddbasbsaasddbabdbbbbadbadb"));
        List<Pair> expected = new ArrayList<>(Arrays.asList(
                new Pair(3, 4), null, new Pair(0, 1),
                new Pair(0, 2), new Pair(0, 1), new Pair(9, 5)));

        return inPhrases.stream().map(phr -> DynamicTest.dynamicTest("Test find uniform string in: " + phr, () -> {
                int i = inPhrases.indexOf(phr);
                ToTest t = new ToTest(phr, new SolverReturnsNull());
                assertEquals(expected.get(i), t.findUniformString());
        }));
    }
}
