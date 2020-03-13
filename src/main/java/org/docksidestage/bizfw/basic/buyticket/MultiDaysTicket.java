package org.docksidestage.bizfw.basic.buyticket;

/**
 * @author subaru
 */
public class MultiDaysTicket implements Ticket {
    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private final int displayPrice;
    private boolean alreadyIn;
    private int inParkDays;

    public MultiDaysTicket(int displayPrice, int inParkDays) {
        this.displayPrice = displayPrice;
        this.inParkDays = inParkDays;
        this.alreadyIn = false;
    }

    // ===================================================================================
    //                                                                             In Park
    //                                                                             =======
    public void doInPark() {
        if (inParkDays <= 0) {
            throw new IllegalStateException("Already in park by this ticket: displayedPrice=" + displayPrice);
        }
        --inParkDays;
        alreadyIn = true;
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public int getDisplayPrice() {
        return displayPrice;
    }

    public boolean isAlreadyIn() {
        return alreadyIn;
    }
}
