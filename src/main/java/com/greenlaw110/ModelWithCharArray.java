package com.greenlaw110;

import java.util.Arrays;

public class ModelWithCharArray {

    private char[] v;

    public char[] getV() {
        return v;
    }

    public void setV(char[] v) {
        this.v = v;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ModelWithCharArray that = (ModelWithCharArray) o;

        return Arrays.equals(v, that.v);

    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(v);
    }

    @Override
    public String toString() {
        return Arrays.toString(v);
    }
}
