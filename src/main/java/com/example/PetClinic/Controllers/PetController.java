package com.example.PetClinic.Controllers;

import com.example.PetClinic.DTO.PetDTO;
import com.example.PetClinic.model.Pet;
import com.example.PetClinic.model.Owner;
import com.example.PetClinic.Services.PetService;
import com.example.PetClinic.Services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
@CrossOrigin(origins = "*")
public class PetController {

    @Autowired
    private PetService petService;

    @Autowired
    private OwnerService ownerService;

    // Endpoint to add a new pet for an owner
    @PostMapping("/add")
    public ResponseEntity<Pet> addPet(@RequestBody PetDTO petDTO) {
        Owner owner = ownerService.getOwnerById(petDTO.getOwnerId());
        if (owner == null) {
            return ResponseEntity.badRequest().body(null);
        }

        Pet pet = new Pet();
        pet.setName(petDTO.getName());
        pet.setType(petDTO.getType());
        pet.setOwner(owner);

        Pet savedPet = petService.savePet(pet);
        return ResponseEntity.ok(savedPet);
    }

    // Endpoint to view all pets for a specific owner
    @GetMapping("/{ownerId}")
    public ResponseEntity<List<Pet>> getPetsByOwner(@PathVariable Long ownerId) {
        Owner owner = ownerService.getOwnerById(ownerId);
        if (owner == null) {
            return ResponseEntity.badRequest().body(null);
        }

        List<Pet> pets = petService.getPetsByOwnerId(ownerId);
        return ResponseEntity.ok(pets);
    }
}
