/*
 * Copyright 2019-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.docksidestage.bizfw.basic.buyticket;

/**
 * @author jflute
 */
public class TicketBooth {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    private static final int MAX_QUANTITY = 10;
    private static final int ONE_DAY_PRICE = 7400; // when 2019/06/15
    private static final int TWO_DAY_PRICE = 13200;
    private static final int FOUR_DAY_PRICE = 22400;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private int quantity = MAX_QUANTITY;
    private Integer salesProceeds;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public TicketBooth() {
    }

    // ===================================================================================
    //                                                                          Buy Ticket
    //                                                                          ==========
    public OneDayTicket buyOneDayPassport(int handedMoney) {
        ticketSoldOutExceptionThrower();
        ticketShortMoneyExceptionThrower(handedMoney, ONE_DAY_PRICE);
        --quantity;
        updateSalesPrice(ONE_DAY_PRICE);
        return new OneDayTicket(ONE_DAY_PRICE);
    }

    public TicketBuyResult buyTwoDayPassport(int handedMoney) {
        ticketSoldOutExceptionThrower();
        ticketShortMoneyExceptionThrower(handedMoney, TWO_DAY_PRICE);
        --quantity;
        updateSalesPrice(TWO_DAY_PRICE);
        return new TicketBuyResult(TWO_DAY_PRICE, 2, handedMoney);
    }

    public TicketBuyResult buyFourDayPassport(int handedMoney) {
        ticketSoldOutExceptionThrower();
        ticketShortMoneyExceptionThrower(handedMoney, FOUR_DAY_PRICE);
        --quantity;
        updateSalesPrice(FOUR_DAY_PRICE);
        return new TicketBuyResult(FOUR_DAY_PRICE, 4, handedMoney);
    }

    private void ticketSoldOutExceptionThrower() {
        if (quantity <= 0) {
            throw new TicketSoldOutException("Sold out");
        }
    }

    private void ticketShortMoneyExceptionThrower(int handedMoney, int ticketPrice) {
        if (handedMoney < ticketPrice) {
            throw new TicketShortMoneyException("Short money: " + handedMoney);
        }
    }

    private void updateSalesPrice(int ticketPrice) {
        if (salesProceeds != null) {
            salesProceeds = salesProceeds + ticketPrice;
        } else {
            salesProceeds = ticketPrice;
        }
    }

    public static class TicketSoldOutException extends RuntimeException {

        private static final long serialVersionUID = 1L;

        public TicketSoldOutException(String msg) {
            super(msg);
        }
    }

    public static class TicketShortMoneyException extends RuntimeException {

        private static final long serialVersionUID = 1L;

        public TicketShortMoneyException(String msg) {
            super(msg);
        }
    }

    public String judgeTicketType(Ticket ticket) {
        int price = ticket.getDisplayPrice();
        if (price == ONE_DAY_PRICE) {
            return "one-day";
        } else if (price == TWO_DAY_PRICE) {
            return "two-day";
        }
        return null;
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public int getQuantity() {
        return quantity;
    }

    public Integer getSalesProceeds() {
        return salesProceeds;
    }
}
