package tn.esprit.forummicroservice.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.forummicroservice.Entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
