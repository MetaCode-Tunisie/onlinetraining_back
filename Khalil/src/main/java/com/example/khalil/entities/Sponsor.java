package com.example.khalil.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Sponsor  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idSponsor;
    String Sname;
    String Lieu;

    @OneToMany(mappedBy = "sponsor", cascade = CascadeType.REMOVE)
    List<Publicite> publicites ;

}
