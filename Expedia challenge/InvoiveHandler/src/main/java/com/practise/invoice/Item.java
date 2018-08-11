package com.practise.invoice;

public class Item {
    private String itemName;
    private long quantity;
    private float cost;

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public String getItemName() {
        return itemName;
    }

    public long getQuantity() {
        return quantity;
    }

    public float getCost() {
        return cost;
    }
}

