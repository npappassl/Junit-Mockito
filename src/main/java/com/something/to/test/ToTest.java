package com.something.to.test;

public class ToTest {

    private String s;
    private StringResolver stRes;
    private Solver solver;
    private Logger lg;

    public ToTest(String s, Solver solver) {
        this.s = s;
        this.solver = solver;
    }

    public ToTest(StringResolver stRes, Solver solver) {
        this.stRes = stRes;
        this.solver = solver;
    }

    public void setLg(Logger lg) {
        this.lg = lg;
    }

    public Pair findUniformString() {
        String input = s != null ? s : stRes.getString();
        Pair result = solver.solve(input);
        if (lg != null) {
            System.out.println("Solving for " + input);
            lg.log(result.toString());
        }
        return result;
    }
}
