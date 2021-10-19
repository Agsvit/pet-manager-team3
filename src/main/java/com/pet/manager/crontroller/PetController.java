package com.pet.manager.crontroller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class PetController {

    @GetMapping("/pets")
    public ResponseEntity<List<String>> getPets(@RequestParam String type) {
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
        System.out.println(type);
        return ResponseEntity.ok(Collections.emptyList());
    }
}
