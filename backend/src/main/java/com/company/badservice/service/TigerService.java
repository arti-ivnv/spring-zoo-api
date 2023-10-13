package com.company.badservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.company.badservice.dto.TigerRequest;
import com.company.badservice.dto.TigerResponse;
import com.company.badservice.exception.InvalidArgumentException;
import com.company.badservice.exception.ResourceNotFoundException;
import com.company.badservice.model.Tiger;
import com.company.badservice.repository.TigerRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TigerService {

    private final TigerRepo tigerRepo;
    
    public void createTiger(TigerRequest tigerRequest){

        if((tigerRepo.findById(tigerRequest.getId())).isPresent()){
            throw new InvalidArgumentException("Id is occudied");
        }

        Tiger tiger = Tiger.builder()
                                .id(tigerRequest.getId())
                                .name(tigerRequest.getName())
                                .build();
        tigerRepo.save(tiger);
    }

    public List<TigerResponse> getTigers(){
        List <Tiger> tigers = tigerRepo.findAll();
        return tigers.stream().map(this::mapTigerResponse).toList();
    }

    private TigerResponse mapTigerResponse(Tiger tiger){
        return TigerResponse.builder()
                                .id(tiger.getId())
                                .name(tiger.getName())
                                .zoo_id((tiger.getZoo() != null) ? tiger.getZoo().getId() : -1)
                                .build();
    }

    public TigerResponse searchTiger(Long id) {
        Tiger tiger = tigerRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Tiger does not exist with id: " + id));
        return TigerResponse.builder()
                                .id(tiger.getId())
                                .name(tiger.getName())
                                .zoo_id((tiger.getZoo() != null) ? tiger.getZoo().getId() : -1)
                                .build();
    }

    public void deleteTiger(Long id){
        tigerRepo.deleteById(id);
    }

    public void updateTiger(TigerRequest tigerRequest){
        Tiger updateTiger = tigerRepo.findById(tigerRequest.getId()).orElseThrow(() -> new ResourceNotFoundException("Tiger does not exist with id: " + tigerRequest.getId()));
        
        updateTiger.setName(tigerRequest.getName());
        tigerRepo.save(updateTiger);
    }
}
