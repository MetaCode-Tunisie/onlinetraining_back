package com.example.forumservice.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level= AccessLevel.PRIVATE)
public class Post implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    int likes;
    int dislikes;
    @Temporal(TemporalType.DATE)
    Date date = new Date();
    @Lob
    String image;

    @ManyToOne
    Forum forum;

    @OneToMany(mappedBy = "post")
    Set<Comment> comments = new HashSet<>();

    @OneToMany(mappedBy = "post")
    @JsonIgnore
    @ToString.Exclude
    Set<PostVote> postVotes;
}
