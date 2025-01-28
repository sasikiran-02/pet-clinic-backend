package com.example.PetClinic.Controllers;

import com.example.PetClinic.DTO.OwnerDTO;
import com.example.PetClinic.model.Owner;
import com.example.PetClinic.Services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/owners")
@CrossOrigin(origins = "http://localhost:4200")
public class OwnerController {



    private OwnerService service;

    @Autowired
    public OwnerController(OwnerService service) {
        this.service = service;
    }

    @GetMapping
    public List<Owner> getAllOwners() {
        return service.getAllOwners();
    }

    @PostMapping
    public Owner saveOwner(@RequestBody OwnerDTO ownerDetails) {
        Owner newOwner = new Owner();
        newOwner.setName(ownerDetails.getName());
        newOwner.setEmail(ownerDetails.getEmail());
        newOwner.setPhone(ownerDetails.getPhone());
        return service.saveOwner(newOwner);
    }
}