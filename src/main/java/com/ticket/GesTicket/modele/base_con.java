package com.ticket.GesTicket.modele;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "base_con")
@Getter
@Setter
@NoArgsConstructor
public class base_con {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id_base;
    private String question;
    private String reponse;

}
