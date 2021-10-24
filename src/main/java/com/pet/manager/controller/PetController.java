package com.pet.manager.controller;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pet.manager.controller.request.FeedCreationRequest;
import com.pet.manager.controller.request.PetCreationRequest;
import com.pet.manager.controller.response.FeedResponse;
import com.pet.manager.controller.response.PetResponse;
import com.pet.manager.model.Feed;
import com.pet.manager.model.Pet;
import com.pet.manager.service.PetService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    public List<PetResponse> petResponses(List<Pet> pets) {
        List<PetResponse> petResponses = new ArrayList<>();
        for (Pet pet : pets) {petResponses.add(pet.petResponse());}
        return petResponses;
    }

    @GetMapping("/pets")
    public List<PetResponse> getPets() {
        return this.petResponses(petService.findAll());
    }

    @GetMapping("/pets/{id}")
    public PetResponse getPetById(@PathVariable(value = "id") String id) {
        return petService.findById(id).petResponse();
    }

    @GetMapping("/pets-by-type")
    public List<PetResponse> getPetByType(@RequestParam String type) {
        return this.petResponses(petService.findByType(type));
    }

    @GetMapping("/pets-by-name")
    public PetResponse getPetByName(@RequestParam String name) {
        return petService.findByName(name).petResponse();
    }

    @PostMapping(value = "/pets", consumes = "application/json", produces = "application/json")
    public PetResponse createPet(@RequestBody PetCreationRequest petReq) {
        return petService.save(petReq.petBuild()).petResponse();
    }

    @PostMapping(value = "/feeds/pets/{petId}")
    public PetResponse addFeed(@PathVariable(value = "petId") String petId, @RequestBody FeedCreationRequest feedReq) {
        return petService.addFeed(petId, feedReq.feedBuild()).petResponse();
    }

    @PutMapping(value = "/pets-update")
    public PetResponse updatePet(@RequestBody String id,  PetCreationRequest petReq) {
        return petService.update(petReq.getName(),petReq.getPetType(),id).petResponse();
    }

    @DeleteMapping(value = "/pets-delete")
    public void deletePet(@RequestBody String id) {
        petService.deleteById(id);
    }


}


