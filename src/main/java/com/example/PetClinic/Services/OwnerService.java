package com.example.PetClinic.Services;

import com.example.PetClinic.model.Owner;
import com.example.PetClinic.Repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {

    private final OwnerRepository repository;

    @Autowired
    public OwnerService(OwnerRepository repository) {
        this.repository = repository;
    }

    public Owner getOwnerById(Long ownerId) {
        return repository.findById(ownerId).orElse(null);
    }

    public List<Owner> getAllOwners() {
        return repository.findAll();
    }

    public Owner saveOwner(Owner owner) {
        return repository.save(owner);
    }
}
