package com.pet.manager.controller;


import com.pet.manager.controller.request.FeedCreationRequest;
import com.pet.manager.controller.request.PetCreationRequest;
import com.pet.manager.model.Feed;
import com.pet.manager.model.Pet;
import com.pet.manager.service.PetService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping("/pets")
    public List<Pet> getPets() {
        return petService.findAll();
    }

    @GetMapping("/pets")
    public Pet getPetById(@RequestBody String id) {
        return petService.findById(id);
    }

    @GetMapping("/pets")
    public List<Pet> getPetByType(@RequestParam String type) {
        return petService.findByType(type);
    }

    @GetMapping("/pets/{name}")
    public Pet getPetByName(@PathVariable(value = "name") String name) {
        return petService.findByName(name);
    }

    @PostMapping(value = "/pets", consumes = "application/json", produces = "application/json")
    public Pet createPet(@RequestBody PetCreationRequest petReq) {
        Pet newPet = Pet
                .builder()
                .petType(petReq.getPetType())
                .petName(petReq.getPetName())
                .build();
        petService.save(newPet);
        return newPet;
    }

    @PutMapping(value = "/pets/{id}")
    public Pet updatePet(@PathVariable(value = "id") String id, @RequestBody PetCreationRequest petReq) {
        return petService.update(petReq, id);
    }

    @PutMapping(value = "/pets")
    public Pet addFeed(@RequestBody String id, FeedCreationRequest feedReq) {
        Feed feed = Feed
                .builder()
                .lunchTime(feedReq.getLunchTime())
                .food(feedReq.getFood())
                .build();
        return petService.addFeed(id, feed);
    }

    @DeleteMapping(value = "/pets/{id}")
    public void deletePet(String id) {
        petService.deleteById(id);
    }


}


