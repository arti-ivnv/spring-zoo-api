package com.company.badservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.badservice.dto.GiraffeRequest;
import com.company.badservice.dto.GiraffeResponse;
import com.company.badservice.exception.InvalidArgumentException;
import com.company.badservice.exception.ResourceNotFoundException;
import com.company.badservice.exception.WrongCredentialsException;
import com.company.badservice.model.Giraffe;
import com.company.badservice.repository.GiraffeRepo;
import com.company.badservice.utils.crypt.CryptoService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GiraffeService {

    @Autowired
    private CryptoService cryptoService;

    private final GiraffeRepo giraffeRepo;

    private static final String PASSCODE = "qwerty123";


    public void createGiraffe(GiraffeRequest giraffeRequest) {

        if((giraffeRepo.findById(giraffeRequest.getId())).isPresent()){
            throw new InvalidArgumentException("Id is occudied");
        }

        Giraffe giraffe = Giraffe.builder()
                                    .id(giraffeRequest.getId())
                                    .name(giraffeRequest.getName())
                                    .secret(cryptoService.encrypt(
                                        (giraffeRequest.getSecret().length() != 0) ? giraffeRequest.getSecret() : " ")
                                        )
                                    .build();
        giraffeRepo.save(giraffe);
    }

    public List<GiraffeResponse> searchGiraffe(String name) {
        List <Giraffe> giraffes = giraffeRepo.findByName(name);

        return giraffes.stream().map(this::mapGiraffeResponse).toList();
    }

    private GiraffeResponse mapGiraffeResponse(Giraffe giraffe){
        return GiraffeResponse.builder()
                                .id(giraffe.getId())
                                .name(giraffe.getName())
                                .secret(giraffe.getSecret())
                                .zoo_id((giraffe.getZoo() != null) ? giraffe.getZoo().getId() : -1)
                                .build();
    }

    public GiraffeResponse giraffeSecrete(String passcode, Long  id) {
        Giraffe giraffe = giraffeRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Tiger does not exist with id: " + id));

        if(passcode.compareTo(PASSCODE) != 0){
            throw new WrongCredentialsException("Wrong passcode");
        }

        return GiraffeResponse.builder()
                                .id(giraffe.getId())
                                .name(giraffe.getName())
                                .secret(cryptoService.decrypt(giraffe.getSecret()))
                                .zoo_id((giraffe.getZoo() != null) ? giraffe.getZoo().getId() : -1)
                                .build();
    }

    public GiraffeResponse getGiraffe(Long id) {
        Giraffe giraffe = giraffeRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Giraffe does not exist with id: " + id));
        return GiraffeResponse.builder()
                                .id(giraffe.getId())
                                .name(giraffe.getName())
                                .secret(giraffe.getSecret())
                                .zoo_id((giraffe.getZoo() != null) ? giraffe.getZoo().getId() : -1)
                                .build();
    }

    public void deleteGiraffe(Long id) {
        giraffeRepo.deleteById(id);
    }

    public GiraffeResponse updateGiraffe(String passcode, GiraffeRequest giraffeRequest) {
        Giraffe updateGiraffe = giraffeRepo.findById(giraffeRequest.getId()).orElseThrow(() -> new ResourceNotFoundException("Tiger does not exist with id: " + giraffeRequest.getId()));

        if(passcode.compareTo(PASSCODE) != 0){
            throw new WrongCredentialsException("Wrong passcode");
        }

        updateGiraffe.setName(giraffeRequest.getName());
        updateGiraffe.setSecret(cryptoService.encrypt(
                                                (giraffeRequest.getSecret().length() != 0) ? giraffeRequest.getSecret() : " ")
                                                );

        giraffeRepo.save(updateGiraffe);

        // no id
        return GiraffeResponse.builder()
                                .id(updateGiraffe.getId())
                                .name(updateGiraffe.getName())
                                .secret(updateGiraffe.getSecret())
                                .zoo_id((updateGiraffe.getZoo() != null) ? updateGiraffe.getZoo().getId() : -1)
                                .build();
    } 

}
