package com.ticket.GesTicket.modele;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;


@Table(name = "formateur")
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Formateur extends User{

    @JsonIgnore
    @OneToMany(mappedBy = "formateur", cascade = CascadeType.ALL)
    private Set<Reponse> reponse;


}
