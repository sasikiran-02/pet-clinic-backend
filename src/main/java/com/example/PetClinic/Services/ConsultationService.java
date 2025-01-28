package com.example.PetClinic.Services;

import com.example.PetClinic.model.Consultation;
import com.example.PetClinic.Repository.ConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultationService {

    @Autowired
    private ConsultationRepository repository;

    public List<Consultation> getAllConsultations() {
        return repository.findAll();
    }

    public Consultation saveConsultation(Consultation consultation) {
        return repository.save(consultation);
    }
}