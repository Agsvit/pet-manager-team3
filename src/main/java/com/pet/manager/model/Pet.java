package com.pet.manager.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Pet {

    @Id
    private  String id;

    @Enumerated(EnumType.ORDINAL)
    private PetType petType;

    private String petName;


}
