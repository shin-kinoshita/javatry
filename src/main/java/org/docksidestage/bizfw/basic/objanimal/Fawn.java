package org.docksidestage.bizfw.basic.objanimal;

import org.docksidestage.bizfw.basic.objanimal.runner.FastRunner;

/**
 * @author subaru
 */
public class Fawn extends Animal implements FastRunner {
    @Override
    protected int getInitialHitPoint() {
        return 5;
    }
    @Override
    protected String getBarkWord() {
        return "myu-n myu-n fuu....";
    }
    @Override
    public void run() {
        downHitPoint();
    }
}
