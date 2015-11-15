package com.jspcore.domain.product;

import org.junit.Test;

import static com.jspcore.domain.product.Item.APPLE;
import static com.jspcore.domain.product.Item.GARLIC;
import static com.jspcore.domain.product.Item.ORANGE;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ItemShould {

    @Test public void
    return_name_apple_when_is_an_apple() {
        assertThat(APPLE.itemName(), is("Apple"));
    }

    @Test public void
    return_unit_price_of_25_when_is_an_apple() {
        assertThat(APPLE.unitPrice(), is(25));
    }

    @Test public void
    return_name_orange_when_is_orange() {
        assertThat(ORANGE.itemName(), is("Orange"));
    }

    @Test public void
    return_unit_price_of_30_when_is_orange() {
        assertThat(ORANGE.unitPrice(), is(30));
    }


    @Test public void
    return_name_garlic_when_is_garlic() {
        assertThat(GARLIC.itemName(), is("Garlic"));
    }

    @Test public void
    return_unit_price_of_15_when_is_garlic() {
        assertThat(GARLIC.unitPrice(), is(15));
    }
}