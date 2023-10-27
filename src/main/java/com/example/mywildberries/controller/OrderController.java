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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class OrderController {
    OrderService orderService;
    ModelMapper modelMapper;

    @Autowired
    public OrderController(OrderService orderService, ModelMapper modelMapper) {
        this.orderService = orderService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/wildberries_orders")
    public ResponseEntity<HttpStatus> addOrder(@RequestBody @Valid OrderRequest request) {
        Order order = orderService.save(modelMapper.map(request, Order.class));

        RestTemplate template = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
        OrderResponse response = modelMapper.map(order, OrderResponse.class);
        template.postForObject(
                "https://localhost:8080/create_tracker", response, String.class );

        return new ResponseEntity<>( HttpStatus.OK);
    }




}