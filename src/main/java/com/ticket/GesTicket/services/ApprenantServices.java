package com.ticket.GesTicket.services;

import com.ticket.GesTicket.Security.Mail;
import com.ticket.GesTicket.Statut;
import com.ticket.GesTicket.modele.*;
import com.ticket.GesTicket.repository.ApprenantRepo;
import com.ticket.GesTicket.repository.NotifRepo;
import com.ticket.GesTicket.repository.TicketRepo;
import com.ticket.GesTicket.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ApprenantServices {

    public final ApprenantRepo AppRepo;
    public final TicketRepo ticketRepo;
    public final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final Mail mail;

    private final Session session;
    private final NotifRepo notifRepo;

    //@Override
    /*public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = ((UserDetails) authentication.getPrincipal()).getUsername();
        return userRepo.findByEmail(email);
    }*/


    // TICKET ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public Ticket AddTicket(Ticket ticket) {
        //Apprenant us = (Apprenant) getCurrentUser();
        Apprenant us = (Apprenant) session.getCurrentUser();  //(Apprenant) getCurrentUser();
        ticket.setApprenant(us);
        System.out.println(us.getPrenom());
        mail.envoiesMessage(us.getEmail(), "Votre ticket a été ajouté");
        us.setRole(Role.APPRENANT);
        ticket.setStatut(Statut.EN_COUR);


        return ticketRepo.save(ticket);
        //return "Ticket ajouté avec succès :)";
    }


    public List<User> ListerApprenent() {
        return userRepo.findAll();
    }

    /*
    public Reponse lireReponse(Long id, Reponse reponse){

        Apprenant us = (Apprenant) session.getCurrentUser();  //(Apprenant) getCurrentUser();
        notifRepo.findById(us.getId());
        return
        /*return ticketRepo.findById(id)
                .map(T ->{
                    notifRepo.findById(T.getId());
                }).orElseThrow(()-> new RuntimeException("reponse non trouvée"));}
        return */


    /*public Apprenant modifierTicket(long id, Apprenant App) {
        return AppRepo.findById(id)
                .map(A -> {
                    A.setNom(App.getNom());
                    A.setPrenom(App.getPrenom());
                    A.setEmail(App.getEmail());
                    A.setPassword(App.getPassword());
                    return AppRepo.save(A);
                }).orElseThrow(()-> new RuntimeException("Apprenant non trouvée"));
    }*/


    public String supprimerApprenant(long id) {
        AppRepo.deleteById(id);
        return "Apprenant supprimer !";
    }
}
