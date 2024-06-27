package com.ticket.GesTicket.services;

import com.ticket.GesTicket.modele.User;
import com.ticket.GesTicket.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class Session {

    private final UserRepo userRepo;


    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = ((UserDetails) authentication.getPrincipal()).getUsername();
        return userRepo.findByEmail(email);
    }
}
