package com.jspcore.domain;

import java.io.PrintStream;

public class Receipt {

    public static final String HEADER = "RECEIPT";
    private final PrintStream printer;

    public Receipt(PrintStream printer) {
        this.printer = printer;
    }

    public void print(Basket basket) {
        printer.println(HEADER);

        basket.groupByItem()
                .entrySet().stream()
                .forEach(e -> printer.println(String.format("Product: %s\t\t%d\t%d\t\t%d",
                        e.getKey().name(), e.getValue(), e.getKey().unitPrice(), e.getKey().priceOf(e.getValue().intValue()))));

        basket.groupByItem()
                .entrySet().stream()
                .forEach(e -> basket.getDiscountIfApplies(e.getKey(), e.getValue().intValue()).ifPresent(d -> printer.println(
                        String.format("Discount: %s\t%s\t%d", d.deal(), d.item().name(),
                                (d.apply(e.getKey(), e.getValue().intValue())) - e.getKey().priceOf(e.getValue().intValue())))));

        printer.println(String.format("Total: \t\t\t\t\t\t\t%d", basket.totalCost()));



    }
}
