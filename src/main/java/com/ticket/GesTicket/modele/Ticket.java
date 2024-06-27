package com.ticket.GesTicket.modele;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ticket.GesTicket.Categorie;
import com.ticket.GesTicket.Statut;
import com.ticket.GesTicket.Urgence;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "tickets")
@Getter
@Setter
@NoArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    //@JoinColumn(name = "apprenant_id", nullable = false)
    private Apprenant apprenant;


    @JsonIgnore
    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL)
    private Set<Reponse> reponse;


    @Enumerated(EnumType.STRING)
    private Categorie categotie;
    @Column(length = 50)
    private String description;
    @Enumerated(EnumType.STRING)
    private Urgence urgence;
    @Enumerated(EnumType.STRING)
    private Statut statut;
}
