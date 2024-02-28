package com.paymentchain.films.repository;

import com.paymentchain.films.entities.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InventoryRepository extends JpaRepository<InventoryEntity,Integer> {

    @Query("SELECT s.address, i.quantity FROM InventoryEntity i INNER JOIN StoreEntity s ON i.storeId = s.storeId WHERE i.filmId = :filmId")
    List<Object[]> findStoreAddressAndQuantityByFilmId(@Param("filmId") Integer filmId);

}
