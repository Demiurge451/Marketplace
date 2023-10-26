package com.example.mywildberries.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Table(name = "user")
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    Integer id;

    @Column(name = "name")
    String name;
    @Column(name = "password")
    String password;

    @OneToMany(mappedBy = "owner")
    List<Order> orders;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    @Override
    public String toString(){
        return "";
    }


}