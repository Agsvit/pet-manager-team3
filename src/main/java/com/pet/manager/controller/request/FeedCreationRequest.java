package com.pet.manager.controller.request;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class FeedCreationRequest {

    private LocalDateTime lunchTime;

    private String food;

}
