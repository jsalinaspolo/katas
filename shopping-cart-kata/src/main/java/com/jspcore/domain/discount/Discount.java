package com.jspcore.domain.discount;

import com.jspcore.domain.product.Item;

public class Discount {

    private final Deal deal;
    private final Item item;

    private Discount(Deal deal, Item item) {
        this.deal = deal;
        this.item = item;
    }

    public Item item() {
        return this.item;
    }

    public String deal() { return this.deal.name(); }

    public int apply(Item item, int quantity) {
        return this.deal.apply(item, quantity);
    }

    public static Discount dealFor(Deal deal, Item item) {
        return new Discount(deal, item);
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Discount discount = (Discount) o;

        if (deal != discount.deal) return false;
        return item == discount.item;

    }

    @Override public int hashCode() {
        int result = deal != null ? deal.hashCode() : 0;
        result = 31 * result + (item != null ? item.hashCode() : 0);
        return result;
    }
}
