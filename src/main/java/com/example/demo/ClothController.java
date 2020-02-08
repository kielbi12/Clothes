package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Hashtable;
import java.util.concurrent.atomic.AtomicInteger;
@Slf4j
@RestController
public class ClothController {

    @Autowired
    ClothService cs;

    @GetMapping("/all")
    public Hashtable<String, Cloth> getClothes() {
        return cs.getAll();
    }

    @GetMapping({"/{id}"})
    public Cloth getCloth(@PathVariable("id") String id) {
        try {
            Cloth cloth = cs.getCloth(id);
            AtomicInteger count = new AtomicInteger(cloth.getViewQuantity());
            cloth.setViewQuantity(count.incrementAndGet());
            return cloth;
        } catch (NullPointerException n) {
            String info = "Nie ma takiego obiektu";
            log.info(info);
        }
        return new Cloth();
    }


}
