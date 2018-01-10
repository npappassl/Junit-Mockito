package com.something.to.test;

public class SimpleSolver implements Solver {
    @Override
    public Pair solve(String s) {
        Pair cur = new Pair(-1, 0);
        if (s.isEmpty()) return cur;
        char current = s.charAt(0);
        int curStart = 0;
        int curLength = 1;
        for (int i = 1; i < s.length(); i++) {
            if (current != s.charAt(i)) {
                if (curLength > cur.length) {
                    cur = new Pair(curStart, curLength);
                }
                current = s.charAt(i);
                curStart = i;
                curLength = 0;
            }
            curLength++;
        }
        if (curLength > cur.length) {
            cur = new Pair(curStart, curLength);
        }

        return cur;
    }
}
