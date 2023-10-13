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

import com.company.badservice.dto.ElephantRequest;
import com.company.badservice.dto.ElephantResponse;
import com.company.badservice.service.ElephantService;

import lombok.RequiredArgsConstructor;

@RestController
// We need this to perform constructor innjection
@RequiredArgsConstructor
@RequestMapping("/animals")
public class ElephantController {

    private final ElephantService elephantService;
    
    // create elephant
    @PostMapping("/create-elephant")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> createElephant(@RequestBody ElephantRequest elephantRequest) {
        elephantService.createElephant(elephantRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body("Elephant was successfully created\n");
    }

    // get all the elephants
    @GetMapping("/elephant")
    @ResponseStatus(HttpStatus.OK)
    public List<ElephantResponse> getElephants() {
        return elephantService.getElephants();
    }

    // get the elephats with a specified name 
    @GetMapping("/search-elephant")
    @ResponseStatus(HttpStatus.OK)
    public List<ElephantResponse> searchElephant(@RequestParam String name) {
        return elephantService.searchElephant(name);
    }

    @GetMapping("/get-elephant-age-h")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> agehElephant(@RequestParam Long id) {
        double result = elephantService.getElephantAgeInHours(id);
        return ResponseEntity.status(HttpStatus.OK).body("Elephant with id: "+id+" is alive for "+ result +" hours\n");
    }

    @GetMapping("/get-elephant")
    @ResponseStatus(HttpStatus.OK)
    public ElephantResponse getElephant(@RequestParam Long id){
        return elephantService.getElephant(id);
    }

    // delete the elephant by id
    @DeleteMapping("/delete-elephant")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteElephant(@RequestParam Long id){
        elephantService.deleteElephant(id);
        return ResponseEntity.status(HttpStatus.OK).body("Elephant was successfully deleted\n");
    }

    // update the elephant by id
    @PutMapping("/update-elephant")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> updateElephant(@RequestBody ElephantRequest elephantRequest){
        elephantService.updateElephant(elephantRequest);
        return ResponseEntity.status(HttpStatus.OK).body("Elephant was successfully updated\n");
    }


}
