package com.ticket.GesTicket.controller;

import com.ticket.GesTicket.modele.Admin;
import com.ticket.GesTicket.modele.Formateur;
import com.ticket.GesTicket.modele.User;
import com.ticket.GesTicket.repository.AdminRepo;
import com.ticket.GesTicket.repository.UserRepo;
import com.ticket.GesTicket.services.AdminServices;
import com.ticket.GesTicket.services.ApprenantServices;
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
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminController {

    private final AdminServices AddSer;
    private final formateurServices formaSer;
    private final AdminRepo adminRepo;
    private final UserRepo userRepo;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/AjouterAdmin")
    public User CreerAdmin(@RequestBody Admin admin){
        return AddSer.creerAdmin(admin);
    }


//FORMATEUR
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/addform")
    public Formateur AddFormateur(@RequestBody Formateur formateur) {
        return AddSer.creerformateur(formateur);
    }
    @GetMapping("/lsiteformateur")
    public List<Formateur> ListeFormateur() {
        return AddSer.ListerFormateur();
    }

    public String SupprimerFormateur(int id) {
        return AddSer.supprimerformateur(id);
    }



    public ResponseEntity<Object> getMyDetails(){
        return ResponseEntity.ok(userRepo.findByEmail(getLoggedInUserDetails().getUsername()));
    }

    public UserDetails getLoggedInUserDetails(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null && authentication.getPrincipal() instanceof UserDetails){
            return (UserDetails) authentication.getPrincipal();
        }
        return null;
    }


}
