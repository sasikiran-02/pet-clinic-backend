package com.example.PetClinic.Controllers;

import com.example.PetClinic.Services.ConsultationService;
import com.example.PetClinic.Services.PetService;
import com.example.PetClinic.model.Consultation;
import com.example.PetClinic.model.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/consultations")
@CrossOrigin(origins = "http://localhost:4200")
public class ConsultationController {

    @Autowired
    private ConsultationService consultationService;

    @Autowired
    private PetService petService;

    // Get all consultations
    @GetMapping
    public ResponseEntity<List<Consultation>> getAllConsultations() {
        return ResponseEntity.ok(consultationService.getAllConsultations());
    }

    // Get all pets for a specific owner (for selecting during consultation booking)
    @GetMapping("/pets/{ownerId}")
    public ResponseEntity<List<Pet>> getPetsByOwner(@PathVariable Long ownerId) {
        List<Pet> pets = petService.getPetsByOwnerId(ownerId);
        return ResponseEntity.ok(pets);
    }

    // Book a consultation
    @PostMapping("/book")
    public ResponseEntity<Consultation> bookConsultation(
            @RequestParam Long petId,
            @RequestParam Date consultationDate,
            @RequestParam String description) {

        // Fetch the pet
        Pet pet = petService.getPetById(petId);
        if (pet == null) {
            return ResponseEntity.badRequest().body(null);
        }

        // Create and save the consultation
        Consultation consultation = new Consultation();
        consultation.setPet(pet);
        consultation.setConsultationDate(consultationDate);
        consultation.setFee(50.0);
        consultation.setDescription(description);

        Consultation savedConsultation = consultationService.saveConsultation(consultation);
        return ResponseEntity.ok(savedConsultation);
    }
}
