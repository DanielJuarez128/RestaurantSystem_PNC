package com.example.restaurant.utils;


import com.example.restaurant.dto.request.PlatoDTORequest;
import com.example.restaurant.dto.response.PlatoDTOResponse;
import com.example.restaurant.entity.Plato;

public class PlatoMapper {
    public static Plato toEntity(PlatoDTORequest platoDTORequest){
        return Plato.builder()
                .name(platoDTORequest.name())
                .description(platoDTORequest.description())
                .price(platoDTORequest.price())
                .avalible(platoDTORequest.avalible())
                .build();
    }

    public static PlatoDTOResponse toResponse(Plato plato){
        return new PlatoDTOResponse(
                plato.getName(),
                plato.getDescription(),
                plato.getPrice()
        );
    }
}
