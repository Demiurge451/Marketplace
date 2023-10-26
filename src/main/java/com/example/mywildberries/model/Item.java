package com.example.mywildberries.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Entity
@Table(name = "item")
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    Integer id;

    @Column(name = "name")
    String name;

    @Column(name = "weight")
    float weight;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    Order order_owner;
}