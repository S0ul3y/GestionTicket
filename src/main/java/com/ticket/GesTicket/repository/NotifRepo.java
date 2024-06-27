package com.ticket.GesTicket.repository;

import com.ticket.GesTicket.modele.Reponse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotifRepo extends JpaRepository<Reponse, Long> {
}
