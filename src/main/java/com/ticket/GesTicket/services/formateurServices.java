package com.ticket.GesTicket.services;

import com.ticket.GesTicket.Security.Mail;
import com.ticket.GesTicket.Statut;
import com.ticket.GesTicket.modele.*;
import com.ticket.GesTicket.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class formateurServices {

    public final formateurRepo formRepo;
    public final ApprenantRepo ApprenRepo;
    public final NotifRepo notifRepo;
    public final TicketRepo ticketRepo;
    private final UserRepo userRepo;
    private final AdminRepo adminRepo;
    private final PasswordEncoder passwordEncoder;
    private final Mail email;
    private final Session session;

    //TICKET ZONE ===========================================================================================================

    public String RepondreTicket(long id_tic, Reponse reponse) {
        return ticketRepo.findById(id_tic)
                .map(T ->
                        ApprenRepo.findById(T.getApprenant().getId())
                        .map(Ap -> {
                            email.envoiesMessage(Ap.getEmail(), "Bonjour "+Ap.getNom()+" "+Ap.getPrenom()+" <br> Votre ticket à été répondu <br> QUESTION: <br> "+T.getDescription()+" <br> REPONSE :<br> "+reponse.getReponse());
                            T.setStatut(Statut.RESOLU);
                            ticketRepo.save(T);
                            Formateur us = (Formateur) session.getCurrentUser();  //(Apprenant) getCurrentUser();
                            reponse.setFormateur(us);
                            reponse.setTicket(T);
                            notifRepo.save(reponse);
                            return "Ticket répondu avec succès";
                        }).orElseThrow(() -> new RuntimeException("Apprenant non trouvé"))).orElseThrow(() -> new RuntimeException("Ticket non trouvé"));
    }


    public Ticket OuvrirTicket(long id_tic, Ticket ticket) {
        return ticketRepo.findById(id_tic)
                .map(T -> ApprenRepo.findById(T.getApprenant().getId())
                        .map(Ap -> {
                            email.envoiesMessage(Ap.getEmail(), "Votre ticket est ouvert, vous aurez un email une fois fini");
                            T.setStatut(Statut.OUVERT);
                            return ticketRepo.save(T);
                        }).orElseThrow(() -> new RuntimeException("Apprenant non trouvé"))).orElseThrow(() -> new RuntimeException("Ticket non trouvé"));
    }




    public User creerAppren(User Appren) {

        email.envoiesMessage(Appren.getEmail(), "Bonjour "+Appren.getNom() +" "+Appren.getPrenom()+" <br> Votre compte à été créer et votre mot de pass est :<br>"+Appren.getPassword());

        String encodedPassword = passwordEncoder.encode(Appren.getPassword());
        Appren.setPassword(encodedPassword);

        Appren.setRole(Role.APPRENANT);
        return userRepo.save(Appren);
    }

    public List<Apprenant> ApprenListe(){
        return ApprenRepo.findAll();
    }

    public String supprimerApprenant(long id) {
        ApprenRepo.deleteById(id);
        return "Apprenant supprimer !";
    }


}
