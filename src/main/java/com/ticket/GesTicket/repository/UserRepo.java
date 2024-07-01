package com.ticket.GesTicket.repository;

import com.ticket.GesTicket.modele.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
    User findByEmail(String email);

}
