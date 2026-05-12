package com.example.restaurant.dto.request;

import lombok.Builder;

@Builder
public record PlatoDTORequest(
        String name,
        String description,
        double price,
        boolean avalible
){

}