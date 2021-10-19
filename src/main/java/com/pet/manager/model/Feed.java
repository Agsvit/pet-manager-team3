package com.pet.manager.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Feed {

    @Id
    private String id;

    private LocalDateTime lunchTime;

//    @OneToOne
    private Food food;

//    @OneToOne
    private Pet pet;
}