package com.company.badservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.company.badservice.dto.ElephantResponse;
import com.company.badservice.dto.GiraffeResponse;
import com.company.badservice.dto.TigerResponse;
import com.company.badservice.dto.ZooRequest;
import com.company.badservice.dto.ZooResponse;
import com.company.badservice.exception.InvalidArgumentException;
import com.company.badservice.exception.ResourceNotFoundException;
import com.company.badservice.model.Elephant;
import com.company.badservice.model.Giraffe;
import com.company.badservice.model.Tiger;
import com.company.badservice.model.Zoo;
import com.company.badservice.repository.ElephantRepo;
import com.company.badservice.repository.GiraffeRepo;
import com.company.badservice.repository.TigerRepo;
import com.company.badservice.repository.ZooRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ZooService {

    private final TigerRepo tigerRepo;
    private final GiraffeRepo giraffeRepo;
    private final ElephantRepo elephantRepo;
    private final ZooRepo zooRepo;

    // ----- Zoo Service -----
    public void createZoo(ZooRequest zooRequest) {

        if((zooRepo.findById(zooRequest.getId())).isPresent()){
            throw new InvalidArgumentException("Id is occudied");
        }

        Zoo zoo = Zoo.builder()
                        .id(zooRequest.getId())
                        .name(zooRequest.getName())
                        .numberOfAnimals(0L)
                        .elephants(new ArrayList<Elephant>())
                        .giraffes(new ArrayList<Giraffe>())
                        .tigers(new ArrayList<Tiger>())
                        .build();

        zooRepo.save(zoo);
    }

    public List<ZooResponse> searchZoo(String name){
        List <Zoo> zoo = zooRepo.findByName(name);

        return zoo.stream().map(this::mapZooResponse).toList();
    }

    public ZooResponse getZoo(Long id){
        Zoo zoo = zooRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Zoo does not exist with id: " + id));

        return ZooResponse.builder()
                            .id(zoo.getId())
                            .name(zoo.getName())
                            .elephants(zoo.getElephantsStr())
                            .giraffes(zoo.getGiraffesStr())
                            .tigers(zoo.getTigersStr())
                            .numberOfAnimals(zoo.getNumberOfAnimals())
                            .build();
    }

    private ZooResponse mapZooResponse(Zoo zoo) {

        return ZooResponse.builder()
                            .id(zoo.getId())
                            .name(zoo.getName())
                            .elephants(zoo.getElephantsStr())
                            .giraffes(zoo.getGiraffesStr())
                            .tigers(zoo.getTigersStr())
                            .numberOfAnimals(zoo.getNumberOfAnimals())
                            .build();
    }

    public void deleteZoo(Long id){
        zooRepo.deleteById(id);
    }

    public void updateZoo(ZooRequest zooRequest){
        Zoo zoo = zooRepo.findById(zooRequest.getId()).orElseThrow(() -> new ResourceNotFoundException("Zoo does not exist with id: " + zooRequest.getId()));

        zoo.setName(zooRequest.getName());
        
        zooRepo.save(zoo);
    }

    public void placeTigerToZoo(Long zId, Long tId){
        Tiger tiger = tigerRepo.findById(tId).orElseThrow(() -> new ResourceNotFoundException("Tiger does not exist with id: " + tId));
        Zoo zoo = zooRepo.findById(zId).orElseThrow(() -> new ResourceNotFoundException("Zoo does not exist with id: " + zId));
        
        tiger.setZoo(zoo);

        List <Tiger> newTigers =  new ArrayList<Tiger>();
        newTigers.add(tiger);

        zoo.setNumberOfAnimals(zoo.getNumberOfAnimals() + 1);
        zoo.setTigers(newTigers);

        tigerRepo.save(tiger);
        zooRepo.save(zoo);
    }

    public void placeGiraffeToZoo(Long zId, Long gId){
        Giraffe giraffe = giraffeRepo.findById(gId).orElseThrow(() -> new ResourceNotFoundException("Giraffe does not exist with id: " + gId));
        Zoo zoo = zooRepo.findById(zId).orElseThrow(() -> new ResourceNotFoundException("Zoo does not exist with id: " + zId));
        
        giraffe.setZoo(zoo);

        List <Giraffe> newGiraffes =  new ArrayList<Giraffe>();
        newGiraffes.add(giraffe);

        zoo.setNumberOfAnimals(zoo.getNumberOfAnimals() + 1);
        zoo.setGiraffes(newGiraffes);

        giraffeRepo.save(giraffe);
        zooRepo.save(zoo);
    }

    public void placeElephantToZoo(Long zId, Long eId){
        Elephant elephant = elephantRepo.findById(eId).orElseThrow(() -> new ResourceNotFoundException("Elephant does not exist with id: " + eId));
        Zoo zoo = zooRepo.findById(zId).orElseThrow(() -> new ResourceNotFoundException("Zoo does not exist with id: " + zId));
        
        elephant.setZoo(zoo);

        List <Elephant> newElephants =  new ArrayList<Elephant>();
        newElephants.add(elephant);

        zoo.setNumberOfAnimals(zoo.getNumberOfAnimals() + 1);
        zoo.setElephants(newElephants);

        elephantRepo.save(elephant);
        zooRepo.save(zoo);
    }

    public void freeTiger(Long zId, Long tId){
        Tiger tiger = tigerRepo.findById(tId).orElseThrow(() -> new ResourceNotFoundException("Tiger does not exist with id: " + tId));
        Zoo zoo = zooRepo.findById(zId).orElseThrow(() -> new ResourceNotFoundException("Zoo does not exist with id: " + zId));
        
        tiger.setZoo(null);

        List <Tiger> newTigers = zoo.getTigers();
        
        if (!newTigers.remove(tiger)){throw new ResourceNotFoundException("There is no such tiger at the zoo");}

        zoo.setNumberOfAnimals(zoo.getNumberOfAnimals() - 1);
        zoo.setTigers(newTigers);

        tigerRepo.save(tiger);
        zooRepo.save(zoo);
    }

    public void freeGiraffe(Long zId, Long gId){
        Giraffe giraffe = giraffeRepo.findById(gId).orElseThrow(() -> new ResourceNotFoundException("Giraffe does not exist with id: " + gId));
        Zoo zoo = zooRepo.findById(zId).orElseThrow(() -> new ResourceNotFoundException("Zoo does not exist with id: " + zId));
        
        giraffe.setZoo(null);

        List <Giraffe> newGiraffes = zoo.getGiraffes();
        
        if (!newGiraffes.remove(giraffe)){throw new ResourceNotFoundException("There is no such giraffe at the zoo");}

        zoo.setNumberOfAnimals(zoo.getNumberOfAnimals() - 1);
        zoo.setGiraffes(newGiraffes);

        giraffeRepo.save(giraffe);
        zooRepo.save(zoo);
    }

    public void freeElephant(Long zId, Long eId){
        Elephant elephant = elephantRepo.findById(eId).orElseThrow(() -> new ResourceNotFoundException("Elephant does not exist with id: " + eId));
        Zoo zoo = zooRepo.findById(zId).orElseThrow(() -> new ResourceNotFoundException("Zoo does not exist with id: " + zId));
        
        elephant.setZoo(null);

        List <Elephant> newElephants = zoo.getElephants();
        
        if (!newElephants.remove(elephant)){throw new ResourceNotFoundException("There is no such elephant at the zoo");}

        zoo.setNumberOfAnimals(zoo.getNumberOfAnimals() - 1);
        zoo.setElephants(newElephants);

        elephantRepo.save(elephant);
        zooRepo.save(zoo);
    }

    public TigerResponse getLastTiger(Long zId){
        Zoo zoo = zooRepo.findById(zId).orElseThrow(() -> new ResourceNotFoundException("Zoo does not exist with id: " + zId));
        Tiger tiger = zoo.getLastTiger();

        return TigerResponse.builder()
                                .id(tiger.getId())
                                .name(tiger.getName())
                                .zoo_id((tiger.getZoo() != null) ? tiger.getZoo().getId() : -1)
                                .build();

    }

    public ElephantResponse getLastElephant(Long zId){
        Zoo zoo = zooRepo.findById(zId).orElseThrow(() -> new ResourceNotFoundException("Zoo does not exist with id: " + zId));
        Elephant elephant = zoo.getLastElephant();

        return ElephantResponse.builder()
                                .id(elephant.getId())
                                .name(elephant.getName())
                                .elephantName(elephant.getElephantName())
                                .elephantSurname(elephant.getElephantSurname())
                                .elephantAge(elephant.getElephantAge())
                                .zoo_id((elephant.getZoo() != null) ? elephant.getZoo().getId() : -1)
                                .build();

    }

    public GiraffeResponse getLastGiraffe(Long zId){
        Zoo zoo = zooRepo.findById(zId).orElseThrow(() -> new ResourceNotFoundException("Zoo does not exist with id: " + zId));
        Giraffe giraffe = zoo.getLastGiraffe();

        return GiraffeResponse.builder()
                                .id(giraffe.getId())
                                .name(giraffe.getName())
                                .secret(giraffe.getSecret())
                                .zoo_id((giraffe.getZoo() != null) ? giraffe.getZoo().getId() : -1)
                                .build();

    }
    

    public Long animalCount(Long id){ 
        Zoo zoo = zooRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Zoo does not exist with id: " + id));
        return zoo.getNumberOfAnimals();
    }
    
}
