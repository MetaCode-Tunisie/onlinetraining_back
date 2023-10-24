package tn.esprit.forummicroservice.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.forummicroservice.Entities.Forum;
import tn.esprit.forummicroservice.Entities.Post;
import tn.esprit.forummicroservice.Entities.PostVote;

import java.util.Optional;

public interface PostVoteRepository extends JpaRepository<PostVote,Integer> {

    Optional<PostVote> findByPost(Post post);
}
