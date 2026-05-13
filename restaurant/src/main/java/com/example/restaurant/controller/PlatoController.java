package com.example.restaurant.controller;

import com.example.restaurant.dto.GeneralResponse;
import com.example.restaurant.dto.request.PlatoDTORequest;
import com.example.restaurant.dto.response.PlatoDTOResponse;
import com.example.restaurant.service.PlatoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/menu")
@AllArgsConstructor
public class PlatoController {

    private final PlatoService platoService;

    @GetMapping("/")
    public ResponseEntity<GeneralResponse> findAll(){
        return ResponseEntity.ok(GeneralResponse.builder()
                .data(platoService.findAllPlato())
                .message("All platos found")
                .build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GeneralResponse> getPlatoById(@PathVariable int id) {
        return ResponseEntity.ok(GeneralResponse.builder()
                .data(platoService.findPlatoById(id))
                .message("Plato found with id: " + id)
                .build());
    }

    @PostMapping("/")
    public ResponseEntity<GeneralResponse> createPlato(@RequestBody PlatoDTORequest plato) {
        platoService.createPlato(plato);
        return ResponseEntity.ok(GeneralResponse.builder()
                .data(plato)
                .message("Plato has been created")
                .build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<GeneralResponse> updatePlato(@PathVariable int id,@RequestBody PlatoDTORequest plato) {
        platoService.updatePlato(id, plato);
        return ResponseEntity.ok(GeneralResponse.builder()
                .data(plato)
                .message("Plato has been updated")
                .build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GeneralResponse> deletePlato(@PathVariable int id) {
        PlatoDTOResponse platoToDeleted = platoService.findPlatoById(id);
        platoService.deletePlatoById(id);
        return ResponseEntity.ok(GeneralResponse.builder()
                .data(platoToDeleted)
                .message("Plato has been deleted")
                .build());
    }

}
