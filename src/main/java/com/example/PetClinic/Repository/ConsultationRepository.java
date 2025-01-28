package com.example.PetClinic.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.PetClinic.model.Consultation;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultationRepository extends JpaRepository<Consultation, Long> {}
