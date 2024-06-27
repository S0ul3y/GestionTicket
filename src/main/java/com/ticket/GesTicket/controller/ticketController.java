package com.ticket.GesTicket.controller;

import com.ticket.GesTicket.modele.Ticket;
import com.ticket.GesTicket.services.ticketServices;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/ticket")
@AllArgsConstructor
public class ticketController {
    public final ticketServices ticketServices;

    @PostMapping("/a")
    public Ticket Creer(@RequestBody Ticket ticket) {
        return ticketServices.creerTicket(ticket);
    }
    @GetMapping("/b")
    List<Ticket> Lire (){
        return ticketServices.ListerTickets();
    }
}
