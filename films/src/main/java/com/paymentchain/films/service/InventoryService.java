package com.paymentchain.films.service;

import com.paymentchain.films.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    public List<Object[]> findStoreAddressAndQuantityByFilmId(Integer filmId) {
        return inventoryRepository.findStoreAddressAndQuantityByFilmId(filmId);
    }

}
