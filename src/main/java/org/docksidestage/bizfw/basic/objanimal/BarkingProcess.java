package org.docksidestage.bizfw.basic.objanimal;

/**
 * @author subaru
 */
public class BarkingProcess {
    protected Animal animal;

    public BarkingProcess(Animal animal) {
        this.animal = animal;
    }

    protected BarkedSound doBark() {
        animal.breatheIn();
        animal.prepareAbdominalMuscle();
        String barkWord = animal.getBarkWord();
        BarkedSound barkedSound = animal.doBark(barkWord);
        return barkedSound;
    }
}
