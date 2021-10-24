package com.pet.manager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pet.manager.controller.request.PetCreationRequest;
import com.pet.manager.controller.response.FeedResponse;
import com.pet.manager.controller.response.PetResponse;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Pet {

    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    @Indexed
    private PetType petType;
    private List<Feed> feedList = new ArrayList<>();

    @JsonIgnore
    public PetResponse petResponse() {
        List<FeedResponse> feedResponseList = new ArrayList<>();
        if (this.feedList!=null && !this.feedList.isEmpty()) {
            for(Feed feed: this.feedList) {
                feedResponseList.add(new FeedResponse(
                        feed.getId(),
                        feed.getLunchTime(),
                        feed.getFood()));
            }
        }
        return new PetResponse(
                this.getId(),
                this.getName(),
                this.getPetType(),
                feedResponseList);
    }

    @JsonIgnore
    public List<PetResponse> petResponses(List<Pet> pets) {
        List<PetResponse> petResponses = new ArrayList<>();
        for (Pet pet : pets) {
            List<FeedResponse> feedResponseList = new ArrayList<>();
            if (this.feedList != null && !this.feedList.isEmpty()) {
                for (Feed feed : this.feedList) {
                    feedResponseList.add(new FeedResponse(
                            feed.getId(),
                            feed.getLunchTime(),
                            feed.getFood()));
                }
            }
            petResponses.add(new PetResponse(
                    this.getId(),
                    this.getName(),
                    this.getPetType(),
                    feedResponseList));
        }
        return petResponses;
    }
}
