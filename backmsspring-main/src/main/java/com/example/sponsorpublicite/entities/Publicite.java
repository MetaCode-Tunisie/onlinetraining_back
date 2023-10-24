package com.example.sponsorpublicite.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Publicite implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        int idPublicite;
        @Lob
        String image;
        String Description;
        float prix;

        @JsonIgnore

        @ManyToOne
        Sponsor sponsor;
    }
