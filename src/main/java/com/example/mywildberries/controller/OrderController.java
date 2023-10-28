package com.example.mywildberries.controller;


import com.example.mywildberries.dto.request.OrderRequest;
import com.example.mywildberries.dto.response.OrderResponse;
import com.example.mywildberries.model.Order;
import com.example.mywildberries.service.OrderService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class OrderController {
    OrderService orderService;
    ModelMapper modelMapper;
    RestTemplate template;

    @Autowired
    public OrderController(OrderService orderService, ModelMapper modelMapper, RestTemplate template) {
        this.orderService = orderService;
        this.modelMapper = modelMapper;
        this.template = template;
    }

    @GetMapping("/hello")
    public String printHello() {
        return "Hello";
    }
    @PostMapping("/wildberries_orders")
    public ResponseEntity<HttpStatus> addOrder(@RequestBody OrderRequest request) {
        Order order = orderService.save(modelMapper.map(request,Order.class));


        OrderResponse response = modelMapper.map(order, OrderResponse.class);
        template.postForObject(
                "http://localhost:8082/create_tracker", response, Integer.class );

        return new ResponseEntity<>( HttpStatus.OK);
    }




}