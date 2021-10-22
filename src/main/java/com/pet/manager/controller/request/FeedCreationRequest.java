package com.pet.manager.controller.request;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class FeedCreationRequest {

    private String lunchTime;

    private String food;

}
