package com.pet.manager.controller.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pet.manager.model.Pet;
import com.pet.manager.model.PetType;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PetCreationRequest {

    private PetType petType;

    private String name;


    @JsonIgnore
    public Pet petBuild() {
        return Pet.builder()
                .petType(this.getPetType())
                .name(this.getName())
                .build();
    }
}
