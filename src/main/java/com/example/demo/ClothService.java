package com.example.demo;


import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Hashtable;

@Service
public class ClothService {

    Hashtable<String, Cloth> clothes = new Hashtable<String, Cloth>();
    Hashtable<String, Cloth> clothesWithDiscount = new Hashtable<String, Cloth>();

    public ClothService() {
        Cloth cloth = new Cloth("Koszulka męska", "Bawełniana koszulka męska w paski", TypeofCloth.MALE, BigDecimal.valueOf(25.50));
        clothes.put("1", cloth);
        cloth = new Cloth("Koszulka damska", "Bawełniana koszulka damska w paski", TypeofCloth.FEMALE, BigDecimal.valueOf(25.50));
        clothes.put("2", cloth);
        cloth = new Cloth("Koszulka dziecięca", "Bawełniana koszulka dziecięca w paski", TypeofCloth.KID, BigDecimal.valueOf(15.70));
        clothes.put("3", cloth);
        cloth = new Cloth("Jeansy męskie", "Jasne jeansy męskie", TypeofCloth.MALE, BigDecimal.valueOf(70.50));
        clothes.put("4", cloth);
        cloth = new Cloth("Jeansy damskie", "Ciemne jeansy damskie", TypeofCloth.FEMALE, BigDecimal.valueOf(60.30));
        clothes.put("5", cloth);
        cloth = new Cloth("Jeansy dziecięce", "Jasne jeansy dziecięce", TypeofCloth.KID, BigDecimal.valueOf(30.50));
        clothes.put("6", cloth);
        cloth = new Cloth("Buty męskie", "Mokasyny męskie", TypeofCloth.MALE, BigDecimal.valueOf(100));
        clothes.put("7", cloth);
        cloth = new Cloth("Buty damskie", "Szpilki damskie", TypeofCloth.FEMALE, BigDecimal.valueOf(85.50));
        clothes.put("8", cloth);
        cloth = new Cloth("Buty dziecięce", "Adidasy dziecięce", TypeofCloth.KID, BigDecimal.valueOf(80.20));
        clothes.put("9", cloth);
    }

    public Cloth getCloth(String id) {
        if (clothes.containsKey(id)) {
            Cloth cloth = clothes.get(id);
            if(cloth.getViewQuantity() <1){
                cloth.setPriceWithDiscount();
            }
            return cloth;
        }
        return null;
    }

    public Hashtable<String, Cloth> getAll() {
        clothes.forEach((k,v) -> v.setPriceWithDiscount());
        return clothes;
    }

}
