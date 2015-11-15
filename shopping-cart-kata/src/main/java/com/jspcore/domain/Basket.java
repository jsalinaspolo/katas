package com.jspcore.domain;


import com.jspcore.domain.discount.Discount;
import com.jspcore.domain.discount.Discounts;
import com.jspcore.domain.product.Item;

import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Basket {
    private final Items items;
    private final Discounts discounts;

    public Basket(Discounts discounts) {
        this.items = new Items();
        this.discounts = discounts;
    }

    public int totalCost() {
        return items.all()
                .collect(groupingBy(item -> item, counting()))
                .entrySet().stream()
                .mapToInt(e -> calculatePriceOf(e.getKey(), e.getValue().intValue()))
                .sum();
    }

    private int calculatePriceOf(Item item, int quantity) {
        return discounts.of(item).map(d -> d.apply(item, quantity))
                .orElse(item.priceOf(quantity));
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public Map<Item, Long> groupByItem() {
        return items.all().collect(groupingBy(item -> item, counting()));
    }

    public Optional<Discount> getDiscountIfApplies(Item item, int quantity) {
        return discounts.of(item).map(d ->
                        d.apply(item, quantity) > 0 ? Optional.of(d) : Optional.<Discount>empty()
        ).orElse(Optional.empty());
    }
}
