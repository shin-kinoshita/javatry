package org.docksidestage.bizfw.basic.buyticket;

/**
 * @author subaru
 */
public class TicketBuyResult {
    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private final Ticket ticket;
    private final int handedMoney;

    public TicketBuyResult(int price, int days, int handedMoney) {
        this.ticket = days == 1 ? new OneDayTicket(price) : new MultiDaysTicket(price, days);
        this.handedMoney = handedMoney;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public int getChange() {
        return handedMoney - ticket.getDisplayPrice();
    }
}
