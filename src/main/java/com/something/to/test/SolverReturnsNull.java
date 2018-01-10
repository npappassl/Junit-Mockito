package com.something.to.test;

public class SolverReturnsNull implements Solver {
    @Override
    public Pair solve(String s) {
        if (s.isEmpty()) return null;
        Solver simple = new SimpleSolver();
        return simple.solve(s);
    }
}
