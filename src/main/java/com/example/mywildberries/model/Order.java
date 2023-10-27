package com.example.mywildberries.model;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.util.List;


@Data
@Entity
@Table(name = "order")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    int id;

    @Column(name = "weight")
    float weight;

    @Column(name = "adress_start")
    String addressStart;

    @Column(name = "adress_end")
    String addressEnd;
}
