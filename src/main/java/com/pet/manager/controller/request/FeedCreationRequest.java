package com.pet.manager.controller.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pet.manager.model.Feed;
import com.pet.manager.model.Pet;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class FeedCreationRequest {

    private String lunchTime;

    private String food;

    @JsonIgnore
    public Feed feedBuild() {
        return Feed
                .builder()
                .id(UUID.randomUUID().toString())
                .lunchTime(LocalTime.parse(this.getLunchTime()))
                .food(this.getFood())
                .build();
    }
}
