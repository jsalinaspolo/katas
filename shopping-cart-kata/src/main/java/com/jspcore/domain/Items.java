package com.jspcore.domain;

import com.jspcore.domain.product.Item;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Stream;

public class Items {

    private final Collection<Item> items;

    public Items() {
        this.items = new ArrayList<>();
    }

    public void add(Item item) {
        items.add(item);
    }

    public int count() {
        return items.size();
    }

    public Stream<Item> all() {
        return items.stream();
    }
}
