package com.ticket.GesTicket.repository;

import com.ticket.GesTicket.modele.Apprenant;
import com.ticket.GesTicket.modele.Formateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApprenantRepo extends JpaRepository<Apprenant, Long> {
    Apprenant findByEmail(String email);
}
