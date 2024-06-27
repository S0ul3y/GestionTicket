package com.ticket.GesTicket.controller;

import com.ticket.GesTicket.modele.Apprenant;
import com.ticket.GesTicket.modele.Ticket;
import com.ticket.GesTicket.modele.User;
import com.ticket.GesTicket.repository.UserRepo;
import com.ticket.GesTicket.services.ApprenantServices;
import com.ticket.GesTicket.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/apprenant")
@AllArgsConstructor
public class ApprenantController {
    public final ApprenantServices AppSer;
    public final UserRepo userRepo;
    public final UserService userService;



    public ResponseEntity<Object> getMyDetails(){
        return ResponseEntity.ok(userService.findByEmail(getLoggedInUserDetails().getUsername()));
    }

    public UserDetails getLoggedInUserDetails(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null && authentication.getPrincipal() instanceof UserDetails){
            return (UserDetails) authentication.getPrincipal();
        }
        return null;
    }







    @PreAuthorize("hasRole('APPRENANT')")
    @PostMapping("/addticket")
    //@GetMapping("/user/single")
    public Ticket Creer(@RequestBody Ticket ticket) {
        return AppSer.AddTicket(ticket);
    }


    @GetMapping("/b")
    List<User> Lire (){
        return AppSer.ListerApprenent();
    }
}
