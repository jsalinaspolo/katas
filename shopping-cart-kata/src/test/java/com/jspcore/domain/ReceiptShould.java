package com.jspcore.domain;

import com.jspcore.domain.discount.Discount;
import com.jspcore.domain.discount.Discounts;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.PrintStream;

import static com.jspcore.domain.discount.Deal.THREE_FOR_TWO;
import static com.jspcore.domain.discount.Discount.dealFor;
import static com.jspcore.domain.product.Item.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ReceiptShould {

    private PrintStream printer;
    private Receipt receipt;

    @Before
    public void initialise() {
        printer = mock(PrintStream.class);
        receipt = new Receipt(printer);
    }

    @Test public void
    print_receipt() {
        Basket basket = new Basket(Discounts.empty());
        basket.addItem(PAPAYA);
        basket.addItem(ORANGE);
        basket.addItem(GARLIC);
        basket.addItem(PAPAYA);
        receipt.print(basket);

        verify(printer).println(String.format("Total: \t\t\t\t\t\t\t%d", basket.totalCost()));
    }

    @Test public void
    print_receipt_with_discounts() {
        Discount discount = dealFor(THREE_FOR_TWO, PAPAYA);
        Basket basket = new Basket(Discounts.of(discount));
        basket.addItem(PAPAYA);
        basket.addItem(PAPAYA);
        basket.addItem(PAPAYA);
        basket.addItem(ORANGE);
        basket.addItem(GARLIC);
        basket.addItem(PAPAYA);
        receipt.print(basket);

        verify(printer).println(String.format("Discount: %s\t%s\t%d", discount.deal(), discount.item().name(),
                (discount.apply(PAPAYA, 4)) - PAPAYA.priceOf(4)));
    }
}