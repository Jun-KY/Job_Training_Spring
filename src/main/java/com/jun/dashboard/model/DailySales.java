package com.jun.dashboard.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DailySales {
    private LocalDate saleDate;
    private BigDecimal totalAmount;
    private int orderCount;

    public DailySales(){
    }

    public DailySales(LocalDate saleDate,BigDecimal totalAmount, int orderCount){
        this.orderCount = orderCount;
        this.saleDate = saleDate;
        this.totalAmount = totalAmount;
    }

    public LocalDate getSaleDate() {
        return saleDate;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public int getOrderCount() {
        return orderCount;
    }

    public void setSaleDate(LocalDate saleDate) {
        this.saleDate = saleDate;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setOrderCount(int orderCount) {
        this.orderCount = orderCount;
    }
}
