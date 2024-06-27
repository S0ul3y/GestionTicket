package com.ticket.GesTicket.repository;

import com.ticket.GesTicket.modele.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepo extends JpaRepository<Ticket, Long> {
}
