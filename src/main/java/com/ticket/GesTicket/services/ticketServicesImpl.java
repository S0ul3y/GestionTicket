package com.ticket.GesTicket.services;

import com.ticket.GesTicket.modele.Ticket;
import com.ticket.GesTicket.repository.TicketRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class ticketServicesImpl implements ticketServices {

    public final TicketRepo ticketRepo;

    @Override
    public Ticket creerTicket(Ticket Ticket) {
        return ticketRepo.save(Ticket);
    }

    @Override
    public List<Ticket> ListerTickets() {
        return ticketRepo.findAll();
    }

    @Override
    public Ticket modifierTicket(long id, Ticket Ticket) {
        return ticketRepo.findById(id)
                .map(T -> {
                    T.setCategotie(Ticket.getCategotie());
                    T.setDescription(Ticket.getDescription());
                    T.setUrgence(Ticket.getUrgence());
                    T.setStatut(Ticket.getStatut());
                    return ticketRepo.save(T);
                }).orElseThrow(()-> new RuntimeException("Ticket non trouvée"));
    }

    @Override
    public String supprimerTicket(long id) {
        ticketRepo.deleteById(id);
        return "Ticket supprimer !";
    }
}
