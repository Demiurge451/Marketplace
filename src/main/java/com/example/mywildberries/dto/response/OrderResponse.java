package com.example.mywildberries.dto.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderResponse {
    String addressStart;
    String addressEnd;
    float startLat;
    float startLon;
    float endLat;
    float endLon;
}
