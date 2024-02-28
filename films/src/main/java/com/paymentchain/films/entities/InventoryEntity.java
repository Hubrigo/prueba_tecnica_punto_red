package com.paymentchain.films.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class InventoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer inventoryId;
    private Integer filmId;
    private Integer storeId;
    private Integer quantity;


}
