package com.something.to.test;

public class Pair {
    int start;
    int length;
    public Pair(int start, int length){
        this.start = start;
        this.length = length;
    }
    public boolean equals(Object p){
        if(p instanceof Pair){
            Pair actual = (Pair) p;
            return start==actual.start && length == actual.length;
        } else {
            return false;
        }
    }
    public String toString(){
        return "Start: "+this.start+"\tLength: "+this.length;
    }
}
