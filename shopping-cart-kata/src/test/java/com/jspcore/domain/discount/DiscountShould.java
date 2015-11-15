package com.jspcore.domain.discount;

import org.junit.Test;

import static com.jspcore.domain.discount.Deal.THREE_FOR_TWO;
import static com.jspcore.domain.discount.Discount.dealFor;
import static com.jspcore.domain.product.Item.ORANGE;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DiscountShould {

    @Test public void
    be_value_object() {
        assertThat(dealFor(THREE_FOR_TWO, ORANGE), is(dealFor(THREE_FOR_TWO, ORANGE)));
    }

    @Test public void
    be_symmetric() {
        Discount first = dealFor(THREE_FOR_TWO, ORANGE);
        Discount second = dealFor(THREE_FOR_TWO, ORANGE);
        assertThat(first.equals(second), is(true));
        assertThat(second.equals(first), is(true));
        assertThat(first.hashCode() == second.hashCode(), is(true));
    }



}