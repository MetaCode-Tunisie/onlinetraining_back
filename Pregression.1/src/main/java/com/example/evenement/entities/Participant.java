package com.example.evenement.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Participant implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idP;

    //@ManyToOne
    //@JoinColumn(name = "idEvents")
    //private Evenement evenement; // Événement auquel l'utilisateur est inscrit


}
