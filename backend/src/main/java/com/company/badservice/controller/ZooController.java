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

import com.company.badservice.dto.ElephantResponse;
import com.company.badservice.dto.GiraffeResponse;
import com.company.badservice.dto.TigerResponse;
import com.company.badservice.dto.ZooRequest;
import com.company.badservice.dto.ZooResponse;
import com.company.badservice.service.ZooService;

import lombok.RequiredArgsConstructor;

@RestController
// We need this to perform constructor innjection
@RequiredArgsConstructor
@RequestMapping("/zoo")
public class ZooController {

    private final ZooService zooService;

    // ------ Zoo -------

    @PostMapping("/create-zoo")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> createZoo(@RequestBody ZooRequest zooRequest){
        zooService.createZoo(zooRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body("Zoo was successfully created\n");
    }

    @GetMapping("/search-zoo")
    @ResponseStatus(HttpStatus.OK)
    public List<ZooResponse> searchZoo(@RequestParam String name) {
        return zooService.searchZoo(name);
    }

    @GetMapping("/get-zoo")
    @ResponseStatus(HttpStatus.OK)
    public ZooResponse getZoo(@RequestParam Long id) {
        return zooService.getZoo(id);
    }

    @DeleteMapping("/delete-zoo")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteZoo(@RequestParam Long id){
        zooService.deleteZoo(id);
        return ResponseEntity.status(HttpStatus.OK).body("Zoo was successfully deleted\n");
    }

    @PutMapping("/update-zoo")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> updateZoo(@RequestBody ZooRequest zooRequest){
        zooService.updateZoo(zooRequest);
        return ResponseEntity.status(HttpStatus.OK).body("Zoo was successfully updated\n");
    }

    @PutMapping("/place-tiger")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> placeTiger(@RequestParam Long zid, @RequestParam Long tid){
        zooService.placeTigerToZoo(zid, tid);
        return ResponseEntity.status(HttpStatus.OK).body("Tiger was successfully placed to zoo\n");
    }

    @PutMapping("/place-giraffe")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> placeGiraffe(@RequestParam Long zid, @RequestParam Long gid){
        zooService.placeGiraffeToZoo(zid, gid);
        return ResponseEntity.status(HttpStatus.OK).body("Giraffe was successfully placed to zoo\n");
    }

    @PutMapping("/place-elephant")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> placeElephant(@RequestParam Long zid, @RequestParam Long eid){
        zooService.placeElephantToZoo(zid, eid);
        return ResponseEntity.status(HttpStatus.OK).body("Elephant was successfully placed to zoo\n");
    }

    @PutMapping("/free-elephant")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> freeElephant(@RequestParam Long zid, @RequestParam Long eid){
        zooService.freeElephant(zid, eid);
        return ResponseEntity.status(HttpStatus.OK).body("Elephant was successfully removed from the zoo\n");
    }

    @PutMapping("/free-tiger")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> freeTiger(@RequestParam Long zid, @RequestParam Long tid){
        zooService.freeTiger(zid, tid);
        return ResponseEntity.status(HttpStatus.OK).body("Tiger was successfully removed from the zoo\n");
    }

    @PutMapping("/free-giraffe")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> freeGiraffe(@RequestParam Long zid, @RequestParam Long gid){
        zooService.freeGiraffe(zid, gid);
        return ResponseEntity.status(HttpStatus.OK).body("Giraffe was successfully removed from the zoo\n");
    }

    @GetMapping("/animal-count")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> animalCount(@RequestParam Long zid){
        Long animalsAmount = zooService.animalCount(zid);
        return ResponseEntity.status(HttpStatus.OK).body("There are " + animalsAmount + " animals in zoo with id: " + zid + "\n");
    }

    @GetMapping("/zoo-last-tiger")
    @ResponseStatus(HttpStatus.OK)
    public TigerResponse getTheLastTiger(@RequestParam Long zid){
        return zooService.getLastTiger(zid);
    }

    @GetMapping("/zoo-last-giraffe")
    @ResponseStatus(HttpStatus.OK)
    public GiraffeResponse getTheLastGiraffe(@RequestParam Long zid){
        return zooService.getLastGiraffe(zid);
    }

    @GetMapping("/zoo-last-elephant")
    @ResponseStatus(HttpStatus.OK)
    public ElephantResponse getTheLastElephant(@RequestParam Long zid){
        return zooService.getLastElephant(zid);
    }
    
}
