package com.paymentchain.films.controller;

import com.paymentchain.films.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/inventory")
@RestController
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/film/{filmId}")
    public List<Object[]> getStoreAddressAndQuantityByFilmId(@PathVariable Integer filmId) {
        return inventoryService.findStoreAddressAndQuantityByFilmId(filmId);
    }

}
