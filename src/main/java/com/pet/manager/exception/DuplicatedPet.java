package com.pet.manager.exception;

public class DuplicatedPet extends RuntimeException {

    public DuplicatedPet() {
        super("Duplicated Pet");     }

    public DuplicatedPet(String message) {
        super(message);
    }
}
