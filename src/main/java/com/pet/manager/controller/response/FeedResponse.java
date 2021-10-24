package com.pet.manager.controller.response;

import com.pet.manager.model.Food;
import lombok.*;

import java.time.LocalTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FeedResponse {
    private String id;
    private LocalTime lunchtime;
    private String food;
}
