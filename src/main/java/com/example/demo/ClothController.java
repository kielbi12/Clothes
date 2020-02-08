package com.example.demo;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import static com.sun.tools.sjavac.Util.getStackTrace;

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
        } catch (Exception ex) {
            Gson gson = new Gson();
            Map<String, String> exc_map = new HashMap<String, String>();
            exc_map.put("message", ex.toString());
            log.info(gson.toJson(exc_map));
            return null;
        }
    }


}
