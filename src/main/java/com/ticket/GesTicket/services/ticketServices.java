package com.ticket.GesTicket.services;
import com.ticket.GesTicket.modele.Ticket;

import java.util.List;

public interface ticketServices {

    Ticket creerTicket(Ticket Ticket);

    List<Ticket> ListerTickets();

    Ticket modifierTicket(long id, Ticket Ticket);

    String supprimerTicket(long id);

}
