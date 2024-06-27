package com.ticket.GesTicket.services;

import com.ticket.GesTicket.Security.Mail;
import com.ticket.GesTicket.modele.Admin;
import com.ticket.GesTicket.modele.Formateur;
import com.ticket.GesTicket.modele.Role;
import com.ticket.GesTicket.modele.User;
import com.ticket.GesTicket.repository.AdminRepo;
import com.ticket.GesTicket.repository.formateurRepo;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor


@Service
public class AdminServices {

private final AdminRepo adminRepo;
private final formateurRepo formRepo;
private final PasswordEncoder passwordEncoder;
private final Mail email;

//public User find





//ADMIN ZONE++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    public Admin creerAdmin(Admin admin) {
        email.envoiesMessage(admin.getEmail(), "Votre compte à été créer et votre mot de pass est :"+admin.getPassword());

        String encodedPassword = passwordEncoder.encode(admin.getPassword());
        admin.setPassword(encodedPassword);

        admin.setRole(Role.ADMIN);
        return adminRepo.save(admin);
    }

//FORMATEUR ZONE ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    public Formateur creerformateur(Formateur form) {
        email.envoiesMessage(form.getEmail(), "Votre compte à été créer et votre mot de pass est :"+form.getPassword());

        String encodedPassword = passwordEncoder.encode(form.getPassword());
        form.setPassword(encodedPassword);

        form.setRole(Role.FORMATEUR);
        return formRepo.save(form);
    }



    public List<Formateur> ListerFormateur() {
        return formRepo.findAll();
    }


    public Formateur modifierFormateur(long id, Formateur App) {
        return formRepo.findById(id)
                .map(F -> {
                    F.setNom(App.getNom());
                    F.setPrenom(App.getPrenom());
                    F.setEmail(App.getEmail());
                    F.setPassword(App.getPassword());
                    return formRepo.save(F);
                }).orElseThrow(()-> new RuntimeException("formateur non trouvée"));
    }


    public String supprimerformateur(long id) {
        formRepo.deleteById(id);
        return "formateur supprimer !";
    }
}
