package com.example.formationservice.Entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@FieldDefaults(level= AccessLevel.PRIVATE)
public class categorie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)@Setter(AccessLevel.NONE)
Long idcategorie;
String NomCategorie;
@JsonIgnore
@OneToMany(mappedBy ="categorie")
    Set<formation>formations=new HashSet<>();
}
