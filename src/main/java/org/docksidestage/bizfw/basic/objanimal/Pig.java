package org.docksidestage.bizfw.basic.objanimal;

/**
 * @author subaru
 */
public class Pig extends Animal {
    @Override
    protected int getInitialHitPoint() {
        return 7;
    }

    @Override
    protected String getBarkWord() {
        return "bu-bu-bu---";
    }

    // ===================================================================================
    //                                                                           Hit Point
    //                                                                           =========
    protected void downHitPoint() {
        --hitPoint;
        --hitPoint;
        if (hitPoint == 0) {
            throw new IllegalStateException("I'm very tired, so I want to sleep" + getBarkWord());
        } else if (hitPoint < 0) {
            throw new IllegalStateException("zzzzzzzzzz.......");
        }
    }
}
