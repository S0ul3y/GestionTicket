package com.ticket.GesTicket.modele;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.GenerationType.*;


@Table(name = "admin")
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Admin extends User{


    /*
    @Column(length = 50)
    private String nom;
    @Column(length = 50)
    private String email;
    @Column(length = 50)
    private String mdp;*/

}
