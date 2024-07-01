package com.ticket.GesTicket.controller;

import com.ticket.GesTicket.modele.Admin;
import com.ticket.GesTicket.modele.Formateur;
import com.ticket.GesTicket.modele.User;
import com.ticket.GesTicket.repository.AdminRepo;
import com.ticket.GesTicket.repository.UserRepo;
import com.ticket.GesTicket.services.AdminServices;
import com.ticket.GesTicket.services.ApprenantServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import com.ticket.GesTicket.services.formateurServices;

import java.util.List;

@RestController

@Tag(name = "ADMIN", description = "Les actions de l'administrateur")
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminController {

    private final AdminServices AddSer;
    private final formateurServices formaSer;
    private final AdminRepo adminRepo;
    private final UserRepo userRepo;


    // Admin ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    @Operation(description = "Ajout d'un Administrateur")
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/AjouterAdmin")
    public User CreerAdmin(@RequestBody Admin admin){
        return AddSer.creerAdmin(admin);
    }

    @GetMapping("/lsiteadmin")
    public List<Formateur> ListeAdmin() {
        return AddSer.ListerFormateur();
    }


    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/supadmin/{id}")
    public String SupprimerAdmin(@PathVariable long id) {
        return AddSer.supprimerformateur(id);
    }


//FORMATEUR +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/addform")
    public Formateur AddFormateur(@RequestBody Formateur formateur) {
        return AddSer.creerformateur(formateur);
    }
    @GetMapping("/lsiteformateur")
    public List<Formateur> ListeFormateur() {
        return AddSer.ListerFormateur();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/supformateur/{id}")
    public String SupprimerFormateur(@PathVariable long id) {
        return AddSer.supprimerformateur(id);
    }



}
