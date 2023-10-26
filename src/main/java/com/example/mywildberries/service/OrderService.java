package com.example.mywildberries.service;

import com.example.mywildberries.model.Order;
import com.example.mywildberries.repository.OrderRepository;
import com.example.mywildberries.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class OrderService {

    OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository repository) {
        this.orderRepository = repository;
    }


    public List<Order> getListOfOrders() {
        return orderRepository.findAll();
    }

    public Order findById(int id) {
        return orderRepository.getReferenceById(id);
    }

    @Transactional
    public void save(Order item) {
        orderRepository.save(item);
    }

    @Transactional
    public void delete(int id) {
        orderRepository.delete(findById(id));
    }
}
