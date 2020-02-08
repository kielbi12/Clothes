package com.example.demo;

import java.math.BigDecimal;

public enum  TypeofCloth {

    MALE(BigDecimal.valueOf(0.05)),
    FEMALE(BigDecimal.valueOf(0.05)),
    KID(BigDecimal.valueOf(0.1));
    private BigDecimal discount;

    TypeofCloth(BigDecimal discount){
        this.discount=discount;
    }

    public BigDecimal getDiscount() {
        return discount;
    }
}
