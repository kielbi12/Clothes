package com.example.demo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicInteger;

@Data
@NoArgsConstructor
public class Cloth {
    private static final AtomicInteger count = new AtomicInteger(0);
    private int id;
    private String name;
    private String desctription;
    private TypeofCloth type;
    private BigDecimal price;
    private BigDecimal pricewithDiscount ;
    private int viewQuantity= 0;

    public Cloth(String name, String desctription, TypeofCloth type, BigDecimal price) {
        this.desctription = desctription;
        this.name = name;
        this.type = type;
        this.price = price;
        this.id = count.incrementAndGet();
    }

    public void setPriceWithDiscount(){
       pricewithDiscount = price.multiply(BigDecimal.valueOf(1).subtract(type.getDiscount()));
    }

}
