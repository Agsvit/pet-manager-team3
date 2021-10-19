package com.pet.manager.controller.request;

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

    private String petName;

}
