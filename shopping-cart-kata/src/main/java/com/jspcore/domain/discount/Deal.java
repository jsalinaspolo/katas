package com.jspcore.domain.discount;

import com.jspcore.domain.product.Item;

public enum Deal implements DealItem {
    THREE_FOR_TWO {
        @Override
        public int apply(Item item, int quantity) {
            return item.priceOf(dealXforY(quantity, 3, 2));
        }
    };

    private static int dealXforY(int number, int x, int y) {
        int bundle = number / x;
        int remainder = number % x;
        return (bundle * y + remainder);
    }


}
