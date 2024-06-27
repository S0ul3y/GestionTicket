package com.ticket.GesTicket.Security;

import com.ticket.GesTicket.modele.User;
import com.ticket.GesTicket.repository.AdminRepo;
import com.ticket.GesTicket.repository.ApprenantRepo;
import com.ticket.GesTicket.repository.UserRepo;
import com.ticket.GesTicket.repository.formateurRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepo userRepository;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            System.out.println("User found: " + user.getEmail()); // Log de vérification
            return new CustomUserDetails(user);
        }
        throw new UsernameNotFoundException("User not found");
    }
}
