package com.example.mywildberries.controller;


import com.example.mywildberries.dto.request.OrderRequest;
import com.example.mywildberries.service.OrderService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class OrderController {
    OrderService orderController;
    ModelMapper modelMapper;

    @Autowired
    public OrderController(OrderService orderController, ModelMapper modelMapper) {
        this.orderController = orderController;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/createOrder")
    public HttpStatus createOrder(@RequestBody OrderRequest orderRequest) {
        return HttpStatus.OK;
    }

}