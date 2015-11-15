package com.jspcore.domain;

import org.junit.Before;
import org.junit.Test;

import static com.jspcore.domain.product.Item.APPLE;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ItemsShould {

    private Items items;

    @Before
    public void initialise() {
        items = new Items();
    }

    @Test public void
    has_empty_collection_when_init() {
        assertThat(items.count(), is(0));
    }

    @Test public void
    has_one_item_after_add_one() {
        items.add(APPLE);
        assertThat(items.count(), is(1));
    }
}