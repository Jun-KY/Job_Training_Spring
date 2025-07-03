package com.jun.dashboard.model;

import java.math.BigDecimal;

public class CustomerRank {
    private int customerId;
    private BigDecimal totalSpent;
    private int rank;

    public CustomerRank(){

    }
    public CustomerRank(int customerId, BigDecimal totalSpent, int rank){
        this.customerId = customerId;
        this.totalSpent = totalSpent;
        this.rank = rank;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setTotalSpent(BigDecimal totalSpent) {
        this.totalSpent = totalSpent;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getCustomerId() {
        return customerId;
    }

    public BigDecimal getTotalSpent() {
        return totalSpent;
    }

    public int getRank() {
        return rank;
    }
}
