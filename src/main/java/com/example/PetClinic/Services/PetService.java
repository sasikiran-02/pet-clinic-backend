package com.example.PetClinic.Services;

import com.example.PetClinic.model.Pet;
import com.example.PetClinic.Repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    public List<Pet> getPetsByOwnerId(Long ownerId) {
        return petRepository.findByOwnerId(ownerId);
    }

    public Pet getPetById(Long id) {
        return petRepository.findById(id).orElse(null);
    }
    public Pet savePet(Pet pet) {
        return petRepository.save(pet);
    }
}
