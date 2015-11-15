package com.jspcore.domain.discount;

import com.jspcore.domain.product.Item;

public interface DealItem {

    int apply(Item item, int quantity);
}
