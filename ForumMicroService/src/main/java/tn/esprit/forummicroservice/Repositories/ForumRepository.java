package tn.esprit.forummicroservice.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.forummicroservice.Entities.Forum;

public interface ForumRepository extends JpaRepository<Forum, Long> {
}
