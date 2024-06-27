package com.ticket.GesTicket.services;

import com.ticket.GesTicket.modele.User;
import com.ticket.GesTicket.repository.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public Iterable<User>findAllUsers(){
        return userRepo.findAll();
    }

    private UserRepo userRepo;
    public User findByEmail(String email) {
        return userRepo.findByEmail(email);
    }
}
