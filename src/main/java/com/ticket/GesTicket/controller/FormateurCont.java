package com.ticket.GesTicket.controller;

import com.ticket.GesTicket.modele.*;
import com.ticket.GesTicket.repository.UserRepo;
import com.ticket.GesTicket.services.formateurServices;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/formateur")
@AllArgsConstructor
public class FormateurCont {

    private final formateurServices formaSer;
    private final UserRepo userRepo;




// APPRENANT++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    @PreAuthorize("hasRole('FORMATEUR')")
    @PostMapping("/AjouterApp")
    public User CreerApp(@RequestBody Apprenant A){
        return formaSer.creerAppren(A);
    }

    @PreAuthorize("hasRole('FORMATEUR')")
    @GetMapping("/listeApprenant")
    List<Apprenant> ListAppren(){
        return formaSer.ApprenListe();
    }


    //TICKET ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    //@PreAuthorize("hasRole('FORMATEUR')")
    @GetMapping("/OuvrirTicket/{id_tic}")
    public Ticket OuvrirTicket(Ticket ticket, @PathVariable Long id_tic){
      return formaSer.OuvrirTicket(id_tic, ticket);
    }

    //@PreAuthorize("hasRole('FORMATEUR')")
    @PostMapping("/repondreticket/{id}")
    public String repondreTicket(@RequestBody Reponse notification, @PathVariable long id){
        return formaSer.RepondreTicket(id, notification);
    }

}
