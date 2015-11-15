package com.jspcore.domain;

import com.jspcore.domain.discount.Discounts;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static com.jspcore.domain.discount.Deal.THREE_FOR_TWO;
import static com.jspcore.domain.discount.Discount.dealFor;
import static com.jspcore.domain.product.Item.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class BasketShould {

    private Basket basket;

    @Before
    public void initialise() {
        basket = new Basket(Discounts.of(dealFor(THREE_FOR_TWO, PAPAYA)));
    }

    @Test public void
    calculate_total_cost_of_items() {
        assertThat(basket.totalCost(), is(0));
    }

    @Test public void
    calculate_total_cost_of_one_apple() {
        basket.addItem(APPLE);
        assertThat(basket.totalCost(), is(25));
    }

    @Test public void
    calculate_total_cost_of_two_apples() {
        basket.addItem(APPLE);
        basket.addItem(APPLE);
        assertThat(basket.totalCost(), is(50));
    }

    @Test public void
    calculate_cost_of_one_apple_and_one_orange() {
        basket.addItem(APPLE);
        basket.addItem(ORANGE);
        assertThat(basket.totalCost(), is(55));
    }

    @Test public void
    calculate_cost_of_one_garlic_and_one_apple() {
        basket.addItem(APPLE);
        basket.addItem(GARLIC);
        assertThat(basket.totalCost(), is(40));
    }

    @Test public void
    calculate_cost_of_one_papaya_and_one_apple() {
        basket.addItem(PAPAYA);
        basket.addItem(APPLE);
        assertThat(basket.totalCost(), is(75));
    }

    @Test public void
    calculate_cost_of_two_papayas() {
        basket.addItem(PAPAYA);
        basket.addItem(PAPAYA);
        assertThat(basket.totalCost(), is(100));
    }

    @Test public void
    calculate_cost_with_discount_of_three_papayas() {
        basket.addItem(PAPAYA);
        basket.addItem(PAPAYA);
        basket.addItem(PAPAYA);
        assertThat(basket.totalCost(), is(100));
    }

    @Test public void
    calculate_cost_of_four_papayas_some_with_discount() {
        basket.addItem(PAPAYA);
        basket.addItem(PAPAYA);
        basket.addItem(PAPAYA);
        basket.addItem(PAPAYA);
        assertThat(basket.totalCost(), is(150));
    }





}