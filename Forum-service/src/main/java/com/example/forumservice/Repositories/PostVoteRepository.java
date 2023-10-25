package com.example.forumservice.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.forumservice.Entities.Post;
import com.example.forumservice.Entities.PostVote;

import java.util.Optional;

public interface PostVoteRepository extends JpaRepository<PostVote,Integer> {

    Optional<PostVote> findByPost(Post post);
}
