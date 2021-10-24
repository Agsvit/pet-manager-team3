package com.pet.manager.service;

import com.pet.manager.controller.request.PetCreationRequest;
import com.pet.manager.exception.DuplicatedPet;
import com.pet.manager.exception.PetNotFound;
import com.pet.manager.model.Feed;
import com.pet.manager.model.Pet;
import com.pet.manager.model.PetType;
import com.pet.manager.repository.PetRepository;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    private final PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public List<Pet> findAll() {
        return petRepository.findAll();
    }

    public Pet save(Pet pet) {
        try {
            return petRepository.save(pet);
        } catch (DuplicateKeyException exception){
            throw new DuplicatedPet();
        }
    }

    public Pet findById(String id) {
        return petRepository.findById(id).orElseThrow(PetNotFound::new);
    }

    public void deleteById(String id) {
        petRepository.deleteById(id);
    }

    public List<Pet> findByType(String type) {
        return petRepository.findByPetType(PetType.valueOf(type));
    }

    public Pet findByName(String name) {
        return petRepository.findByNameContaining(name).orElseThrow(PetNotFound::new);
    }

    public Pet update(String name, PetType type, String id) {
        Pet pet = this.findById(id);
        pet.setName(name);
        pet.setPetType(type);
        return this.save(pet);
    }

    public Pet addFeed(String id, Feed feed) {
        Pet pet = this.findById(id);
        pet.getFeedList().add(feed);
        return petRepository.save(pet);
    }

}
