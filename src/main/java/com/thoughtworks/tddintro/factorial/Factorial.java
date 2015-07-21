package com.thoughtworks.tddintro.factorial;

public class Factorial {
    public Integer compute(int i) throws IllegalArgumentException {
        if (i < 0) {
            throw new IllegalArgumentException("Positive Integers Only!");
        } else {
            return -1;
        }
    }
}
