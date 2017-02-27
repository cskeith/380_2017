package edu.ouhk.comps380f.lab03;

import java.io.Serializable;

public class VisitCounter implements Serializable {

    private int count;

    public VisitCounter() {
        count = 0;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
