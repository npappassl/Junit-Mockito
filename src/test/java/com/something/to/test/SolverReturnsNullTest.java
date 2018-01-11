package com.something.to.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Simple solver should find the starting index and length of the longest uniform String (returns null for empty String)")
public class SolverReturnsNullTest {
    static class MyArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                    Arguments.of("aaabbbb", new Pair(3, 4)),
                    Arguments.of("", null),
                    Arguments.of("a", new Pair(0, 1)),
                    Arguments.of("aa", new Pair(0, 2)),
                    Arguments.of("ab", new Pair(0, 1)),
                    Arguments.of("acvsasvasdddddbasbsaasddbabdbbbbadbadb", new Pair(9, 5))
            );
        }
    }
    @ParameterizedTest
    @ArgumentsSource(MyArgumentsProvider.class)
    public void findUniformStringTestSimple(String input, Pair expectedOut) {
        SolverReturnsNull s = new SolverReturnsNull();
        ToTest t = new ToTest(input, s);

        assertEquals(expectedOut, t.findUniformString());
    }
}
