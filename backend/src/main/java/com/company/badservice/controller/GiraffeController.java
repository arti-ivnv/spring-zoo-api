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

import com.company.badservice.dto.GiraffeRequest;
import com.company.badservice.dto.GiraffeResponse;
import com.company.badservice.service.GiraffeService;

import lombok.RequiredArgsConstructor;

@RestController
// We need this to perform constructor innjection
@RequiredArgsConstructor
@RequestMapping("/animals")
public class GiraffeController {

    private final GiraffeService giraffeService;

    // ------ Giraffes -------

    @PostMapping("/create-giraffe")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> createGiraffe(@RequestBody GiraffeRequest giraffeRequest){
        giraffeService.createGiraffe(giraffeRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body("Giraffe was successfully created\n");
    }

    @GetMapping("/search-giraffe")
    @ResponseStatus(HttpStatus.OK)
    public List<GiraffeResponse> searchGiraffe(@RequestParam String name){
        return giraffeService.searchGiraffe(name);
    }

    @GetMapping ("/giraffe-secret")
    @ResponseStatus(HttpStatus.OK)
    public GiraffeResponse giraffeSecrete( @RequestParam Long id, @RequestParam String passcode){
        return giraffeService.giraffeSecrete(passcode, id);
    }

    @GetMapping("/get-giraffe")
    @ResponseStatus(HttpStatus.OK)
    public GiraffeResponse getGiraffe(@RequestParam Long id){
        return giraffeService.getGiraffe(id);
    }

    @DeleteMapping("/delete-giraffe")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteGiraffe(@RequestParam Long id){
        giraffeService.deleteGiraffe(id);
        return ResponseEntity.status(HttpStatus.OK).body("Giraffe was successfully deleted\n");
    }

    @PutMapping("/update-giraffe")
    @ResponseStatus(HttpStatus.OK)
    public GiraffeResponse updateGiraffe(@RequestParam String passcode, @RequestBody GiraffeRequest giraffeRequest){
        return giraffeService.updateGiraffe(passcode, giraffeRequest);
    }
    
}
