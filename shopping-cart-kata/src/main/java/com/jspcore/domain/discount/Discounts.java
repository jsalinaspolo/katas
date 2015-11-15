package com.jspcore.domain.discount;

import com.jspcore.domain.product.Item;

import java.util.*;

import static java.util.Collections.singletonList;

public class Discounts {

    private final Collection<Discount> discounts;

    private Discounts(Collection<Discount> discounts) {
        this.discounts = discounts;
    }

    public Optional<Discount> of(Item item) {
        return discounts.stream().filter(d -> d.item() == item)
                .findFirst();
    }

    public static Discounts empty() {
        return new Discounts(Collections.emptyList());
    }

    public static Discounts of(Discount discount) {
        return new Discounts(singletonList(discount));
    }
}


