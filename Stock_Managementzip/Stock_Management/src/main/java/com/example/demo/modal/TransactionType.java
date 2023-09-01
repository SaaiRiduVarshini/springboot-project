package com.example.demo.modal;

public enum TransactionType {
    BUY("Buy"),
    SELL("Sell");

    private final String displayName;

    TransactionType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}