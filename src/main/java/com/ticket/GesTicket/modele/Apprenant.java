package com.ticket.GesTicket.modele;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Set;


@Table(name = "apprenant")
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Apprenant extends User{

    @JsonIgnore
    @OneToMany(mappedBy = "apprenant", cascade = CascadeType.ALL)
    private Set<Ticket> ticket;




    /*@Column(length = 50)
    private String nom;
    @Column(length = 50)
    private String email;
    private String mdp;*/

}

