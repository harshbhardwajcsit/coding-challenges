package com.practise.invoice;

class Item {
    private String itemName;
    private long quantity;
    private double cost;

    void setItemName(String itemName) {
        this.itemName = itemName;
    }

    void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    void setCost(double cost) {
        this.cost = cost;
    }

    String getItemName() {
        return itemName;
    }

    long getQuantity() {
        return quantity;
    }

    double getCost() {
        return cost;
    }
}

