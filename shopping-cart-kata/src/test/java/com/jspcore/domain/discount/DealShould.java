package com.jspcore.domain.discount;

import org.junit.Test;

import static com.jspcore.domain.discount.Deal.THREE_FOR_TWO;
import static com.jspcore.domain.product.Item.ORANGE;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DealShould {

    @Test public void
    return_price_of_two_items_when_apply_discount_of_three_per_two() {
        assertThat(THREE_FOR_TWO.apply(ORANGE, 3), is(ORANGE.priceOf(2)));
    }

    @Test public void
    return_price_of_two_items_when_only_two_items() {
        assertThat(THREE_FOR_TWO.apply(ORANGE, 2), is(ORANGE.priceOf(2)));
    }



}