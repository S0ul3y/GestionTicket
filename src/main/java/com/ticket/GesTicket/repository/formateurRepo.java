package com.ticket.GesTicket.repository;

import com.ticket.GesTicket.modele.Apprenant;
import com.ticket.GesTicket.modele.Formateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface formateurRepo extends JpaRepository<Formateur, Long> {
    Formateur findByNom(String nom);
}