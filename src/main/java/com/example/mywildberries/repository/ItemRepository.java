package com.example.mywildberries.repository;


import com.example.mywildberries.model.Item;
import com.example.mywildberries.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

}

