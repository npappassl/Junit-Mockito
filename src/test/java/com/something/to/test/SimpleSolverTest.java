package com.something.to.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SimpleSolverTest {
    @TestFactory
    public Collection<DynamicTest> uniformStringDynamicTests() {
        List<String> inPhrases = new ArrayList<>(Arrays.asList(
                "aaabbbb", "", "a",
                "aa", "ab", "acvsasvasdddddbasbsaasddbabdbbbbadbadb"));
        List<Pair> expected = new ArrayList<>(Arrays.asList(
                new Pair(3, 4), new Pair(-1, 0), new Pair(0, 1),
                new Pair(0, 2), new Pair(0, 1), new Pair(9, 5)));
        Collection<DynamicTest> dynamicTests = new ArrayList<>();
        for (int i = 0; i < inPhrases.size(); i++) {
            String phr = inPhrases.get(i);
            Pair p = expected.get(i);
            ToTest t = new ToTest(phr, new SimpleSolver());
            // create an test execution
            Executable exec = () -> assertEquals(p, t.findUniformString());
            // create a test display name
            String testName = "Test find uniform string in: " + phr;
            // create dynamic test
            DynamicTest dTest = DynamicTest.dynamicTest(testName, exec);
            // add the dynamic test to collection
            dynamicTests.add(dTest);
        }
        return dynamicTests;
    }
}
