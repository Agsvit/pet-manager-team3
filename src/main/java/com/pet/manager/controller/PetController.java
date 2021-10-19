package com.pet.manager.controller;


import com.pet.manager.controller.request.PetCreationRequest;
import com.pet.manager.model.Pet;
import com.pet.manager.service.PetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping("/pets")
    public List<Pet> getPets(@RequestParam String type) {
        // -> Not unique index on type attribute which is not unique
        // -> Create A unique index on the Name field
        // -> CommandLineRunnerBean
        // -> Map the exception of having multiple names to a 409(CONFLICT statusCode)
        /*
            try {
                insert
            } catch(IndexViolationException e){
                throw new DuplicatedPetException() -> Exception handler to 409
            }
         */
        List<Pet> pets = petService.findAll();
        System.out.println(type);
        return pets;
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
}
