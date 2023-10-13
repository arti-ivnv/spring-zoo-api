package com.company.badservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.company.badservice.dto.TigerRequest;
import com.company.badservice.dto.TigerResponse;
import com.company.badservice.service.TigerService;

import lombok.RequiredArgsConstructor;

@RestController
// We need this to perform constructor innjection
@RequiredArgsConstructor
@RequestMapping("/animals")
public class TigerController {

    private final TigerService tigerService;


    // create tiger
    @PostMapping("/create-tiger")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> createTiger(@RequestBody TigerRequest tigerRequest){
        tigerService.createTiger(tigerRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body("Tiger was successfully created\n");
    }
  
    // get all the tigers
    @GetMapping("/tigers")
    @ResponseStatus(HttpStatus.OK)
    public List<TigerResponse> tigers(){
        return tigerService.getTigers();
    }

    // get the tiger by id
    @GetMapping("/search-tiger")
    @ResponseStatus(HttpStatus.OK)
    public TigerResponse searchTiger(@RequestParam Long id){
        return tigerService.searchTiger(id);
    }

    // delete the tiger by id
    @DeleteMapping("/delete-tiger")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteTiger(@RequestParam Long id){
        tigerService.deleteTiger(id);
        return ResponseEntity.status(HttpStatus.OK).body("Tiger was successfully deleted\n");
    }

    // update the tiger by id
    @PutMapping("/update-tiger")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> updateTiger(@RequestBody TigerRequest tigerRequest){
        tigerService.updateTiger(tigerRequest);
        return ResponseEntity.status(HttpStatus.OK).body("Tiger was successfully updated\n");
    }

}
