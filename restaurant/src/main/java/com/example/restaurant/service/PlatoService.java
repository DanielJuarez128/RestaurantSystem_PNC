package com.example.restaurant.service;

import com.example.restaurant.dto.request.PlatoDTORequest;
import com.example.restaurant.dto.response.PlatoDTOResponse;
import com.example.restaurant.entity.Plato;
import com.example.restaurant.repository.PlatoRepository;
import com.example.restaurant.utils.PlatoMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlatoService {
    private final PlatoRepository repository;
    public PlatoService(PlatoRepository repository){
        this.repository = repository;
    }

    public void createPlato(PlatoDTORequest plato){
        repository.save(PlatoMapper.toEntity(plato));
    }

    public PlatoDTOResponse findPlatoById(int id){
        return PlatoMapper.toResponse(repository.findById(id).get());
    }

    public void deletePlatoById(int id){
        repository.deleteById(id);
    }

    public List<Plato> findAllPlato(){
        return repository.findAll();
    }

    public void updatePlato(int id, PlatoDTORequest plato){
        Plato platoToUpdate = PlatoMapper.toEntity(plato);
        if (repository.existsById(id)){
            platoToUpdate.setId(id);
        }
        repository.save(platoToUpdate);
    }

}
