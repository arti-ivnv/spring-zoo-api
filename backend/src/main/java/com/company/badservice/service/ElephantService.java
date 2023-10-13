package com.company.badservice.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.company.badservice.dto.ElephantRequest;
import com.company.badservice.dto.ElephantResponse;
import com.company.badservice.exception.InvalidArgumentException;
import com.company.badservice.exception.ResourceNotFoundException;
import com.company.badservice.model.Elephant;
import com.company.badservice.repository.ElephantRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ElephantService {

    private final ElephantRepo elephantRepo;

    private HashMap<Long, Elephant> elephantCache = new HashMap<Long, Elephant>();

    // ----- Elephants Service -----
    public void createElephant(ElephantRequest elephantRequest){

        if((elephantRepo.findById(elephantRequest.getId())).isPresent()){
            throw new InvalidArgumentException("Id is occudied");
        }

        Elephant elephant = Elephant.builder()
                                    .id(elephantRequest.getId())
                                    .name(elephantRequest.getName())
                                    .elephantAge(elephantRequest.getElephantAge())
                                    .build();


        elephantCache.put(elephant.getId(), elephant);
        elephantRepo.save(elephant);

    }

    public List<ElephantResponse> getElephants(){

        List<Elephant> elephants = elephantRepo.findAll();

        return elephants.stream().map(this::mapToElephantResponse).toList();
    }

    public ElephantResponse getElephant(Long id){

        Elephant elephant = elephantRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Elephant does not exist with id: " + id));

        return ElephantResponse.builder()
                                .id(elephant.getId())
                                .name(elephant.getName())
                                .elephantName(elephant.getElephantName())
                                .elephantSurname(elephant.getElephantSurname())
                                .elephantAge(elephant.getElephantAge())
                                .zoo_id((elephant.getZoo() != null) ? elephant.getZoo().getId() : -1)
                                .build();
    }

    public List<ElephantResponse> searchElephant(String name){

        List<Elephant> elephants = elephantRepo.findByName(name);

        return elephants.stream().map(this::mapToElephantResponse).toList();
    }

    public void deleteElephant(Long id) {
        elephantCache.remove(id);
        elephantRepo.deleteById(id);
    }

    public void updateElephant(ElephantRequest elephantRequest) {
        
        Elephant updateElephant = elephantRepo.findById(elephantRequest.getId()).orElseThrow(() -> new ResourceNotFoundException("Elephant does not exist with id: " + elephantRequest.getId()));
        
        updateElephant.setName(elephantRequest.getName());
        updateElephant.setElephantAge(elephantRequest.getElephantAge());

        elephantRepo.save(updateElephant);
        
    }

     // Helper method Elephant object to ElephantResponse object.
    private ElephantResponse mapToElephantResponse(Elephant elephant){
        return ElephantResponse.builder()
                                .id(elephant.getId())
                                .name(elephant.getName())
                                .elephantName(elephant.getElephantName())
                                .elephantSurname(elephant.getElephantSurname())
                                .elephantAge(elephant.getElephantAge())
                                .zoo_id((elephant.getZoo() != null) ? elephant.getZoo().getId() : -1)
                                .build();
        
    }


    public double getElephantAgeInHours(Long id){
        Elephant elephant = elephantRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Elephant does not exist with id: " + id));
        
        return elephant.getElephantAgeInHours();
    }
}
