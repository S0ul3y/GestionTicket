package com.ticket.GesTicket.modele;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "reponse")
@Getter
@Setter
@NoArgsConstructor
public class Reponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String reponse;

    @ManyToOne
    private Formateur formateur;

    @ManyToOne
    private Ticket ticket;

}
