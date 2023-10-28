package com.example.mywildberries.model;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.util.List;


@Data
@Entity
@Table(name = "order_delivery")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    int id;

    @Column(name = "weight")
    int weight;

    @Column(name = "address_start")
    String addressStart;

    @Column(name = "address_end")
    String addressEnd;
}
