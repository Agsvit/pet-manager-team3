package com.pet.manager.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
public class AuthorResponse {
    private String firstName;
    private String lastName;
    private int age;
}
