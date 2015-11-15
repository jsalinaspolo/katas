package com.jspcore.domain.product;

public enum Item {
    APPLE("Apple", 25),
    ORANGE("Orange", 30),
    GARLIC("Garlic", 15),
    PAPAYA("Papaya", 50);

    private final String name;
    private final int pricePerUnit;

    Item(String name, int pricePerUnit) {
        this.name = name;
        this.pricePerUnit = pricePerUnit;
    }

    public String itemName() {
        return this.name;
    }

    public int unitPrice() {
        return this.pricePerUnit;
    }

    public int priceOf(int quantity) {
        return unitPrice() * quantity;
    }
}
