package com.paymentchain.films.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Timer;

@Data
@Entity
public class FilmEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
    private String description;
    private Date year;
    private Integer rentalDuration;
    private Integer rating;
    private Integer duration;
    private Double rentalPrice;

}
