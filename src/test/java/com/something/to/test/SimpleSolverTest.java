package com.something.to.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("Simple solver should find the starting index and length of the longest uniform String")
public class SimpleSolverTest {
    // only a single argument of type String || int || long || double
    @ParameterizedTest
    @ValueSource(strings = {"Hello", "World"})
    public void findUniformStringTestValueSource(String word) {
        // ... Test Body Here
        System.out.println(word);
        assertNotNull(word);
    }

    static Stream<Arguments> argumentProviderMethod() {
        return Stream.of(
                Arguments.of("aaabbbb", new Pair(3, 4)),
                Arguments.of("", new Pair(-1, 0)),
                Arguments.of("a", new Pair(0, 1)),
                Arguments.of("aa", new Pair(0, 2)),
                Arguments.of("ab", new Pair(0, 1)),
                Arguments.of("acvsasvasdddddbasbsaasddbabdbbbbadbadb", new Pair(9, 5))
        );
    }

    @ParameterizedTest(name = "{index} Find a uniform string in {0}")
    @MethodSource("argumentProviderMethod")
    @DisplayName("Parametrized test for Simple Solver")
    public void findUniformStringTest(String input, Pair expectedOut) {
        Solver s = new SimpleSolver();
        ToTest t = new ToTest(input, s);
        assertEquals(expectedOut, t.findUniformString());
    }


}
