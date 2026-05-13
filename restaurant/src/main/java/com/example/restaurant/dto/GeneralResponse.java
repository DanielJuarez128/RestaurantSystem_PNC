package com.example.restaurant.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class GeneralResponse {
    Object data;
    String message;
}