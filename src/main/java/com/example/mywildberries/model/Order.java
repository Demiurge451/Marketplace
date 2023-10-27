package com.example.mywildberries.model;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Data
@Entity
@Table(name = "order")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    int id;

    @Column
    int weight;

    @OneToMany(mappedBy = "order_owner")
    List<Item> items;

    public Order() throws IOException {
        RestTemplate template = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
        Map<String, String> vars = Collections.singletonMap("hotel", "42");
        String result = restTemplate.getForObject(
                "https://example.com/hotels/{hotel}/rooms/{hotel}", String.class, vars);
        Person person = restTemplate.getForObject("https://example.com/people/{id}", Person.class, 42);
    }
}
