package com.pet.manager.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Pet {

    @Id
    private  String id;

    @Indexed
//    @Enumerated(EnumType.ORDINAL)
    private PetType petType;

    @Indexed(unique = true)
    private String petName;

}
