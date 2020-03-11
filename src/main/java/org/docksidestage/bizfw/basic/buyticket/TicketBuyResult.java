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

    public TicketBuyResult(int price, int handedMoney) {
        this.ticket = new Ticket(price);
        this.handedMoney = handedMoney;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public int getChange() {
        return handedMoney - ticket.getDisplayPrice();
    }
}
