package com.jspcore.domain.discount;

import com.jspcore.domain.product.Item;
import org.junit.Test;

import java.util.Optional;

import static com.jspcore.domain.discount.Deal.THREE_FOR_TWO;
import static com.jspcore.domain.discount.Discount.dealFor;
import static com.jspcore.domain.product.Item.APPLE;
import static com.jspcore.domain.product.Item.ORANGE;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DiscountsShould {

    private Discounts discounts;

    @Test public void
    return_discount_of_an_item() {
        final Discount discount = dealFor(THREE_FOR_TWO, ORANGE);
        discounts = Discounts.of(discount);
        assertThat(discounts.of(ORANGE).get(), is(discount));
    }

    @Test public void
    return_empty_discount_when_not_exist() {
        discounts = Discounts.empty();
        assertThat(discounts.of(APPLE), is(Optional.empty()));
    }

    @Test public void
    build_empty_discounts() {
        discounts = Discounts.empty();
        for (Item item : Item.values()) {
            assertThat(discounts.of(item), is(Optional.empty()));
        }
    }

    @Test public void
    build_discounts() {
        final Discount discount = dealFor(THREE_FOR_TWO, ORANGE);
        discounts = Discounts.of(discount);
        assertThat(discounts.of(ORANGE).isPresent(), is(true));
    }


}