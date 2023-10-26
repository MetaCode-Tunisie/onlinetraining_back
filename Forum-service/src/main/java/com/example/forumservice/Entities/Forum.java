package com.example.forumservice.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level= AccessLevel.PRIVATE)
public class Forum implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String description;
    String title;


    @JsonIgnore
    @OneToMany(mappedBy = "forum", cascade = CascadeType.REMOVE)
    Set<Post> posts = new HashSet<>();



}
